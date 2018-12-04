package com.platform.base.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.platform.base.common.page.incepter.ReflectionUtils;

/**
 * @author gaopj
 * 处理移动端请求
 */
public class APParamUtils {

	
	/***********************
	 * 2016年4月13日下午5:11:04
	 * @param request
	 * @param clazz
	 * @return
	 * @author gaopj
	 * 功能：提取请求中的参数，隐射成需要的类
	 ***********************/
	
	public static <T> T getParamBean(HttpServletRequest request,Class<T> clazz){
		
		try {
			T t = clazz.newInstance();
			//获取所有参数集合
			Enumeration<String> enra = request.getParameterNames();
			//遍历参数集合
			while(enra.hasMoreElements()){
				String key = enra.nextElement();
				String value = request.getParameter(key);
				ReflectionUtils.operate(t, key, value, "set");
			}
			return t;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
