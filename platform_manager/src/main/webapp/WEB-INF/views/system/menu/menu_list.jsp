<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单列表</title>
</head>
<body oncontextmenu="return false">
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
			<tr>
				<td><a>1 </a></td>
				<td>菜单管理</td>
				<td>/admin/templte/conr.html</td>
				<td>西蒙</td>
				<td>2015-08-20</td>
				<td>2015-08-20</td>
				<td>菜单</td>
				<td>xxxxx</td>
				<td>禁用|删除</td>
			</tr>
			<tr class="even">
				<td><a>2 </a></td>
				<td>角色管理</td>
				<td>/admin/templte/conr.html</td>
				<td>西蒙</td>
				<td>2015-08-20</td>
				<td>2015-08-20</td>
				<td>菜单</td>
				<td>xxxxx</td>
				<td>禁用|删除</td>
			</tr>
		</tbody>
	</table>
</body>
</html>