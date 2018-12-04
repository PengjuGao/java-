/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbUserinfoMapper;
import com.platform.core.po.TbUserinfo;
import com.platform.core.vo.TbUserinfoVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbUserinfoService;
@Service
public class TbUserinfoServiceImpl extends BaseServiceImpl<TbUserinfo, TbUserinfoVo> implements TbUserinfoService {

	@Autowired
	private TbUserinfoMapper mapper;

}
