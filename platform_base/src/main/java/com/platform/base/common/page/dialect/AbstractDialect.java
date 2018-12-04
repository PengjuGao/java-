/**
 * AbstractPageHepler.java 2012-6-25 下午3:46:40 author:huaxin
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package com.platform.base.common.page.dialect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分页抽象管理类
 * @version 1.0
 * @since 1.0
 * */
public abstract class AbstractDialect implements DBDialect{

	/**
	 * 得到分页的SQL
	 * @param offset 	偏移量
	 * @param limit		位置
	 * @return	分页SQL
	 */
	public abstract String getLimitString(String querySelect,int offset, int limit);
	
	/**
	 * 得到查询总数的sql
	 */
	public  String getCountString(String querySelect) {
		querySelect		= getLineSql(querySelect);
		int orderIndex  = getLastOrderInsertPoint(querySelect);
		if(orderIndex == -1){
			orderIndex = querySelect.length();
		}
		int formIndex   = getAfterFormInsertPoint(querySelect);
		String select   = querySelect.substring(0, formIndex);
		//如果SELECT 中包含 DISTINCT 只能在外层包含COUNT
		if (select.toLowerCase().indexOf("select distinct") != -1 || querySelect.toLowerCase().indexOf("group by")!=-1) {
			return new StringBuffer(querySelect.length()).append(
					"select count(1) count from (").append(
					querySelect.substring(0, orderIndex)).append(" ) t")
					.toString();
		} else {
			return new StringBuffer(querySelect.length()).append(
					"select count(1) count ").append(
					querySelect.substring(formIndex, orderIndex)).toString();
		}
	}
	
	/**
	 * 得到最后一个Order By的插入点位置
	 * @return 返回最后一个Order By插入点的位置
	 */
	protected  int getLastOrderInsertPoint(String querySelect){
		int orderIndex = querySelect.toLowerCase().lastIndexOf("order by");
		int orderIndex2 = querySelect.toLowerCase().lastIndexOf("order siblings by");
		if (orderIndex == -1 || !isBracketCanPartnership(querySelect.substring(orderIndex,querySelect.length()))) {
			if (orderIndex2 == -1 || !isBracketCanPartnership(querySelect.substring(orderIndex2,querySelect.length()))) {
				throw new RuntimeException("My SQL 分页必须要有Order By 语句!");
			}
		}
		return orderIndex;
	}
	/**
	 * 将SQL语句变成一条语句，并且每个单词的间隔都是1个空格
	 * 
	 * @param sql SQL语句
	 * @return 如果sql是NULL返回空，否则返回转化后的SQL
	 */
	protected String getLineSql(String sql) {
		return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
	}

	/**
	 * 得到SQL第一个正确的FROM的的插入点
	 */
	protected int getAfterFormInsertPoint(String querySelect) {
		String regex = "\\s+FROM\\s+";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(querySelect);
		while (matcher.find()) {
			int fromStartIndex = matcher.start(0);
			String text = querySelect.substring(0, fromStartIndex);
			if (isBracketCanPartnership(text)) {
				return fromStartIndex;
			}
		}
		return 0;
	}

	/**
	 * 判断括号"()"是否匹配,并不会判断排列顺序是否正确
	 * 
	 * @param text 要判断的文本
	 * @return 如果匹配返回TRUE,否则返回FALSE
	 */
	private boolean isBracketCanPartnership(String text) {
		if (text == null || (getIndexOfCount(text, '(') != getIndexOfCount(text, ')'))) {
			return false;
		}
		return true;
	}

	/**
	 * 得到一个字符在另一个字符串中出现的次数
	 * @param text	文本
	 * @param ch    字符
	 */
	private int getIndexOfCount(String text, char ch) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			count = (text.charAt(i) == ch) ? count + 1 : count;
		}
		return count;
	}
}
