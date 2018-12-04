package com.platform.base.common.classTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.platform.base.utils.CommonUtils;


public class TemplateUtil {

	/**存放模板**/
	public static StringBuffer BUFFER = new StringBuffer();

	private static final String CONTROLLER_KEY = "Controller";

	private static final String SERVICE_KEY = "Service";

	private static final String SERVICEIMPL_KEY = "ServiceImpl";

	private static final String DAO_KEY = "Mapper";

	private static final String VO_KEY = "Vo";

	private static final String TEMPLATE_URL = "D:/huaxin/workspace/myplatform/src/main/resources/template/";

	private static String PO_PACKAGE_URL ;  //PO包路径

	private static String VO_PACKAGE_URL ;  //VO包路径

	private static String DAO_PACKAGE_URL ; //MAPPER包路径

	private static String SERVICE_PACKAGE_URL; //SERVICE包路径

	private static String SERVICEIMPL_PACKAGE_URL;//SERVICEIMPL包路径

	private static String CONTROLLER_PACKAGE_URL;//CONTROLLER包路径

	private static String CURRENT_TEMPLATE_TYPE;//当前目标类型

	/**
	 * 那种模板类型（dao,service,controller）
	 * @author gaopj
	 */
	enum TemplateType{

		DAO("dao"),
		SERVICE("service"),
		SERVICEIMPL("serviceimpl"),
		CONTROLLER("controller"),
		;

		private TemplateType(String type){
			this.type = type;
		}

		private String type;

		public String getType() {
			return type;
		}
	}


	/**
	 * 模板中的需要替换掉的关键字
	 * @author gaopj
	 *
	 */
	enum ReplaceKey{

		Hello("","");

		private ReplaceKey(String id,String value){
			this.id = id;
			this.value = value;
		}

		private String id;
		private String value;

		public String getId() {
			return id;
		}


		public String getValue() {
			return value;
		}
	}


