<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <classPathEntry
            location="${jarPath}\mysql-connector-java-5.1.20-bin.jar"/>

    <context id="demo" targetRuntime="MyBatis3">
        <plugin type="org.mybatis.generator.plugins.SerializablePlugin"/>
		<plugin type="com.mybatis.generator.plugins.MapperAnnotationPlugin"/>
		<plugin type="com.mybatis.generator.plugins.MySqlInsertPKPlugin"/>

        <commentGenerator>
        	<property name="suppressTypeWarnings" value="true"/>
            <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
       		<property name="suppressAllComments" value="false"/>
		</commentGenerator>
        
        <!--<jdbcConnection driverClass="oracle.jdbc.driver.OracleDriver"
                        connectionURL="jdbc:oracle:thin:@192.168.2.135:1521:member"
                        userId="game_billing"
                        password="root">
        </jdbcConnection>-->

        <jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://localhost:3306/${databaseName}?useUnicode=true&amp;characterEncoding=latin1"
            userId="${databaseUser}" password="${databasePassword}">
        </jdbcConnection>

        <javaTypeResolver type="com.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl">
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>

        <javaModelGenerator targetPackage="${poPkg}" targetProject="${mybatisProject}">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>

        <sqlMapGenerator targetPackage="${daoPkg}.sqlmap" targetProject="${mybatisProject}">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>

        <javaClientGenerator type="XMLMAPPER" targetPackage="${daoPkg}" targetProject="${mybatisProject}">
        <property name="enableSubPackages" value="true"/>
     </javaClientGenerator>

        <#list tableList as tableName>
        <table schema="general" tableName="${tableName}" />
        </#list>
    </context>
</generatorConfiguration>