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

import com.platform.core.po.TbPermissionFun;
import com.platform.core.vo.TbPermissionFunVo;

import com.platform.base.common.page.Page;
import com.platform.base.common.page.PageBean;
import com.platform.base.utils.DateUtils;
import com.platform.base.web.BaseController;
import com.platform.core.vo.condition.TbPermissionFunConditionVo;

import com.platform.core.service.TbPermissionFunService;
@Controller
@RequestMapping("/system/tbpermissionfun/")
public class TbPermissionFunController extends BaseController<TbPermissionFun, TbPermissionFunVo> {
	
	@Autowired
	public TbPermissionFunService service;
	
	@Override
	protected void queryList(Object vo,TbPermissionFun t, TbPermissionFunVo e,PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		
		TbPermissionFunConditionVo tempVo = (TbPermissionFunConditionVo)vo;
		
		if(pageBean == null){
			
			pageBean = new PageBean();
			
			//拆vo重组查询条件
			pageBean.setPageNo(tempVo.getPageNo());
			
			pageBean.setPageSize(tempVo.getPageSize());
		}
		
		TbPermissionFunVo.Criteria criteria = e.createCriteria();
		

		//if(StringUtils.isNotEmpty(tempVo.getName())){
			//criteria.andNameLike("%"+tempVo.getName()+"%");
		//}
		
		//功能url
		//if(StringUtils.isNotEmpty(tempVo.getUrlStr())){
			//criteria.andFunctionUrlLike("%"+tempVo.getUrlStr()+"%");
		//}
		
		//功能类型
		//if(StringUtils.isNotEmpty(tempVo.getType())){
			//criteria.andFunctionTypeEqualTo(tempVo.getType());
		//}
		
		String startTime = tempVo.getStartTime();
		
		String endTime = tempVo.getEndTime();
		
		//判断两个值的大小，小的设置为startTime，大的设置成endTime
		
		if(StringUtils.isNotEmpty(startTime) && StringUtils.isNotEmpty(endTime)){
			//比较大小重新set日期
			int value = DateUtils.compare_date(startTime, endTime,"MM/dd/yyyy");
			
			if(value == 1){
				tempVo.setStartTime(endTime);
				tempVo.setEndTime(startTime);
			}
			//转换成日期
			Date startDate = DateUtils.parseDateFromString(tempVo.getStartTime()+" 00:00:00", "MM/dd/yyyy HH:mm:ss");
			
			Date endDate = DateUtils.parseDateFromString(tempVo.getEndTime()+" 23:59:59", "MM/dd/yyyy HH:mm:ss");
			
			criteria.andCreateTimeBetween(startDate, endDate);
		}else if(StringUtils.isEmpty(startTime) && StringUtils.isNotEmpty(endTime)){
			
			Date endDate = DateUtils.parseDateFromString(tempVo.getEndTime()+" 23:59:59", "MM/dd/yyyy HH:mm:ss");
			
			criteria.andCreateTimeLessThanOrEqualTo(endDate);
		}else if(StringUtils.isNotEmpty(startTime) && StringUtils.isEmpty(endTime)){
			
			Date startDate = DateUtils.parseDateFromString(tempVo.getStartTime()+" 00:00:00", "MM/dd/yyyy HH:mm:ss");
			criteria.andCreateTimeGreaterThanOrEqualTo(startDate);
		}
		
		e.setDistinct(true);
		
		e.setOrderByClause(" create_time desc ");
		
		//criteria.andFunctionIdEqualTo("123123");
		
		List<TbPermissionFun> list = service.selectByVo(e);
		
		model.addAttribute("list", list);
		
		model.addAttribute("vo", tempVo);
		
		Page<TbPermissionFun> page = service.selectByVoAndPage(e, pageBean);
		
		model.addAttribute("page", page.getPageBean());
		
		model.addAttribute("list", page.getListResult());
	}
}
