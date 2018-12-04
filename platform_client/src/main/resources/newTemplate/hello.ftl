<?xml version="1.0" encoding="UTF-8"?>
<!--基础框架结构 -->
<${project}>
<src>
    <main>
        <java id="main_java"/>
        <resources id="main_resources"/>
    <#if mavenType == "web">
        <webapp>
            <static id="webstatic"/>
            <WEB-INF id="webinf">
                <views>
                    <#if template=="jsp">
                        <#if htmlFramework="dwz">
                            <index suffix="jsp" type="file" action="copy" target="framework/common/page/dwz/view_index.ftl"/>
                            <#if cache!="">
                            <cacheTest suffix="jsp" type="file" action="copy" target="framework/common/page/dwz/cacheTest.ftl"/>
                            </#if>
                            <nositemesh suffix="jsp" type="file" action="copy" target="framework/common/page/dwz/nositemesh.ftl"/>
                            <testDatabase suffix="jsp" type="file" action="copy" target="framework/common/page/dwz/testDatabase.ftl"/>
                        <#elseif htmlFramework="amazeUI">
                            <index suffix="jsp" type="file" action="copy" target="framework/common/page/amazeUI/view_index.ftl"/>
                            <#if cache!="">
                            <cacheTest suffix="jsp" type="file" action="copy" target="framework/common/page/amazeUI/cacheTest.ftl"/>
                            </#if>
                            <nositemesh suffix="jsp" type="file" action="copy" target="framework/common/page/amazeUI/nositemesh.ftl"/>
                            <testDatabase suffix="jsp" type="file" action="copy" target="framework/common/page/amazeUI/testDatabase.ftl"/>
                        <#elseif htmlFramework="easyUI">
                            <index suffix="jsp" type="file" action="copy" target="framework/common/page/easyUI/view_index.ftl"/>
                            <#if cache!="">
                            <cacheTest suffix="jsp" type="file" action="copy" target="framework/common/page/easyUI/cacheTest.ftl"/>
                            </#if>
                            <nositemesh suffix="jsp" type="file" action="copy" target="framework/common/page/easyUI/nositemesh.ftl"/>
                            <testDatabase suffix="jsp" type="file" action="copy" target="framework/common/page/easyUI/testDatabase.ftl"/>
                        <#elseif htmlFramework="bootstrap">
                            <#if cache!="">
                            <cacheTest suffix="jsp" type="file" action="copy" target="framework/common/page/bootstrap/cacheTest.ftl"/>
                            </#if>
                            <nositemesh suffix="jsp" type="file" action="copy" target="framework/common/page/bootstrap/nositemesh.ftl"/>
                            <testDatabase suffix="jsp" type="file" action="copy" target="framework/common/page/bootstrap/testDatabase.ftl"/>
                            <index suffix="jsp" type="file" action="copy" target="framework/common/page/bootstrap/view_index.ftl"/>
                        <#else>
                            <index suffix="jsp" type="file" action="copy" target="views_index.ftl"></index>
                        </#if>
                        <#else >
                            <#if htmlFramework="dwz">
                                <index suffix="html" type="file" action="copy" target="framework/common/page/dwz/view_index.ftl"/>
                                <cacheTest suffix="html" type="file" action="copy" target="framework/common/page/dwz/cacheTest.ftl"/>
                                <nositemesh suffix="html" type="file" action="copy" target="framework/common/page/dwz/nositemesh.ftl"/>
                                <testDatabase suffix="html" type="file" action="copy" target="framework/common/page/dwz/testDatabase.ftl"/>
                            <#elseif htmlFramework="amazeUI">
                                <index suffix="html" type="file" action="copy" target="framework/common/page/amazeUI/view_index.ftl"/>
                                <cacheTest suffix="html" type="file" action="copy" target="framework/common/page/amazeUI/cacheTest.ftl"/>
                                <nositemesh suffix="html" type="file" action="copy" target="framework/common/page/amazeUI/nositemesh.ftl"/>
                                <testDatabase suffix="html" type="file" action="copy" target="framework/common/page/amazeUI/testDatabase.ftl"/>
                            <#elseif htmlFramework="easyUI">
                                <index suffix="html" type="file" action="copy" target="framework/common/page/easyUI/view_index.ftl"/>
                                <cacheTest suffix="html" type="file" action="copy" target="framework/common/page/easyUI/cacheTest.ftl"/>
                                <nositemesh suffix="html" type="file" action="copy" target="framework/common/page/easyUI/nositemesh.ftl"/>
                                <testDatabase suffix="html" type="file" action="copy" target="framework/common/page/easyUI/testDatabase.ftl"/>
                            <#elseif htmlFramework="bootstrap">
                                <cacheTest suffix="html" type="file" action="copy" target="framework/common/page/bootstrap/cacheTest.ftl"/>
                                <nositemesh suffix="html" type="file" action="copy" target="framework/common/page/bootstrap/nositemesh.ftl"/>
                                <testDatabase suffix="html" type="file" action="copy" target="framework/common/page/bootstrap/testDatabase.ftl"/>
                                <index suffix="html" type="file" action="copy" target="framework/common/page/bootstrap/view_index.ftl"/>
                            <#else>
                                <index suffix="html" type="file" action="copy" target="views_index.ftl"/>
                            </#if>
                    </#if>
                </views>
                <web suffix="xml" type="file" action="copy" target="web.ftl"/>
            </WEB-INF>
            <#if template=="jsp">
                <#if htmlFramework="dwz">
                    <index suffix="jsp" type="file" action="copy" target="htmlFramework/dwz_index.ftl"/>
                    <#elseif htmlFramework="amazeUI">
                        <index suffix="jsp" type="file" action="copy" target="htmlFramework/amazeUI_index.ftl"/>
                    <#elseif htmlFramework="easyUI">
                    <index suffix="jsp" type="file" action="copy" target="htmlFramework/easyUI_index.ftl"/>
                    <#elseif htmlFramework="bootstrap">
                    <index suffix="jsp" type="file" action="copy" target="htmlFramework/bootstrap_index.ftl"/>
                    <#else>
                    <index suffix="jsp" type="file" action="copy" target="jsp_index.ftl"/>
                </#if>

            <#elseif template=="freemaker">
                <#if htmlFramework="dwz">
                    <index suffix="html" type="file" action="copy" target="htmlFramework/dwz_index.ftl"/>
                <#elseif htmlFramework="amazeUI">
                    <index suffix="html" type="file" action="copy" target="htmlFramework/amazeUI_index.ftl"/>
                <#elseif htmlFramework="easyUI">
                    <index suffix="html" type="file" action="copy" target="htmlFramework/easyUI_index.ftl"/>
                <#elseif htmlFramework="bootstrap">
                    <index suffix="html" type="file" action="copy" target="htmlFramework/bootstrap_index.ftl"/>
                <#else>
                    <index suffix="html" type="file" action="copy" target="freemaker_index.ftl"/>
                </#if>
            <#elseif template == "velocity">
                <#if htmlFramework="dwz">
                    <index suffix="html" type="file" action="copy" target="htmlFramework/dwz_index.ftl"/>
                <#elseif htmlFramework="amazeUI">
                    <index suffix="html" type="file" action="copy" target="htmlFramework/amazeUI_index.ftl"/>
                <#elseif htmlFramework="easyUI">
                    <index suffix="html" type="file" action="copy" target="htmlFramework/easyUI_index.ftl"/>
                <#elseif htmlFramework="bootstrap">
                    <index suffix="html" type="file" action="copy" target="htmlFramework/bootstrap_index.ftl"/>
                <#else>
                    <index suffix="html" type="file" action="copy" target="volecity_index.ftl"/>
                </#if>
            </#if>
        </webapp>
    </#if>
    </main>
    <test>
        <java id="test_java"/>
        <resources id="test_resources"/>
    </test>
</src>
<pom suffix="xml" action="copy" type="file" target="pom.ftl"/>
</${project}>