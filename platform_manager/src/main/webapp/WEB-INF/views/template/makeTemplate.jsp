<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模板创建</title>
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
				<td>单据号</td>
				<td class="detail"><input type="text" /></td>
				<td>单据类型</td>
				<td class="td_detail"><input type="text" /></td>
				<td>部门</td>
				<td><select>
						<option>第二营销事业部</option>
						<option>第三营销事业部</option>
				</select></td>
			</tr>
			<tr>
				<td>提交日期起</td>
				<td>
					<div class="input-append">
						<input class="span2 datepicker" id="startime" size="16"
							type="text" /><span class="add-on"><i
							class="icon-calendar"></i></span>至<input class="span2 datepicker"
							id="endtime" size="16" type="text" /><span class="add-on"><i
							class="icon-calendar"></i></span>
					</div>
				</td>
				<td>报销人</td>
				<td><select size="1" name="select2">
						<option value="10401"></option>
						<option value="10388">第二营销事业部</option>
						<option value="10389">第三营销事业部</option>
						<option value="10390">第一营销事业部</option>
						<option value="10391">康讯公司</option>

				</select></td>
				<td>所属项目</td>
				<td><select size="1" name="select3" s>
						<option value="10401"></option>
						<option value="10388">第二营销事业部</option>
				</select></td>
			</tr>
			<tr>
				<td>本币金额</td>
				<td>
					<div class="input-append">
						<input class="span2" id="Text2" size="16" type="text" /><span
							class="add-on">$</span>至<input class="span2" id="Text3" size="16"
							type="text" /><span class="add-on">$</span>
					</div>
				</td>
				<td>申请人</td>
				<td colspan="3"><input type="text"></td>
			</tr>
			<tr>
				<td>提交财务审核日期</td>
				<td>
					<div class="input-append">
						<input class="span2 datepicker" size="16" type="text" /><span
							class="add-on"><i class="icon-calendar"></i></span>至<input
							class="span2 datepicker" size="16" type="text" /><span
							class="add-on"><i class="icon-calendar"></i></span>
					</div>
				</td>
				<td>单据状态</td>
				<td colspan="3"><select size="1" name="select4">
						<option value="10401"></option>
						<option value="10388">第二营销事业部</option>

				</select> 至 <select size="1" name="select5">
						<option value="10401"></option>
						<option value="10388">第二营销事业部</option>

				</select></td>
			</tr>
			<tr>
				<td colspan="6" align="right"><input class="btn btn-inverse"
					id="find" type="button" value="查询" /> <input
					class="btn btn-inverse" type="button" value="清空" /></td>
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