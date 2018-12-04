package com.platform.client.web;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/8.
 */
@Controller
@RequestMapping("/platform")
public class FreemakerController {

    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;
    @RequestMapping("/freemaker")
    public void dealFtl(HttpServletResponse response){
        try {
          Template template =  freeMarkerConfigurer.getConfiguration().getTemplate("hello.ftl");
            Map<String,String> map = new HashMap<String,String>();
            map.put("project","haha");
            map.put("mavenType","web");
          template.process(map, response.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
