package com.platform.base.common.classTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成jsp文件 list.jsp,add.jsp,edit.jsp
 * 前提：通过所有的po类的名称来获取
 * @author gaopj
 * 2015 2015年12月1日
 */
public class JSPTemplateUtil {
	
	
	/**
	 * 读取所有的po类，然后放入list返回
	 * @return
	 */
	public static List<String> getPoClassName(){
		
		List<String> list = new ArrayList<String>();
		
		File file = new File(FilePathConstants.PO_URL);
		
		if(!file.exists() || !file.isDirectory()){
			return null;
		}
		
		File[] fileArr = file.listFiles();
		
		for (File tempFile : fileArr) {
			list.add((tempFile.getName().split("/.")[0]).toLowerCase());
		}
		
		return list;
	}
	
	
	/**
	 * 生成每个po对应的存放jsp的文件夹
	 */
	public static List<String> generateFolder(){
		
		List<String> list = new ArrayList<String>();
		
		List<String> poList =  getPoClassName();
		
		if(poList == null || poList.isEmpty()){
			System.err.println("--------------抱歉，没有要生成的文件夹-----");
			return null;
		}
		
		for (String str : poList) {
			
			File file = new File(FilePathConstants.JSP_URL,str);
			
			if(file.exists()){
				continue;
			}
			
			boolean flag = file.mkdir();
			
			if(flag){
				System.out.println(file.getName()+"创建成功");
				list.add(file.getAbsolutePath());
			}else{
				System.err.println(file.getName()+"创建失败-------------");
			}
		}
		
		return list;
	}
	
	
	/**
	 * 读取jsp 模板，并生成需要的jsp文件
	 * @return
	 */
	public static StringBuffer readJspTemplate(){
		
		
		return null;
	}
	
	
	public static void main(String[] args) {
		JSPTemplateUtil.generateFolder();
	}
	
}
