/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbRolePermissionMapper;
import com.platform.core.po.TbRolePermission;
import com.platform.core.vo.TbRolePermissionVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbRolePermissionService;
@Service
public class TbRolePermissionServiceImpl extends BaseServiceImpl<TbRolePermission, TbRolePermissionVo> implements TbRolePermissionService {

	@Autowired
	private TbRolePermissionMapper mapper;

}
