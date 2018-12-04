<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="/static/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/static/js/jquery.js"></script>

</head>
<body oncontextmenu="return false">
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">java项目生成</a></li>
    </ul>
</div>
<div class="formbody">
    <form method="post" action="/platform/makeFunction">
    <div class="formtitle"><span>基本信息</span></div>
    <ul class="forminfo">
        <li>
            <label>功能名称</label>
            <input name="functionName" type="text" class="dfinput" value="">
        </li>

        <li>
            <label>&nbsp;</label>
            <input name="" type="submit" class="btn" value="确认保存">
        </li>
    </ul>
        </form>
</div>
</body>
</html>
