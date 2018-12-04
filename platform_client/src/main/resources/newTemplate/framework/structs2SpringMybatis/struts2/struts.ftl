<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <constant name="struts.action.excludePattern" value="/static/.*?" />
    <!-- 请求参数的编码方式 -->
    <constant name="struts.i18n.encoding" value="UTF-8"/>
    <!-- 指定被struts2处理的请求后缀类型。多个用逗号隔开 -->
    <!-- <constant name="struts.action.extension" value="action,do,htm"/> -->
    <!-- 当struts.xml改动后，是否重新加载。默认值为false(生产环境下使用),开发阶段最好打开  -->
    <constant name="struts.configuration.xml.reload" value="true"/>
    <!-- 是否使用struts的开发模式。开发模式会有更多的调试信息。默认值为false(生产环境下使用),开发阶段最好打开  -->
    <constant name="struts.devMode" value="true"/>
    <!-- 设置浏览器是否缓存静态内容。默认值为true(生产环境下使用),开发阶段最好关闭  -->
    <constant name="struts.serve.static.browserCache" value="false" />
    <!-- 是否开启动态方法调用 -->
    <constant name="struts.enable.DynamicMethodInvocation" value="false"/>
    <#if template=="velocity">
        <constant name="struts.velocity.configfile" value="velocity/velocity.properties"/>
        <constant name="struts.velocity.toolboxlocation" value="velocity/toolbox.xml"/>
    <#elseif template=="freemaker">
        <constant name="struts.freemarker.wrapper.altMap" value="true"/>
        <constant name="struts.freemarker.manager.classname" value="org.apache.struts2.views.freemarker.FreemarkerManager"/>
        <constant name="struts.freemarker.templatesCache" value="false" />
    </#if>
    <package name="test" namespace="/test" extends="struts-default" strict-method-invocation="false">
        <action name="database" class="testAction" method="testDatabase">
            <#if template=="freemaker">
                <result name="success" type="freemarker">
                    /WEB-INF/views/testDatabase.html
                </result>
                <#elseif template=="velocity" >
                    <result name="success" type="velocity">
                        /WEB-INF/views/testDatabase.html
                    </result>
                <#else >
                <result name="success">
                    /WEB-INF/views/testDatabase.jsp
                </result>
            </#if>
        </action>
        <action name="index" class="testAction" method="index">
            <#if template=="freemaker">
            <result name="success" type="freemarker">
                /WEB-INF/views/index.html
            </result>
                <#elseif template=="velocity">
                    <result name="success" type="velocity">
                        /WEB-INF/views/index.html
                    </result>
                <#else >
                <result name="success" >
                    /WEB-INF/views/index.jsp
                </result>
            </#if>
        </action>
        <#if sitemesh=="yes">
        <!-- test sitemesh-->
        <action name="nositemesh" class="testAction" method="nositemesh">
        <#if template=="freemaker">
            <result name="success" type="freemarker">
                /WEB-INF/views/nositemesh.html
            </result>
        <#elseif template=="velocity">
            <result name="success" type="velocity">
                /WEB-INF/views/nositemesh.html
            </result>
        <#else >
            <result name="success" >
                /WEB-INF/views/nositemesh.jsp
            </result>
        </#if>
        </action>
        </#if>
        <#if cache != "">
            <!-- test cache -->
            <action name="cache" class="testAction" method="testCache">
            <#if template=="freemaker">
                <result name="success" type="freemarker">
                    /WEB-INF/views/cacheTest.html
                </result>
            <#elseif template == "velocity">
                <result name="success" type="velocity">
                    /WEB-INF/views/cacheTest.html
                </result>
                <#else >
                <result name="success">
                    /WEB-INF/views/cacheTest.jsp
                </result>
            </#if>
            </action>
        </#if>
    </package>
</struts>