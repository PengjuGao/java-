<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/8
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript" src="/static/js/jquery.js"></script>
    <script type="text/javascript">
        //alert(123);
        //alert($);
        $(function(){
            /**登录**/
            $("#login").click(function(){
                window.location.href = "/platform/login/doLogin?userId=751527394@qq.com&password=123456";
            });
            /**注册**/
            $("#register").click(function(){
                window.location.href = "/platform/register/doRegister?userId=751527394@qq.com&password=123456&type=1";
            });
            /**忘记密码**/
            $("#forgetPassword").click(function(){
                window.location.href = "/platform/alterPassword/unloginAlterPassword?userId=751527394@qq.com&oldPassword=123456&newPassword=654321";
            });
            /**修改密码**/
            $("#alterPassword").click(function(){
                window.location.href = "/platform/alterPassword/loginAlterPassword?userId=751527394@qq.com&oldPassword=123456&newPassword=654321";
            });
            /**发送邮件**/
            $("#sendEmail").click(function(){
                window.location.href = "/platform/email/sednVerifyCode?userId=751527394@qq.com";
            });
        });
    </script>
</head>
<body oncontextmenu="return false">
我是首页
<button value="提交" id="login" name="hellword">登录(不需要验证)</button><br>
<button value="提交" name="register" id="register">注册（不需要验证）</button><br>
<button value="提交" name="forgetPassword" id="forgetPassword">忘记密码（不需要验证）</button><br>
<button value="提交" name="alterPassword" id="alterPassword">修改密码（需要验证）</button><br>
<button value="提交" name="sendEmail" id="sendEmail">发送验证码（不需要验证）</button><br>
</body>
</html>
