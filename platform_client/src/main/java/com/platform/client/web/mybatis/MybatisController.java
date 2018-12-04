package com.platform.client.web.mybatis;

import com.ReplaceJDBCType;
import com.platform.base.cache.MemcacheCache;
import com.platform.base.common.classTemplate.FileUtils;
import com.platform.base.common.shiro.ShiroUser;
import com.platform.base.utils.BeanToMapUtil;
import com.platform.base.utils.StringUtils;
import com.platform.client.c3p0.C3P0Factory;
import com.platform.client.common.ProjectUtils;
import com.platform.client.config.ConfigVo;
import com.platform.client.vo.MybatisVo;
import freemarker.template.Template;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.util.FileUtil;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * Created by CHUCHU on 2017/5/19.
 */
@Controller
@RequestMapping("/platform/mybatis")
public class MybatisController {

    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;
    @Autowired
    C3P0Factory factory;
    @Autowired
    MemcacheCache otherCache;
    @Autowired
    ConfigVo configVo;
    private final static int num = 20;

    @RequestMapping("/make")
    @SuppressWarnings("unchecked")
    public String makeMybatis(MybatisVo mybatisVo, Model model, HttpServletRequest request){
        if(StringUtils.isNullString(mybatisVo.getDaoPkg())){
            mybatisVo.setDaoPkg("com.javacoder.dao");
        }
        if(StringUtils.isNullString(mybatisVo.getPoPkg())){
            mybatisVo.setPoPkg("com.javacoder.po");
        }
        if(StringUtils.isNotNullString(mybatisVo.getMysql())){
           //判断是否是以分号结尾，如果不是加上分号
            if(!mybatisVo.getMysql().endsWith(";")){
                mybatisVo.setMysql(mybatisVo.getMysql()+";");
            }
        }
        Subject subject = SecurityUtils.getSubject();
        ShiroUser user = (ShiroUser) subject.getPrincipal();
        if(user == null){
            return "project/login";
        }
        //校验是否重复提交
        String submitToken = (String) otherCache.getCacheValue(user.getId() + "_mybatis");
        if (StringUtils.isNullString(submitToken) || !mybatisVo.getToken().equals(submitToken)) {
            return "redirect:/platform/mybatis/page";
        } else {
            otherCache.evict(user.getId() + "_mybatis");
        }
        String sqlName = "mybatis_"+new Date().getTime()+user.getId()+".sql";
        String userPath =  ProjectUtils.getProjectPath(String.valueOf(user.getUsername()))+File.separator+"mybatisCode";
        System.out.println(userPath);
        File file = new File(userPath);
        if(file.exists()){
            FileUtil.deleteContents(file);
        }else{
            file.mkdirs();
        }
        //执行sql文件
        Long threadId = Thread.currentThread().getId();
        int id = threadId.intValue();
        int value = id%num;
        //1:查找对应的数据库,删除所有表
        String path = configVo.getMybatisPath()+File.separator+sqlName;
        FileUtils.makeFile(path,mybatisVo.getMysql(),"utf-8",false);
        Map<String,Object> tempMap = null;
        try {
            tempMap = factory.excute(factory.getDataSource(value),path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> tableNameList = (List<String>)tempMap.get("tableList");
        if(tableNameList == null || tableNameList.size()==0){
            model.addAttribute("error","不能辨别出有效的sql脚本,请检查");
            return "project/mybatis_new";
        }

        File configFile = null;
        try {
           Map<String,Object> map =  BeanToMapUtil.convertBean(mybatisVo);
           map.putAll(tempMap);
           map.put("mybatisProject",userPath);
           map.put("jarPath",configVo.getJarPath());
           configFile = File.createTempFile("mybatis",".xml");
           Template template =  freeMarkerConfigurer.getConfiguration().getTemplate("genterMapper/generatorConfig.ftl");
           Writer writer = new FileWriter(configFile);
           //template.process(mybatisVo,new PrintWriter(System.out));
            template.process(map,writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String genCfg = "generatorConfig.xml";
        //File configFile = new File(MyBatisGeneratorTool.class.getClassLoader().getResource(genCfg).getFile());
        System.out.println(configFile.getAbsolutePath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {
            config = cp.parseConfiguration(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            System.out.println("-----------------------------------------------------------------");
            System.out.println(genCfg + " 中指定的表对应类与配置文件已经生成完毕！");
            System.out.println("-----------------------------------------------------------------");
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(null);
            ReplaceJDBCType.replace(userPath);
            //删除表
            factory.dropTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*model.addAttribute("downloadUrl",userPath);
        model.addAttribute("fileName",new Date().getTime()+"_mybatis");
        model.addAttribute("flag","mybatis");*/
        request.setAttribute("downloadUrl",userPath);
        request.setAttribute("fileName",new Date().getTime()+"_mybatis");
        request.setAttribute("flag","mybatis");
        return "forward:/platform/framework/download";
    }

    /**
     * 获取所有的dao文件,然后复制并替换生成service文件
     * @param s
     */
    private void genertaorServiceAndController(String s,String servicePkg) {

        System.out.println(servicePkg);
        servicePkg = servicePkg.replace(".","/");
        System.out.println(servicePkg);

        final File file = new File(s);
        getFile(file.listFiles(),servicePkg,s);

    }

    private void getFile(File[] files,String servicePkg,String s){

        for (File tempFile :
                files) {
            if(tempFile.isDirectory()){
                getFile(tempFile.listFiles(),servicePkg,s);
                continue;
            }else {
                System.out.println("123-----");
                if(tempFile.getName().endsWith("Dao.java")){
                    String filePath = s + File.separator + servicePkg;
                    System.out.println(filePath);
                    String content = FileUtils.getFileContent(tempFile.getAbsolutePath(), "utf-8");
                    System.out.println(content);
                    String newFilePATH = filePath + File.separator + tempFile.getName().replace("Dao", "Service");
                    new File(newFilePATH);
                    System.out.println(newFilePATH);
                    FileUtils.makeFile(newFilePATH, content, "utf-8", false);
                }
            }
            System.out.println(tempFile.getName());
        }
    }

    /**
     * 提交数据
     * @param mybatisVo
     * @return
     */
    @RequestMapping("/make11")
    public String makeMybatis_new(MybatisVo mybatisVo) {
        Long threadId = Thread.currentThread().getId();
        Long num = threadId%20;
        int value = num.intValue();


        return "project/mybatis_new";
    }

    /**
     * 跳转到mybatis生成页面
     * @param model
     * @return
     */
    @RequestMapping("/page")
    public String mybatisPage(Model model) {
        Subject subject = SecurityUtils.getSubject();
        ShiroUser user = (ShiroUser) subject.getPrincipal();
        if (user != null) {
            String uuid = UUID.randomUUID().toString();
            otherCache.put(user.getId() + "_mybatis", uuid);
            model.addAttribute("token", uuid);
        }

        return "project/mybatis_new";
    }

    public static void main(String[] args) {
        MybatisController mybatisController = new MybatisController();
        mybatisController.genertaorServiceAndController("d:\\gaopengju\\mybatisCode","com.hello.xx");
    }

}
