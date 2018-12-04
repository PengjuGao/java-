package com.platform.client.enums;

/**
 * Created by Administrator on 2016/10/31.
 */
public enum FunctionEnum {
    //spring mvc 功能
    springMVC(1001,"springMvc","template/common/spring_conf.xml"),
    //没有任何框架下的mybatis功能
    mybatis(1002,"springMybatis","template/common/mybatis/springMybatis.xml"),
    //spring集成的mybatis功能
    springMybatis(1003,"springMybatis","template/common/mybatis/springMybatis.xml"),
    //structs集成的mybatis功能
    structs2Mybatis(1004,"structs2Mybatis","template/common/spring_conf.xml"),
    //数据库功能相关
    springDatabase(2005,"springDatabase",""),
    ;
    public int code;
    public String msg;
    public String configUrl;
    FunctionEnum(int code,String msg,String configUrl){
        this.code = code;
        this.msg = msg;
        this.configUrl = configUrl;
    }

    /**
     * 根据code获取对应的枚举
     * @return
     */
    public static FunctionEnum getEnum(int code){
        FunctionEnum obj = null;
        for (FunctionEnum temp :
                values()) {
            if (code == temp.code) {
                return temp;
            }
        }
        return obj;
    }
}
