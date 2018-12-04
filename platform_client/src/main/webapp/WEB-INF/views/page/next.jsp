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
    <form method="post" action="/platform/addDatabase">
    <div class="formtitle"><span>基本信息</span></div>
    <input type="hidden" name="userId" value="admin"/>
    <ul class="forminfo">
        <li>
            <label>数据库</label>
            <cite>
                <input name="databaseType" type="radio" checked="checked" value="0" >Mysql&nbsp;&nbsp;&nbsp;
                <input name="databaseType" type="radio" checked="checked" value="1">Oracle&nbsp;&nbsp;&nbsp;
            </cite>
        </li>
        <li>
            <label>数据库连接池</label>
            <cite>
                <input name="databasePool" type="radio" value="1">C3P0&nbsp;&nbsp;&nbsp;
                <input name="databasePool" type="radio" value="2">DBCH&nbsp;&nbsp;&nbsp;
                <input name="databasePool" type="radio" value="3">Durid(阿里巴巴开源连接池)
            </cite>
        </li>
        <li>
            <label>数据源个数</label>
            <cite>
                <input name="isMoreOrSingle" type="radio" value="1">单数据源&nbsp;&nbsp;&nbsp;
                <input name="isMoreOrSingle" type="radio" value="2">多数据源(2个)&nbsp;&nbsp;&nbsp;
            </cite>
        </li>
        <li>
            <label>&nbsp;</label>
            <input name="" type="submit" class="btn" value="下一页">
        </li>
    </ul>
        </form>
</div>
</body>
</html>
