/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbFunctionMapper;
import com.platform.core.po.TbFunction;
import com.platform.core.vo.TbFunctionVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbFunctionService;
@Service
public class TbFunctionServiceImpl extends BaseServiceImpl<TbFunction, TbFunctionVo> implements TbFunctionService {

	@Autowired
	private TbFunctionMapper mapper;

}
