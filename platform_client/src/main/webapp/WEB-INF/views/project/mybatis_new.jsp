<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body oncontextmenu="return false">
<div class="section">
        <div class="container">
                <div class="row">
                        <div class="col-md-12">
                                <hr>
                        </div>
                </div>
        </div>
</div>

<div class="section">
        <div class="container">
                <div class="col-md-12"><h1 class="text-center">JAVA 框架生成</h1>
                        <p class="text-center">免费为您，一键打造</p>
                </div>

        </div>
</div>
<div class="section">
        <div class="container">
                <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                                <div class="panel panel-primary">
                                        <div class="panel-heading"><h3 class="panel-title">Mybatis映射生成</h3></div>
                                        <div class="panel-body">
                                                <form class="form-horizontal" role="form" method="post" action="/platform/mybatis/make">
                                                        <input type="hidden" name="token" value="${token}"/>
                                                        <div>mybatis自动生成映射文件功能在线版</div>
                                                        <div class="row">
                                                                <div class="col-md-6">
                                                                        <h3>数据表创建sql语句</h3>
                                                                        <div>
                                                                                <textarea name="mysql"  style="margin: 0px; width: 429px; height: 374px;resize: none;"></textarea>
                                                                        </div>
                                                                        </div>
                                                                <div class="col-md-6">
                                                                        <h3>对应包名</h3>
<%--
                                                                        <div class="form-group"><div class="col-sm-4"><label for="inputEmail31" class="control-label">Controller 包名</label></div><div class="col-sm-8"><input name="controllerPkg" type="text" class="form-control" id="inputEmail31" placeholder="默认:com.javacoder.top.controller"></div></div>
--%>
<%--
                                                                        <div class="form-group"><div class="col-sm-4"><label for="inputEmail32" class="control-label">Service 包名</label></div><div class="col-sm-8"><input type="text" name="servicePkg" class="form-control" id="inputEmail32" placeholder="默认:com.javacoder.top.service"></div></div>
--%>
                                                                        <div class="form-group"><div class="col-sm-4"><label for="inputEmail33" class="control-label">Dao 包名</label></div><div class="col-sm-8"><input type="text" name="daoPkg" class="form-control" id="inputEmail33" placeholder="默认:com.javacoder.top.dao"></div></div>
                                                                        <div class="form-group"><div class="col-sm-4"><label for="inputEmail34" class="control-label">PO 包名</label></div><div class="col-sm-8"><input type="text" name="poPkg" class="form-control" id="inputEmail34" placeholder="默认:com.javacoder.top.po"></div></div>
                                                                        <%--<div class="form-group"><div class="col-sm-4"><label for="inputEmail35" class="control-label">Example 包名</label></div><div class="col-sm-8"><input type="text" name="examplePkg" class="form-control" id="inputEmail35" placeholder="默认:com.javacoder.top.po"></div></div>--%>
<%--
                                                                        <div class="form-group"><div class="col-sm-4"><label for="inputEmail36" class="control-label">Example 后缀</label></div><div class="col-sm-8"><input type="text" name="exampleSuffix" class="form-control" id="inputEmail36" placeholder="默认:Example"></div></div>
                                                                        <div class="form-group"><div class="col-sm-4"><label for="inputEmail37" class="control-label">XMLMethod 后缀</label></div><div class="col-sm-8"><input type="text" name="xmlMethodReplace" class="form-control" id="inputEmail37" placeholder="默认:Example"></div></div>
--%>
                                                                </div>

                                                        </div>
                                                        <br>
                                                    <shiro:guest>
                                                        <button type="button" class="btn btn-block btn-primary" data-toggle="modal" data-target="#modal-dialog" id="alterBtn">立即生成</button>
                                                    </shiro:guest>
                                                    <shiro:authenticated>
                                                        <button type="submit" class="btn btn-block btn-primary">立即生成</button>
                                                    </shiro:authenticated>
                                                </form>
                                                <blockquote><p>感谢您的使用</p>
                                                        <footer>如有问题请反馈给我们</footer>
                                                </blockquote>
                                        </div>
                                </div>
                        </div>
                        <div class="col-md-1"></div>
                </div>
        </div>
</div>
</body>
</html>