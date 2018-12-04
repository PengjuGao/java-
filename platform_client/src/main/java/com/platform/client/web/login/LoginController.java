package com.platform.client.web.login;

import com.platform.base.common.verifyCode.VerifyCode;
import com.platform.client.utils.ResultUtils;
import com.platform.core.param.LoginParam;
import com.platform.core.param.common.CommonResult;
import com.platform.core.service.TbUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gaopengju on 2016/12/22.
 * 登录页面
 */
@Controller
@RequestMapping("/platform/login")
public class LoginController {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    private TbUserService userService;

    /**
     * 登录动作
     * @return
     */
    @RequestMapping(value = "/doLogin",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(HttpServletRequest request,LoginParam param, Model model){
        CommonResult result = new CommonResult();
        String verifyCode = (String) request.getSession().getAttribute(VerifyCode.VERIFY_TYPE_COMMENT);
        if(param.getVerifyCode().equalsIgnoreCase(verifyCode)) {
            Subject subject = SecurityUtils.getSubject();
            try {
                UsernamePasswordToken token = new UsernamePasswordToken(param.getUserId(), param.getPassword());
                //subject.isPermitted("123");
                // token.setRememberMe(true);
                subject.login(token);
                //Session session = subject.getSession();
                //异步更新最后登陆记录
                //RunnableRecordLogin loginRunner = new RunnableRecordLogin();
                //loginRunner.setUserService(this.userService);
                //taskExecutor.execute(loginRunner);
            } catch (Exception e) {
                e.printStackTrace();
                //System.out.println(e.getMessage());
                result.setCode(206);
                result.setMessage("用户名密码不正确");
            }
        }else{
            result.setCode(207);
            result.setMessage("验证码输入不正确");
        }
        String resultStr = ResultUtils.getView(result,ResultUtils.VIEW_TYPE_JSON,null,null);
        return resultStr;
    }

    /**
     * 实际登录跳转
     * @return
     */
    @RequestMapping("/actualLogin")
    public String actualLogin(HttpServletRequest request,HttpServletResponse response,Model model){
        //TODO: 处理
        return "/project/home";
    }


    /**
     * 跳转到的登录页面
     * @return
     */
    @RequestMapping("/goToLogin")
    public String goToLogin(HttpServletRequest request, HttpServletResponse response, Model model){
        return "project/login";
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "/project/home";
    }
}
