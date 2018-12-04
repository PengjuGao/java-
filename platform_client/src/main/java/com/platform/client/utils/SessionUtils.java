package com.platform.client.utils;

import com.platform.base.common.shiro.ShiroUser;
import com.platform.core.po.TbUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Created by gaopengju on 2016/12/27.
 * shiro session工具类
 */
public class SessionUtils {

    /**
     * 获取session
     * @return
     */
    public static Session getSession(){
        Session session = SecurityUtils.getSubject().getSession();
        return session;
    }

    /**
     * 获取当前用户信息
     * @return
     */
    public static ShiroUser getShiroUser(){
        Subject subject = SecurityUtils.getSubject();
        ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
        return shiroUser;
    }

}
