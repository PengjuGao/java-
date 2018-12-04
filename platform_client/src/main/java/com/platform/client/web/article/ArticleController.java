package com.platform.client.web.article;

import com.platform.base.common.page.Page;
import com.platform.base.common.page.PageBean;
import com.platform.core.po.TbArticle;
import com.platform.core.service.TbArticleService;
import com.platform.core.vo.TbArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by CHUCHU on 2017/5/18.
 */
@Controller
@RequestMapping("/platform/article")
public class ArticleController {

    @Autowired
    TbArticleService tbArticleService;
    /**
     * 列表查询
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/list")
    public String articleList(PageBean pageBean,ModelMap modelMap,int articleType) {
        TbArticleVo articleVo = new TbArticleVo();
        TbArticleVo.Criteria citer = articleVo.or();
        citer.andStatusEqualTo(1);//有效数据
        citer.andCategoryIdEqualTo(articleType);//分类
        articleVo.setOrderByClause("order by id desc");
        Page<TbArticle> page =   tbArticleService.selectByVoAndPage(articleVo,pageBean);
        modelMap.put("page",page);
        modelMap.put("pageList",page.getListResult());
        return "";
    }

}
