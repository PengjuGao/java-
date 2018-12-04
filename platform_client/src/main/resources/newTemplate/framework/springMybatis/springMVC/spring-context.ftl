<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc" 
	   xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:context="http://www.springframework.org/schema/context" 
	xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/aop 
        http://www.springframework.org/schema/aop/spring-aop.xsd
		http://www.springframework.org/schema/mvc 
		http://www.springframework.org/schema/mvc/spring-mvc.xsd
		http://www.springframework.org/schema/context
		http://www.springframework.org/schema/context/spring-context.xsd">
	<!-- 全局context类配置 -->
	<mvc:default-servlet-handler />
	<!-- 激活自动代理功能 -->
	<aop:aspectj-autoproxy proxy-target-class="true" />
	<!-- 启动注解扫描 -->
	<mvc:annotation-driven />
	<context:component-scan base-package="${packageName}"></context:component-scan>
	<!-- start视图配置 -->
	<#if template=="jsp">
	<bean id="viewResolver"
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix">
			<value>/WEB-INF/views/</value>
		</property>
		<property name="suffix">
			<value>.jsp</value>
		</property>
		<property name="viewClass">
			<value>org.springframework.web.servlet.view.JstlView</value>
		</property>
	</bean>
	<#elseif template=="velocity">
        <!-- 配置velocity引擎 -->
        <bean id="velocityConfigurer"
              class="org.springframework.web.servlet.view.velocity.VelocityConfigurer">
            <property name="resourceLoaderPath" value="/WEB-INF/views/" /><!-- 模板存放的路径 -->
            <property name="configLocation" value="classpath:velocity/velocity.properties" />
        </bean>
        <!-- 配置视图的显示 -->
        <bean id="viewResolver" class="org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver">
            <property name="prefix" value="/" /><!-- 视图文件的前缀，即存放的路径 -->
            <property name="suffix" value=".html" /><!-- 视图文件的后缀名 -->
          <!--  <property name="toolboxConfigLocation" value="/WEB-INF/tools.xml" /> --><!--toolbox配置文件路径-->
            <property name="dateToolAttribute" value="date" /><!--日期函数名称-->
            <property name="numberToolAttribute" value="number" /><!--数字函数名称-->
            <property name="contentType" value="text/html;charset=UTF-8" />
            <property name="exposeSpringMacroHelpers" value="true" /><!--是否使用spring对宏定义的支持-->
            <property name="exposeRequestAttributes" value="true" /><!--是否开放request属性-->
            <property name="requestContextAttribute" value="rc"/><!--request属性引用名称-->
            <property name="layoutUrl" value="base/default.html"/><!--指定layout文件-->
        </bean>
	<#elseif template=="freemaker">
        <bean id="freemarkerConfig" class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
            <property name="templateLoaderPath" value="/WEB-INF/views/"/>
            <property name="freemarkerVariables">
                <map>
                    <entry key="xml_escape" value-ref="fmXmlEscape"/>
                </map>
            </property>
        </bean>
        <bean id="fmXmlEscape" class="freemarker.template.utility.XmlEscape"/>
        <bean id="viewResolver" class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
            <property name="cache" value="true" />
            <property name="prefix" value="" />
            <property name="suffix" value=".html" />
            <property name="contentType" value="text/html;charset=UTF-8"></property>
            <property name="requestContextAttribute" value="request" />
            <property name="exposeSpringMacroHelpers" value="true" />
            <property name="exposeRequestAttributes" value="true" />
            <property name="exposeSessionAttributes" value="true" />
        </bean>
	</#if>
	<!-- end视图配置 -->
	<!-- 全局context类配置 -->
</beans>