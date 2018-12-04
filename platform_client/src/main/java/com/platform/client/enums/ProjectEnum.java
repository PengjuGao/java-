package com.platform.client.enums;

/**
 * Created by Administrator on 2016/11/11.
 * 项目架构枚举
 */
public enum ProjectEnum {
    ssm(1000,"ssm","framework/structs2SpringMybatis.ftl"),
    ssh(1001,"ssh","framework/structs2SpringHibernate.ftl"),
    springHibernate(1002,"springHibernate","framework/springHibernate.ftl"),
    springMybatis(1003,"springMybatis","framework/springMybatis.ftl"),
    structs2Hibernate(1004,"structs2Hibernate","framework/structs2Hibernate.ftl"),
    structs2Mybatis(1005,"structs2Mybatis","framework/structs2Mybatis.ftl"),
    ;
    public int code;
    public String name;
    public String url;

    ProjectEnum(int code,String name,String url){
        this.code = code;
        this.name = name;
        this.url = url;
    }

    /**
     * 获取枚举类
     * @param name
     * @return
     */
    public static ProjectEnum getEnum(String name){
        for (ProjectEnum obj:
               values()) {
            if(obj.name.equals(name)){
                return obj;
            }
        }
        return null;
    }

    /**
     * 获取url
     * @param name
     * @return
     */
    public static String getUrl(String name){
        ProjectEnum obj = getEnum(name);
        if(null != obj ){
            return obj.url;
        }else{
            return "";
        }
    }
}
