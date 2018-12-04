package com.platform.base.utils;

import java.beans.PropertyEditorSupport;


public class StringEscapeEditor extends PropertyEditorSupport {

	private boolean isFilterXSS;

	public StringEscapeEditor() {
		super();
	}
	
	public StringEscapeEditor(boolean isFilterXSS) {
		super();
		this.isFilterXSS = isFilterXSS;
	}

	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		} else {
			String value = text;
			if(isFilterXSS){
				value = cleanXSS(value);
			}
			setValue(value);
		}

	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}
	
	private String cleanXSS(String value) {
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		value = value.replaceAll("'", "&#39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		return value;
	}
	

}