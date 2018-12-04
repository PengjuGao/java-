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
				<td colspan="4"><b>操作表基本信息</b></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>表名称<font color="FF0000">*</font></td>
				<td colspan="3">${obj.tableName }</td>
			</tr>
			<c:forEach items="${obj.columns}" var="cloumns">
				<tr>
						<td>${cloumns}</td>
						<td colspan="1">
							<input type="checkbox" name="selected" />
						</td>
						<td colspan="2">
							<select>
								<option>生成input</option>
								<option>生成select</option>
								<option>生成input</option>
								<option>生成input</option>
							</select>
						</td>
				</tr>
			</c:forEach>
			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
				
				<input class="btn btn-inverse" id="find" type="button" value="生成add.jsp" /> 
					
				<input class="btn btn-inverse" type="button" value="生成edit.jsp" />
				
				<input class="btn btn-inverse" type="button" value="生成controller.java" />
				
				<input class="btn btn-inverse" type="button" value="生成service.java" />
				
				<input class="btn btn-inverse" type="button" value="生成serviceImpl.java" />
				
				<input class="btn btn-inverse" type="button" value="生成mapper.java" />
				
				<input class="btn btn-inverse" type="button" value="生成表单验证js" />
				
				<input class="btn btn-inverse" type="button" value="生成异步ajaxjs" />
					
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>
