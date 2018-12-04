package com.platform.base.common.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class JSPTemplateVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String pageTitle;
	
	private String classlowerName;//获取同名的jsp目录方便生成list.jsp 文件
	
	private String isAdd;//是否生成add.jsp文件
	
	private String isEdit;//是否生成edit.jsp文件
	
	public String getClasslowerName() {
		return classlowerName;
	}

	public void setClasslowerName(String classlowerName) {
		this.classlowerName = classlowerName;
	}

	private String[] clazz;
	
	private String[] voClazz;
	
	private ArrayList<TargetVo> list;
	
	private ArrayList<ConditionTargetVo> voList;
	
	public ArrayList<ConditionTargetVo> getVoList() {
		return voList;
	}

	public void setVoList(ArrayList<ConditionTargetVo> voList) {
		this.voList = voList;
	}

	public String[] getClazz() {
		return clazz;
	}

	public void setClazz(String[] clazz) {
		this.clazz = clazz;
	}

	public String[] getVoClazz() {
		return voClazz;
	}

	public void setVoClazz(String[] voClazz) {
		this.voClazz = voClazz;
	}

	public ArrayList<TargetVo> getList() {
		return list;
	}

	public void setList(ArrayList<TargetVo> list) {
		this.list = list;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(String isAdd) {
		this.isAdd = isAdd;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
}
