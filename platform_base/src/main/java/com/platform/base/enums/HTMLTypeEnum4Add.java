package com.platform.base.enums;

public enum HTMLTypeEnum4Add {
	TEXT("text","<input type=\"text\" value=\"\" name=\"$#value#\" />"),
	TEXTAREA("textarea","<input type=\"textarea\" value=\"\" name=\"$#value#\" />"),
	RADIO("radio","<input type=\"radio\"  name=\"$#value#\" value=\"\"/>xxxx"),
	CHECKBOX("checkbox","<input type=\"checkbox\"  name=\"$#value#\" value=\"\"/>xxxx"),
	SELECT("select","<select name=\"$#value#\"><option selected=\"selected\" value=\"\">请选择</option>"
			+ "<option value=\"xxxx\">xxxxx"
			+ "</option></select>"),
	;
	public String code;
	public String html;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
	private HTMLTypeEnum4Add(String code,String html){
		this.code = code;
		this.html = html;
	}
}
