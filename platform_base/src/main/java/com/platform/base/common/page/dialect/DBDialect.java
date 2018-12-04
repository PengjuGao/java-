/**
 * Dialect.java 2012-6-25 上午10:57:32 author:huaxin
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package com.platform.base.common.page.dialect;
/**
 * 数据库方言抽象类
 * @version 1.0
 * @since 1.0
 * */
public interface DBDialect {

	public static enum Type{
		MYSQL,
		ORACLE
	}
	
	/**
	 * 得到分页查询语句
	  * @Title: getLimitString
	  * @param @param sql
	  * @param @param skipResults
	  * @param @param maxResults
	  * @param @return
	  * @return String
	  * @throws
	 */
	public abstract String getLimitString(String sql, int skipResults, int maxResults);
	
	/**
	 *  得到查询总数的sql
	  * @Title: getCountString
	  * @param @param querySelect
	  * @param @return
	  * @return String
	  * @throws
	 */
	public abstract String getCountString(String querySelect);
}
