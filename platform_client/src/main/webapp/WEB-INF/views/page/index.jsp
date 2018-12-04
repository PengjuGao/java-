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
    <form method="post" action="/platform/makeProject">
    <div class="formtitle"><span>基本信息</span></div>
    <input type="hidden" name="userId" value="admin"/>
    <ul class="forminfo">
        <li>
            <label>项目名称</label>
            <input name="projectName" type="text" class="dfinput" value="">
        </li>
        <li>
            <label>项目类型</label>
            <cite>
                <input name="maven" type="radio" checked="checked" disabled="disabled">Maven
            </cite>
        </li>
        <li>
            <label>maven类型</label>
            <cite>
                <input name="mavenType" type="radio" value="web">web&nbsp;&nbsp;&nbsp;
                <input name="mavenType" type="radio" value="jar">jar&nbsp;&nbsp;&nbsp;
            </cite>
        </li>
        <li>
            <label>web框架类型</label>
            <cite>
                <input name="webFrameworkType" type="radio" value="0">None&nbsp;&nbsp;&nbsp;
                <input name="webFrameworkType" type="radio" value="1">Spring&nbsp;&nbsp;&nbsp;
                <input name="webFrameworkType" type="radio" value="2">Struts2.0
            </cite>
        </li>
        <li>
            <label>orm框架类型</label>
            <cite>
                <input name="ormFrameworkType" type="radio" value="0">None&nbsp;&nbsp;&nbsp;
                <input name="ormFrameworkType" type="radio" value="1" >Mybatis&nbsp;&nbsp;&nbsp;&nbsp;
                <input name="ormFrameworkType" type="radio" value="2">Hibernate
            </cite>
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
