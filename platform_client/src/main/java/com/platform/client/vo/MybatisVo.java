package com.platform.client.vo;

/**
 * Created by Administrator on 2017/6/1.
 * mybatis 参数提交
 */
public class MybatisVo {

    private String mysql;//sql 文本
    private String controllerPkg="com.javacoder.top.controller";//控制层包名
    private String servicePkg="com.javacoder.top.service";//服务层报名
    private String daoPkg="com.javacoder.top.dao";//dao层包名
    private String poPkg="com.javacoder.top.po";//实体类包名
    private String examplePkg="com.javacoder.top.po";//sql封装类包名
    private String exampleSuffix="Example";//sql 封装类包名后缀
    private String xmlMethodReplace="Example";//mapper 中方法名替换值
    private String token;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMysql() {
        return mysql;
    }

    public void setMysql(String mysql) {
        this.mysql = mysql;
    }

    public String getControllerPkg() {
        return controllerPkg;
    }

    public void setControllerPkg(String controllerPkg) {
        this.controllerPkg = controllerPkg;
    }

    public String getServicePkg() {
        return servicePkg;
    }

    public void setServicePkg(String servicePkg) {
        this.servicePkg = servicePkg;
    }

    public String getDaoPkg() {
        return daoPkg;
    }

    public void setDaoPkg(String daoPkg) {
        this.daoPkg = daoPkg;
    }

    public String getPoPkg() {
        return poPkg;
    }

    public void setPoPkg(String poPkg) {
        this.poPkg = poPkg;
    }

    public String getExamplePkg() {
        return examplePkg;
    }

    public void setExamplePkg(String examplePkg) {
        this.examplePkg = examplePkg;
    }

    public String getExampleSuffix() {
        return exampleSuffix;
    }

    public void setExampleSuffix(String exampleSuffix) {
        this.exampleSuffix = exampleSuffix;
    }

    public String getXmlMethodReplace() {
        return xmlMethodReplace;
    }

    public void setXmlMethodReplace(String xmlMethodReplace) {
        this.xmlMethodReplace = xmlMethodReplace;
    }
}
