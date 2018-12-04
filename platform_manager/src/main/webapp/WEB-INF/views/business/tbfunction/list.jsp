<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="un"  uri="/WEB-INF/taglib/union.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单列表页</title>
	<script type="text/javascript">
		$(function(){
			$("#makeProject").click(function(){
				$("form").attr("action","/system/makeProject/toSetPage.html");
				$("form").attr("method","post");
				$("form").submit();
			});
		});
	</script>
</head>
<body oncontextmenu="return false">

<div class="alert alert-info">
		当前位置<b class="tip"></b>查询界面<b class="tip"></b>表单样式
	</div>
	<form action="showListPage.html" method="post">
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<td colspan="6" class="auto-style2">&nbsp;请填写查询条件</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>功能名称</td>
				<td class="detail"><input type="text" name="name" value="${vo.name }"/></td>
				<td>功能url</td>
				<td class="td_detail"><input type="text" name="urlStr" value="${vo.urlStr }"/></td>
				<td>类型</td>
				
				<td><select name="type">
						<option value="">请选择</option>
						<option value="123" <c:if test="${vo.type eq '123' }">selected="selected"</c:if> >菜单</option>
						<option value="123123123" <c:if test="${vo.type eq '123123123' }">selected="selected"</c:if> >模块</option>
				</select></td>
				
			</tr>
			<tr>
				<td>开始时间</td>
				<td class="td_detail">
					<div class="input-append">
						<input class="span2 datepicker" size="16" type="text" name="startTime"  value="${vo.startTime }"/><span
							class="add-on"><i class="icon-calendar"></i></span>
					</div>
				</td>
				<td>结束时间</td>
				<td class="td_detail">
					<div class="input-append">
					<input class="span2 datepicker" size="16" type="text" name="endTime" value="${vo.endTime}" /><span
							class="add-on"><i class="icon-calendar"></i></span>
					</div>
				</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="6" align="right"><input class="btn btn-inverse"
					id="find" type="submit" value="查询" /> 
					<input class="btn btn-inverse"
					id="reset" type="reset" value="清空" />
					<input class="btn btn-inverse"
					id="makeProject" type="button" value="项目生成页" />
					
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
				<td><fmt:formatDate value="${menu.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${menu.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${menu.functionType }</td>
				<td>xxxxx</td>
				<td>禁用|删除</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</form>
	<div class="pager_new">
		<un:pager href="?name=${vo.name}&type=${vo.type}" id="${page.pageNo}" size="${page.pageSize}" total="${page.totalItems}"   />
	</div>
</body>
</html>