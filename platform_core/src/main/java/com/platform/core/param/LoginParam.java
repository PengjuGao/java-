package com.platform.core.param;

import com.platform.core.param.common.CommonParam;

import java.io.Serializable;

/**
 * Created by gaopengju on 2016/12/26.
 * 登录参数
 */
public class LoginParam extends CommonParam implements Serializable {

    private String password;
    private String verifyCode;//验证码
    private int remeberMe;//0:不记住 1:记住

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public int getRemeberMe() {
        return remeberMe;
    }

    public void setRemeberMe(int remeberMe) {
        this.remeberMe = remeberMe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
