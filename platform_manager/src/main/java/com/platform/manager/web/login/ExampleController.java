package com.platform.manager.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Template")
public class ExampleController {

	
	@RequestMapping("/find-formx.html")
	public String findForm(HttpServletRequest request,HttpServletResponse response){
		
		System.out.println("---------find-form.do");
		
		return "/example/find-form";
	}
}
