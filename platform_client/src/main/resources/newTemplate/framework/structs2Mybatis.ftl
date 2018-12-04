<?xml version="1.0" encoding="UTF-8"?>
<root>
    <!--structs 功能-->
    <element action="create" name="${packageName}" id="package_root" parentNode="main_java" type="package"/>
    <element action="create" name="${packageName}.test" parentNode="test_java" id="test_test" type="package"/>
    <element action="create" name="${packageName}.web" parentNode="main_java" id="package_web" type="package"/>
    <element action="copy" suffix="java"  name="TestAction" target="framework/structs2Mybatis/mybatis/TestAction.ftl" parentNode="package_web"/>
    <element action="copy" suffix="xml" name="struts" target="framework/structs2Hibernate/structs2/struts.ftl" parentNode="main_resources"/>

    <!--mybatis 功能-->
    <element action="create" name="${packageName}.base" parentNode="main_java" id="package_base" type="package"/>
    <element action="create" name="${packageName}.po" parentNode="main_java" id="package_po" type="package"/>
    <element action="create" name="${packageName}.dao" parentNode="main_java" id="package_dao" type="package"/>
    <element action="create" name="mapper" parentNode="main_resources" id="resources_mapper" type="dir"/>
    <element action="create" name="mybatis" parentNode="main_resources" id="resources_mybatis" type="dir"/>
    <element action="copy" suffix="java" name="Book" target="framework/springMybatis/mybatis/Book.ftl" parentNode="package_po"/>
    <element action="copy" suffix="java" name="BookDAO" target="framework/springMybatis/mybatis/BookDAO.ftl" parentNode="package_dao"/>
    <element action="copy" suffix="xml" name="BookDAOMapper" target="framework/springMybatis/mybatis/BookDAOMapper.ftl" parentNode="resources_mapper"/>
    <element action="copy" suffix="xml" name="mybatis-config" target="framework/structs2Mybatis/mybatis/mybatis-config.ftl" parentNode="resources_mybatis"/>
    <element action="copy" suffix="java" name="BaseDao" target="framework/structs2Mybatis/mybatis/BaseDao.ftl" parentNode="package_base"/>
    <!-- 进行修改 -->
    <!--是否是多数据源-->
<#if isMoreOrSingle == 1>
    <element action="copy" target="/xx.java"/>
    <element action="merge" node="pom" target="newTemplate/pom.xml"/>
</#if>
    <!-- sitemesh 配置 -->
<#if sitemesh=="yes">
    <element action="create" type="dir" name="sitemesh"  parentNode="webinf" id="sitemesh"/>
    <element action="copy" suffix="xml" name="sitemesh3" target="framework/common/sitemesh/sitemesh3.ftl" parentNode="webinf"/>
    <#if template == "jsp">
        <#if htmlFramework="dwz">
            <element action="copy" suffix="jsp" name="sitemesh" target="framework/common/sitemesh/sitemesh_dwz.ftl" parentNode="sitemesh"/>
        <#elseif htmlFramework="amazeUI">
            <element action="copy" suffix="jsp" name="sitemesh" target="framework/common/sitemesh/sitemesh_amazeUI.ftl" parentNode="sitemesh"/>
        <#elseif htmlFramework="easyUI">
            <element action="copy" suffix="jsp" name="sitemesh" target="framework/common/sitemesh/sitemesh_easyUI.ftl" parentNode="sitemesh"/>
        <#elseif htmlFramework="bootstrap">
            <element action="copy" suffix="jsp" name="sitemesh" target="framework/common/sitemesh/sitemesh_bootstrap.ftl" parentNode="sitemesh"/>
        <#else>
            <element action="copy" suffix="jsp" name="sitemesh" target="framework/common/sitemesh/sitemesh.ftl" parentNode="sitemesh"/>
        </#if>

    <#else>
        <#if htmlFramework="dwz">
            <element action="copy" suffix="html" name="sitemesh" target="framework/common/sitemesh/sitemesh_dwz.ftl" parentNode="sitemesh"/>
        <#elseif htmlFramework="amazeUI">
            <element action="copy" suffix="html" name="sitemesh" target="framework/common/sitemesh/sitemesh_amazeUI.ftl" parentNode="sitemesh"/>
        <#elseif htmlFramework="easyUI">
            <element action="copy" suffix="html" name="sitemesh" target="framework/common/sitemesh/sitemesh_easyUI.ftl" parentNode="sitemesh"/>
        <#elseif htmlFramework="bootstrap">
            <element action="copy" suffix="html" name="sitemesh" target="framework/common/sitemesh/sitemesh_bootstrap.ftl" parentNode="sitemesh"/>
        <#else>
            <element action="copy" suffix="html" name="sitemesh" target="framework/common/sitemesh/sitemesh.ftl" parentNode="sitemesh"/>
        </#if>
    </#if>
</#if>
    <!--是否需要profile-->
<#if isNeedProfile == 1>
    <element action="copy" target="/xx.java"></element>
    <element action="merge" node="pom" target="newTemplate/pom.xml"/>
</#if>

<#if template=="velocity">
    <!--创建 base/default.html-->
    <element action="create" name="base" parentNode="views" id="views_base" type="dir"/>
    <element action="copy" name="default" target="framework/springMybatis/template/default.ftl" parentNode="views_base" suffix="html" type="file"/>
    <!-- 创建velocity.properties-->
    <element action="create"  name="velocity" parentNode="main_resources" id="resources_velocity" type="dir"/>
    <element action="copy" target="framework/springMybatis/template/velocity.ftl" name="velocity" parentNode="resources_velocity" suffix="properties" type="file"/>
</#if>
</root>