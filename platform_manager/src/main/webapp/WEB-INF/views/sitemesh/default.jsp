<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><sitemesh:write property='title' /></title>
<link rel="stylesheet" type="text/css" href="/Styles/admin-all.css" />
<link rel="stylesheet" type="text/css" href="/Styles/base.css" />
<link rel="stylesheet" type="text/css" href="/Styles/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
<script type="text/javascript" src="/Scripts/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="/Scripts/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="/Scripts/index.js"></script>
<script type="text/javascript"
	src="/Scripts/ChurAlert.min.js?skin=blue"></script>
<script type="text/javascript" src="/Scripts/chur-alert.1.0.js"></script>
<script type="text/javascript" src="/resource/js/autoSubmit.js"></script>
<link rel="stylesheet" type="text/css" href="/Styles/chur.css" />
<script type="text/javascript">
        $(function () {
            $(".datepicker").datepicker();

            $('#find').click(function () {
                $('#list').show();
            })
        })

</script>
<sitemesh:write property='head' />
</head>
<body oncontextmenu="return false">
	<div class="warp">
		<jsp:include page="/login/gotoHeaderPage"></jsp:include>
		<jsp:include page="/login/gotoMenuPage">
			<jsp:param value="${funId}" name="functionId"/>
		</jsp:include>
		<!--右边框架开始-->
		<div class="right_c">
			<div class="nav-tip" onclick="javascript:void(0)">&nbsp;</div>
		</div>
		<div class="Conframe" style="height: 80%; z-index: 1">
			<div name="Conframe" id="Conframe">
				<sitemesh:write property='body' />
			</div>
		</div>
		<!--右边框架结束-->

		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
</html>