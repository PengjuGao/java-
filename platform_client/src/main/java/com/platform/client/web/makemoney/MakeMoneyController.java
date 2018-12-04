package com.platform.client.web.makemoney;

import com.platform.core.service.TbClickRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gaopengju on 2016/12/29.
 *
 */
@Controller
@RequestMapping("/platform/makeMoney")
public class MakeMoneyController {

    @Autowired
    TbClickRecordService service;
    /**
     * 页面展示
     * @return
     */
    @RequestMapping("/gotoMakeMoneyPage")
    public String gotoMakeMoneyPage(HttpServletRequest request, HttpServletResponse response, Model model){
        //TODO:记录访问的人
        return "project/makeMoney";
    }

    /**
     * 页面展示
     * @return
     */
    @RequestMapping("/gotoRewardPage")
    public String gotoRewardPage(HttpServletRequest request, HttpServletResponse response, Model model){
        //TODO:记录访问的人
        return "project/reward";
    }
}
