package com.platform.base.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.platform.base.common.page.Page;
import com.platform.base.common.page.PageBean;

public interface BaseDao<T,E> {
	
	
	/**统计一定条件下数据总量**/
	int countByVo(@Param("vo")E vo);
	
	/**删除一定条件下的数据**/
    int deleteByVo(@Param("vo")E vo);
    /**根据条件查询**/
    List<T> selectByVo(@Param("vo")E vo);
    /**根据条件更新**/
    int updateByVoSelective(@Param("record")T record, @Param("vo")E vo);
    /**根据条件更新**/
    int updateByVo(@Param("record")T record, @Param("vo")E vo);

    //List<T> selectPageListByVo(E vo,PageBean pageBean);
    List<T> selectByVoAndPage(@Param("vo")E vo,@Param("pageBean")PageBean pageBean);
    /**根据条件删除**/
    int deleteByPrimaryKey(BigDecimal id);
    /**插入数据***/
    int insert(T record);
    /**插入数据***/
    int insertSelective(T record);
    /**根据id查询数据***/
    T selectByPrimaryKey(BigDecimal id);
    /**更新数据***/
    int updateByPrimaryKeySelective(T record);
    /**更新数据***/
    int updateByPrimaryKey(T record);
	
}
