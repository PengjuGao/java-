package com.platform.manager.web.genterProject.constants;

/**
 * Enums Constants 枚举静态类声明
 * Created by gaoepngju on 16/6/28.
 */
public class EConstants {

    /**
     * 自动生成的种类:项目,模块,代码
     * */
    public static enum EProjectType{
        PROJECT("project","项目"),
        MODULE("module","模块"),
        CODE("code","代码"),
        SQL("sql","SQL语句"),
        XML("xml","XML文件"),
        ENUM("enum","java 枚举类"),
        INTERFACE("interface","java 接口"),
        BEAN("bean","java bean"),
        ;
        public String code;
        public String value;
        EProjectType(String code,String value){
            this.code = code;
            this.value = value;
        }
    }

    /**
     * 要创建的文件名称枚举类
     */
    public static enum CreateFileType{
        POM("pom.xml","项目pom.xml文件"),
        WEB("web.xml","项目web.xml文件"),
        ;
        public String name;
        public String desc;
        //构造函数
        CreateFileType(String name,String desc){
            this.name = name;
            this.desc = desc;
        }
        //获取枚举类
        public static CreateFileType getEnumObj(String name){
            CreateFileType[] objs = CreateFileType.values();
            for (CreateFileType tempObj:
                 objs) {
                if(name.equals(tempObj.name)){
                    return tempObj;
                }
            }
            return null;
        }

    }
}
