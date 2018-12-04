/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbRoleUserMapper;
import com.platform.core.po.TbRoleUser;
import com.platform.core.vo.TbRoleUserVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbRoleUserService;
@Service
public class TbRoleUserServiceImpl extends BaseServiceImpl<TbRoleUser, TbRoleUserVo> implements TbRoleUserService {

	@Autowired
	private TbRoleUserMapper mapper;

}
