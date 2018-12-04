<?xml version="1.0" encoding="UTF-8"?>
<root>
    <!--spring 功能-->
    <element action="create" name="${packageName}" parentNode="main_java" type="package"/>
    <element action="create" name="${packageName}.test" parentNode="test_java" id="test_test" type="package"/>
    <element action="create" name="${packageName}.web" parentNode="main_java" id="package_web" type="package"/>
    <element action="create" name="spring" parentNode="main_resources" id="resources_spring" type="dir"/>
    <element action="copy" suffix="java"  name="TestController" target="framework/springMybatis/springMVC/TestController.ftl" parentNode="package_web"/>
    <element action="copy" suffix="xml" name="spring-context" target="framework/springMybatis/springMVC/spring-context.ftl" parentNode="resources_spring"/>
    <element action="copy" suffix="java" name="SpringTestCase" target="framework/springMybatis/springMVC/SpringTestCase.ftl" parentNode="test_test"/>

    <!--hibernate 功能-->
    <element action="create" name="${packageName}.po" parentNode="main_java" id="package_po" type="package"/>
    <element action="create" name="${packageName}.dao" parentNode="main_java" id="package_dao" type="package"/>
    <element action="create" name="${packageName}.base" parentNode="main_java" id="package_base" type="package"/>
    <element action="copy" suffix="java" name="Book" target="framework/springMybatis/hibernate/Book.ftl" parentNode="package_po"/>
    <element action="copy" suffix="java" name="BookDAO" target="framework/springMybatis/hibernate/BookDAO.ftl" parentNode="package_dao"/>
    <element action="copy" suffix="java" name="BookDAOImpl" target="framework/springMybatis/hibernate/BookDAOImpl.ftl" parentNode="package_dao"/>
    <element action="copy" suffix="java" name="BaseDao" target="framework/springMybatis/hibernate/BaseDao.ftl" parentNode="package_base"/>
    <element action="copy" suffix="xml" name="applicationContext-hibernate" target="framework/springMybatis/hibernate/applicationContext-hibernate.ftl" parentNode="resources_spring"/>
    <!-- 进行修改 -->
    <!--是否是多数据源-->
<#if isMoreOrSingle == 1>
    <element action="copy" target="/xx.java"/>
    <element action="merge" node="pom" target="newTemplate/pom.xml"/>
</#if>
    <!-- 数据库 -->
    <element action="copy" suffix="xml" name="applicationContext-datasource"  target="framework/springMybatis/datasource/applicationContext-datasource.ftl" parentNode="resources_spring" id="package_po" type="file"/>

<#if template=="velocity">
    <!--创建 base/default.html-->
    <element action="create" name="base" parentNode="views" id="views_base" type="dir"/>
    <element action="copy" name="default" target="framework/springMybatis/template/default.ftl" parentNode="views_base" suffix="html" type="file"/>
    <!-- 创建velocity.properties-->
    <element action="create"  name="velocity" parentNode="main_resources" id="resources_velocity" type="dir"/>
    <element action="copy" target="framework/springMybatis/template/velocity.ftl" name="velocity" parentNode="resources_velocity" suffix="properties" type="file"/>
</#if>
    <!--是否需要profile-->
<#if isNeedProfile == 1>
    <element action="copy" target="/xx.java"></element>
    <element action="merge" node="pom" target="newTemplate/pom.xml"/>
</#if>
    <!-- 添加缓存 功能-->
    <element action="create" name="${packageName}.service" parentNode="main_java" id="main_service" type="package"/>
<#if cache != "">
    <element action="create" name="cache" parentNode="main_resources" id="spring_cache" type="dir"/>
    <element action="create" name="${packageName}.cache" parentNode="main_java" id="main_cache" type="package"/>
    <element action="copy" name="applicationContext-cache" target="framework/springMybatis/cache/applicationContext-cache.ftl" parentNode="resources_spring" suffix="xml" type="file"/>
    <element action="copy" name="CacheService" target="framework/springMybatis/cache/CacheService.ftl" parentNode="main_service" suffix="java" type="file"/>
</#if>
<#if cache=="ehcache">
    <element action="copy" name="ehcache" target="framework/springMybatis/cache/ehcache.ftl" parentNode="spring_cache" suffix="xml" type="file"/>
<#elseif cache=="memcached">
    <element action="copy" name="MemcachedCache" target="framework/springMybatis/cache/MemcachedCache.ftl" parentNode="main_cache" suffix="java" type="file"/>
    <element action="copy" name="MemcachedCacheManager" target="framework/springMybatis/cache/MemcachedCacheManager.ftl" parentNode="main_cache" suffix="java" type="file"/>
<#elseif cache=="redis">
    <element action="copy" name="RedisCache" target="framework/springMybatis/cache/RedisCache.ftl" parentNode="main_cache" suffix="java" type="file"/>
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
</root>