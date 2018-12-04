<?xml version="1.0" encoding="UTF-8"?>
<root>
    <!--structs 功能-->
    <element action="create" name="${packageName}" id="package_root" parentNode="main_java" type="package"/>
    <element action="create" name="${packageName}.test" parentNode="test_java" id="test_test" type="package"/>
    <element action="create" name="${packageName}.web" parentNode="main_java" id="package_web" type="package"/>
    <element action="copy" suffix="java"  name="TestAction" target="framework/structs2Hibernate/structs2/TestAction.ftl" parentNode="package_web"/>
    <element action="copy" suffix="xml" name="struts" target="framework/structs2Hibernate/structs2/struts.ftl" parentNode="main_resources"/>

    <!--hibernate 功能-->
    <element action="create" name="${packageName}.base" parentNode="main_java" id="package_base" type="package"/>
    <element action="create" name="${packageName}.po" parentNode="main_java" id="package_po" type="package"/>
    <element action="create" name="${packageName}.dao" parentNode="main_java" id="package_dao" type="package"/>

    <element action="copy" suffix="java" name="BaseDao" target="framework/structs2Hibernate/hibernate/BaseDao.ftl" parentNode="package_base"/>
    <element action="copy" suffix="java" name="Book" target="framework/structs2Hibernate/hibernate/Book.ftl" parentNode="package_po"/>
    <element action="copy" suffix="java" name="BookDAO" target="framework/structs2Hibernate/hibernate/BookDAO.ftl" parentNode="package_dao"/>
    <element action="copy" suffix="java" name="BookDAOImpl" target="framework/structs2Hibernate/hibernate/BookDAOImpl.ftl" parentNode="package_dao"/>
    <element action="copy" suffix="xml" name="hibernate#cfg" target="framework/structs2Hibernate/hibernate/hibernated.cfg.ftl" parentNode="main_resources"/>

    <#if template=="velocity">
        <element action="create" type="dir" name="velocity"  parentNode="main_resources" id="resources_velocity"/>
        <element action="copy" suffix="xml" name="toolbox" target="framework/structs2Hibernate/velocity/toolbox.ftl" parentNode="resources_velocity"/>
        <element action="copy" suffix=".properties" name="velocity" target="framework/structs2Hibernate/velocity/velocity.ftl" parentNode="resources_velocity"/>
    </#if>

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

    <#if databasePool == "Proxool">
        <element action="copy" suffix="xml" name="proxool" target="framework/structs2Hibernate/hibernate/proxool.ftl" parentNode="main_resources"/>
    </#if>
</root>