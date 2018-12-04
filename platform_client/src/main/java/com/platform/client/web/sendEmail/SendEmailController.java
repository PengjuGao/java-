package com.platform.client.web.sendEmail;

import com.platform.base.cache.MemcacheCache;
import com.platform.base.utils.Validator;
import com.platform.client.service.EmailService;
import com.platform.core.param.common.CommonResult;
import com.platform.core.po.TbUser;
import com.platform.core.service.TbUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gaopengju on 2016/12/28.
 * 发送邮件
 */
@Controller
@RequestMapping("/platform/email")
public class SendEmailController {

    @Autowired
    private EmailService emailService;
    @Autowired
    private MemcacheCache memcacheCache;
    @Autowired
    private TbUserService userService;
    /**
     * 向邮箱发送验证码
     * @return
     */
    @RequestMapping(value = "/sendVerifyCode",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String sendVerifyCode(String email,String sendType){
        CommonResult result = new CommonResult();
        try {
            if("register".equals(sendType)) {
                //TODO:校验email 是否存在
                TbUser tbUser = userService.userIsExists(email);
                if (tbUser != null) {
                    result.setCode(302);
                    result.setMessage("邮箱已存在");
                    return JSONObject.fromObject(result).toString();
                }
            }
            if(Validator.isEmail(email)){
                //生成六位随机数
                String random = String.valueOf(Math.round((Math.random()*9+1)*100000));
                //往缓存中写记录
                memcacheCache.put(email,random);
                emailService.sendTextMail(email,random);
            }else{
                result.setCode(302);
                result.setMessage("邮箱错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(204);
            result.setMessage("send email error,please contact the administrator....");
        }
        return JSONObject.fromObject(result).toString();
    }

}
