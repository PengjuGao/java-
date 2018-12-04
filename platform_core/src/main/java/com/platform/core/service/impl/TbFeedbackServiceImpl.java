/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import com.platform.base.common.shiro.ShiroUser;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.base.utils.ClassPropertyUtils;
import com.platform.core.dao.TbFeedbackMapper;
import com.platform.core.param.FeedbackParam;
import com.platform.core.param.common.CommonResult;
import com.platform.core.po.TbFeedback;
import com.platform.core.service.TbFeedbackService;
import com.platform.core.vo.TbFeedbackVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbFeedbackServiceImpl extends BaseServiceImpl<TbFeedback, TbFeedbackVo> implements TbFeedbackService {

	@Autowired
	private TbFeedbackMapper mapper;


	@Override
	public CommonResult addFeedback(FeedbackParam param) {
		TbFeedback feedback = new TbFeedback();
		BeanUtils.copyProperties(param,feedback);
		//如果用户已经登录
		Subject subject = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
		if(shiroUser != null){
			feedback.setUserId(shiroUser.getId());
			feedback.setEmail(shiroUser.getUsername());
		}
		this.mapper.insert(feedback);
		return new CommonResult();
	}

	@Override
	public CommonResult listFeedback(long userId) {
		TbFeedbackVo vo = new TbFeedbackVo();
		TbFeedbackVo.Criteria citer = vo.or();
		citer.andUserIdEqualTo(userId);
		citer.andStatusEqualTo(1);
		List<TbFeedback> feedbackList = this.mapper.selectByVo(vo);
		CommonResult result = new CommonResult();
		result.setList(feedbackList);
		return result;
	}
}
