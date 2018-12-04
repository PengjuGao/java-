package com.platform.manager.web.genterProject.service.webxmlService;

import com.platform.manager.web.genterProject.utils.xmlUtils.XMLUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * 修改webxml文件
 * Created by gaoepngju on 16/7/4.
 */
public class WebxmlService {

    public static final String SPRING_MVC_WEB_XML = "springmvc_web.xml";

    /**
     * 添加springMvc配置到web.xml中去
     * 返回的map是要放到页面展示的信息
     *
     * @param filePath
     * @return map
     */
    public static Map<String, String> addSpringMvc(String filePath) {
        //读取文件,向文件里添加xml片段,输出新的文件
        InputStream in = WebxmlService.class.getResourceAsStream(SPRING_MVC_WEB_XML);
        Document tempDoc = XMLUtils.xml4project(in);

        //源文件
        try {

            File file = new File(filePath);
            if (file.exists()) {
                InputStream is = new FileInputStream(file);
                Document sourceDoc = XMLUtils.xml4project(is);

                //获取片段中需要的片段
                Element tempRoot = tempDoc.getRootElement();
                List<Element> chilren = tempRoot.elements();
                //获取源中的root
                Element root = sourceDoc.getRootElement();
                for (int i = 0; i < chilren.size(); i++) {
                    root.add(chilren.get(i));
                }

                //重新写入到web.xml中去
                String content = sourceDoc.asXML();
                Writer writer = new FileWriter(file);
                writer.write(content);

                writer.close();
                is.close();
                in.close();

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 添加structs配置文件
     * 返回的map是要放到页面展示的信息
     *
     * @param filePath
     */
    public static Map<String, String> addStructs(String filePath) {

        return null;
    }

    public static void main(String[] args) {
        addSpringMvc("/Users/heyanyang/most_code/ximi_api/platform_manager/src/main/webapp/WEB-INF/web.xml");
    }
}
