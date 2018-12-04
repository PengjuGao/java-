package com.platform.base.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Constants;
import com.platform.base.common.upload.UploadUtils;

public class HTTPConnectionClient {

	private final static Logger logger = Logger.getLogger(HTTPConnectionClient.class);
	
	/**
	 * 打开连接获取内容
	 * @param url
	 * @return
	 */
	public static String getResponseContent(URL url,String data) throws Exception{
		
		HttpURLConnection connection = null;
		OutputStream output = null;
		OutputStreamWriter outr = null;
		String content = "";
		connection = (HttpURLConnection)url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		output = connection.getOutputStream();
        outr = new OutputStreamWriter(output,"utf-8");
        // 写入请求参数
        outr.write(data.toCharArray(), 0, data.length());
        outr.flush();
        outr.close();
        System.out.println("send ok");
		System.out.println("----------开始请求-------------");
		if(connection != null){
			//链接
			connection.setReadTimeout(5000);
			connection.connect();
			//响应码
			int repCode = connection.getResponseCode();
			//获取编码
			String charset = connection.getContentEncoding();
			if(null == charset || "".equals(charset)){
				charset = "UTF-8";
			}
			if(repCode == HttpURLConnection.HTTP_OK){
				//获取输出流
				InputStream is = connection.getInputStream();
				//将输出流转换成文字
				content = UploadUtils.inputStream2String(is, charset);
				is.close();
			}else{
				logger.info("------"+url+"----响应码是【"+repCode+"】");
			}
			connection.disconnect();
			System.out.println("---------连接关闭-----------");
		}
		System.err.println(content);
		return content;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(getResponseContent(new URL("http://localhost:8080/strategy/web/updateStrategy"),"strategyName=%E7%BB%93%E7%AE%97&strategy=%7B%22bike%22%3A%7B%2210%22%3A%221%22%7D%2C%22isCar%22%3A1%2C%22car%22%3A%7B%2210%22%3A%221%22%7D%2C%22address%22%3A%5B%22010%22%5D%7D&expireDay=1&functionType=4"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 此请求不需要写入信息到输出流中
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String getResponseContent(URL url) throws Exception{
		
		HttpURLConnection connection = null;
		String content = "";
		connection = (HttpURLConnection)url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("GET");
        System.out.println("send ok");
		System.out.println("----------开始请求-------------");
		if(connection != null){
			//链接
			connection.setReadTimeout(5000);
			connection.connect();
			//响应码
			int repCode = connection.getResponseCode();
			//获取编码
			String charset = connection.getContentEncoding();
			if(null == charset || "".equals(charset)){
				charset = "UTF-8";
			}
			if(repCode == HttpURLConnection.HTTP_OK){
				//获取输出流
				InputStream is = connection.getInputStream();
				//将输出流转换成文字
				content = UploadUtils.inputStream2String(is, charset);
				is.close();
			}else{
				logger.info("------"+url+"----响应码是【"+repCode+"】");
			}
			connection.disconnect();
			System.out.println("---------连接关闭-----------");
		}
		System.err.println(content);
		return content;
	}
	
}
