<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee           http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         version="3.0">
    <display-name>${project} 3.0 Web Application</display-name>
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
        <welcome-file>index.html</welcome-file>
    </welcome-file-list>
<#if sitemesh=="yes">
    <!--siteMesh 控制器 -->
    <filter>
        <filter-name>sitemesh</filter-name>
        <filter-class>org.sitemesh.config.ConfigurableSiteMeshFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>sitemesh</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</#if>
<#if  frameworkType=="ssh" ||  webFramework=="springMVC" || frameworkType=="ssm" >
    <!-- spring 装载xml文件-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring/applicationContext-*.xml</param-value>
    </context-param>
    <context-param>
        <param-name>spring.liveBeansView.mbeanDomain</param-name>
        <param-value>dev</param-value>
    </context-param>
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</#if>

<#if webFramework=="springMVC">
    <!--通过容器来处理静态资源文件-->
    <servlet-mapping>
        <servlet-name>default</servlet-name>
        <url-pattern>/static/*</url-pattern>
    </servlet-mapping>
</#if>
<#if webFramework=="springMVC">
    <servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <!--在DispatcherServlet的初始化过程中，框架会在web应用的 WEB-INF文件夹下寻找名为[servlet-name]-servlet.xml 的配置文件，生成文件中定义的bean。-->
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--指明了配置文件的文件名，不使用默认配置文件名，而使用dispatcher-servlet.xml配置文件。-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <!--其中<param-value>**.xml</param-value> 这里可以使用多种写法-->
            <!--1、不写,使用默认值:/WEB-INF/<servlet-name>-servlet.xml-->
            <!--2、<param-value>/WEB-INF/classes/dispatcher-servlet.xml</param-value>-->
            <!--3、<param-value>classpath*:dispatcher-servlet.xml</param-value>-->
            <!--4、多个值用逗号分隔-->
            <param-value>classpath:spring/spring-context.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup><!--是启动顺序，让这个Servlet随Servletp容器一起启动。-->
    </servlet>
    <servlet-mapping>
        <!--这个Servlet的名字是dispatcher，可以有多个DispatcherServlet，是通过名字来区分的。每一个DispatcherServlet有自己的WebApplicationContext上下文对象。同时保存的ServletContext中和Request对象中.-->
        <!--ApplicationContext是Spring的核心，Context我们通常解释为上下文环境，我想用“容器”来表述它更容易理解一些，ApplicationContext则是“应用的容器”了:P，Spring把Bean放在这个容器中，在需要的时候，用getBean方法取出-->
        <servlet-name>DispatcherServlet</servlet-name>
        <!--Servlet拦截匹配规则可以自已定义，当映射为@RequestMapping("/user/add")时，为例,拦截哪种URL合适？-->
        <!--1、拦截*.do、*.htm， 例如：/user/add.do,这是最传统的方式，最简单也最实用。不会导致静态文件（jpg,js,css）被拦截。-->
        <!--2、拦截/，例如：/user/add,可以实现现在很流行的REST风格。很多互联网类型的应用很喜欢这种风格的URL。弊端：会导致静态文件（jpg,js,css）被拦截后不能正常显示。 -->
        <url-pattern>/</url-pattern> <!--会拦截URL中带“/”的请求。-->
    </servlet-mapping>
<#elseif  frameworkType=="ssh" || webFramework=="structs2" || frameworkType=="ssm">
    <filter>
        <filter-name>struts2</filter-name>
        <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>struts2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</#if>
<#if (ormFramework=="hibernate" && webFramework=="springMVC") || frameworkType=="ssh">
    <!--hibernate 相关 -->
    <filter>
        <filter-name>hibernate5Filter</filter-name>
        <filter-class>org.springframework.orm.hibernate5.support.OpenSessionInViewFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>hibernate5Filter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</#if>
    <#if databasePool=="Druid">
        <!--druid 监控 -->
        <servlet>
            <!-- sql 栏显示 -->
            <servlet-name>DruidStatView</servlet-name>
            <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
            <init-param>
                <!-- 允许清空统计数据 -->
                <param-name>resetEnable</param-name>
                <param-value>true</param-value>
            </init-param>
            <init-param>
                <!-- 用户名 -->
                <param-name>loginUsername</param-name>
                <param-value>druid</param-value>
            </init-param>
            <init-param>
                <!-- 密码 -->
                <param-name>loginPassword</param-name>
                <param-value>druid</param-value>
            </init-param>
        </servlet>
        <servlet-mapping>
            <servlet-name>DruidStatView</servlet-name>
            <url-pattern>/druid/*</url-pattern>
        </servlet-mapping>
    </#if>
<#if isProfile=="yes">
    <!--profile 控制器 -->
</#if>
    <!--日志环境配置-->
    <!--公用环境配置:session-config,error_page,404,500-->
<#if urlRewriter=="yes">
    <filter>
        <filter-name>UrlRewriteFilter</filter-name>
        <filter-class>org.tuckey.web.filters.urlrewrite.UrlRewriteFilter</filter-class>
        　　<!-- 因为urlrewrite.xml只能在web-inf下，所以我们这里可以省略掉urlrewrite.xml的路径配置。 -->
        <init-param>
            <param-name>logLevel</param-name>
            <param-value>WARN</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>UrlRewriteFilter</filter-name>
        <url-pattern>/*</url-pattern>
        <dispatcher>REQUEST</dispatcher>
        <dispatcher>FORWARD</dispatcher>
    </filter-mapping>
</#if>

    <#if template != "jsp">
        <!-- 解决velocity，freemaker 欢饮页面乱码问题-->
    <jsp-config>
        <jsp-property-group>
            <url-pattern>*.html</url-pattern>
            <page-encoding>UTF-8</page-encoding>
        </jsp-property-group>
    </jsp-config>
    </#if>
</web-app>