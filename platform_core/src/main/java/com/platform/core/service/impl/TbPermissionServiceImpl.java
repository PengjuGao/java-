/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbPermissionMapper;
import com.platform.core.po.TbPermission;
import com.platform.core.vo.TbPermissionVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbPermissionService;
@Service
public class TbPermissionServiceImpl extends BaseServiceImpl<TbPermission, TbPermissionVo> implements TbPermissionService {

	@Autowired
	private TbPermissionMapper mapper;

}
