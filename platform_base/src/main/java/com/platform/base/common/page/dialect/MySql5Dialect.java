/**
 * MySql5Dialect.java 2012-6-25 上午10:59:13 author:huaxin
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package com.platform.base.common.page.dialect;
/**
 * MySql方言实现
 * @version 1.0
 * @since 1.0
 * */
public class MySql5Dialect extends AbstractDialect{

	@Override
	public String getLimitString(String querySelect, int offset, int limit) {
		querySelect	= super.getLineSql(querySelect);
		return querySelect.replaceAll("[^\\s,]+\\.", "") +" limit "+ offset +" ,"+ limit;
	}
}
