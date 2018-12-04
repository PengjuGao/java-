package com.platform.base.enums;

public enum HTMLTypeEnum {
	
	TEXT("text","<input type=\"text\" value=\"${vo.$#value#}\" name=\"$#value#\" />"),
	TEXTAREA("textarea","<input type=\"textarea\" value=\"${vo.$#value#}\" name=\"$#value#\" />"),
	RADIO("radio","<input type=\"radio\"  name=\"$#value#\" value=\"${vo.$#value#}\"/>xxxx"),
	CHECKBOX("checkbox","<input type=\"checkbox\"  name=\"$#value#\" value=\"${vo.$#value#}\"/>xxxx"),
	SELECT("select","<select name=\"$#value#\"><option value=\"\">请选择</option>"
			+ "<option value=\"xxxx\" <c:if test=\"${vo.$#value# eq 'xxxx'}\">selected=\"selected\"</c:if>>xxxxx"
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
	
	private HTMLTypeEnum(String code,String html){
		this.code = code;
		this.html = html;
	}
	
}
