package com.platform.manager.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String toLogin(HttpServletRequest request,HttpServletResponse response){
		
		
		System.out.println("------------/ ----跳转到login--------");
		
		return "/login";
	}

}
