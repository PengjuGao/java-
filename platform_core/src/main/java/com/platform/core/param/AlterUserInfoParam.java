package com.platform.core.param;

import com.platform.core.param.common.CommonParam;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/14.
 * 用户信息修改
 */
public class AlterUserInfoParam extends CommonParam implements Serializable{

    private String nick;
    private Integer userType;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
