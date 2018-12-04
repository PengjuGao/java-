<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/14
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
        $("li button").bind("click",function () {
            var id = $(this).attr("id");
            if(id == "frameList"){
                location.href="/platform/user/gotoCenter?page=frameworkList";
            }else if(id == "alterPassword"){
                location.href="/platform/user/gotoCenter?page=alterPassword";
            }else if(id == "alterUserinfo"){
                location.href="/platform/user/gotoCenter?page=alterUserInfo";
            }else if(id == "feedBack"){
                location.href="/platform/feedback/gotoFeedbackPage?page=userFeedback";
            }else{
                location.href="/home.jsp"
            }
        });
    });
</script>
<div class="col-md-3">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">功能菜单</h3>
        </div>
        <div class="panel-body">
            <ul class="list-group">
                <li class="list-group-item">
                    <button id="frameList" type="button"  class="btn btn-block btn-primary">框架生成记录</button>
                </li>
                <li class="list-group-item">
                    <button id="alterPassword" class="btn btn-block btn-info">修改密码</button>
                </li>
                <li class="list-group-item">
                    <button id="alterUserinfo" class="btn btn-block btn-success">信息编辑</button>
                </li>
                <li class="list-group-item">
                    <button id="feedBack" class="btn btn-block btn-danger">反馈</button>
                </li>
            </ul>
        </div>
    </div>
</div>
