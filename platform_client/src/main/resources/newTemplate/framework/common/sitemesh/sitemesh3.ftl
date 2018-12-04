<?xml version="1.0" encoding="UTF-8"?>
<sitemesh>
<!-- 指明满足“/exclude.jsp*”的页面，将被排除，不被装饰

<mapping path="/" exclude="true" />
-->
    <mapping path="/test/nositemesh" exclude="true" />
<!-- 指明满足“/*”的页面，将被“/WEB-INF/views/sitemesh/sitemesh.html”所装饰 -->
    <#if template != "jsp">
<mapping path="/test/**" decorator="/WEB-INF/sitemesh/sitemesh.html" />
    <#else>
<mapping path="/test/**" decorator="/WEB-INF/sitemesh/sitemesh.jsp" />
</#if>
</sitemesh>