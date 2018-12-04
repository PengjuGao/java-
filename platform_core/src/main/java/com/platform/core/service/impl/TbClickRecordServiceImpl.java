/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbClickRecordMapper;
import com.platform.core.po.TbClickRecord;
import com.platform.core.vo.TbClickRecordVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbClickRecordService;
@Service
public class TbClickRecordServiceImpl extends BaseServiceImpl<TbClickRecord, TbClickRecordVo> implements TbClickRecordService {

	@Autowired
	private TbClickRecordMapper mapper;

}
