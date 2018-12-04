<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>增加菜单</title>
</head>
<body oncontextmenu="return false">
	<div class="alert alert-info">
		当前位置<b class="tip"></b>维护界面<b class="tip"></b>增加菜单
	</div>

	<table class="table table-striped table-bordered table-condensed list">
		<thead>
			<tr>
				<td colspan="4"><b>菜单基本信息</b></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>菜单名称<font color="FF0000">*</font></td>
				<td colspan="2"><input name="name" value="" type="text" /></td>
				<td><span class="msg"></span></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
				<input class="btn btn-inverse" id="find" type="button" value="保存" /> 
				<input class="btn btn-inverse" type="button" value="取消" />
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>
