<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/20
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用说明</title>
    <meta name="description" content="java框架在线生成,一键生成，省时省力，免去您搭建框架的烦恼，直接上手开发，希望能对您有帮助" />
    <meta name="keyword" content="java框架在线生成,在线生成java框架,java框架,java framework,java 框架在线生成,java主流框架" />
    <script type="text/javascript">
        $(function(){
            $("li button").bind("click",function () {
                var id = $(this).attr("id");
                location.href = "/platform/home/doDownload?name="+id;
            });
        });
    </script>
</head>
<body>
<div class="section">
    <div class="col-md-12"><h1 class="text-center">JAVA 框架生成</h1>
        <p class="text-center">免费为您，一键打造</p>
    </div>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8 tab-bordered text-primary" id="tabs"> <!-- Only required for left/right tabs -->
            <ul class="nav nav-tabs">
                <li class="active"><a href="#panel-104223" data-toggle="tab">说明</a></li>
                <li ><a href="#panel-104389" data-toggle="tab">Eclipse 部署</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="panel-104223" >
                    <div class="well">
                        <h2>说明</h2>
                        <p>网站生成的java框架都是基于maven的项目,
                            其中涉及到需要安装的软件如下<br>(如果生成的项目不包含可以不用下载或者到网络上下载均可)：
                            <br/>
                            <br/>maven 安装配置地址 :<a class="text-danger" target="_blank" href="http://jingyan.baidu.com/article/425e69e6f67190be15fc16e9.html">http://jingyan.baidu.com/article/425e69e6f67190be15fc16e9.html</a>
                        </p>
                        <br>
                        <ul class="list-inline">
                            <li><button id="maven" class="btn btn-danger">Apache maven</button></li>
                            <li><button id="memcached" class="btn btn-info">Memcached</button></li>
                            <li><button id="redis" class="btn btn-success">Redis</button></li>
                        </ul>
                    </div>
                </div>
                <div class="tab-pane" id="panel-104389" >
                    <div class="well">
                        <h2>部署</h2>
                        <br>
                        <p>1：配置maven</p>
                        <br>
                        <img src="/style/img/show/notitle.png" class="img-responsive"/>
                        <p>2:导入maven项目</p>
                        <br>
                        <img src="/style/img/show/importmaven.png" class="img-responsive"/>
                        <br>
                        <img src="/style/img/show/xuanzemaven.png" class="img-responsive"/>
                        <p>3:导入成功</p>
                        <br>
                        <img src="/style/img/show/importdone.png" class="img-responsive"/>
                        <p>4:配置maven 命令</p>
                        <br>
                        <img src="/style/img/show/first.png" class="img-responsive"/>
                        <br>
                        <img src="/style/img/show/importrun.png" class="img-responsive"/>
                        <p>4:运行maven 命令</p>
                        <br>
                        <img src="/style/img/show/excute.png" class="img-responsive"/>
                        <p>5:AmazeUI 效果图</p>
                        <br>
                        <img src="/style/img/show/AmazeUI.png" class="img-responsive"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
</body>
</html>
