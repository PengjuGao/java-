package com.platform.client.web.sitemesh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/28.
 * sitemesh controller
 */
@Controller
@RequestMapping("/sitemesh")
public class SitemeshController {
    /**
     * 获取jsp
     * @return
     */
    @RequestMapping("/header")
    public String header(Model model){
        model.addAttribute("name","homepage");
        return "project/common/header";
    }
}
