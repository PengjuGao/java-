package com.platform.client.web;

import com.platform.base.cache.MemcacheCache;
import com.platform.client.common.CommonParser;
import com.platform.client.common.Resources;
import com.platform.client.factory.FunctionFactory.BaseFunction;
import com.platform.client.service.*;
import com.platform.client.utils.FileUtils;
import com.platform.client.vo.CommonVo;
import com.platform.client.vo.FrameworkVo;
import com.platform.client.vo.ProjectResult;
import com.platform.client.vo.ProjectVo;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 * 生成项目的controller
 * 第一：生成项目骨架
 * 第二：添加第三方配置
 * 第三：添加功能
 * 第四：生成zip包
 * 第五：完成
 */
@Controller
@RequestMapping("/platform")
public class MainController {

    @Autowired
    MakeProjectService makeProjectService;
    @Autowired
    FrameworkService frameworkService;
    @Resource(name = "memcacheCache")
    MemcacheCache cache;
    @Autowired
    FunctionService functionService;
    @Autowired
    CommonService commonService;
    @Autowired
    CacheService cacheService;
    /**
     * 第一步：
     * 根据传递的值生成项目骨架
     * @return
     */
    @RequestMapping("/makeProject")
    public String makeProject(FrameworkVo vo,Model model){
        //创建骨架
        makeProjectService.makeProject(vo);
        //添加web框架，orm框架
        frameworkService.addFramework(vo);
        //将vo对象放到memcache中
        cache.getClient().add(vo.getUserId(),10*60,vo);
        return "/page/next";
    }

    /**
     * 添加数据库
     * @return
     */
    @RequestMapping("/addDatabase")
    @ResponseBody
    public String addDatabase(FrameworkVo vo){
        String userId = vo.getUserId();
        //获取缓存中的framework对象
        FrameworkVo frameworkVo = (FrameworkVo) cache.get(userId);
        //如果找不到，将userId下的文件夹全删除
        if(frameworkVo == null){
            //delete
        }else{
            BeanUtils.copyProperties(frameworkVo,vo);
            CommonService.getDataBaseFunctionService(vo);

        }
        return "success";
    }


    /**
     * 添加数据库
     * @return
     */
    @RequestMapping("/addFunctions")
    @ResponseBody
    public String addFunctions(FrameworkVo vo){
       String userId = vo.getUserId();
        //获取缓存中的framework对象
        FrameworkVo frameworkVo = (FrameworkVo) cache.get(userId);
        //如果找不到，将userId下的文件夹全删除
        if(frameworkVo == null){
            //delete
        }else{
            this.functionService.addFunction(vo);
        }
        return "success";
    }

    /***
     * 功能生成页面
     * @return
     */
    @RequestMapping("/toMakeFunction")
    public String toMakeFunction(){
        return "/page/function";
    }

    /***
     * 功能结构生成
     * @param functionName
     * @return
     */
    @RequestMapping("/makeFunction")
    @ResponseBody
    public String makeFunction(String functionName){
        String path = System.getProperty("user.dir");
        FrameworkVo vo = new FrameworkVo();
        vo.setPath(path);
        String filePath = path+File.separator+ Resources.PRO_MAIN_RESOURCES+"/template/baseFile/function.xml";
        Document document = CommonParser.getDoc(filePath);
        Element root = document.getRootElement();
        List<Element> children = root.elements();
        StringBuilder builder = new StringBuilder();
        for (Element child :
                children) {
            String attrValue = child.attributeValue("type");
            String targetValue = child.attributeValue("target");
            String[] texts = child.getText().split(";");
            if("copy".equals(attrValue)){
                for (String file :
                        texts) {
                    String newFileName = BaseFunction.dealFileName(file);
                    newFileName = functionName+"."+newFileName.split("\\.")[1];
                    InputStream in =  this.getClass().getClassLoader().getResourceAsStream(file);
                    File newFile = FileUtils.copyFile(in,path+File.separator+Resources.PRO_MAIN_RESOURCES+File.separator+targetValue,newFileName);
                    builder.append("file path is "+newFile.getAbsolutePath()).append("\n");
                }
            }else if("create".equals(attrValue)){
                for (String file :
                        texts) {
                    File newFile = FileUtils.createDir(path+File.separator+Resources.PRO_MAIN_RESOURCES+File.separator+targetValue+File.separator+functionName+File.separator+file);
                    builder.append("file path is "+newFile.getAbsolutePath()).append("\n");
                }
            }
        }
        return builder.toString();
    }

    @RequestMapping("/cache")
    @ResponseBody
    public String testCache(){
        String value = cacheService.getHello();
        return value;
    }

    @RequestMapping("/getCache")
    @ResponseBody
    public String getCache(){
        String value = cacheService.getCache();
        return value;
    }
}
