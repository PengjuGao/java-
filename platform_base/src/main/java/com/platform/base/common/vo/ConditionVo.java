package com.platform.base.common.vo;

import java.io.Serializable;

/**
 * 公共的查询条件vo类
 * @author gaopj
 * 2015 2015年12月2日
 */
public class ConditionVo implements Serializable {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	
	/**
	 * 任何以名称查询的条件
	 */
	protected String name;

	/**
	 * 任何以编码查询的条件
	 */
	protected String code;
	
	/**
	 * 已开始时间为查询的条件(记录创建时间)
	 */
	protected String startTime;
	
	/**
	 * 已结束时间为查询的条件(记录创建时间)
	 */
	protected String endTime;
	
	/**
	 * 修改时间的开始时间
	 */
	protected String modifyStartTime;
	
	/**
	 * 修改时间的结束时间
	 */
	protected String modifyEndTime;
	
	/**
	 * 翻页查询条件的第几页
	 */
	protected int pageNo = 1;
	
	/**
	 * 翻页查询条件的一页多少行
	 */
	protected int pageSize = 15;
	
	
	/**
	 * 类型
	 */
	protected String type ;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getModifyStartTime() {
		return modifyStartTime;
	}

	public void setModifyStartTime(String modifyStartTime) {
		this.modifyStartTime = modifyStartTime;
	}

	public String getModifyEndTime() {
		return modifyEndTime;
	}

	public void setModifyEndTime(String modifyEndTime) {
		this.modifyEndTime = modifyEndTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
