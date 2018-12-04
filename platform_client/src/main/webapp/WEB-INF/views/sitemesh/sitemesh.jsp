<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/6
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><sitemesh:write property='title' /></title>
    <script type="text/javascript" src="/static/js/jquery.js"></script>
    <style type="text/css">
        div{
            margin: 0;
            padding: 0;
        }
        .sitTop{
            margin:0 auto;
        }
        .sitLeft{
            margin:0;
            float: left;
        }
        .sitRight{
            margin-left: 0;
            width: auto;
            height: auto;
            overflow: hidden;
        }
    </style>
    <sitemesh:write property='head'/>
</head>
<body oncontextmenu="return false">
<!--头部-->
<div class="sitTop">
    <jsp:include page="/platform/top"></jsp:include>
</div>
<!---->
<div style="clear: both;">
    <div class="sitLeft">
        <jsp:include page="/platform/left"></jsp:include>
    </div>
    <div class="sitRight">
        <sitemesh:write property='body' />
    </div>
</div>
</body>
</html>
