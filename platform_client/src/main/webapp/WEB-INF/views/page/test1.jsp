<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/static/js/jquery.js"></script>
<script type="text/javascript" src="/static/js/jsapi.js"></script>
<script type="text/javascript" src="/static/js/format+zh_CN,default,corechart.I.js"></script>
<script type="text/javascript" src="/static/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="/static/js/jquery.ba-resize.min.js"></script>

<script type="text/javascript">
		gvChartInit();
		jQuery(document).ready(function(){

		jQuery('#myTable5').gvChart({
				chartType: 'PieChart',
				gvSettings: {
					vAxis: {title: 'No of players'},
					hAxis: {title: 'Month'},
					width: 650,
					height: 250
					}
			});
		});
		</script>
    <script type="text/javascript">
        setWidth();
        $(window).resize(function(){
            setWidth();
        });
        function setWidth(){
            var width = ($('.leftinfos').width()-12)/2;
            $('.infoleft,.inforight').width(width);
        }
    </script>
</head>


<body oncontextmenu="return false">
{result}
</body>

</html>
