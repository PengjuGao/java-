package com.platform.base.common.classTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReplaceMapperUtils {
	
	//需要替换的字符串内容列举
	
	public enum ContentValue{

		R1("Example","Vo"),
		R2("collection=\"oredCriteria\"","collection=\"vo.oredCriteria\""),
		R3("example","vo"),
		R4("test=\"distinct\"","test=\"vo !=  null and vo.distinct\""),
		R5("test=\"_parameter != null\"","test=\"vo !=  null\""),
		R6("test=\"orderByClause != null\"","test=\"vo !=  null and vo.orderByClause != null\""),
		R7("parameterType=\"com\\.platform\\.core\\.po","parameterType=\"com\\.platform\\.core\\.vo"),
		R8("\\{orderByClause\\}","\\{vo\\.orderByClause\\}"),
		;
		
		
		public String content;
		
		public String target;
		
		private ContentValue(String content,String target){
			this.content = content;
			this.target = target;
		}
		
	}
	
	//doReplace
	
	public static void doReplace(String whichWebName){

		List<File> list = new ArrayList<File>();

		if("platform_base".equals(whichWebName)){
			//获取mapper的路径
			File file = new File(FilePathConstants.SYSTEM_MAPPER);
			
			File[] fileArr = file.listFiles();
			
			for (File file2 : fileArr) {
				list.add(file2);
			}
		}

		//doreplace
		for (File file : list) {
			
			String fileContent = FileUtils.getFileContent(file.getAbsolutePath(), "UTF-8");
			
			if(fileContent.contains("vo.oredCriteria")){
				
				System.err.println(file.getAbsolutePath()+file.getName()+"不需要替换");
				continue;
			}
			
			ContentValue[] cvEnums = ContentValue.values();
			
			for (ContentValue cvEnum : cvEnums) {
				fileContent =fileContent.replaceAll(cvEnum.content, cvEnum.target);
			}
			
			//统一替换PO类的包名
			String poName = file.getName().split("Mapper")[0];
			
			//System.out.println(poName);
			
			fileContent = fileContent.replaceAll("vo\\."+poName+"\"", "po\\."+poName+"\"");
			
			System.out.println("==============被重写的文件---------"+file.getAbsolutePath()+file.getName());
			FileUtils.makeFile(file.getAbsolutePath(), fileContent, "UTF-8", true);
		}
	}
	
	public static void main(String[] args) {
		ReplaceMapperUtils.doReplace("platform_base");
	}

}
