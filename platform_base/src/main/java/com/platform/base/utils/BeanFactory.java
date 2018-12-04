package com.platform.base.utils;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SuppressWarnings("unchecked")
public final class BeanFactory implements ApplicationContextAware {
	
	private static ApplicationContext context;
	
	private BeanFactory(){}
	
	public static <T> T getBean(String beanName) {
		return (T)context.getBean(beanName);
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return (T)context.getBeansOfType(clazz);
	}
	
	public static <T> T getBean(Class<T> clazz, boolean includeNonSingletons, boolean allowEagerInit) {
		return BeanFactoryUtils.beanOfType(context, clazz, includeNonSingletons, allowEagerInit);
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		if(null == context) {
			context = applicationContext;
		}
	}
}