<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>信息修改</title>
    <script type="text/javascript">
        $(function () {
            $("#userBtn").bind("click",function () {
                var nick = $("input[name=nick]").val();
                var userType = $("select[name=userType]").val();
                if(nick=="" || userType == "" ||userType == -1){
                    $(this).attr("type","submit");
                    return;
                }
                if(nick=="${user.nick}" && userType=="${user.userType}"){
                    $(this).attr("type","button");
                    $("#errorMsg").html("信息没有变更，不能提交");
                    $("#error-modal-dialog").modal("show");
                    return;
                }

                $(this).attr("type","button");
                var url = "/platform/user/alterUserInfo";
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {"nick":nick,"userType":userType},
                    cache: false,
                    async : false,
                    dataType: "json",
                    success: function (data) {
                        var code = data.code;
                        var message = data.message;
                        if (code == 200) {
                            $("#successMsg").html("修改成功");
                            $("#success-modal-dialog").modal("show");
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
        })
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
                        <h3 class="panel-title">信息修改</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <div class="col-sm-2"><label for="nick" class="control-label">昵称</label>
                                </div>
                                <div class="col-sm-7"><input type="text" class="form-control" required id="nick" name="nick" value="${user.nick}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2"><label for="userType" class="control-label">您是</label></div>
                                <div class="col-sm-7"><select class="form-control" id="userType" required
                                                              name="userType">
                                    <option value=""  <c:if test="${user.userType eq -1}">selected="selected"</c:if> >请选择</option>
                                    <optgroup label="学生">
                                        <option value="0" <c:if test="${user.userType eq 0}">selected="selected"</c:if>>学生</option>
                                    </optgroup>
                                    <optgroup label="java">
                                        <option value="1" <c:if test="${user.userType eq 1}">selected="selected"</c:if>>实习java工程师</option>
                                        <option value="2" <c:if test="${user.userType eq 2}">selected="selected"</c:if>>初级java工程师</option>
                                        <option value="3" <c:if test="${user.userType eq 3}">selected="selected"</c:if>>中级java工程师</option>
                                        <option value="4" <c:if test="${user.userType eq 4}">selected="selected"</c:if>>高级java工程师</option>
                                    </optgroup>
                                    <optgroup label="程序员(非java)">
                                        <option value="5" <c:if test="${user.userType eq 5}">selected="selected"</c:if>>程序员</option>
                                    </optgroup>
                                    <optgroup label="非程序员">
                                        <option value="6" <c:if test="${user.userType eq 6}">selected="selected"</c:if>>其他</option>
                                    </optgroup>
                                </select></div>
                            </div>
                            <br>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-7">
                                    <button id="userBtn" class="btn btn-block btn-primary">
                                        提交
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
