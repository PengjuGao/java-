package com.platform.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
@RequestMapping("/platform")
public class TestController{
    @RequestMapping("/hello")
    public String test(Map<String,String> map){
        Set<String> keySet = map.keySet();
        for (String key :
                keySet) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
        System.out.println("hello");
        return "/page/main";
    }

    @RequestMapping("/top")
    public String top(){
        System.out.println("top");
        return "page/top";
    }

    @RequestMapping("/left")
    public String left(){
        System.out.println("left");
        return "page/left";
    }
    @RequestMapping("/index")
    public String index(){
        System.out.println("index");
        return "page/index";
    }

    @RequestMapping("/computer")
    public String computer(){
        System.out.println("computer");
        return "page/computer";
    }

    @RequestMapping("/default11")
    public String default11(){
        System.out.println("default11");
        return "page/default";
    }
    @RequestMapping("/error")
    public String error(){
        System.out.println("error");
        return "page/error";
    }

    @RequestMapping("/form")
    public String form(){
        System.out.println("form");
        return "page/form";
    }

    @RequestMapping("/imglist")
    public String imglist(){
        System.out.println("imglist");
        return "page/imglist";
    }

    @RequestMapping("/imglist1")
    public String imglist1(){
        System.out.println("imglist1");
        return "page/imglist1";
    }

    @RequestMapping("/imgtable")
    public String imgtable(){
        System.out.println("imgtable");
        return "page/imgtable";
    }

    @RequestMapping("/right")
    public String right(){
        System.out.println("right");
        return "page/right";
    }

    @RequestMapping("/filelist")
    public String filelist(){
        System.out.println("filelist");
        return "page/filelist";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("login");
        return "page/login";
    }

    @RequestMapping("/tab")
    public String tab(){
        System.out.println("tab");
        return "page/tab";
    }
    @RequestMapping("/tools")
    public String tools(){
        System.out.println("tools");
        return "page/tools";
    }
    @RequestMapping("/toFirstPage")
    public String firstPage(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request.getAuthType()="+request.getAuthType());
        System.out.println("request.getContextPath()="+request.getContextPath());
        System.out.println("request.getPathInfo()="+request.getPathInfo());
        System.out.println("request.getQueryString()="+request.getQueryString());
        System.out.println("request.getPathTranslated()="+request.getPathTranslated());
        System.out.println("request.getRemoteUser()="+request.getRemoteUser());
       Cookie[] cookies = request.getCookies();
       if(cookies != null && cookies.length>0){
           for (Cookie cookie :
                   cookies) {
               System.out.println("cookieName="+cookie.getName());
               System.out.println("cookieValue="+cookie.getValue());
               System.out.println(cookie.getComment());
               System.out.println(cookie.getDomain());
               System.out.println(cookie.getMaxAge());
               System.out.println(cookie.getPath());
               System.out.println(cookie.getSecure());
               System.out.println(cookie.getSecure());
               System.out.println(cookie.getVersion());
           }
           Cookie tempCokie = new Cookie("hello","gaopengju");
           response.addCookie(tempCokie);
       }else {

       }
        return "function/firstPage";
    }

    @RequestMapping("/toHeader")
    public String toHeader(){
        return "common/header";
    }

}
