package com.platform.client.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/28.
 * 添加框架的vo（spring: sturts2.0，mybatis，hibernate）
 */
public class FrameworkVo extends CommonVo implements Serializable{

    //web框架类型
    private int webFrameworkType;
    //orm框架类型
    private int ormFrameworkType;
    //maven 类型（只支持jar，web）
    private String mavenType;
    //用户输入的项目名称
    private String projectName;
    //用户id
    private String userId;

    public String getMavenType() {
        return mavenType;
    }

    public void setMavenType(String mavenType) {
        this.mavenType = mavenType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getWebFrameworkType() {
        return webFrameworkType;
    }

    public void setWebFrameworkType(int webFrameworkType) {
        this.webFrameworkType = webFrameworkType;
    }

    public int getOrmFrameworkType() {
        return ormFrameworkType;
    }

    public void setOrmFrameworkType(int ormFrameworkType) {
        this.ormFrameworkType = ormFrameworkType;
    }
}
