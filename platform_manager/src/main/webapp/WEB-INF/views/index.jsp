<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>后台管理系统首页111</title>
</head>
<body oncontextmenu="return false">

	<div class="alert alert-info">
		当前位置<b class="tip"></b>维护界面<b class="tip"></b>修改
	</div>

	<table class="table table-striped table-bordered table-condensed list">
		<thead>
			<tr>
				<td colspan="4"><b>maven 项目</b></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="4">
					<div class="alert-block">
						<span class="alert-block">
							<input type="radio" value="project">项目
						</span>
						<span class="span3">
							<input type="radio" value="module">模块
						</span>
						<span class="span3">
							<input type="radio" value="code">代码片段
						</span>
						<span class="span3">
							<input type="radio" value="bean">java bean
						</span>
						<span class="span3">
							<input type="radio" value="interface">接口
						</span>
						<span class="span3">
							<input type="radio" value="sql">sql语句
						</span>
						<span class="span3">
							<input type="radio" value="xml">xml
						</span>
						<span class="span3">
							<input type="radio" value="enum">java枚举类
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td>资源编号</td>
				<td colspan="3">BOSZ-010-0001-TPB（系统自动生成）</td>
			</tr>
			<tr>
				<td width="15%">图书名称<font color="FF0000">*</font></td>
				<td width="500"><input name="Name" value="" type="text" /></td>
				<td width="500">图书数量<font color="FF0000">*</font></td>
				<td width="500"><input name="Name" value="" type="text" /></td>
			</tr>
			<tr>
				<td>图书类型<font color="FF0000">*</font></td>
				<td><input name="Name" value="" type="text" /></td>
				<td>本书编号<font color="FF0000">*</font></td>
				<td><input name="Name" value="" type="text" /></td>
			</tr>
			<tr>
				<td>所属图书室<font color="FF0000">*</font></td>
				<td><input name="Name" value="" type="text" /></td>
				<td>所属书架<font color="FF0000">*</font></td>
				<td><input name="Name" value="" type="text" /></td>
			</tr>
			<tr>
				<td>地点<font color="FF0000">*</font></td>
				<td><select name="Address">
						<option value=" ">A座2楼</option>
						<option value=" ">AB座连廊2楼</option>
						<option value=" ">A座1楼</option>
						<option value=" ">A座4楼</option>
						<option value=" ">A座5楼</option>
						<option value=" ">A座6楼</option>
						<option value=" ">数字园B2座2楼</option>
						<option value=" ">数字园B2座3楼</option>
						<option value=" ">数字园B2座4楼</option>
						<option selected="selected">-=所在地点=-</option>
				</select></td>
				<td>所属地区<font color="FF0000">*</font></td>
				<td><select name="Address">
						<option selected="selected">-=所在地区=-</option>
						<option value=" ">深圳</option>
						<option value=" ">上海</option>
						<option value=" ">南京</option>
						<option>重庆</option>
						<option>西安</option>
						<option>北京</option>
						<option>国外</option>
						<option>其它</option>
				</select></td>
			</tr>
			<tr>
				<td width="15%">负责人<font color="FF0000">*</font></td>
				<td><input name="Manager" value="刘伟" readonly="readonly"
					type="text" /></td>
				<td width="500">联系电话</td>
				<td width="500"><input name="Phone" value="" type="text" /></td>
			</tr>
			<tr>
				<td>对外单位开放<font color="FF0000">*</font></td>
				<td><input name="radbutton" type="radio" value="radiobutton"
					checked="checked" /> 是 <input type="radio" name="radbutton"
					value="radiobutton" /> 否</td>
				<td>负责人审批<font color="FF0000">*</font></td>
				<td><input name="radiobutton" type="radio" value="radiobutton"
					checked="checked" /> 需要 <input type="radio" name="radiobutton"
					value="radiobutton" /> 不需要</td>
			</tr>
			<tr>
				<td>主管领导审批<font color="FF0000">*</font></td>
				<td colspan="3"><input name="radiobutton1" type="radio"
					value="radiobutton" /> 需要 <input name="radiobutton1" type="radio"
					value="radiobutton" checked="checked" /> 不需要</td>
			</tr>
			<tr>
				<td width="15%">管理单位</td>
				<td colspan="3"><select name="HyClass">
						<option value="0" selected="selected">-=一级部门=-</option>
				</select> <select name="HyClass">
						<option value="0" selected="selected">-=二级部门=-</option>
				</select> <select name="HyClass">
						<option value="0" selected="selected">-=三级部门=-</option>
				</select></td>
			</tr>
			<tr>
				<td width="15%">备注</td>
				<td width="500" colspan="3" height=""><textarea name="bak"
						style="width: 95%" rows="4" cols="5"></textarea></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4"><input class="btn btn-inverse" id="find"
					type="button" value="保存" /> <input class="btn btn-inverse"
					type="button" value="取消" /></td>
			</tr>
		</tfoot>
	</table>

</body>
</html>