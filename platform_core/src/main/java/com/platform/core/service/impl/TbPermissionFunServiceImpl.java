/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbPermissionFunMapper;
import com.platform.core.po.TbPermissionFun;
import com.platform.core.vo.TbPermissionFunVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbPermissionFunService;
@Service
public class TbPermissionFunServiceImpl extends BaseServiceImpl<TbPermissionFun, TbPermissionFunVo> implements TbPermissionFunService {

	@Autowired
	private TbPermissionFunMapper mapper;

}
