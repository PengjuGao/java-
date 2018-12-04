package com.platform.base.common.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UrlFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		/*HttpServletRequest req = (HttpServletRequest) request;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String path = req.getContextPath();
		String ctx = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path;
		req.setAttribute("ctx", ctx);
		//获取路径放入session当中，目的是确定menu应该展开哪一个
		//req.getSession().setAttribute("menuUrl", req.get);*/
		ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest)request;
		Enumeration<String> headerNames = shiroRequest.getHeaderNames();
		while (headerNames.hasMoreElements()){
			String key = headerNames.nextElement();
			//System.out.println(key+"==="+shiroRequest.getHeader(key));
		}
		//判断如果是已登录状态，则忘记密码，登录，注册页面url不能再访问
		Subject subject = SecurityUtils.getSubject();
		String uri = shiroRequest.getRequestURI();
		if("/".equals(uri)){
			uri = "/home.jsp";
		}
		shiroRequest.setAttribute("uri",uri);
		if(subject.isAuthenticated()){
			if("/platform/login/goToLogin".equals(uri) || "/platform/register/gotoRegister".equals(uri)||"/platform/alterPassword/gotForgetPwd".equals(uri)
					){
				shiroRequest.getRequestDispatcher("/home.jsp").forward(request,response);
				return;
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
