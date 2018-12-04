/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbRoleMapper;
import com.platform.core.po.TbRole;
import com.platform.core.vo.TbRoleVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbRoleService;
@Service
public class TbRoleServiceImpl extends BaseServiceImpl<TbRole, TbRoleVo> implements TbRoleService {

	@Autowired
	private TbRoleMapper mapper;

}
