package com.platform.base.annotation;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpServletResponse;    
import java.lang.reflect.Method;    
import java.util.UUID;    
    
public class TokenInterceptor implements HandlerInterceptor {

    private String redirect;

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);  //判断是否有标注
            if (annotation != null) {
                boolean needSaveSession = annotation.save();
                if (needSaveSession) {
                    //生成uuid随机token，反射到jsp
                    request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
                }
                boolean needRemoveSession = annotation.remove();  //saveentity方法触发
                if (needRemoveSession) {
                    if (isRepeatSubmit(request)) {
                       response.sendRedirect(redirect);
                        return false;
                    }
                    //防止下一次进入，去掉token，
                    request.getSession(false).removeAttribute("token");
                }
            }
            return true;
        } else {
            request.getRequestDispatcher(redirect).forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("-----------postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("-----------afterCompletion--------");
    }

    /** 
     * 判断是否重复点击 
     *  @author 李品良 
     *创建时间：2016年9月10日 下午2:26:05 
     * @param request 
     * @return 
     */  
    private boolean isRepeatSubmit(HttpServletRequest request) {   
        //那么下一次，这个方法就失败了.  
        String serverToken = (String) request.getSession(false).getAttribute("token");    
        if (serverToken == null) {    
            return true;    
        }    
        String clinetToken = request.getParameter("token");    
        if (clinetToken == null) {    
            return true;    
        }    
        if (!serverToken.equals(clinetToken)) {    
            return true;    
        }    
        return false;    
    }    
}    