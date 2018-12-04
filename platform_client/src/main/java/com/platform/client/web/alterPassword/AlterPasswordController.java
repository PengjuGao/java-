package com.platform.client.web.alterPassword;

import com.platform.base.annotation.Token;
import com.platform.base.common.shiro.ShiroUser;
import com.platform.client.utils.ResultUtils;
import com.platform.client.utils.SessionUtils;
import com.platform.core.param.AlterPasswordParam;
import com.platform.core.param.common.CommonResult;
import com.platform.core.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gaopengju on 2016/12/26.
 * 修改密码
 */
@Controller
@RequestMapping("/platform/alterPassword")
public class AlterPasswordController {

    @Autowired
    private TbUserService userService;

    /**
     * 登录后修改密码
     * @param passwordParam
     */
    @Token(remove = true)
    @RequestMapping(value = "/loginAlterPassword",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String loginAlertPassword(AlterPasswordParam passwordParam){
       ShiroUser shiroUser = SessionUtils.getShiroUser();
        passwordParam.setUserId(shiroUser.getUsername());
        CommonResult result = userService.updateLoginPassword(passwordParam);
        String resultStr = ResultUtils.getView(result,ResultUtils.VIEW_TYPE_JSON,null,null);
        return resultStr;
    }

    /**
     * 未登录修改密码提交
     * @param passwordParam
     * @return
     */
    @RequestMapping("/unloginAlterPassword")
    public String unloginAlertPassword(AlterPasswordParam passwordParam){
        CommonResult result = userService.updateUnLoginPassword(passwordParam);
        String resultStr = ResultUtils.getView(result,ResultUtils.VIEW_TYPE_PAGE,"/success","/error");
        return resultStr;
    }

    /**
     * 忘记密码页面
     * @return
     */
    @RequestMapping("/gotForgetPwd")
    public String gotoForgetPwd(){
        return "project/forgetPassword";
    }

}
