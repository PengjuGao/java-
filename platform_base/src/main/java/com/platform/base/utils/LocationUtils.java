package com.platform.base.utils;

import java.net.URL;

/**
 * @author gaopj
 * 获取用户所在实际地理位置
 */
public class LocationUtils {

	public final static String LOCATION_API = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=";
	
	/**
	 * 根据ip地址获取用户当前位置
	 * @param ip
	 * @return
	 */
	public static String getLocaltion(String ip){
		
		if(StringUtils.hasText(ip)){
			try {
				URL url = new URL(LOCATION_API+ip);
				String content = HTTPConnectionClient.getResponseContent(url);
				return content;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
}
