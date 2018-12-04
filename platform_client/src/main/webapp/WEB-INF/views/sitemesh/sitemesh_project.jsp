<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <title><sitemesh:write property='title' /></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta baidu-gxt-verify-token="79219b89dd3c836d057b209f70b43829">
    <link rel="stylesheet" href="/style/css/blue2.css"  rel="stylesheet"  media="screen">
    <link href="/style/css/font-awesome.min.430.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/style/css/magic-check.css">
    <script type="text/javascript" src="/style/js/jquery.min.203.js"></script>
    <script type="text/javascript" src="/style/js/bootstap.min.334.js"></script>
    <!-- md5 -->
    <script type="text/javascript" src="/style/md5/md5.js"></script>
    <link rel="shortcut icon" href="/style/img/favicon.ico" />
    <sitemesh:write property='head'/>
</head>
<body oncontextmenu="return false">
<jsp:include page="/sitemesh/header" flush="true"/>
<div class="row">
    <div class="col-md-3">

    </div>
    <div class="col-md-7">
        <script src="http://wm.lrswl.com/page/s.php?s=246596&w=728&h=90"></script>
    </div>
    <div class="col-md-2">
    </div>
</div>
<div class="row">
<sitemesh:write property='body'/>
</div>
<footer class=" panel-footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-6"><h3>网站信息</h3>
                <p class="bg-info">java框架生成工具,不重复造轮子<br/>快速上手,省时省事,适合简单项目,新手学习使用!!!!QQ群:384304235</p>
                <p><label class="alert-info">网站名称</label>:java 框架生成</p>
                <p><label class="alert-info">备案号:</label>:京ICP备17006472号</p>
                <p><label class="alert-info">QQ群:</label>:384304235</p>
            </div>
            <div class="col-sm-6"><h3>友情链接</h3>
                <p>
                    <a href="#" class="alert-danger" style="font-size: 20px" target="_blank" onclick="open_window('https://www.2345.com/?k42725478')">导航主页</a><br>
                </p>
                <p>
                    <a href="http://uoowo.com/" class="alert-danger" style="font-size: 20px" target="_blank">柚沃科技</a> <br>
                </p>
            </div>
        </div>
    </div>
</footer>
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1261189056'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/z_stat.php%3Fid%3D1261189056%26show%3Dpic2' type='text/javascript'%3E%3C/script%3E"));</script>
<!-- 百度自动提交-->
<script>
    (function(){
        var bp = document.createElement('script');
        var curProtocol = window.location.protocol.split(':')[0];
        if (curProtocol === 'https') {
            bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
        }
        else {
            bp.src = 'http://push.zhanzhang.baidu.com/push.js';
        }
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(bp, s);
    })();
</script>
<script>(function(){
    var src = (document.location.protocol == "http:") ? "http://js.passport.qihucdn.com/11.0.1.js?579f2399885afb7883c8d780602e4017":"https://jspassport.ssl.qhimg.com/11.0.1.js?579f2399885afb7883c8d780602e4017";
    document.write('<script src="' + src + '" id="sozz"><\/script>');
})();
</script>
</body>
</html>
