package com.platform.client.runnable;

import com.platform.base.common.shiro.ShiroUser;
import com.platform.client.utils.SessionUtils;
import com.platform.core.po.TbUser;
import com.platform.core.service.TbUserService;
import org.apache.thrift.TBase;

import java.util.Date;

/**
 * Created by Administrator on 2017/1/14.
 * 记录用户最后的登陆时间
 */
public class RunnableRecordLogin implements Runnable{

    private TbUserService userService;

    public void setUserService(TbUserService userService) {
        this.userService = userService;
    }

    @Override
    public void run() {
        ShiroUser user = SessionUtils.getShiroUser();
        if(user == null){
            System.out.println("--------------can't find shirouser in session --------------error error error");
            return;
        }else{
            TbUser tbUser = new TbUser();
            tbUser.setId(user.getId());
            tbUser.setLastLoginTime(new Date());
            userService.updateByPrimaryKeySelective(tbUser);
        }
    }
}
