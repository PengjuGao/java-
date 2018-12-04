/**
 * OracleDialect.java 2012-6-25 上午11:04:10 author:huaxin
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package com.platform.base.common.page.dialect;



/**
 * Oracle方言
 * @date 2012-6-25 上午11:04:10
 * @version 1.0
 * @since 1.0
 * */
public class OracleDialect extends AbstractDialect{

	public String getLimitString(String sql, int offset, int limit) {
		sql	= getLineSql(sql);
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		pagingSelect.append(sql);
		pagingSelect.append(" ) row_ ) where rownum_ > " + offset + " and rownum_ <= " + (offset + limit));
		if (isForUpdate) {
			pagingSelect.append(" for update");
		}
		return pagingSelect.toString();
	}
}
