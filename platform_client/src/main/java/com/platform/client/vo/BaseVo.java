package com.platform.client.vo;

/**
 * Created by Administrator on 2016/11/3.
 * 未来修改中需要重新规划，目前暂不在规划中
 */
public class BaseVo {
    //用户id
    private String userId;
   /**maven 类型：web,jar**/
    public String mavenType;
    /**web 框架:0 无 1: spring 2：structs***/
    public int webFramework;
    /***orm 框架：0：无 1:mybatis 2:hibernate 3:jpa****/
    public int ormFramework;
    /***是否是多数据源0:单数据源1:多数据源****/
    public int isMoreDatabase;
    /***数据库连接池: 1:dbcp,2:c3p0,3:durid***/
    public int databasePool;
}
