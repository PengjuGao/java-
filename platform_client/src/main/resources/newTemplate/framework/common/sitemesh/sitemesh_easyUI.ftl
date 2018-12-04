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
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>
</head>
<body>
<div>
    <p style="font-size: x-large">Welcome to use sitemesh3</p>
</div>
<br/>
<sitemesh:write property='body'/>
</body>
</html>