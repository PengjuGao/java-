<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="/customjs/sendEmail.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#regBtn").bind("click",function(){
                var userId=$("#email").val();
                var verifyCode=$("#verifyCode").val();
                var nick=$("#nick").val();
                if($("#password").val() == ""){
                    return;
                }
                var password= hex_md5($("#password").val());
                var userType = $("#userType").val();
                if(userId==""||verifyCode==""||userType==""){
                    $(this).removeAttr("type","button");
                    return ;
                }
                $(this).attr("type","button");
                var url = "/platform/register/doRegister";
                var token = $("input[name=token]").val();
                $.ajax({
                    type: "post",
                    url: url,
                    data: {"userId":userId,"password":password,"verifyCode":verifyCode,"nick":nick,"userType":userType,"token":token},
                    cache: false,
                    async : false,
                    dataType: "json",
                    success: function (data)
                    {
                        var code = data.code;
                        var message = data.message;
                        if(code == 200){
                            $("#form").attr("method","post");
                            $("#form").attr("action","/platform/register/registerSuccess");
                            $("#form").submit();
                        }else{
                            $("#errorMsg").html(message);
                            $("#error-modal-dialog").modal("show");
                        }
                    },
                    error:function (XMLHttpRequest, textStatus, errorThrown) {
                        $("#errorMsg").html("数据请求异常");
                        $("#error-modal-dialog").modal("show");
                    }
                });
            });
        });
    </script>
</head>
<body oncontextmenu="return false">

<div class="section">
    <div class="container">
        <div class="col-md-12"><h1 class="text-center">JAVA 框架生成</h1>
            <p class="text-center">免费为您，一键打造</p>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <hr>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-4"><img src="/style/img/makemoney/java3.jpg" class="img-responsive"></div>
            <div class="col-md-6">
                <form id="form" class="form-horizontal" role="form">
                    <input type="hidden" name="sendType" value="register">
                    <input type="hidden" name="token" value="${token}">
                    <blockquote>
                        <p class="alert-warning">*您的邮箱即您的登陆账号</p>
                        <div class="form-group">
                            <div class="col-sm-2"><label for="email" class="control-label">邮箱</label></div>
                            <div class="col-sm-7"><input type="email" class="form-control" id="email" required
                                                         placeholder="请输入邮箱"></div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2"><label for="verifyCode" class="control-label">验证码</label></div>
                            <div class="col-sm-7"><input type="text" class="form-control" id="verifyCode"  required
                                                         placeholder="请输您邮箱收到的验证码">
                            </div>
                            <div class="col-sm-3">
                                <button id="sendVerifyCode" class="btn btn-block btn-primary">发送验证码</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2"><label for="nick" class="control-label">昵称</label></div>
                            <div class="col-sm-7"><input type="text" class="form-control" id="nick"
                                                         placeholder="请输入昵称"></div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2"><label for="password" class="control-label">密码</label></div>
                            <div class="col-sm-7"><input type="password" class="form-control" id="password" required
                                                         autocomplete="new-password"
                                                         placeholder="请输入密码"></div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2"><label for="userType" class="control-label">您是</label></div>
                            <div class="col-sm-7"><select class="form-control" id="userType" required
                                                          name="userType"
                                                          >
                                <option value="">请选择</option>
                                <optgroup label="学生">
                                    <option value="0">学生</option>
                                </optgroup>
                                <optgroup label="java">
                                    <option value="1">实习java工程师</option>
                                    <option value="2">初级java工程师</option>
                                    <option value="3">中级java工程师</option>
                                    <option value="4">高级java工程师</option>
                                </optgroup>
                                <optgroup label="程序员(非java)">
                                    <option value="5">程序员</option>
                                </optgroup>
                                <optgroup label="非程序员">
                                    <option value="6">其他</option>
                                </optgroup>
                            </select></div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-6 col-md-7">
                                <button id="regBtn" class="btn btn-block btn-primary">注册</button>
                                <br/>
                                <a href="/platform/login/goToLogin">已经有账号?去登陆-&gt;</a>
                            </div>
                        </div>
                    </blockquote>
                </form>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <hr>
            </div>
        </div>
    </div>
</div>
</body>
</html>
