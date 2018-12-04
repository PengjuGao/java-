<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <meta name="description" content="java框架在线生成,一键生成，省时省力，免去您搭建框架的烦恼，直接上手开发，希望能对您有帮助-登陆页面" />
    <meta name="keyword" content="java框架在线生成,在线生成java框架,java框架,java framework,java 框架在线生成,java主流框架" />
    <script type="text/javascript">
        $(function(){
            $("#login").bind("click",function(){
                var userId = $("#userName").val();
                var password = hex_md5($("#password").val());
                var verifyCode = $("#verifyCode").val();
                if(userId==""||userId==null || password==""||password==null || verifyCode==""||verifyCode==null){
                    $(this).removeAttr("type","button");
                    return;
                }
                $(this).attr("type","button");
                var url = "/platform/login/doLogin";
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {"userId":userId,"password":password,"verifyCode":verifyCode},
                    cache: false,
                    async : false,
                    dataType: "json",
                    success: function (data) {
                        var code = data.code;
                        var message = data.message;
                        if (code == 200) {
                            $("#myform").attr("method", "POST");
                            $("#myform").attr("action", "/platform/login/actualLogin");
                            $("#myform").submit();
                        } else {
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
            $("#updateImg").bind("click",function () {
                var random = Math.random();
                $("#codeImg").attr("src","/verifyCodeServlet?random="+random);
            })
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
            <div class="col-md-4"><img
                    src="/style/img/makemoney/java1.jpg"
                    class="img-responsive"></div>
            <div class="col-md-6">
                <form id="myform" class="form-horizontal">
                    <blockquote>
                        <div class="alert-info">*欢迎您的登陆，您的支持是我们最大的动力</div>
                        <br/>
                        <div class="form-group">
                            <div class="col-sm-2"><label for="userName" class="control-label">用户名</label></div>
                            <div class="col-sm-7"><input type="email" class="form-control" name="userId"  id="userName" placeholder="请输入用户名" required></div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2"><label for="password" class="control-label">密码</label></div>
                            <div class="col-sm-7"><input type="password" name="password" class="form-control" autocomplete="new-password"   required id="password" placeholder="请输入密码"></div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-2"><label for="verifyCode" class="control-label">验证码</label></div>
                            <div class="col-sm-7"><input type="text" name="verifyCode" class="form-control"  required id="verifyCode" placeholder="请输入验证码"></div>
                            <a id="updateImg"><img src="/verifyCodeServlet" alt="" id="codeImg" /></a>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-6 col-md-7">
                                <button id="login"  class="btn btn-block btn-primary" data-dismiss="modal">登陆</button>
                                <br/>
                                <a href="/platform/register/gotoRegister" >还没有账号?去注册-></a>|<a href="/platform/alterPassword/gotForgetPwd">忘记密码</a>
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