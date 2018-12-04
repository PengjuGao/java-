package com.platform.client.web.framework;

import com.platform.base.cache.MemcacheCache;
import com.platform.base.common.shiro.ShiroUser;
import com.platform.base.utils.BeanToMapUtil;
import com.platform.base.utils.StringUtils;
import com.platform.client.common.*;
import com.platform.client.enums.ProjectEnum;
import com.platform.client.runnable.RunnableClearUserZIP;
import com.platform.client.utils.FileUtils;
import com.platform.client.utils.ResultUtils;
import com.platform.client.utils.ZipUtils;
import com.platform.client.vo.CommonFrameWorkVo;
import com.platform.core.param.common.CommonResult;
import com.platform.core.po.TbRecord;
import com.platform.core.service.TbRecordService;
import net.sf.json.JSONObject;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by gaopengju on 2016/12/29.
 * framework auto make controller
 */
@Controller
@RequestMapping("/platform/framework")
public class FrameworkController {

    @Autowired
    private TbRecordService recordService;
    @Autowired
    MemcacheCache otherCache;
    @Autowired
    ThreadPoolTaskExecutor taskExecutor;
    /**
     * 生成页面跳转
     *
     * @param type
     * @return
     */
    @RequestMapping("/gotoMakePage")
    public String gotoAutoPage(String type, Model model) {
        String view = "project/home";
        Subject subject = SecurityUtils.getSubject();
        ShiroUser user = (ShiroUser) subject.getPrincipal();
        /*if (user != null) {
            String uuid = UUID.randomUUID().toString();
            otherCache.put(user.getUsername() + "_submitToken", uuid);
            model.addAttribute("submitToken", uuid);
        }*/
        if ("ssh".equals(type)) {
            view = "project/ssh";
        } else if ("ssm".equals(type)) {
            view = "project/ssm";
        } else if ("sh".equals(type)) {
            view = "project/sh";
        } else if ("sm".equals(type)) {
            view = "project/sm";
        } else if ("s2h".equals(type)) {
            view = "project/s2h";
        } else if ("s2m".equals(type)) {
            view = "project/s2m";
        }
        return view;
    }

