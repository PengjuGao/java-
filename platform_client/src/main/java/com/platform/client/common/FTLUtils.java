package com.platform.client.common;

import com.platform.base.web.SpringHolder;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/11/9.
 * 解析ftlUtils
 */
public class FTLUtils {

    public static Lock lock = new ReentrantLock();

    /**
     * 解析ftl
     * @return
     */
    public static String getContent(String ftlFile,Map map){
        System.out.println("-------------------ftlFile-------------------");
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream() ;
            Writer writer = new OutputStreamWriter(out);
            FreeMarkerConfigurer configurer = SpringHolder.getBean("freemarkerConfig");
            Template template = configurer.getConfiguration().getTemplate(ftlFile);
            template.process(map,writer);
            String result =  out.toString("utf-8");
           // return  new String(buffer.array(),"UTF-8");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("project","myProject");
        String xx = FTLUtils.getContent("hello.ftl",map);
        System.out.println(xx);
    }
}
