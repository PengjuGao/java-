package com.platform.core.param;

import com.platform.core.param.common.CommonParam;

import java.io.Serializable;

/**
 * Created by gaopengju on 2016/12/26.
 */
public class RegisterParam extends CommonParam implements Serializable {

    private Integer userType;//注册类型
    private String password;//注册密码
    private String nick;
    private String verifyCode;//注册验证码

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
