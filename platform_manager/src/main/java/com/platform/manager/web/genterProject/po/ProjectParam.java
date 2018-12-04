package com.platform.manager.web.genterProject.po;

import java.io.Serializable;

/**
 * Created by gaoepngju on 16/6/28.
 */
public class ProjectParam implements Serializable{

    /**
     * 项目存放路径
     * */
    private String url;
    /**
     * 项目类型
     * @see com.platform.manager.web.genterProject.constants.EConstants
     *
     * */
    private String type;
    /**
     * 项目名称
     */
    private String name;

    /**
     * 特殊文件的路径
     * pom.xml,web.xml,index.jsp,errorPage.jsp.....
     */
    private String pomxmlPath;
    private String webxmlPath;
    private String indexjspPath;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPomxmlPath() {
        return pomxmlPath;
    }

    public void setPomxmlPath(String pomxmlPath) {
        this.pomxmlPath = pomxmlPath;
    }

    public String getWebxmlPath() {
        return webxmlPath;
    }

    public void setWebxmlPath(String webxmlPath) {
        this.webxmlPath = webxmlPath;
    }

    public String getIndexjspPath() {
        return indexjspPath;
    }

    public void setIndexjspPath(String indexjspPath) {
        this.indexjspPath = indexjspPath;
    }
}
