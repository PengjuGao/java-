package com.platform.base.utils.html;

import org.apache.commons.lang3.StringUtils;

import com.platform.base.enums.HTMLTypeEnum;
import com.platform.base.enums.HTMLTypeEnum4Add;

public class MyHtmlUtils {
	
	/**
	 * 根据字段名称和类型获取html
	 * @param fieldName
	 * @param fieldType
	 * @return
	 */
	public static String getHtml(String fieldName, String fieldType) {
		
		String result = "没有生成需要的html，请检查代码";
		
		if(StringUtils.isEmpty(fieldType))return result;
		
		HTMLTypeEnum tempEnum = HTMLTypeEnum.valueOf(fieldType.toUpperCase());
		
		switch (tempEnum) {
		
		case TEXT:
			result =HTMLTypeEnum.TEXT.html.replaceAll("\\$#value#", fieldName);
			break;
		case TEXTAREA:
			
			result =HTMLTypeEnum.TEXTAREA.html.replaceAll("\\$#value#", fieldName);
			break;
		case SELECT:
					
			result =HTMLTypeEnum.SELECT.html.replaceAll("\\$#value#", fieldName);
			break;
		case RADIO:
			result =HTMLTypeEnum.RADIO.html.replaceAll("\\$#value#", fieldName);
			
			break;
		case CHECKBOX:
			result =HTMLTypeEnum.CHECKBOX.html.replaceAll("\\$#value#", fieldName);
			
			break;
		default:
			break;
		}
		return result;
	}
	
	/**
	 * 根据字段名称和类型获取html
	 * @param fieldName
	 * @param fieldType
	 * @return
	 */
	public static String getAddHtml(String fieldName, String fieldType) {
		
		String result = "没有生成需要的html，请检查代码";
		
		if(StringUtils.isEmpty(fieldType))return result;
		
		HTMLTypeEnum4Add tempEnum = HTMLTypeEnum4Add.valueOf(fieldType.toUpperCase());
		
		switch (tempEnum) {
		
		case TEXT:
			result =HTMLTypeEnum4Add.TEXT.html.replaceAll("\\$#value#", fieldName);
			break;
		case TEXTAREA:
			
			result =HTMLTypeEnum4Add.TEXTAREA.html.replaceAll("\\$#value#", fieldName);
			break;
		case SELECT:
					
			result =HTMLTypeEnum4Add.SELECT.html.replaceAll("\\$#value#", fieldName);
			break;
		case RADIO:
			result =HTMLTypeEnum4Add.RADIO.html.replaceAll("\\$#value#", fieldName);
			
			break;
		case CHECKBOX:
			result =HTMLTypeEnum4Add.CHECKBOX.html.replaceAll("\\$#value#", fieldName);
			
			break;
		default:
			break;
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
