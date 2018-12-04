/**
 * @author gaopj
 * @date {date}
 */
package com.platform.manager.web.manager;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.platform.core.po.TbArticleContent;
import com.platform.core.vo.TbArticleContentVo;

import com.platform.base.common.page.Page;
import com.platform.base.common.page.PageBean;
import com.platform.base.utils.DateUtils;
import com.platform.base.web.BaseController;
import com.platform.core.vo.condition.TbArticleContentConditionVo;

import com.platform.core.service.TbArticleContentService;
@Controller
@RequestMapping("/system/tbarticlecontent/")
public class TbArticleContentController extends BaseController<TbArticleContent, TbArticleContentVo> {
	
	@Autowired
	public TbArticleContentService service;
	
	@Override
	protected void queryList(Object vo,TbArticleContent t, TbArticleContentVo e,PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		
		TbArticleContentConditionVo tempVo = (TbArticleContentConditionVo)vo;
		
		if(pageBean == null){
			
			pageBean = new PageBean();
			
			//拆vo重组查询条件
			pageBean.setPageNo(tempVo.getPageNo());
			
			pageBean.setPageSize(tempVo.getPageSize());
		}
		
		TbArticleContentVo.Criteria criteria = e.createCriteria();

		String startTime = tempVo.getStartTime();
		
		String endTime = tempVo.getEndTime();
		
		//判断两个值的大小，小的设置为startTime，大的设置成endTime

		e.setDistinct(true);
		
		e.setOrderByClause(" create_time desc ");
		
		//criteria.andFunctionIdEqualTo("123123");
		
		List<TbArticleContent> list = service.selectByVo(e);
		
		model.addAttribute("list", list);
		
		model.addAttribute("vo", tempVo);
		
		Page<TbArticleContent> page = service.selectByVoAndPage(e, pageBean);
		
		model.addAttribute("page", page.getPageBean());
		
		model.addAttribute("list", page.getListResult());
	}
}
