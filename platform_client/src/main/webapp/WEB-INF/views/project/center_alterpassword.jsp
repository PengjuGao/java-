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
    <title>个人中心-修改密码</title>
    <script type="text/javascript">
        $(function () {
            $("#alterBtn").bind("click",function () {
                var oldPassword = $("#oldPassword").val();
                var newPassword = $("#newPassword").val();
                var confirmNewPassword = $("#confirmNewPassword").val();
                if (oldPassword == "" || newPassword == "" || confirmNewPassword == "") {
                    $("#alterBtn").attr("type", "submit");
                    return;
                }
                $("#alterBtn").attr("type","button");
                if(oldPassword == newPassword){
                    $("#errorMsg").html("原密码不能跟新密码一样");
                    $("#error-modal-dialog").modal("show");
                    return;
                }
                if (confirmNewPassword == newPassword) {
                    var token = $("input[name=token]").val();
                    var type = $("input[name=type]").val();
                    oldPassword = hex_md5(oldPassword);
                    newPassword = hex_md5(newPassword);
                    confirmNewPassword = hex_md5(confirmNewPassword);
                    //异步请求
                    var url = "/platform/alterPassword/loginAlterPassword";
                    $.ajax({
                        type: "POST",
                        url: url,
                        data: {"token":token,"type":type,"oldPassword":oldPassword,"newPassword":newPassword},
                        cache: false,
                        async : false,
                        dataType: "json",
                        success: function (data) {
                            var code = data.code;
                            var message = data.message;
                            if (code == 200) {
                                location.reload();
                                $("#successMsg").html("密码修改成功");
                                $("#error-modal-dialog").modal("show");
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
                    return;
                }else  if (newPassword != confirmNewPassword) {
                    $("#errorMsg").html("新密码跟确认密码不一致，请重新填写");
                    $("#error-modal-dialog").modal("show");
                    return;
                }
            });
        });
    </script>
</head>
<body oncontextmenu="return false">
<div class="section">
    <div class="container">
        <div class="row">
            <jsp:include page="common/userMenu.jsp"/>
            <div class="col-md-8">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">修改密码</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" method="post" >
                            <input type="hidden" name="type" value="1">
                            <input type="hidden" name="token" value="${token}"/>
                            <div class="form-group">
                                <div class="col-sm-2"><label for="oldPassword" class="control-label">原来的密码</label>
                                </div>
                                <div class="col-sm-7"><input type="password" class="form-control" required id="oldPassword" name="oldPassword" placeholder="请输入旧的密码"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2"><label for="newPassword" class="control-label">新密码</label>
                                </div>
                                <div class="col-sm-7"><input type="password" class="form-control" required id="newPassword" name="newPassword" placeholder="请输入新密码"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2"><label for="confirmNewPassword" class="control-label">新密码确认</label>
                                </div>
                                <div class="col-sm-7"><input type="password" class="form-control" required id="confirmNewPassword" placeholder="请再次输入新密码">
                                </div>
                            </div>
                            <br>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-7">
                                    <button id="alterBtn"  class="btn btn-block btn-primary" >
                                        修改密码
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
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
