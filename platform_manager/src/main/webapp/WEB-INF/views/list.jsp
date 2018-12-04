<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body oncontextmenu="return false">
<%-- 	${className} --%>
<%-- 	<shiro:hasRole name="administrator"> --%>

<!-- 		<a href="admin.jsp">Administer the system</a> -->

<%-- 	</shiro:hasRole> --%>

<%-- 	<shiro:principal /> --%>


<%-- 	${fn:length(list)} --%>

<%-- 	<c:forEach items="${list}" var="helloxx"> --%>
<%-- 		${helloxx.functionId } --%>
<%-- 	</c:forEach> --%>


<!-- 	<form action="/system/TbFunction/list" method="post"> -->
<!-- 		<input type="text" name="name" value="123456" /> <input type="text" -->
<!-- 			name="creator" value="gaopengju" /> <input type="text" -->
<!-- 			name="orderByClause" value="create_time desc" /> <input type="text" -->
<!-- 			name="oredCriteria.criteria.singleValue" value="123" /> <input -->
<!-- 			type="text" name="singleValue" value="xxx" /> <input type="text" -->
<!-- 			name="singleValue" value="xxx" /> <input type="submit" value="提交" /> -->
<!-- 	</form> -->


<div class="alert alert-info">
		当前位置<b class="tip"></b>查询界面<b class="tip"></b>表单样式
	</div>
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<td colspan="6" class="auto-style2">&nbsp;请填写查询条件</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>功能名称</td>
				<td class="detail"><input type="text" /></td>
				<td>功能url</td>
				<td class="td_detail"><input type="text" /></td>
				<td>类型</td>
				<td><select>
						<option>菜单</option>
						<option>模块</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="6" align="right"><input class="btn btn-inverse"
					id="find" type="button" value="查询" /> <input
					class="btn btn-inverse" type="button" value="清空" />
					
				</td>
			</tr>
		</tbody>
	</table>

	<table class="table table-striped table-bordered table-condensed"
		id="list">
		<thead>
			<tr class="tr_detail">
				<td>排序</td>
				<td>功能名称</td>
				<td>功能url</td>
				<td>创建人</td>
				<td>创建时间</td>
				<td>修改时间</td>
				<td>功能类型</td>
				<td>摘要</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="menu" varStatus="index">
			<tr>
				<td><a>${index.index }</a></td>
				<td>${menu.name }</td>
				<td>${menu.functionUrl }</td>
				<td>${menu.creator }</td>
				<td>${menu.createTime }</td>
				<td>${menu.modifyTime }</td>
				<td>${menu.functionType }</td>
				<td>xxxxx</td>
				<td>禁用|删除</td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>
</body>
</html>