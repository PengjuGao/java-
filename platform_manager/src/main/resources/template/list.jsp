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
<title>$#page_title#</title>
<script type="text/javascript">
$(function(){
	//点击新增按钮跳转到新增页面
	$("#btnAdd").click(function(){
		location.href = "$#addPageUrl#";
	});	
	//点击编辑按钮跳转到编辑页面
	$(".btnEdit").click(function(){
		var id = $(this).attr("name").split("btnEdit")[1];
		var url = "$#editPageUrl#";
		var jsonData = {"id":id};
		autoSubmit(jsonData,url);
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
				<td>$#page_1_condition_name#</td>
				<td class="td_detail">$#page_1_condition_content#</td>
				<td>$#page_2_condition_name#</td>
				<td class="td_detail">$#page_2_condition_content#</td>
				<td>$#page_3_condition_name#</td>
				<td class="td_detail">$#page_3_condition_content#</td>
			</tr>
			<tr>
				<td>开始时间</td>
				<td class="td_detail">
					<div class="input-append">
						<input class="span2 datepicker" readonly="readonly"  size="16" type="text" name="startTime"  value="${vo.startTime }"/><span
							class="add-on"><i class="icon-calendar"></i></span>
					</div>
				</td>
				<td>结束时间</td>
				<td class="td_detail">
					<div class="input-append">
					<input class="span2 datepicker" readonly="readonly" size="16" type="text" name="endTime" value="${vo.endTime}" /><span
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
					<input class="btn btn-primary add"
					id="btnAdd" type="reset" value="新增" />
				</td>
			</tr>
		</tbody>
	</table>

	<table class="table table-striped table-bordered table-condensed"
		id="list">
		<thead>
			<tr class="tr_detail">
				<td>排序</td>
				$#page_list_thead#
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="obj" varStatus="index">
			<tr>
				<td>${index.index+1 }</td>
				$#page_list_tbody#
				<td>
					<input class="btn btn-primary btnEdit"
					 name="btnEdit${obj.id}" type="button" value="编辑" />
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</form>
	<div class="pager_new">
		<un:pager href="?$#pager_param#" id="${page.pageNo}" size="${page.pageSize}" total="${page.totalItems}"   />
	</div>
</body>
</html>