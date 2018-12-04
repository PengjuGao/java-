package com.platform.client.web.feedback;

import com.platform.base.annotation.Token;
import com.platform.base.common.shiro.ShiroUser;
import com.platform.client.utils.ResultUtils;
import com.platform.core.param.FeedbackParam;
import com.platform.core.param.common.CommonResult;
import com.platform.core.service.TbFeedbackService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gaopengju on 2016/12/28.
 * 信息反馈
 */
@Controller
@RequestMapping("/platform/feedback")
public class FeedbackController {


    @Autowired
    private TbFeedbackService feedbackService;

    /**
     * 跳转到信息反馈页面
     * @param model
     * @return
     */
    @Token(save = true)
    @RequestMapping("gotoFeedbackPage")
    public String gotoFeedbackPage(String page, Model model){
        Subject subject = SecurityUtils.getSubject();
        ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
        if(shiroUser != null){
            if("userFeedback".equals(page)){
                return "/project/center_feedback";
            }
        }
        return "/project/feedback";
    }

    /**
     * 提交反馈信息
     * @param param
     * @return
     */
    @Token(remove = true)
    @RequestMapping("/doFeedback")
    public String doFeedback(FeedbackParam param){
        CommonResult result = feedbackService.addFeedback(param);
        String resultStr = ResultUtils.getView(result,ResultUtils.VIEW_TYPE_PAGE,"redirect:/platform/home/gotoHome","/error");
        return resultStr;
    }

}
