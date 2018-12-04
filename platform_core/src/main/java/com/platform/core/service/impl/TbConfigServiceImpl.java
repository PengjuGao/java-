/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbConfigMapper;
import com.platform.core.po.TbConfig;
import com.platform.core.vo.TbConfigVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbConfigService;
@Service
public class TbConfigServiceImpl extends BaseServiceImpl<TbConfig, TbConfigVo> implements TbConfigService {

	@Autowired
	private TbConfigMapper mapper;

}
