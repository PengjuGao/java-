<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="../../project/dialog/errorDialog.jsp" flush="true"/>
<jsp:include page="../../project/dialog/successDialog.jsp" flush="true"/>
<jsp:include page="../../project/dialog/unauthzDialog.jsp" flush="true"/>
<div class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span>JAVA框架生成</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li <c:if test="${fn:contains('/home.jsp',uri)} ">class="active"</c:if>>
                    <a href="/home.jsp" >首页</a>
                </li>
                <li <c:if test="${fn:contains('/platform/framework/gotoMakePage?type=ssh',uri) and uri ne '/'}">class="active"</c:if>>
                    <a href="/platform/framework/gotoMakePage?type=ssh">代码生成</a>
                </li>
                <li <c:if test="${fn:contains('/platform/mybatis/page?type=mybatis',uri) and uri ne '/'}">class="active"</c:if>>
                    <a href="/platform/mybatis/page?type=mybatis">Mybatis代码生成</a>
                </li>
                <li <c:if test="${fn:contains('/platform/home/gotoShow',uri) and uri ne '/'}">class="active"</c:if>>
                    <a href="/platform/home/gotoShow">使用说明</a>
                </li>
                <li>
                    <a href="http://dfttpc.7654.com/?chno=121816" target="_blank">东方快讯</a>
                </li>
                <li <c:if test="${fn:contains('/platform/makeMoney/gotoMakeMoneyPage',uri) and uri ne '/'}">class="active"</c:if>>
                    <a href="/platform/makeMoney/gotoMakeMoneyPage"><font color="red">区块链</font></a>
                </li>
                <shiro:user>
                <li <c:if test="${fn:contains('/platform/user/gotoCenter?page=frameworkList',uri) and uri ne '/'}">class="active"</c:if>>
                    <a href="/platform/user/gotoCenter?page=frameworkList">用户中心</a>
                </li >
                </shiro:user>
                <li <c:if test="${fn:contains('/platform/home/gotoDownload',uri) and uri ne '/'}">class="active"</c:if>>
                    <a href="/platform/home/gotoDownload">软件下载</a>
                </li>
                <li <c:if test="${fn:contains('/platform/makeMoney/gotoRewardPage',uri) and uri ne '/'}">class="active"</c:if>>
                    <a href="/platform/makeMoney/gotoRewardPage">赞赏</a>
                </li>
                <li <c:if test="${fn:contains('/platform/feedback/gotoFeedbackPage',uri) and uri ne '/'}">class="active"</c:if>>
                    <a href="/platform/feedback/gotoFeedbackPage">反馈</a>
                </li>
                <shiro:guest>
                <li <c:if test="${fn:contains('/platform/login/goToLogin',uri) and uri ne '/'}">class="active"</c:if>>
                    <a href="/platform/login/goToLogin">登陆</a>
                </li>
                    <li <c:if test="${fn:contains('/platform/register/gotoRegister',uri) and uri ne '/'}">class="active"</c:if>>
                        <a href="/platform/register/gotoRegister">注册</a>
                    </li>
                </shiro:guest>
                <shiro:user>
                    <li class="active">
                        <a href="#"> <shiro:principal property="nick"/> </a>
                    </li>
                    <li>
                        <a href="/platform/login/logout"> 退出 </a>
                    </li>
                </shiro:user>
            </ul>
        </div>
    </div>
</div>
