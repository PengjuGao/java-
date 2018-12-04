<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--左边菜单开始-->
<div class="left_c left">
	<h1>系统操作菜单</h1>
	<div class="acc">
		<c:forEach items="${parentList}" var="parent">
			<div>
				<a class="one">${parent.name}</a>
				<ul class="kid">
					<c:forEach items="${childrentList}" var="children">
						<c:if test="${children.parentId eq parent.functionId }">
							<li><b class="tip"></b><a href="${children.functionUrl }">${children.name}</a></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>
		<div id="datepicker"></div>
	</div>
</div>
<!--左边菜单结束-->