    /**
     * 生成框架
     *
     * @param vo
     * @return
     */
    @RequestMapping("/doMakeFramework")
    public String doMakeFramework(CommonFrameWorkVo vo) {

        CommonResult result = new CommonResult();
        try {
            Subject subject = SecurityUtils.getSubject();
            ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
            if (shiroUser == null) {
                result.setCode(211);
                result.setMessage("不合法的请求");
            } else {
                vo.setUserId(shiroUser.getUsername());
                /*//校验是否重复提交
                String submitToken = (String) otherCache.getCacheValue(vo.getUserId() + "_submitToken");
                if (StringUtils.isNullString(submitToken) || !vo.getToken().equals(submitToken)) {
                    return "project/center_frameworklist";
                } else {
                    otherCache.evict(vo.getUserId() + "_submitToken");
                }*/
                //1.判断框架类型是否存在
                ProjectEnum tempEnum = ProjectEnum.getEnum(vo.getFrameworkType());
                if (tempEnum == null) {
                    result.setCode(208);
                    result.setMessage("选择的框架类型错误，请重新选择");
                } else {
                    //判断，当前项目名称是否已经存在
                    //最后一步 html 框架拷贝,js框架拷贝,其他文件拷贝
                    String projectPath = ProjectUtils.getProjectPath(vo.getUserId()) + File.separator + vo.getProject();
                    FileUtils.deleteFileOrZip(projectPath);
                    /*File projectFile = new File(projectPath);
                    if(projectFile.exists()){
                        result.setCode(401);
                        result.setMessage("项目已经存在，为了避免错误发生，请重新填写项目名");
                        String resultStr = ResultUtils.getView(result, ResultUtils.VIEW_TYPE_PAGE, "redirect:/platform/user/gotoCenter?page=frameworkList", "error");
                        return resultStr;
                    }*/
                    Map map = BeanToMapUtil.convertBean(vo);
                    File file = ProjectUtils.makeProject(map);
                    Document doc = XMLUtils.getDocument(new FileInputStream(file));
                    String content = FTLUtils.getContent(ProjectEnum.getUrl(tempEnum.name), map);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content.trim().getBytes());
                    Document tempDoc = XMLUtils.getDocument(byteArrayInputStream);
                    Element root = tempDoc.getRootElement();
                    List<Element> chilren = root.elements();
                    for (Element element :
                            chilren) {
                        List<Attribute> attrList = element.attributes();
                        Node node = XMLUtils.getNode(attrList);
                        XMLUtils.executeFtl(node, doc, map);
                    }

                    String staticPath = projectPath + File.separator + Resources.PRO_MAIN_STATIC;
                    ProjectUtils.copyHtmlFramework(staticPath, vo.getHtmlFramework());
                    ProjectUtils.copyJsFramework(staticPath, vo.getJsFramework());
                    ProjectUtils.copyOther(projectPath, "");
                    //打包---------//TODO:
                   /* String zipFilePath = FileUtils.fileToZip(projectPath, ProjectUtils.getProjectPath(vo.getUserId()),vo.getProject());
                    if(StringUtils.isNullString(zipFilePath)){
                        result.setCode(311);
                        result.setMessage("-------文件生成失败-----");
                        String resultStr = ResultUtils.getView(result, ResultUtils.VIEW_TYPE_PAGE, "project/center_frameworklist", "error");
                        return resultStr;
                    }*/
                   Date date = new Date();
                    TbRecord record = new TbRecord();
                    record.setCreateTime(date);
                    record.setRecordType(tempEnum.code);
                    record.setStatus(1);
                    record.setUpdateTime(new Date());
                    record.setUserId(shiroUser.getId());
                    JSONObject object = JSONObject.fromObject(vo);
                    System.out.println(object);
                    object.element("downloadUrl", projectPath);
                    record.setRecordDetail(object.toString());
                    this.recordService.insert(record);
                    //删除改用户下其他下载地址的zip包
                    RunnableClearUserZIP clearUserZIP = new RunnableClearUserZIP();
                    clearUserZIP.setRecordService(this.recordService);
                    clearUserZIP.setDate(date);
                    clearUserZIP.setUrl(projectPath);
                    clearUserZIP.setCurrentProject(vo.getProject());
                    clearUserZIP.setUserId(shiroUser.getId());
                    taskExecutor.execute(clearUserZIP);
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
            result.setCode(209);
            result.setMessage("生成框架异常");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            result.setCode(210);
            result.setMessage("生成框架异常");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            result.setCode(211);
            result.setMessage("生成框架异常");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            result.setCode(212);
            result.setMessage("生成框架异常");
        }
        String resultStr = ResultUtils.getView(result, ResultUtils.VIEW_TYPE_PAGE, "redirect:/platform/user/gotoCenter?page=frameworkList", "error");
        return resultStr;
    }

    /**
     * @param downloadUrl
     * @param fileName    项目名称
     * @return
     * @throws Exception
     */
    /*@RequestMapping(value = "/download")
    @ResponseBody
    public ResponseEntity<byte[]> downLoad(String downloadUrl,String fileName) throws Exception {
        if(StringUtils.isNullString(fileName)){
            fileName = "java框生成.zip";
        }else{
            fileName = fileName+"_java框架生成.zip";
        }
        File file = new File(downloadUrl);
        if(!file.exists()){
            return null;
        }else{
            String parent = file.getParent();
            ZipUtils.createZip(downloadUrl,parent+File.separator+fileName);
            File downloadFile = new File(parent+File.separator+fileName);
            HttpHeaders headers = new HttpHeaders();
            fileName=new String(fileName.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(org.apache.commons.io.FileUtils.readFileToByteArray(downloadFile),
                    headers, HttpStatus.CREATED);
        }
    }*/
    @RequestMapping("/download")
    public String download(String downloadUrl, String fileName, HttpServletRequest request,
                           HttpServletResponse response, ModelMap modelMap,Model model) throws Exception {
        System.out.println("----coming to download---");
        if("mybatis".equals(request.getAttribute("flag"))){
            downloadUrl = (String) request.getAttribute("downloadUrl");
            fileName = (String)request.getAttribute("fileName");
        }
        if (StringUtils.isNullString(fileName)) {
            fileName = "java_framework.zip";
        } else {
            fileName = fileName + "_java_framework.zip";
        }
        String userAgent = request.getHeader("User-Agent");
        //fileName=new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        //针对IE或者以IE为内核的浏览器：
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            //非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.reset();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileName);
        try {
            File file = new File(downloadUrl);
            if (!file.exists()) {
                file.delete();
            }
            String parent = file.getParent();
            ZipUtils.createZip(downloadUrl, parent + File.separator + fileName);
            File downloadFile = new File(parent + File.separator + fileName);
            //创建temp11098763894xxui文件夹，将压缩好的文件再次进行压缩
            if(!"mybatis".equals(request.getAttribute("flag"))) {
                this.createZipAgain(downloadFile);
            }
            InputStream inputStream = new FileInputStream(downloadFile);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            os.flush();
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            // 这里主要关闭。
            os.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 2017年4月9日10:38:56
     * @param downloadFile
     * @return
     */
    private File createZipAgain(File downloadFile) {
        String parent = downloadFile.getParent();
        String fileName= downloadFile.getName();
        System.out.println(DateUtils.formatDate(new Date(),DateUtils.PATTERN_ASCTIME)+"\tcreateZipAgain\t"+parent);
        File tempFileal= new File(parent,"temp11098763894xxui");
        if(tempFileal.exists()){
            System.out.println("删除文件----"+tempFileal.listFiles().length);
           FileUtils.deleteDir(tempFileal);
        }else{
            tempFileal.mkdirs();
        }
        //将压缩后的zip拷贝到临时文件夹
        FileUtils.copyFile(downloadFile,tempFileal.getPath(),null);
        //将other文件夹的数据放进来
        ProjectUtils.copyOther(tempFileal.getPath(),"");
        //压缩文件
        ZipUtils.createZip(tempFileal.getPath(),parent+ File.separator + fileName);
        return new File(parent+ File.separator + fileName);
    }
}
