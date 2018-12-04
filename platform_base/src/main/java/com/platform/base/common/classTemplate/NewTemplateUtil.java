package com.platform.base.common.classTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.platform.base.common.classTemplate.PathParamVo.TemplateType;
import com.platform.base.utils.CommonUtils;



public class NewTemplateUtil {
	
	
	
	/*****po类和vo类文件名字的集合******/
	private static List<String>  PO_AND_VO_FILENAME = new ArrayList<String>();
	/*****各种必要url参数类******/
	private static PathParamVo pathParamVo = new PathParamVo();
	/*****模板共用的前缀，用来拼凑模板文件名******/
	private static final String TEMPLATE_PREFIX = "$#po#";
	/*****模板共用的后缀，用来拼凑模板文件名******/
	private static final String TEMPLATE_SUFFIX = ".java";
	/*****vo类的后缀，用来过滤po类******/
	private static final String VO_SUFFIX = "Vo";
	
	public NewTemplateUtil(){
		//初始化所有需要的路径
		pathParamVo.setControllerPackageUrl(FilePathConstants.ControllerPackageUrl);
		pathParamVo.setDaoPackageUrl(FilePathConstants.DaoPackageUrl);
		pathParamVo.setPoPackageUrl(FilePathConstants.PoPackageUrl);
		pathParamVo.setServiceImplPackageUrl(FilePathConstants.ServiceImplPackageUrl);
		pathParamVo.setServicePackageUrl(FilePathConstants.ServicePackageUrl);
		pathParamVo.setTemplateUrl(FilePathConstants.TemplateUrl);
		pathParamVo.setVoPackageUrl(FilePathConstants.VoPackageUrl);
		pathParamVo.setConditionVoPackageUrl(FilePathConstants.ConditionVoPackageUrl);
		
		//获取所有模板所依赖的vo,po类名
		PO_AND_VO_FILENAME = this.init(pathParamVo.getPoPackageUrl(), pathParamVo.getVoPackageUrl());
		
	}
	
	
	/**
	 * 首先获取vo,po类集合
	 * @param poPackageUrl
	 * @param voPackageUrl
	 * @return
	 */
	public List<String> init(String poPackageUrl,String voPackageUrl){
		
		List<String> list = new ArrayList<String>();

		getFileNameList(poPackageUrl, list);

		getFileNameList(voPackageUrl,list);

		return list;
	}
	
	/**
	 * 通过路径获取名称集合
	 * @param poPackageUrl
	 * @param list
	 */
	private void getFileNameList(String poPackageUrl, List<String> list) {
		if(!CommonUtils.isEmpty(poPackageUrl)){

			File file = new File(poPackageUrl);

			if(file.isDirectory()){

				File[] fileArr = file.listFiles();

				for (int i = 0; i < fileArr.length; i++) {

					File tempFile = fileArr[i];
					
					list.add(tempFile.getName());
				}
			}

		}
	}

	/**
	 * 生成dao
	 */
	public void makeDao(){
		
	}
	
	/**
	 * 生成service
	 */
	public void makeService(){
		
	}
	
	/**
	 * 生成service实现
	 */
	public void makeServiceImpl(){
		
	}
	
	/**
	 * 生成控制器
	 */
	public void makeController(){
		
	}
	
	/**
	 * 生成test类
	 */
	public void makeTest(){
		
	}
	
	/**
	 * 生成不同种类的文件
	 */
	public void makeFileByType(TemplateType type){
		
		//根据枚举获取，需要的模板
		String templateContent = this.readTemplate(type);
		
		String packageName = this.getPackage(type);
		
		String packageUrl = this.getPackageUrl(type);
		
		//获取需要替换的文件内容key------->在参数类中生成
		
		//获取需要生成的文件对应的vo,po(List);
		for (String fileName : PO_AND_VO_FILENAME) {
			
			if(fileName.contains(".")){
				fileName = fileName.split("\\.")[0];
			}else{
				continue;
			}

			if(fileName.endsWith(VO_SUFFIX)){

				continue;

			}else{
				
			
				String tempStr  = templateContent.replace("$#po#", fileName).replace("$#vo#", fileName+VO_SUFFIX).replace("$#packageUrl#", packageName)
						.replace("$#po_lower#", fileName.toLowerCase())
					.replace("$#poPackageUrl#", pathParamVo.getPoPackage()+"."+fileName).replace("$#voPackageUrl#", pathParamVo.getVoPackage()+"."+fileName+VO_SUFFIX)
					.replace("$#mapperPackageUrl#", pathParamVo.getDaoPackage()+"."+fileName+"Mapper").replace("$#servicePackageUrl#",pathParamVo.getServicePackage()+"."+fileName+"Service");
				
				//要生成的文件名称
				String tempFileName = packageUrl+File.separatorChar+fileName+type.getType()+TEMPLATE_SUFFIX;
				
				System.out.println("待生成的文件的全路径名称：-------------"+tempFileName);
				
				FileUtils.makeFile(tempFileName, tempStr,"GBK",false);
			}
			
			
		}
		
	}
	
	
	/**
	 * 根据类型获取包路径
	 * @param type
	 * @return
	 */
	private String getPackageUrl(TemplateType type) {

		String result = null;

		switch (type) {

		case DAO:
			result = pathParamVo.getDaoPackageUrl();
			break;
		case SERVICEIMPL:
			result = pathParamVo.getServiceImplPackageUrl();
			break;
		case SERVICE:
			result = pathParamVo.getServicePackageUrl();
			break;
		case CONTROLLER:
			result = pathParamVo.getControllerPackageUrl();
			break;
		case CONDITIONVO:
			result = pathParamVo.getConditionVoPackageUrl();
			break;
		default:
			break;
		}

		return result;

	}


	/**
	 * 根据要生成的类型获取对应的包名
	 * @param type
	 * @return
	 */
	private String getPackage(TemplateType type) {
		
		String result = null;
		
		switch (type) {
		
		case DAO:
			result = pathParamVo.getDaoPackage();
			break;
		case SERVICEIMPL:
			result = pathParamVo.getServiceImplPackage();
			break;
		case SERVICE:
			result = pathParamVo.getServicePackage();
			break;
		case CONTROLLER:
			result = pathParamVo.getControlelrPackage();
			break;
		case CONDITIONVO:
			result = pathParamVo.getConditionVoPackage();
			break;
		default:
			break;
		}
		
		return result;
	}


	/**
	 * 根据枚举获取模板内容
	 * @param type
	 * @return
	 */
	private String readTemplate(TemplateType type) {
		// TODO Auto-generated method stub
		return this.readTemplate(type.getType());
	}


	/**
	 * 重载读取模板
	 * @param type
	 * @return
	 */
	private String readTemplate(String type) {
		
		String fileName = TEMPLATE_PREFIX+type+TEMPLATE_SUFFIX;
		
		System.err.println("拼凑的模板文件名字是-----------"+fileName);
		
		String filePath = pathParamVo.getTemplateUrl()+fileName;
		
		String content = FileUtils.getFileContent(filePath,"GBK");
		
		return content;
	}


	/**
	 * 一键生成所有的数据
	 * @param typeArr
	 */
	public void oneKeyMakeAll(TemplateType[] typeArr){
		
		for (int i = 0; i < typeArr.length; i++) {
			
			this.makeFileByType(typeArr[i]);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		NewTemplateUtil template = new NewTemplateUtil();
		
		template.oneKeyMakeAll(TemplateType.values());
		
	}
}
