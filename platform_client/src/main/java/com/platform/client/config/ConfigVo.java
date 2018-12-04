package com.platform.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ConfigVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Value("#{configProperties['root_path']}")
	private String rootPath;
	@Value("#{configProperties['jsFramework_path']}")
	private String jsFrameworkPath;
	@Value("#{configProperties['htmlFramework_path']}")
	private String htmlFrameworkPath;
	@Value("#{configProperties['other_path']}")
	private String otherPath;
	@Value("#{configProperties['software_path']}")
	private String softewarePath;
	@Value("#{configProperties['mybatis_path']}")
	private String mybatisPath;
	@Value("#{configProperties['jarPath']}")
	private String jarPath;

	public String getSoftewarePath() {
		return softewarePath;
	}

	public void setSoftewarePath(String softewarePath) {
		this.softewarePath = softewarePath;
	}

	public String getOtherPath() {
		return otherPath;
	}

	public void setOtherPath(String otherPath) {
		this.otherPath = otherPath;
	}

	public String getJsFrameworkPath() {
		return jsFrameworkPath;
	}

	public void setJsFrameworkPath(String jsFrameworkPath) {
		this.jsFrameworkPath = jsFrameworkPath;
	}

	public String getHtmlFrameworkPath() {
		return htmlFrameworkPath;
	}

	public void setHtmlFrameworkPath(String htmlFrameworkPath) {
		this.htmlFrameworkPath = htmlFrameworkPath;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getMybatisPath() {
		return mybatisPath;
	}

	public void setMybatisPath(String mybatisPath) {
		this.mybatisPath = mybatisPath;
	}

	public String getJarPath() {
		return jarPath;
	}

	public void setJarPath(String jarPath) {
		this.jarPath = jarPath;
	}
}
