package com.platform.manager.web.genterProject;

import com.platform.manager.web.genterProject.po.ProjectParam;
import com.platform.manager.web.genterProject.po.WebFrameWorkParam;
import com.platform.manager.web.genterProject.service.ConfigFileFactory;
import com.platform.manager.web.genterProject.utils.CommonUtils;
import com.platform.manager.web.genterProject.utils.xmlUtils.XMLUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by gaoepngju on 16/6/28.
 */
@Controller
@RequestMapping("/system/makeProject")
public class GenterProjectController {

    public static final Logger logger = Logger.getLogger(GenterProjectController.class);
    @Autowired
    ConfigFileFactory factory;
    /**
     * 跳转到设置页面:
     * 设置项目的参数
     *
     * @return
     * @see com.platform.manager.web.genterProject.po.ProjectParam
     */
    @RequestMapping("/toSetPage.html")
    public String toSetPage() {

        return "/tbfunction/add";
    }

    /**
     * 根据传递的类型提供不同的设置页面
     */
    @RequestMapping("/toParamPage")
    public String toParamPage(String type) {

        return type;
    }

    /**
     * 生成简单的maven项目
     */
    @RequestMapping("/makeSimpleProject")
    public String makeSimpleProject(ProjectParam param) {
        //解析xml文件
        Document doc = XMLUtils.xml4project(GenterProjectController.class.getClassLoader().getResourceAsStream("maven-webapp.xml"));
        Element root = doc.getRootElement();
        List<Element> list = root.elements();
        //解析doc---创建文件夹及文件
        Map<String,String> map = CommonUtils.make(param.getType(), list,param.getUrl());
        //创建简单的配置文件:生成简单的web.xml,pom.xml,index.jsp 文件
        Set<String> keySet = map.keySet();
        for (String key :
                keySet) {
            String filePath = map.get(key);
            //创建文件
            factory.getService(key).createFile(key,filePath);
           if("pom.xml".equals(key)){
               param.setPomxmlPath(filePath);
           }else if("web.xml".equals(key)){
               param.setWebxmlPath(filePath);
           }else if("index.jsp".equals(key)){
               param.setIndexjspPath(filePath);
           }
        }

        return "/tbfunction/done";
    }

    /**
     * goto添加web框架页面
     */
    @RequestMapping("toAddWEBFrameWork")
    public String toAddWEBFrameWork(ProjectParam param, ModelMap modelMap){
        //调用make项目
        this.makeSimpleProject(param);
        modelMap.put("projectParam",param);//一些参数信息接下来会用到
        return "/tbfunction/addWEBFrameWork";
    }

    /**
     * 添加web框架页面设置
     */
    @RequestMapping("addWEBFrameWork")
    public String addWEBFrameWork(WebFrameWorkParam param){

        //1.获取并修改web.xml,添加spirng的框架
        //2.根据web.xml中设定好的值,创建spring文件夹及spring.xml(其他需要添加的xml设置成(applicationContext-*.xml)
        //3.修改pom.xml文件,增加spring相关jar包依赖


        return "/tbfunction/addWEBFrameWork";
    }









}
