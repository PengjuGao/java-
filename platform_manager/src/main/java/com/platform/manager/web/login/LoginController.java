package com.platform.manager.web.login;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	//@Autowired
	//private TbFunctionService tbFunctionService;

	
	/**
	 * 检验是否登陆
	 * @param request
	 * @param response
	 */
	@RequestMapping("/isLogin")
	@ResponseBody
	public void isLogin(HttpServletRequest request,HttpServletResponse response){
		
		Subject subject = SecurityUtils.getSubject();
		
		if(subject.isAuthenticated()){
			System.out.println("已经登录了");
		}else{
			System.out.println("还未登录");
		}
		
	}
	
	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login.html",method={RequestMethod.GET,RequestMethod.POST})
	public String login(HttpServletRequest request,HttpServletResponse response,Model model){
		//获取用户名，密码
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Subject subject = SecurityUtils.getSubject();

		/*try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			//subject.isPermitted("123");
			// token.setRememberMe(true);
			subject.login(token);
			HttpSession session = request.getSession(false);
			session.setAttribute("username", username);
			
		}catch(Exception e){
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			model.addAttribute("errorMsg", "user name or pass word is error");
			
			return "forward:/index";
		}*/
		
		//暂时逻辑替代
		
		
		//return "login/parent";
		return "index";
	}
	
	/**
	 * 退出
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request,HttpServletResponse response,Model model){
    	
		Subject subject = SecurityUtils.getSubject();
		
		subject.logout();
		
    	return "Login";
    }
	
	
	@RequestMapping("/gotoMainPage")
    public String gotMainPage(HttpServletRequest request,HttpServletResponse response,Model model){
    	
		//页面展示信息:
		model.addAttribute("currentTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
    	return "login/main";
    }
	
	@RequestMapping("/gotoHeaderPage")
    public String gotoHeaderPage(HttpServletRequest request,HttpServletResponse response,Model model){
    	
		//Subject subject = SecurityUtils.getSubject();
		
		//subject.logout();
		
		return "common/header";
    }
	
	@RequestMapping("/gotoMenuPage")
    public String gotoMenuPage(HttpServletRequest request,HttpServletResponse response,Model model){
    	
		/*//所有菜单
		List<TbFunction> allList = tbFunctionService.selectByVo(null);
		
		//父菜单
		List<TbFunction> parentList = new ArrayList<TbFunction>();
		
		List<TbFunction> childrentList = new ArrayList<TbFunction>();
		
		for (TbFunction tbFunction : allList) {
			if(!"1".equals(tbFunction.getFunctionType())){
				continue;
			}
			if("-1".equals(tbFunction.getParentId())){
				parentList.add(tbFunction);
			}else{
				childrentList.add(tbFunction);
			}
		}
		//获取当前被选中的菜单id
		String funId = (String)request.getSession().getAttribute("functionId");
		model.addAttribute("funId", funId);
		model.addAttribute("parentList", parentList);
		
		model.addAttribute("childrentList", childrentList);*/
		
    	return "common/menu";
    }
}
