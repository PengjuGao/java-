package com.platform.client.aop;

import com.platform.base.common.shiro.ShiroUser;
import com.platform.base.utils.IPUtils;
import com.platform.core.po.TbClickRecord;
import com.platform.core.service.TbClickRecordService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by gaopengju on 2016/12/30.
 */
@Aspect
@Component
public class RecordAop {
    @Pointcut(value = "execution(@org.springframework.web.bind.annotation.RequestMapping * * (..))" )
    public void pointCut(){}
    @Autowired
    private TbClickRecordService clickRecordService;
    @After(value = "pointCut()")
    public void atfer(JoinPoint point){
       Object[] objects = point.getArgs();
       String ip = "";
       String uri = "";
       String browser = "";
        for (Object obj:
             objects) {
            if(obj instanceof HttpServletRequest){
                HttpServletRequest request = (HttpServletRequest)obj;
                ip = IPUtils.getIpFromRequest(request);
                uri = request.getRequestURI();
                browser = request.getHeader("user-agent");
                System.out.println(ip+"----------------------------------"+uri);
                TbClickRecord record = new TbClickRecord();
                record.setCreateTime(new Date());
                record.setUpdateTime(new Date());
                record.setIp(ip);
                record.setBrowser(browser);
                Subject subject = SecurityUtils.getSubject();
                ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
                if(shiroUser != null){
                    record.setUserid(shiroUser.getId());
                }
                //this.clickRecordService.insert(record);
            }
        }
    }
}
