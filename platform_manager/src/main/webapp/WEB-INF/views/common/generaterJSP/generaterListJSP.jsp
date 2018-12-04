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
<title>JSP模板生成</title>
<script type="text/javascript">
		
	$(function(){
		//改变类的时候需要检索该类所有的字段名称
		$("#className").bind('change',function(){
			
			$(".myTr").remove();
			
			var className = $("#className").val();
			
			$.ajax({ //一个Ajax过程
	            type: "post", //以post方式与后台沟通
	            url : "getPoFileds.html", //与此php页面沟通
	            dataType:'json',//从php返回的值以 JSON方式 解释
	            data: {"className":className}, 
	            success: function(json){
	            	//生成相应页面的类
	            	var clazzJson = json.clazz;
	            	//生成查询条件的类
	            	var voJson = json.voClazz;
	            	//查询条件类名
	            	var voName = json.voName;
	            	//组装类的字段并填充到相应位置
	            	
	            	//公用替换字符串
	            	
	            	var htmlStr = $("#demo").html();
	            	var num=0;
	            	var str = "";
	            	for(var i in clazzJson){
	            		var demo = htmlStr;
	            		str+="<input type='checkbox' class='parentClazz' checked='checked' name='clazz' value='"+clazzJson[i]+"' />"+clazzJson[i]+"&nbsp;&nbsp;";
	    				while(demo.indexOf("$#num#")!=-1){
	    					demo = demo.replace("$#num#",num);
	    				}
	    				while(demo.indexOf("$#field_name#")!=-1){
	    					demo =demo.replace("$#field_name#",clazzJson[i]);
	            		}
	    				if($("#classTbody tr[id='"+clazzJson[i]+"']").length<=0){
	    					$("#classTbody").append("<tr class='myTr' id='"+clazzJson[i]+"'>"+demo+"</tr>");
	    				}
	            		num++;
	            	}
	            	$("#classFileds").html(str);
	            	
	            	//组装查询条件vo类的字段并填充到相应的位置
	            	var voStr = "";
	            	var voNum = 0;
	            	for(var i in voJson){
	            		var demo = htmlStr;
	            		voStr+="<input type='checkbox' class='parentClazz' checked='checked' name='voClazz' value='"+voJson[i]+"' />"+voJson[i]+"&nbsp;&nbsp;";
	            		while(demo.indexOf("$#num#")!=-1){
	    					demo = demo.replace("list[$#num#]","voList["+voNum+"]");
	    				}
	            		while(demo.indexOf("$#field_name#")!=-1){
	    					demo =demo.replace("$#field_name#",voJson[i]);
	            		}
	            		if($("#conditionTbody tr[id='"+voJson[i]+"']").length<=0){
	    					$("#conditionTbody").append("<tr class='myTr' id='"+voJson[i]+"'>"+demo+"</tr>");
	    				}
	            		voNum++;
	            	}
	            	$("#voNameField").html(voStr);
	            	
	            	$("#voName").html(voName);
	            	
	            },
	            error:function(x,x1,x2){
	            	alert(x);
	            	alert(x1);
	            	alert(x2);
	            }
	        });
		});
		
		//checkbox 选中事件
		$(".myChecbox").live('click',function(){
			//nex sublings
			var value= $(this).next("span").text();
			
			var parentTbody = $(this).closest("tbody");
			
			if($(this).attr("checked")){
				$(this).val(1);
				parentTbody.find("input[value='"+value+"']").attr("checked","checked");
			}else{
				$(this).val(0);
				parentTbody.find("input[value='"+value+"']").removeAttr("checked");
			}
		});
		
		//checkbox 选中事件
		$(".parentClazz").live('click',function(){
			
			var parentTbody = $(this).closest("tbody");
			
			var value = $(this).val();
			if($(this).attr("checked")){
				parentTbody.find("input~span").each(function(){
					var str = $(this).text();
					
					if(str.indexOf(value) == 0){
						
						$(this).prev().attr("checked","checked");
						
						return false;
					}
				});
				
			}else{
				parentTbody.find("input~span").each(function(){
					var str = $(this).text();
					
					if(str.indexOf(value) == 0){
						
						$(this).prev().removeAttr("checked");
						
						return false;
					}
				});
			}
		});
		
	});
	
	//提交之前设置成diabled
	function setDisabled(){
		$("#demo").remove();
		$("#demo1").remove();
	}
	
	
</script>
</head>
<body oncontextmenu="return false">
	<div class="alert alert-info">
		当前位置<b class="tip"></b>JSP模板<b class="tip"></b>生成list.jsp页面
	</div>
	<form action="generaterList.html" method="post" onsubmit="setDisabled();" >
		<table class="table table-striped table-bordered table-condensed list">
			<thead>
				<tr>
					<td colspan="4"><b>生成页面基本信息</b></td>
				</tr>
			</thead>
			<tbody id="classTbody">
				<tr class="tr_detail">
					<td>页面title</td>
					<td colspan="3">
						<input type="text" name="pageTitle" value="xxx列表">
					</td>
				</tr>
				<tr class="tr_detail">
					<td>po类名列表<font color="FF0000">*</font></td>
					<td>
						<select id="className" name="classlowerName">
							<option>请必须选择</option>
							<c:forEach items="${classList}" var="obj">
								<option value="${obj}">${obj}-类</option>
							</c:forEach>
						</select>
					</td>
					<td>是否生成add.jsp:<input type="checkbox" checked="checked" name="isAdd" value="yes"/></td>
					<td>是否生成edit.jsp:<input type="checkbox" checked="checked" name="isEdit" value="yes"/></td>
				</tr>
				<tr class="tr_detail">
					<td>po类字段名列表<font color="FF0000">*</font></td>
					<td colspan="3" id="classFileds"></td>
				</tr>
				<tr id="demo" style="display:none">
					<td><input class="myChecbox" type="checkbox" value="1" checked="checked" name="list[$#num#].isChecked"><span>$#field_name#</span></td>
					<td style="display:none"><input type="hidden" value="$#field_name#" name="list[$#num#].fieldName" >   </td>
					<td><input type="text" value="$#field_name#" name="list[$#num#].alias"/></td>
					<td colspan="2">
						<input type="radio" checked="checked" value="text" name="list[$#num#].fieldType">文本
						<input type="radio" value="checkbox" name="list[$#num#].fieldType">checkbox
						<input type="radio" value="radio" name="list[$#num#].fieldType">raido
						<input type="radio" value="select" name="list[$#num#].fieldType">select
						<input type="radio" value="textarea" name="list[$#num#].fieldType">textarea
						(注：生成类型：文本，checkbox,raido,select,textarea)
					</td>
				</tr>
			</tbody>
		</table>
		<table class="table table-striped table-bordered table-condensed list">
			<thead>
				<tr>
					<td colspan="4"><b>生成页面条件查询信息</b></td>
				</tr>
			</thead>
			<tbody id="conditionTbody">
				<tr>
					<td>条件查询基类<font color="FF0000">*</font></td>
					<td id="voName" colspan="3"></td>
				</tr>
				<tr>
					<td>条件查询类所有的字段</td>
					<td id="voNameField" colspan="3"></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-striped table-bordered table-condensed list">
			<tfoot>
				<tr>
					<td colspan="4">
					<input class="btn btn-inverse"  id="find" type="submit" value="生成jsp" /> 
					<input class="btn btn-inverse" type="reset" value="取消" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>
