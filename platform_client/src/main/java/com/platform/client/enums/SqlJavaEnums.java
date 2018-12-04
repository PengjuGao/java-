package com.platform.client.enums;

/**
 * Created by Administrator on 2017/2/21.
 */
public enum SqlJavaEnums {

   object("Object","point,linestring,polygon,multipoint,multilinestring,multipolygon,geometrycollection"),
    string("String","varchar,char,tinytext,enum,set,text,mediumtext,longtext"),
    byteArr("byte[]","tinyblob,blob,mediumblob,longblob,binary,varbinary,geometry"),
    Byte("Byte","tinyint"),
    integer("Integer","mediumint,int"),
    SHORT("Short","smallint"),
    LONG("Long","bigint"),
    Boolean("Boolean","Boolean"),
    DOUBLE("Double","double"),
    FLOAT("Float","float"),
    DATE("Date","date,time,year,timestamp,datetime"),
    ;
    public String className;
    public String sqlType;
    SqlJavaEnums(String className,String sqlType){
        this.className = className;
        this.sqlType = sqlType;
    }

}
