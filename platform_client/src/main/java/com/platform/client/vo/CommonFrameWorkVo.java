package com.platform.client.vo;



import com.platform.base.utils.DateUtils;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/9.
 */
public class CommonFrameWorkVo {
    private String token;//重复提交标志
    private String frameworkType;//ssh ,springHibernate,springMybatis,structsHibernate,structsMybatis
    private String userId;//代指email
    private String project;//项目名称
    private String packageName;//包名
    private String mavenType="web";
    private String webFramework;
    private String ormFramework;
    private String isMoreOrSingle;//单数据源，多数据源
    private String databaseType="mysql";//数据库类型，默认mysql
    private String databasePool;//数据库连接池 c3p0，dbcp，druid
    private String cache;//缓存：ehcache，memcache，redis
    private String isProfile;//是否需要profile；
    private String sitemesh;//是否添加siteMesh；
    private String urlRewiter;//是否添加urlRewiter;
    private String template;//页面模板引擎
    private String htmlFramework;//dwz amazeUI easyUI bootstrap
    private String createTime = DateUtils.formatFullDate(new Date());
    private String jsFramework;//jquery,vue,angluarjs

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getJsFramework() {
        return jsFramework;
    }

    public void setJsFramework(String jsFramework) {
        this.jsFramework = jsFramework;
    }

    public String getHtmlFramework() {
        return htmlFramework;
    }

    public void setHtmlFramework(String htmlFramework) {
        this.htmlFramework = htmlFramework;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getFrameworkType() {
        return frameworkType;
    }

    public void setFrameworkType(String frameworkType) {
        this.frameworkType = frameworkType;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMavenType() {
        return mavenType;
    }

    public void setMavenType(String mavenType) {
        this.mavenType = mavenType;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSitemesh() {
        return sitemesh;
    }

    public void setSitemesh(String siteMesh) {
        this.sitemesh = siteMesh;
    }

    public String getUrlRewiter() {
        return urlRewiter;
    }

    public void setUrlRewiter(String urlRewiter) {
        this.urlRewiter = urlRewiter;
    }

    public String getIsProfile() {
        return isProfile;
    }

    public void setIsProfile(String isProfile) {
        this.isProfile = isProfile;
    }

    public String getWebFramework() {
        return webFramework;
    }

    public void setWebFramework(String webFramework) {
        this.webFramework = webFramework;
    }

    public String getOrmFramework() {
        return ormFramework;
    }

    public void setOrmFramework(String ormFramework) {
        this.ormFramework = ormFramework;
    }

    public String getIsMoreOrSingle() {
        return isMoreOrSingle;
    }

    public void setIsMoreOrSingle(String isMoreOrSingle) {
        this.isMoreOrSingle = isMoreOrSingle;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getDatabasePool() {
        return databasePool;
    }

    public void setDatabasePool(String databasePool) {
        this.databasePool = databasePool;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }
}
