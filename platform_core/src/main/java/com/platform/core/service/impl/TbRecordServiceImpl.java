/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbRecordMapper;
import com.platform.core.po.TbRecord;
import com.platform.core.vo.TbRecordVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbRecordService;
@Service
public class TbRecordServiceImpl extends BaseServiceImpl<TbRecord, TbRecordVo> implements TbRecordService {

	@Autowired
	private TbRecordMapper mapper;

}
