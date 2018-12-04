<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body oncontextmenu="return false">
<div class="section">
    <div class="container">
        <div class="col-md-12"><h1 class="text-center">JAVA 框架生成</h1>
            <p class="text-center">免费为您，一键打造</p>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="panel panel-primary center-block">
                    <div class="panel-heading"><h3 class="panel-title">密码修改</h3></div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <input type="hidden" name="token" value="${token}">
                            <div class="form-group">
                                <div class="col-sm-3"><label for="oldPassword"
                                                             class="control-label">原来的密码</label>
                                </div>
                                <div class="col-sm-6"><input type="password"
                                                             class="form-control"
                                                             id="oldPassword"
                                                             placeholder="请输入旧的密码"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-3"><label for="newPassword"
                                                             class="control-label">新密码</label>
                                </div>
                                <div class="col-sm-6"><input type="password"
                                                             class="form-control"
                                                             id="newPassword"
                                                             placeholder="请输入新密码"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-3"><label for="confirmNewPassword"
                                                             class="control-label">新密码确认</label>
                                </div>
                                <div class="col-sm-6"><input type="password"
                                                             class="form-control"
                                                             id="confirmNewPassword"
                                                             placeholder="请再次输入新密码">
                                </div>
                            </div>
                            <br>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-6">
                                    <button type="submit" class="btn btn-block btn-primary">
                                        修改密码
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
</div>
</body>
</html>
