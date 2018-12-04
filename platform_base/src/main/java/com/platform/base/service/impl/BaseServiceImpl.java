package com.platform.base.service.impl;

import com.platform.base.common.page.Page;
import com.platform.base.common.page.PageBean;
import com.platform.base.dao.BaseDao;
import com.platform.base.service.BaseService;
import com.platform.base.utils.BeanFactory;
import com.platform.base.utils.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;

public class BaseServiceImpl<T, E> implements BaseService<T, E> {
	
	
	private Class<T> entityClass = null;
	private BaseDao<T,E> dao;
	
	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		Object object = this.getClass().getGenericSuperclass();
		if (object instanceof ParameterizedType) {
			entityClass = (Class<T>)((ParameterizedType) object).getActualTypeArguments()[0];
		}
		
		if (null == dao && null != entityClass) {
			
			System.out.println(StringUtils.toLowerFirstChar(entityClass.getSimpleName()));
			
			System.out.println(new StringBuilder().append(StringUtils.toLowerFirstChar(entityClass.getSimpleName())).append("Mapper").toString());
			
			dao = BeanFactory.getBean(new StringBuilder().append(StringUtils.toLowerFirstChar(entityClass.getSimpleName())).append("Mapper").toString());
		}
	}
	
	public BaseDao<T,E> getLocationDao() {
		if (null == dao && null != entityClass) {
			
			System.out.println(StringUtils.toLowerFirstChar(entityClass.getSimpleName())+"111111");
			
			System.out.println(new StringBuilder().append(StringUtils.toLowerFirstChar(entityClass.getSimpleName())).append("Mapper").toString());
			
			dao = BeanFactory.getBean(new StringBuilder().append(StringUtils.toLowerFirstChar(entityClass.getSimpleName())).append("Mapper").toString());
		}
		return dao;
	}
	
	

	@Override
	public int countByVo(E vo) {
		
		return getLocationDao().countByVo(vo);
	}

	@Override
	public int deleteByVo(E vo) {
		
		return getLocationDao().deleteByVo(vo);
	}

	@Override
	public List<T> selectByVo(E vo) {
		
		return getLocationDao().selectByVo(vo);
	}

	@Override
	public int updateByVoSelective(T record, E vo) {
		
		return getLocationDao().updateByVoSelective(record, vo);
	}

	@Override
	public int updateByVo(T record, E vo) {
		
		return getLocationDao().updateByVo(record, vo);
	}

	@Override
	public int deleteByPrimaryKey(BigDecimal id) {
		
		return getLocationDao().deleteByPrimaryKey(id);
	}

	@Override
	public int insert(T record) {
		
		return getLocationDao().insert(record);
	}

	@Override
	public int insertSelective(T record) {
		
		return getLocationDao().insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(BigDecimal id) {
		
		return getLocationDao().selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		
		return getLocationDao().updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		
		return getLocationDao().updateByPrimaryKey(record);
	}

	@Override
	public Page<T> selectByVoAndPage(E vo, PageBean pageBean) {
		
		List<T> list = getLocationDao().selectByVoAndPage(vo, pageBean);
		
		Page<T> page = new Page<T>();
		
		page.setListResult(list);
		
		page.setPageBean(pageBean);
		
		return page;
	}

	
}
