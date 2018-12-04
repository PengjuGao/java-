package com.platform.base.common.vo;

import java.io.Serializable;

public class TargetVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String fieldName;//字段名称
	
	public String fieldType;//字段要生成的控件类型
	
	public String isChecked;//该字段是否要生成html

	public String alias;//该字段的别名

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	
	
	
}