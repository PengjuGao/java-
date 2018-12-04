package com.platform.client.web.article;

import com.platform.base.cache.MemcacheCacheManager;
import com.platform.core.po.TbCategory;
import com.platform.core.service.TbCategoryService;
import com.platform.core.vo.TbCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by CHUCHU on 2017/5/18.
 */
@Controller
public class CategoryController {

    private final String ARTICLE_CACHE = "articleCache";

    @Autowired
    TbCategoryService tbCategoryService;
    @Autowired
    MemcacheCacheManager memcacheCacheManager;
    /**
     *
     * @param modelMap
     * @return
     */

    public String  getAllCategory(ModelMap modelMap){
        TbCategoryVo vo = new TbCategoryVo();
        TbCategoryVo.Criteria citer = vo.or();
        citer.andStatusEqualTo(1);
        List<TbCategory> list = tbCategoryService.selectByVo(vo);
        Cache cache = memcacheCacheManager.getCache("articleCache");
        if(list != null){


        }
        return null;
    }



}
