package com.platform.manager.web.genterProject.utils.xmlUtils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * 专门解析xml文件
 * Created by gaoepngju on 16/7/1.
 */
public class XMLUtils {
    /**
     * 根据流解析xml文件
     * @param xmlstram
     * @return
     */
    public static Document xml4project(InputStream xmlstram){

        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(xmlstram);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return doc;
    }

}
