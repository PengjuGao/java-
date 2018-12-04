/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbArticleContentMapper;
import com.platform.core.po.TbArticleContent;
import com.platform.core.vo.TbArticleContentVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbArticleContentService;
@Service
public class TbArticleContentServiceImpl extends BaseServiceImpl<TbArticleContent, TbArticleContentVo> implements TbArticleContentService {

	@Autowired
	private TbArticleContentMapper mapper;

}
