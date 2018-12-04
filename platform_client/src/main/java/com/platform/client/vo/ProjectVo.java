package com.platform.client.vo;

/**
 * Created by Administrator on 2016/10/24.
 * 创建项目骨架的时候需要的辅助类
 */
public class ProjectVo extends CommonVo {

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
}
