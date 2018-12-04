<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库操作</title>
</head>
<body oncontextmenu="return false">
	<div class="alert alert-info">
		当前位置<b class="tip"></b>查询界面<b class="tip"></b>数据库操作
	</div>
	<form action="/system/getTableAndColumns.html" method="post">
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<td colspan="6" class="auto-style2">&nbsp;请填写查询条件</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>数据库地址</td>
				<td class="detail"><input type="text" /></td>
				<td>数据库名称</td>
				<td class="td_detail"><input type="text" /></td>
				<td>数据库类型</td>
				<td><select>
						<option>mysql</option>
						<option>oracle</option>
				</select></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td class="detail"><input type="text" /></td>
				<td>密码</td>
				<td class="td_detail"><input type="password" /></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="6" align="right"><input class="btn btn-inverse"
					id="find" type="submit" value="查询" /> <input
					class="btn btn-inverse" type="button" value="清空" /></td>
			</tr>
		</tbody>
	</table>
	</form>
	<table class="table table-striped table-bordered table-condensed" id="list">
		<thead>
			<tr class="tr_detail">
				<td>排序</td>
				<td>数据表名</td>
				<td>字段名称</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="obj" varStatus="index">
				<tr>
					<td><a>${index.index } </a></td>
					<td>${obj.tableName }</td>
					<td>
						<c:forEach items="${obj.columns}" var="column" varStatus="step">
							${column}
							<c:if test="${!step.last }">
								,
							</c:if>
						</c:forEach>
					</td>
					<td>
					   <form action="/system/operatorColumns.html" method="post">
					   	 <input type="text" value="${obj.tableName}" name="tableName"/>
					   	 <input type="submit" value="详情操作"/>
					   </form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>