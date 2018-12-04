<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
    <script type="text/javascript" src="/customjs/sendEmail.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#subBtn").bind("click",function () {
                var newPass = $("#newPassword").val();
                var userId = $("#email").val();
                var verifyCode = $("#checkCode").val();
                var confirmPass = $("#confirmNewPassword").val();
                if(userId == ""||verifyCode == "" || newPass==""||confirmPass==""){
                    $(this).attr("type","submit");
                    return;
                }
                $(this).attr("type","button");
                if(newPass == confirmPass){
                    $(this).removeAttr("type");
                    //md5加密密码
                    $("#newPassword").val(hex_md5(newPass))
                    return;
                }else{
                    $("#errorMsg").html("两次输入密码不一致");
                    $("#error-modal-dialog").modal("show");
                    return;
                }
            });
        })
    </script>
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
                        <form class="form-horizontal" role="form" method="post" action="/platform/alterPassword/unloginAlterPassword">
                            <input type="hidden" value="forgetPassword" name="sendType"/>
                            <input type="hidden" value="2" name="type"/>
                            <div class="form-group">
                                <div class="col-sm-3"><label for="email"
                                                             class="control-label">注册的邮箱</label>
                                </div>
                                <div class="col-sm-6"><input type="email"
                                                             class="form-control"
                                                             name="userId"
                                                             id="email"
                                                             required
                                                             placeholder="请输入您注册时使用的邮箱"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-3"><label for="checkCode"
                                                             class="control-label">验证码</label>
                                </div>
                                <div class="col-sm-6"><input type="text"
                                                             class="form-control"
                                                             id="checkCode"
                                                             name="verifyCode"
                                                             required
                                                             placeholder="请输入发送到您邮箱的验证码"></div>
                                <div class="col-sm-3">
                                    <button id="sendVerifyCode" class="btn btn-block btn-default">发送验证码</button>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-3"><label for="newPassword"
                                                             class="control-label">新密码</label>
                                </div>
                                <div class="col-sm-6"><input type="password"
                                                             class="form-control"
                                                             autocomplete="new-password"
                                                             id="newPassword"
                                                             name="newPassword"
                                                             required
                                                             minlength="6"
                                                             maxlength="20"
                                                             placeholder="请输入新密码"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-3"><label for="confirmNewPassword"
                                                             class="control-label">新密码确认</label>
                                </div>
                                <div class="col-sm-6"><input type="password"
                                                             class="form-control"
                                                             id="confirmNewPassword"
                                                             minlength="6"
                                                             maxlength="20"
                                                             required
                                                             placeholder="请再次输入新密码">
                                </div>
                            </div>
                            <br>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-6">
                                    <button id="subBtn" class="btn btn-block btn-primary">
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
