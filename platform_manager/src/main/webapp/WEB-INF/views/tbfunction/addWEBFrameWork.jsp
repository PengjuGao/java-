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
    <script type="text/javascript">
		$(function(){
			$("#makeProject").click(function(){
				//生成简单的项目即可
				$("form").attr("action","makeSimpleProject.html");
				$("form").attr("method","post");
				$("form").submit();
			});
			$("#nextStep").click(function(){
				//生成简单的项目即可
				$("form").attr("action","addWEBFrameWork.html");
				$("form").attr("method","post");
				$("form").submit();
			});
		});
    </script>

</head>
<body oncontextmenu="return false">
	<div class="alert alert-info">
		当前位置<b class="tip"></b>维护界面<b class="tip"></b>增加菜单
	</div>
	<form>
	<table class="table table-striped table-bordered table-condensed list">
		<thead>
			<tr>
				<td colspan="4"><b>添加框架基本信息</b></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>生成项目</td>
				<td colspan="2">
					<input name="frameWorkType" value="springMVC" type="radio" checked="checked"/>springMVC框架
					<input name="frameWorkType" value="structs" type="radio" />structs框架
				</td>
				<td><span class="msg"></span></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
				<input class="btn btn-inverse" id="makeProject" type="button" value="完成" />
				<input class="btn btn-inverse" id="nextStep"    type="button" value="下一步" />
				</td>
			</tr>
		</tfoot>
	</table>
	</form>
</body>
</html>
