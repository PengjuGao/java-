package com.platform.client.enums;

/**
 * Created by Administrator on 2016/10/28.
 */
public enum FrameworkEnum {
    NONE(0),
    SPINRG(10),
    STRUCTS2(20),
    MYBATIS(1),
    HIBERNATE(2),
    SPRING_MYBATIS(11),
    STRUCTS2_HIBERNATE(22),
    SPRING_HIBERNATE(12),
    STRUCTS2_MYBATIS(21),
    ;
    public int webOrmCode;
    FrameworkEnum(int webOrmCode){
       this.webOrmCode = webOrmCode;
    }
    public static FrameworkEnum getEnum(int value){
        FrameworkEnum obj = null;
        for (FrameworkEnum tempObj :
                values()) {
            if (tempObj.webOrmCode == value) {
                return tempObj;
            }
        }
        return obj;
    }
}