	/**
	 * 根据包路径获取po，vo(po,vo的包路径可能一样)
	 * @param packageUrl
	 * @return
	 */
	public List<String> getFileNames(String poPackageUrl,String voPackageUrl){

		//转换po,vo包路径
		if(!CommonUtils.isEmpty(poPackageUrl)){
			PO_PACKAGE_URL =  this.dealPackageUrl(poPackageUrl);
		}

		if(!CommonUtils.isEmpty(voPackageUrl)){
			VO_PACKAGE_URL = this.dealPackageUrl(voPackageUrl);
		}

		//若果VO路径为空，默认vo=po
		if(CommonUtils.isEmpty(VO_PACKAGE_URL)){
			VO_PACKAGE_URL = PO_PACKAGE_URL;
		}

		/***********设计缺陷：上面的代码是为了导入vo,po,拼凑进来的，后期可优化************/

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
	 * 读取模板
	 */
	public void readTemplate(String templateType){

		//1.清空buffer
		BUFFER = new StringBuffer("");

		TemplateType objType = null;

		for (TemplateType type : TemplateType.values()) {

			if(type.getType().equalsIgnoreCase(templateType)){
				objType = type;
				CURRENT_TEMPLATE_TYPE = type.getType();//存放标志
				break;
			}
		}

		switch (objType) {

		case DAO:
			this.readTemplate(BUFFER,DAO_KEY);
			break;
		case SERVICE:
			this.readTemplate(BUFFER, SERVICE_KEY);
			break;
		case SERVICEIMPL:
			this.readTemplate(BUFFER, SERVICEIMPL_KEY);
			break;
		case CONTROLLER:
			this.readTemplate(BUFFER, CONTROLLER_KEY);
			break;
		default:
			break;
		}

	}


	/**
	 * 模板生成启动方法
	 */
	public void startMaker(){



	}


	/**
	 * 通过已知的类型生成对应的文件
	 * @param list
	 * @param buffer
	 *//*
	public void fileMaker(String packageUrl,String poUrl,String voUrl,String typeFlag){

		List<String> list = this.getFileNames(poUrl, voUrl);

		this.fileMaker(packageUrl,list,typeFlag);

	}



	  *//**
	  * 创建相对应类型的文件
	  * @param packageUrl
	  * @param list
	  * @param typeFlag
	  *//*
	private void fileMaker(String packageUrl, List<String> list, String typeFlag) {

		//1.通过类型获取不同的模板
		this.readTemplate(typeFlag);

		//2.循环遍历list,生成对应的文件

		for (String fileName : list) {

			System.out.println(fileName+"-------------------------$$$$$$$$$$$$$$$");
			if(fileName.indexOf('.') != -1){
				String[] strArr = fileName.split(".");
				fileName = strArr[0];
			}

			if(fileName.contains(VO_KEY)){
				//说明是VO类
			}else{
				//说明是PO类
			}


		}


	}*/

	private void readTemplate(StringBuffer buffer, String keyType) {

		List<String> list = new ArrayList<String>();

		this.getFileNameList(TEMPLATE_URL, list);

		List<String> tempList = new ArrayList<String>(list.size());

		for (String fileName : list) {

			if(fileName.contains(".")){
				fileName = fileName.split("\\.")[0];
			}

			if(fileName.endsWith(keyType)){

				tempList.add(fileName);

			}
		}

		if(null != tempList && tempList.size() == 1){

			File file = new File(TEMPLATE_URL+File.separatorChar+tempList.get(0)+".java");


			Reader reader = null;

			try {
				reader = new FileReader(file);

				char[] tempArr = null;

				int num = 0;

				while((num = reader.read()) != -1){

					tempArr = new char[1024];

					int count = reader.read(tempArr);

					System.out.println("读取的字符串长度是："+count);

					for (int i = 0; i < count; i++) {

						BUFFER.append(tempArr[i]);
					}

				}

				//数据读取完毕，打印buffer读到的数据
				System.out.println("--------------数据读取完毕，打印buffer读到的数据----------begin--------");
				System.out.println(BUFFER.toString());
				System.out.println("--------------数据读取完毕，打印buffer读到的数据----------end--------");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{

				if(reader != null){
					try {
						reader.close();
					} catch (IOException e) {
						System.err.println("关闭流失败");
					}
				}
			}

		}

	}


	/**
	 * 生成dao类
	 * @param packageUrl
	 * @param poName
	 * @param voName
	 */
	public void makeFileSecond(String packageUrl,String poName,String voName){

		File file = new File(packageUrl);

		if(!file.exists()){
			try {
				file.mkdir();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String keyType = "";

		if("dao".equals(CURRENT_TEMPLATE_TYPE)){
			keyType = DAO_KEY;
			DAO_PACKAGE_URL = this.dealPackageUrl(packageUrl);
		}else if("service".equals(CURRENT_TEMPLATE_TYPE)){
			keyType = SERVICE_KEY;
			SERVICE_PACKAGE_URL =this.dealPackageUrl(packageUrl);
		}else if("serviceimpl".equals(CURRENT_TEMPLATE_TYPE)){
			keyType = SERVICEIMPL_KEY;
			SERVICEIMPL_PACKAGE_URL =this.dealPackageUrl(packageUrl);
		}else if("controller".equals(CURRENT_TEMPLATE_TYPE)){
			keyType = CONTROLLER_KEY;
			CONTROLLER_PACKAGE_URL =this.dealPackageUrl(packageUrl);
		}

		//获取包名
		String packageName = this.dealPackageUrl(packageUrl);

		String tempStr = BUFFER.toString();

		tempStr = tempStr.replace("$#po#", poName).replace("$#vo#", voName).replace("$#packageUrl#", packageName)
				.replace("$#poPackageUrl#", PO_PACKAGE_URL+"."+poName).replace("$#voPackageUrl#", VO_PACKAGE_URL+"."+voName)
				.replace("$#mapperPackageUrl#", DAO_PACKAGE_URL+"."+poName+"Mapper").replace("$#servicePackageUrl#",SERVICE_PACKAGE_URL+"."+poName+"Service");


		System.out.println("----------转换后的BUFFER字符串为："+tempStr+"&&&&&&&&&&&&&&&&&&");

		//创建文件



		String tempFileName = poName+keyType+".java";

		System.err.println("tempFileName========"+tempFileName);;

		File tempFile = new File(packageUrl,tempFileName);

		Writer writer = null;

		if(tempFile.exists()){
			//什么也不做
		}else{
			try {
				//创建FILE
				tempFile.createNewFile();
				//写数据到file
				writer = new FileWriter(tempFile);

				writer.write(tempStr.toCharArray());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(null !=  writer){
					try {
						writer.flush();
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

	}


	/**
	 * 通过包路径，获取包名
	 * @param packageUrl
	 * @return
	 */
	private String dealPackageUrl(String packageUrl) {

		//1.首先改包路径必定是目录

		//File file = new File(packageUrl);

		//if(file.isDirectory()){

		//获取/com/的位置
		int num = packageUrl.indexOf("com");

		String packageName = packageUrl.substring(num);

		packageName = packageName.replace("\\", ".").replace("/", ".");

		return packageName;
		//}


		//return null;
	}

	/**
	 * 生成DAO
	 * @param packageUrl
	 * @param poPackurl
	 * @param voPackurl
	 */
	public void makeFileFirst(String packageUrl,String poPackurl,String voPackurl){

		List<String> list = new ArrayList<String>();

		list = this.getFileNames(poPackurl, voPackurl);


		for (String fileName : list) {

			if(fileName.contains(".")){
				fileName = fileName.split("\\.")[0];
			}

			if(fileName.contains(VO_KEY)){
				//说明是VO类
				continue;
			}else{
				//说明是PO类
				this.makeFileSecond(packageUrl, fileName, fileName+VO_KEY);

			}
		}

	}

	/*public void makeServiceFirst(String packageUrl,String poPackurl,String voPackurl){

	}*/




	public static void main(String[] args) {

		TemplateUtil tt = new TemplateUtil();

		/*String packageName = tt.dealPackageUrl("D:\\huaxin\\workspace\\myplatform\\src\\main\\java\\com\\platform");

		System.out.println(packageName);*/

		tt.readTemplate("DAO");

		tt.makeFileFirst("F:\\20150420\\down\\myplatform\\src\\main\\java\\com\\platform\\app\\dao", "F:\\20150420\\down\\myplatform\\src\\main\\java\\com\\platform\\app\\dao\\po", null);

		tt.readTemplate("service");

		tt.makeFileFirst("F:\\20150420\\down\\myplatform\\src\\main\\java\\com\\platform\\app\\service", "F:\\20150420\\down\\myplatform\\src\\main\\java\\com\\platform\\app\\po", null);

		tt.readTemplate("serviceImpl");

		tt.makeFileFirst("F:\\20150420\\down\\myplatform\\src\\main\\java\\com\\platform\\app\\service\\impl", "F:\\20150420\\down\\myplatform\\src\\main\\java\\com\\platform\\app\\po", null);

		tt.readTemplate("controller");

		tt.makeFileFirst("F:\\20150420\\down\\myplatform\\src\\main\\java\\com\\platform\\app\\web", "F:\\20150420\\down\\myplatform\\src\\main\\java\\com\\platform\\app\\po", null);

	}
}
