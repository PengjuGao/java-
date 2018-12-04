package com.auto.test;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/hello")
    @ResponseBody
    public String test(String id,Model model) {
        return "success";
    }
}