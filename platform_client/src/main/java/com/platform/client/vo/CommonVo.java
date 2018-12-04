package com.platform.client.vo;

import com.platform.client.common.Resources;

import java.io.File;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/28.
 */
public class CommonVo implements Serializable{

    private String userId;
    private String projectName;
    private String path;
    private String javaMainPath;
    private String javaTestPath;
    private String webPath;
    private String pomPath;
    private String javaPath;
    private String selfPath;
    private int[] functionIds;

    /***数据库功能相关****/
    private int databaseType;//1：mysql 2：Oracle
    private int databasePool;//1：C3PO 2:DBCH 3:阿里巴巴Druid
    private int isMoreOrSingle;//1:单数据源 2:多数据源(2个)

    public int getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(int databaseType) {
        this.databaseType = databaseType;
    }

    public int getDatabasePool() {
        return databasePool;
    }

    public void setDatabasePool(int databasePool) {
        this.databasePool = databasePool;
    }

    public int getIsMoreOrSingle() {
        return isMoreOrSingle;
    }

    public void setIsMoreOrSingle(int isMoreOrSingle) {
        this.isMoreOrSingle = isMoreOrSingle;
    }

    public int[] getFunctionIds() {
        return functionIds;
    }

    public void setFunctionIds(int[] functionIds) {
        this.functionIds = functionIds;
    }

    public String getJavaPath() {
        return path + File.separator + Resources.PRO_MAIN_JAVA;
    }

    public void setJavaPath(String javaPath) {
        this.javaPath = javaPath;
    }

    public String getSelfPath() {
        return selfPath;
    }

    public void setSelfPath(String selfPath) {
        this.selfPath = selfPath;
    }

    public String getJavaMainPath() {
        return path + File.separator + Resources.PRO_MAIN_JAVA;
    }

    public void setJavaMainPath(String javaMainPath) {
        this.javaMainPath = javaMainPath;
    }

    public String getJavaTestPath() {
        return path + File.separator + Resources.PRO_TEST_JAVA;
    }

    public void setJavaTestPath(String javaTestPath) {
        this.javaTestPath = javaTestPath;
    }

    public String getWebPath() {
        return path + File.separator + Resources.PRO_MAIN_WEBINF + File.separator + "web.xml";
    }

    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }

    public String getPomPath() {
        return path + File.separator + "pom.xml";
    }

    public void setPomPath(String pomPath) {
        this.pomPath = pomPath;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
