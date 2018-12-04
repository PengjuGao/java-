package com.platform.client.web.register;

import com.platform.base.annotation.Token;
import com.platform.client.utils.ResultUtils;
import com.platform.core.param.RegisterParam;
import com.platform.core.param.common.CommonResult;
import com.platform.core.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gaopengju on 2016/12/26.
 * 注册控制器
 */
@Controller
@RequestMapping("/platform/register")
public class RegisterController {

    @Autowired
    TbUserService userService;
    /**
     * 跳转到注册页面
     * @return
     */
    @Token(save = true)
    @RequestMapping("/gotoRegister")
    public String gotoRegister(){
        return "project/register";
    }

    /**
     * 提交注册
     * @return
     */
    @Token(remove = true)
    @RequestMapping(value = "/doRegister",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String doRegister(RegisterParam param){
        CommonResult result = userService.doRegister(param);
        String resultStr =  ResultUtils.getView(result,ResultUtils.VIEW_TYPE_JSON,
                null,null);
        return resultStr;
    }

    @RequestMapping("/registerSuccess")
    public String registerSuccess(){
        return "/success";
    }
}
