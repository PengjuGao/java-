package com.platform.client.common;

/**
 * Created by Administrator on 2016/10/23.
 *资源位置标记类
 * 骨架是固定的，将所有固定的文件夹和文件以硬代码的形式列出来
 */
public class Resources {
    //maven项目公用src
    public static final String PRO_SRC ="src";
    //maven项目公用main
    public static final String PRO_MAIN=PRO_SRC+"/main";
    //maven项目公用test
    public static final String PRO_TEST = PRO_SRC+"/test";
    //maven项目main目录下公用java ，resources webapp
    public static final String PRO_MAIN_JAVA = PRO_MAIN+"/java";
    public static final String PRO_MAIN_RESOURCES = PRO_MAIN+"/resources";
    public static final String PRO_MAIN_WEBAPP = PRO_MAIN+"/webapp";

    //maven项目test目录下公用 java ，resources
    public static final String PRO_TEST_JAVA = PRO_TEST+"/java";
    public static final String PRO_TEST_RESOURCES = PRO_TEST+"/resources";

    //maven web 项目下的WEB-INF ,WEB.XML,index.jsp
    public static final String PRO_MAIN_STATIC = PRO_MAIN_WEBAPP+"/static";//存放静态文件
    public static final String PRO_MAIN_WEBINF= PRO_MAIN_WEBAPP+"/WEB-INF";
    public static final String PRO_MAIN_VIEWS = PRO_MAIN_WEBINF+"/views";
    //web.xml 和index.jsp 是固定的，写地址即可
}
