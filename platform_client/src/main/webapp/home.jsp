<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>java框架生成</title>
    <meta name="description" content="java框架在线生成,一键生成，省时省力，免去您搭建框架的烦恼，直接上手开发，希望能对您有帮助" />
    <meta name="keyword" content="java框架在线生成,在线生成java框架,java框架生成,java framework,java 框架生成,java主流框架" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/style/css/blue2.css">
    <link href="/style/css/font-awesome.min.430.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/style/css/magic-check.css">
    <link rel="shortcut icon" href="/style/img/favicon.ico" />
    <script type="text/javascript" src="/style/js/jquery.min.203.js"></script>
    <script type="text/javascript" src="/style/js/bootstap.min.334.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#ssh").bind("click", function () {
                $("input[name=type]").val("ssh");
                $("form").submit();
            });
            $("#ssm").bind("click", function () {
                $("input[name=type]").val("ssm");
                $("form").submit();
            });
            $("#sh").bind("click", function () {
                $("input[name=type]").val("sh");
                $("form").submit();
            });
            $("#sm").bind("click", function () {
                $("input[name=type]").val("sm");
                $("form").submit();
            });
            $("#s2h").bind("click", function () {
                $("input[name=type]").val("s2h");
                $("form").submit();
            });
            $("#s2m").bind("click", function () {
                $("input[name=type]").val("s2m");
                $("form").submit();
            });
        });
    </script>
</head>
<body oncontextmenu="return false">
<jsp:include page="/sitemesh/header">
    <jsp:param name="name" value="home"/>
</jsp:include>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">JAVA 主流框架</h1>

                <p class="text-center">免费为您，一键打造</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <hr>
            </div>
        </div>
        <form action="/platform/framework/gotoMakePage" method="post">
            <input type="hidden" name="type" value=""/>

            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-3">
                    <h3 class="text-left">Struts2+Spring+Hibernate</h3>

                    <p class="text-left">基于maven的java框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术--java框架生成。</p>
                    <br>
                    <button id="ssh" class="btn btn-block btn-primary">立即体验</button>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-3">
                    <h3 class="text-left">Stuts2+Spring+Mybatis</h3>

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术--java框架生成。</p>
                    <br>
                    <button id="ssm" class="btn btn-block btn-info">立即体验</button>
                </div>
                <div class="col-md-2"></div>
            </div>
            <div class="section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-3">
                    <h3 class="text-left">Spring+Mybatis</h3>

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术--java框架生成。</p>
                    <br>
                    <button id="sm" class="btn btn-block btn-success">立即体验</button>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-3 text-center">
                    <h3 class="text-left">Spring+Hibernate</h3>

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术--java框架生成。</p>
                    <br>
                    <button id="sh" class="btn btn-block btn-warning">立即体验</button>
                </div>
                <div class="col-md-2"></div>
            </div>
            <div class="section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-3">
                    <h3 class="text-left">Struts2+Hibernate</h3>

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术--java框架生成。</p>
                    <br>
                    <button id="s2h" class="btn btn-block btn-danger">立即体验</button>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-3 text-center">
                    <h3 class="text-left">Struts2+Mybatis</h3>

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术--java框架生成。</p>
                    <br>
                    <button id="s2m" class="btn btn-block btn-primary">立即体验</button>
                </div>
                <div class="col-md-2"></div>
            </div>
        </form>
        <div class="row">
            <div class="col-md-12">
                <hr>
            </div>
        </div>
    </div>
</div>
<footer class=" panel-footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-6"><h3>网站信息</h3>
                <p class="bg-info">java框架生成工具,不重复造轮子<br/>快速上手,省时省事,适合简单项目,新手学习使用!!!!qq群：384304235
                </p>
                <p><label class="alert-info">网站名称</label>:java 框架生成</p>
                <p><label class="alert-info">备案号:</label>:京ICP备17006472号</p>
                <p><label class="alert-info">qq群:</label>:384304235</p>
            </div>
            <div class="col-sm-6"><h3>友情链接</h3>
                <p>
                    <a href="#" class="alert-danger" style="font-size: 20px" target="_blank" onclick="open_window('https://www.2345.com/?k42725478')">导航主页</a><br>
                </p>
                <p >
                    <a href="http://uoowo.com/" class="alert-danger" style="font-size: 20px" target="_blank">柚沃科技</a> <br>
                </p>
                <p >
                    <a href="http://javajavajavajavajava.com/" class="alert-danger" style="font-size: 20px" target="_blank">五个java</a> <br>
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
