<#if template == "jsp">
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<#else>
<!DOCTYPE html>
</#if>
<html>
<head>
    <meta charset="UTF-8">
    <title>测试缓存</title>
</head>
<body>
<div class="admin-content">
    <div class="admin-content-body">
        <div class="am-cf am-padding am-padding-bottom-0">
            <div class="am-fl am-cf">
                <strong class="am-text-primary am-text-lg">缓存测试</strong> /
                <small>缓存</small>
            </div>
        </div>

        <hr>
        第一次进入此页面后，请看后台打印的信息，然后刷新此页面，后台不再打印相关信息说明 以注解方式的缓存成功。
    </div>

    <footer class="admin-content-footer">
        <hr>
        <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </footer>
</div>

</body>
</html>
