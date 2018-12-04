package com.platform.base.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class SpringHolder implements  ApplicationContextAware {

	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		SpringHolder.context = context;
	}
	
	public static <T> T getBean(String beanName){
		T t = (T)SpringHolder.context.getBean(beanName);
		return t;
	}
}
