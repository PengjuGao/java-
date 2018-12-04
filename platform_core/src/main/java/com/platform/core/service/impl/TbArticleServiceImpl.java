/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbArticleMapper;
import com.platform.core.po.TbArticle;
import com.platform.core.vo.TbArticleVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbArticleService;
@Service
public class TbArticleServiceImpl extends BaseServiceImpl<TbArticle, TbArticleVo> implements TbArticleService {

	@Autowired
	private TbArticleMapper mapper;

}
