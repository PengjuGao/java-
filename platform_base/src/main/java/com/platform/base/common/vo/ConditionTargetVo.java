package com.platform.base.common.vo;

import java.io.Serializable;

public class ConditionTargetVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String fieldName;
	
	public String fieldType;
	
	public String isChecked;
	
	public String alias;
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	

}
