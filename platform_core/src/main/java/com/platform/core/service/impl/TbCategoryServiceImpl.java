/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbCategoryMapper;
import com.platform.core.po.TbCategory;
import com.platform.core.vo.TbCategoryVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbCategoryService;
@Service
public class TbCategoryServiceImpl extends BaseServiceImpl<TbCategory, TbCategoryVo> implements TbCategoryService {

	@Autowired
	private TbCategoryMapper mapper;

}
