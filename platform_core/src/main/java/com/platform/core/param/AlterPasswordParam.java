package com.platform.core.param;

import com.platform.core.param.common.CommonParam;

import java.io.Serializable;

/**
 * Created by gaopengju on 2016/12/26.
 * 修改密码
 */
public class AlterPasswordParam extends CommonParam implements Serializable{

    private String oldPassword;
    private String newPassword;

    //如果是忘记密码
    private String verifyCode;
    private int type = -1;//1：修改密码 2：忘记密码

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
