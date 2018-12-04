package com.platform.client.common;

import com.platform.client.utils.FileUtils;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.List;


/**
 * Created by Administrator on 2016/10/30.
 * 统一解析自定义xml文件
 */
public class CommonParser {

    /***
     * 获取相应地址文件 并转换成document
     */
    public static Document getDoc(String webUrl){
        File file = new File(webUrl);
        Document document = getDoc(file);
        return document;
    }

    /**
     * 根据文件获取document
     * @param file
     * @return
     */
    public static Document getDoc(File file){
        try {
            InputStream in = new FileInputStream(file);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(in);
            return document;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取节点单个文件内容
     * @return
     */
    public static Document getDoc(Element element){
        String name =element.getName();
        if("java".equals(name)){

        }else if("pom".equals(name)){
            return getDocument(element);
        }else if("self".equals(name)){

        }else if("web".equals(name)){
          return getDocument(element);
        }
        return null;
    }

    public static Document getDocument(Element element){
        Element element1 = element.element("address");
        String url = element1.getTextTrim();
        InputStream inputStream =  CommonParser.class.getClassLoader().getResourceAsStream(url);
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputStream);
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 合并配置文件
     * @param fileUrl
     * @param document
     */
    public static void megreFile(String fileUrl,Document document,String whichFile){

        try {
            //获取file路径
            File file = new File(fileUrl);
            Document doc = CommonParser.getDoc(file);
            //获取片段中需要的片段
            Element tempRoot = document.getRootElement();
            List<Element> chilren = tempRoot.elements();
            //获取源中的root
            Element root = doc.getRootElement();
            if("pom".equals(whichFile)){
                //如果是pom文件需要先找到depenciy
                Element dependencies = root.element("dependencies");
                //获取统一配置区
                Element properties = root.element("properties");
                for (Element tempElement:
                     chilren) {
                    if("properties".equals(tempElement.getName())){
                        //统一配置区
                        List<Element> tempList = tempElement.elements();
                        for (Element xx :
                                tempList) {
                            xx.setParent(null);
                           // xx.add(properties.getNamespace());
                            properties.add( xx);
                        }
                    }else if("dependency".equals(tempElement.getName())){
                        tempElement.setParent(null);
                        //tempElement.add(properties.getNamespace());
                        dependencies.add(tempElement);
                    }
                }
            }else if("web".equals(whichFile)){
                for (int i = 0; i < chilren.size(); i++) {
                    Element temp= chilren.get(i);
                    temp.setParent(null);
                    //temp.add(root.getNamespace());
                    root.add(temp);
                }
            }

            //重新写入到web.xml中去
            String content = doc.asXML();
            Writer writer = null;
            writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
