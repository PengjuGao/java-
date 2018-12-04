package com.platform.base.common.classTemplate;

/**
 * 
 * 生成模板所需要的路径
 * @author gaopj
 *
 */
public class PathParamVo {

	/**
	 * po路径
	 */
	private String poPackageUrl;
	
	private String poPackage;
	/**
	 * vo路径
	 */
	private String voPackageUrl;
	
	private String voPackage;
	/**
	 * dao路径
	 */
	private String daoPackageUrl;
	
	private String daoPackage;
	/**
	 * serviceImpl路径
	 */
	private String serviceImplPackageUrl;
	
	private String serviceImplPackage;
	/**
	 * service路径
	 */
	private String servicePackageUrl;
	
	private String servicePackage;
	/**
	 * controller路径
	 */
	private String controllerPackageUrl;
	
	private String controllerPackage;
	/**
	 * conditionVo路径
	 */
	private String conditionVoPackageUrl;
	
	private String conditionVoPackage;
	
	
	/**
	 * 模板路径
	 */
	private String templateUrl;
	
	/**
	 * 那种模板类型（dao,service,controller）
	 * @author gaopj
	 */
	public enum TemplateType{
		CONDITIONVO("ConditionVo"),
		DAO("Mapper"),
		SERVICE("Service"),
		SERVICEIMPL("ServiceImpl"),
		CONTROLLER("Controller"),
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
		
		//去掉最后的点
		if(packageName.endsWith(".")){
			packageName = packageName.substring(0, packageName.length()-1);
		}

		return packageName;
		//}


		//return null;
	}
	
	public String getPoPackageUrl() {
		return poPackageUrl;
	}
	public void setPoPackageUrl(String poPackageUrl) {
		this.poPackageUrl = poPackageUrl;
		
		this.poPackage = dealPackageUrl(poPackageUrl);
	}
	public String getVoPackageUrl() {
		return voPackageUrl;
	}
	public void setVoPackageUrl(String voPackageUrl) {
		this.voPackageUrl = voPackageUrl;
		
		this.voPackage = dealPackageUrl(voPackageUrl);
	}
	public String getDaoPackageUrl() {
		return daoPackageUrl;
	}
	public void setDaoPackageUrl(String daoPackageUrl) {
		this.daoPackageUrl = daoPackageUrl;
		
		this.daoPackage = dealPackageUrl(daoPackageUrl);
	}
	public String getServiceImplPackageUrl() {
		return serviceImplPackageUrl;
	}
	public void setServiceImplPackageUrl(String serviceImplPackageUrl) {
		this.serviceImplPackageUrl = serviceImplPackageUrl;
		
		this.serviceImplPackage = dealPackageUrl(serviceImplPackageUrl);
	}
	public String getServicePackageUrl() {
		return servicePackageUrl;
	}
	public void setServicePackageUrl(String servicePackageUrl) {
		this.servicePackageUrl = servicePackageUrl;
		
		this.servicePackage = dealPackageUrl(servicePackageUrl);
	}
	public String getControllerPackageUrl() {
		return controllerPackageUrl;
	}
	public void setControllerPackageUrl(String controllerPackageUrl) {
		this.controllerPackageUrl = controllerPackageUrl;
		
		this.controllerPackage = dealPackageUrl(controllerPackageUrl);
	}
	public String getTemplateUrl() {
		return templateUrl;
	}
	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}
	public String getPoPackage() {
		return poPackage;
	}
	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
	public String getVoPackage() {
		return voPackage;
	}
	public void setVoPackage(String voPackage) {
		this.voPackage = voPackage;
	}
	public String getDaoPackage() {
		return daoPackage;
	}
	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	public String getServiceImplPackage() {
		return serviceImplPackage;
	}
	public void setServiceImplPackage(String serviceImplPackage) {
		this.serviceImplPackage = serviceImplPackage;
	}
	public String getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
	public String getControlelrPackage() {
		return controllerPackage;
	}
	public void setControlelrPackage(String controlelrPackage) {
		this.controllerPackage = controlelrPackage;
	}

	public String getControllerPackage() {
		return controllerPackage;
	}

	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}

	public String getConditionVoPackageUrl() {
		return conditionVoPackageUrl;
	}

	public void setConditionVoPackageUrl(String conditionVoPackageUrl) {
		this.conditionVoPackageUrl = conditionVoPackageUrl;
		
		this.conditionVoPackage = this.dealPackageUrl(conditionVoPackageUrl);
	}

	public String getConditionVoPackage() {
		return conditionVoPackage;
	}

	public void setConditionVoPackage(String conditionVoPackage) {
		this.conditionVoPackage = conditionVoPackage;
	}
}
