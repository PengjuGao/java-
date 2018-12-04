package com.platform.client.common;

import com.platform.base.web.SpringHolder;
import com.platform.client.config.ConfigVo;
import com.platform.client.utils.FileUtils;
import org.dom4j.Document;

import java.io.*;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/9.
 */
public class ProjectUtils {

    /**
     * 读取baseFile文件，创建文件
     */
    public static File makeProject( Map map){
        ConfigVo vo = SpringHolder.getBean("configVo");
        String userId = (String) map.get("userId");
        String path = vo.getRootPath()+File.separator+userId;
        final String content = FTLUtils.getContent("hello.ftl",map);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(content.trim().getBytes());
        Document document = XMLUtils.getDocument(inputStream);
        XMLUtils.parse(document,map);
        //创建一个跟用户相关的xml
        ByteArrayInputStream tempInstrum = new ByteArrayInputStream(document.asXML().getBytes());
        File file = FileUtils.copyFile(tempInstrum,path,userId+"_doc.xml");
        return file;
    }

    /**
     * 获取项目路径
     * @return
     */
    public static String getProjectPath(String userId){
        ConfigVo vo =SpringHolder.getBean("configVo");
        String path = vo.getRootPath()+File.separator+userId;
        return path;
    }

    /**
     * 获取项目画像的document
     * @param userId
     * @return
     */
    public static Document getProjectDocument(String userId){
        String path = getProjectPath(userId);
        File file = new File(path+File.separator+userId+"_doc.xml");
        if(!file.exists()){
            return null;
        }else{
            BufferedInputStream inputStream = null;
            try {
                inputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Document document = XMLUtils.getDocument(inputStream);
            return document;
        }
    }

    /**
     * 拷贝jsFramework 框架
     */
    public static void copyJsFramework(String path,String jsFrameworkType){
        //获取目标位置
        ConfigVo vo = SpringHolder.getBean("configVo");
        String jsPath = vo.getJsFrameworkPath()+File.separator+jsFrameworkType;
        System.out.println("--------jsPath---"+jsPath);
        FileUtils.copyDir(jsPath,path);
    }

    /**
     * 拷贝htmlFramework 框架
     */
    public static void copyHtmlFramework(String path,String htmlFrameworkType){
        //获取目标位置
        ConfigVo vo = SpringHolder.getBean("configVo");
        String htmlPath = vo.getHtmlFrameworkPath()+File.separator+htmlFrameworkType;
        System.out.println("--------jsPath---"+htmlPath);
        FileUtils.copyDir(htmlPath,path);
    }

    /**
     * 拷贝其他文件
     */
    public static void copyOther(String path,String otherType){
        //获取目标位置
        ConfigVo vo = SpringHolder.getBean("configVo");
        String htmlPath = vo.getOtherPath()+File.separator+otherType;
        System.out.println("--------otherPath---"+htmlPath);
        FileUtils.copyDir(htmlPath,path);
    }
}
