package com.platform.jobs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.platform.jobs.tasks.TestTask;

@Controller
@RequestMapping("/jobs/index")
public class TestController {
    @Autowired
    TestTask testTask;
    @Autowired
    MyTask111Service m11Service;
	@RequestMapping("/test")
	public String testView(Model model){
		testTask.testxxTask();
		m11Service.testMyTask();
		model.addAttribute("message", "jobs success!!!");
		return "/index";
	}
}
