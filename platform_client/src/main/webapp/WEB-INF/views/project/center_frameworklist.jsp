<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="un"  uri="/WEB-INF/taglib/union.tld"%>
<html>
<head>
    <title>框架记录</title>
    <script type="text/javascript">
        $(function () {
            $("#downloadBtn").bind("click",function () {
                var downloadUrl = $("input[name=downloadUrlhidden]").val();
                var fileName = $("input[name=fileNamehidden]").val();
                // 创建Form
                var form = $('#downloadForm');
                // 设置属性
                // form的target属性决定form在哪个页面提交
                // _self -> 当前页面 _blank -> 新页面
                form.attr('target', '_self');
                // 创建Input
                $('input[name=downloadUrl]').val(downloadUrl);
                $('input[name=fileName]').val(fileName);
                form.submit();
                // 注意return false取消链接的默认动作
                //return false;
            });
        })
    </script>
</head>
<body oncontextmenu="return false">
<form id="downloadForm" action="/platform/framework/download" method="post">
    <input type="hidden" name="downloadUrl" value="" />
    <input type="hidden" name="fileName" value="" />
</form>
<div class="section">
    <div class="container">
        <div class="row">
            <jsp:include page="common/userMenu.jsp"/>
            <div class="col-md-8">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">框架生成记录</h3>
                    </div>
                    <div class="panel-body">
                       <c:if test="${fn:length(list) eq 0}">
                           <p>还没有框架生成记录</p>
                       </c:if>
                        <c:if test="${fn:length(list) gt 0}">
                        <c:forEach items="${list}" var="list" varStatus="index">
                        <div class="list-group">
                            <div class="list-group-item">
                                <h4 class="list-group-item-heading">
                                    <c:if test="${list.recordDetail.get('frameworkType') eq 'structs2Hibernate'}">
                                        Struts2 Hibernate 框架
                                    </c:if>
                                    <c:if test="${list.recordDetail.get('frameworkType') eq 'ssh'}">
                                        Struts2 Spring Hibernate 框架
                                    </c:if>
                                    <c:if test="${list.recordDetail.get('frameworkType') eq 'springHibernate'}">
                                        Spring Hibernate 框架
                                    </c:if>
                                    <c:if test="${list.recordDetail.get('frameworkType') eq 'ssm'}">
                                        Struts2 Spring Mybatis 框架
                                    </c:if>
                                    <c:if test="${list.recordDetail.get('frameworkType') eq 'structs2Mybatis'}">
                                        Struts2 Mybatis 框架
                                    </c:if>
                                </h4>
                                <br>
                                    <div class="row">
                                        <div class="col-md-3">项目：${list.recordDetail.get('project')}</div>
                                        <div class="col-md-3">${list.recordDetail.get('packageName')}</div>
                                        <div class="col-md-3">${list.recordDetail.get('createTime')}</div>
                                        <c:if test="${index.first}">
                                            <input type="hidden" name="downloadUrlhidden" value="${list.recordDetail.get('downloadUrl')}">
                                            <input type="hidden" name="fileNamehidden" value="${list.recordDetail.get('project')}">
                                        <button id="downloadBtn" class="btn-sm btn-primary">下载</button>
                                        </c:if>
                                    </div>
                            </div>
                        </div>
                        </c:forEach>
                        <div class="col-md-12 page">
                            <un:pager href="?" id="${page.pageBean.pageNo}" size="${page.pageBean.pageSize}" total="${page.pageBean.totalItems}"   />
                        </div>
                        </c:if>
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
