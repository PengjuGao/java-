package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.dao.TableAndColumnsMapper;
import com.platform.core.po.TableAndColumns;
import com.platform.core.service.TableAndColumnsService;
import com.platform.core.vo.TableAndColumnsVo;

@Service
public class TableAndColumnsServiceImpl extends BaseServiceImpl<TableAndColumns, TableAndColumnsVo> implements TableAndColumnsService {

	@Autowired
	private TableAndColumnsMapper mapper;

}
