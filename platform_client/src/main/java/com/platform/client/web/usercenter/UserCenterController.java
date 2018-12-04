package com.platform.client.web.usercenter;

import com.platform.base.annotation.Token;
import com.platform.base.common.page.Page;
import com.platform.base.common.page.PageBean;
import com.platform.base.common.shiro.ShiroUser;
import com.platform.base.utils.StringUtils;
import com.platform.client.utils.ResultUtils;
import com.platform.client.utils.SessionUtils;
import com.platform.client.vo.RecordVo;
import com.platform.core.param.AlterUserInfoParam;
import com.platform.core.param.common.CommonResult;
import com.platform.core.po.TbRecord;
import com.platform.core.po.TbUser;
import com.platform.core.service.TbRecordService;
import com.platform.core.service.TbUserService;
import com.platform.core.vo.TbRecordVo;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaopengju on 2017/1/6.
 */
@Controller
@RequestMapping("/platform/user")
public class UserCenterController {

    @Autowired
    private TbRecordService recordService;
    @Autowired
    private TbUserService userService;

    /**
     * 用户中心页面跳转
     * @param page
     * @param model
     * @return
     */
    @Token(save = true)
    @RequestMapping("/gotoCenter")
    public String gotoCenter(String page,Model model){
        //能进入个人中心说明用户已经的登陆，否则跳转到首页
        ShiroUser shiroUser = SessionUtils.getShiroUser();
        if(shiroUser == null){
            return "/project/home";
        }
        /***为空跳转到首页***/
        if(StringUtils.isNullString(page)){
            return "/home";
        }else if("frameworkList".equals(page)){
            return "forward:/platform/user/frameworkList";
        }else if("alterPassword".equals(page)){
            return "project/center_alterpassword";
        }else if("alterUserInfo".equals(page)){
            //查询用户信息
            TbUser tbUser = this.userService.selectByPrimaryKey(new BigDecimal(shiroUser.getId()));
            if(tbUser != null){
                model.addAttribute("user",tbUser);
            }
            return "project/center_alteruserinfo";
        }else if("reward".equals(page)){
            return "project/reward";
        }
        return "/home";
    }

    /**
     * 框架列表分页查询
     * @param pageBean
     * @param model
     * @return
     */
    @RequestMapping("/frameworkList")
    public String frameworkList(PageBean pageBean,Model model){
        TbRecordVo vo = new TbRecordVo();
        TbRecordVo.Criteria citer = vo.or();
        Subject subject = SecurityUtils.getSubject();
        ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
        citer.andUserIdEqualTo(shiroUser.getId());
        //citer.andStatusEqualTo(1);
        vo.setOrderByClause("create_time desc");
        Page<TbRecord> page = recordService.selectByVoAndPage(vo,pageBean);
        model.addAttribute("page",page);
        List<TbRecord> list = page.getListResult();
        //处理列表中的json数据
        List<RecordVo> newList = dealPageList(list);
        model.addAttribute("list",newList);
        return "project/center_frameworklist";
    }

    /**
     * 处理tbrecord中的json串
     * @param list
     * @return
     */
    private List<RecordVo> dealPageList( List<TbRecord> list){
        List<RecordVo> newList = new ArrayList<RecordVo>();
        for (TbRecord record:
             list) {
            RecordVo vo = new RecordVo();
            vo.setId(record.getId());
            vo.setCreateTime(record.getCreateTime());
            vo.setRecordDetail(new JSONObject().fromObject(record.getRecordDetail()));
            vo.setRecordType(record.getRecordType());
            vo.setStatus(record.getStatus());
            vo.setTime(record.getTime());
            vo.setUserId(record.getUserId());
            newList.add(vo);
        }
        return newList;
    }

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    @RequestMapping("/alterUserInfo")
    @ResponseBody
    public String alterUserInfo(AlterUserInfoParam param){
        CommonResult result = new CommonResult();
        try {
            ShiroUser shiroUser = SessionUtils.getShiroUser();
            TbUser tbUser = new TbUser();
            tbUser.setId(shiroUser.getId());
            tbUser.setNick(param.getNick());
            tbUser.setUserType(param.getUserType());
            this.userService.updateByPrimaryKeySelective(tbUser);
            //更新 shiroUser
            shiroUser.setNick(param.getNick());
            shiroUser.setUserType(param.getUserType().toString());
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(305);
            result.setMessage("数据提交异常");
        }
        return  ResultUtils.getView(result,ResultUtils.VIEW_TYPE_JSON,null,null);
    }
}
