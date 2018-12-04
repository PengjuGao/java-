package com.platform.manager.web.genterProject.utils;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gaoepngju on 16/7/1.
 */
public class CommonUtils {

    public static Logger logger = Logger.getLogger(CommonUtils.class);

    /**
     * 解析maven_webapp.xml并生成项目结构
     */
    public static Map<String,String> make(String type, List<Element> list, String path) {

        Map<String,String> map = new ConcurrentHashMap<String,String>();
        for (Element tempObj:list
                ) {
            String dirPath = path;
            //获取name和value属性
            Attribute nameAttr= tempObj.attribute("name");
            Attribute valueAttr = tempObj.attribute("value");
            if(nameAttr != null && valueAttr != null){
                //获取值,并组装成url,生成文件
                String name = nameAttr.getValue();
                String value = valueAttr.getValue();
                if ("dir".equals(value)){
                    if("jar".equals(type)){
                        if("webapp".equals(name)){
                            continue;
                        }
                    }
                    File file = new File(path,name);
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    dirPath = file.getAbsolutePath();
                    System.out.println("----make dir---"+dirPath);
                    logger.info("----make dir---"+dirPath);
                }else if ("file".equals(value)){
                    File file = new File(path,name);
                    if(!file.exists()){
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    map.put(name,file.getAbsolutePath());
                    System.out.println("====make file===="+file.getAbsolutePath());
                    logger.info("====make file===="+file.getAbsolutePath());
                }

            }
            //获取该节点下的元素列表,继续创建文件
            List<Element> chirenList = tempObj.elements();
            Map<String,String> tempMap =CommonUtils.make(type,chirenList,dirPath);
            map.putAll(tempMap);
        }
        return map;
    }

}
