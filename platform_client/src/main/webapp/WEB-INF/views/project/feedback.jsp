<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>信息反馈</title>
</head>
<body oncontextmenu="return false">
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
                    <div class="panel-heading"><h3 class="panel-title">我要反馈</h3></div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" method="post" action="/platform/feedback/doFeedback">
                            <input type="hidden" name="token" value="${token}"/>
                            <div class="form-group">
                                <div class="col-sm-2"><label for="youremail" class="control-label">电子邮箱:</label></div>
                                <div class="col-sm-10"><input type="email"
                                                              class="form-control" id="youremail" required
                                                              placeholder="请输入您的电子邮箱" name="email"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2"><label for="feedbackType" class="control-label">反馈类型:</label></div>
                                <div class="col-sm-10" >
                                    <select name="type" id="feedbackType" required="required" >
                                    <option >请选择</option>
                                    <option value="1" >我要建议</option>
                                    <option value="2" >我要报错</option>
                                    <option value="3" >框架优化</option>
                                    <option value="4">合作</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2"><label class="control-label">反馈信息描述:</label></div>
                                <div class="col-sm-10"><textarea name="message" class="form-control" required
                                                                 style="margin-top: 0px; margin-bottom: 0px; height: 257px;"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">提交反馈</button>
                                </div>
                            </div>
                        </form>
                        <blockquote><p>感谢您的反馈</p>
                            <footer>您的意见是我们最宝贵的财富</footer>
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
