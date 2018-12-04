<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <meta name="description" content="java框架在线生成,一键生成，省时省力，免去您搭建框架的烦恼，直接上手开发，希望能对您有帮助" />
    <meta name="keyword" content="java框架在线生成,在线生成java框架,java框架,java framework,java 框架在线生成,java主流框架" />
    <script type="text/javascript">
        $(function () {
            $("#ssh").bind("click",function () {
                $("input[name=type]").val("ssh");
                $("form").submit();
            });
            $("#ssm").bind("click",function () {
                $("input[name=type]").val("ssm");
                $("form").submit();
            });
            $("#sh").bind("click",function () {
                $("input[name=type]").val("sh");
                $("form").submit();
            });
            $("#sm").bind("click",function () {
                $("input[name=type]").val("sm");
                $("form").submit();
            });
            $("#s2h").bind("click",function () {
                $("input[name=type]").val("s2h");
                $("form").submit();
            });
            $("#s2m").bind("click",function () {
                $("input[name=type]").val("s2m");
                $("form").submit();
            });
        });
    </script>
</head>
<body oncontextmenu="return false">
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">JAVA 主流框架</h1>
                <p class="text-center">免费为您，一键打造</p>
            </div>
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
        <form action="/platform/framework/gotoMakePage" method="post">
            <input type="hidden" name="type" value=""/>

            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-3">
                    <h3 class="text-left">Struts2+Spring+Hibernate</h3>

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术。</p>
                    <br>
                    <button id="ssh" class="btn btn-block btn-primary">立即体验</button>
                </div>
                <div class="col-md-2">
                </div>
                <div class="col-md-3">
                    <h3 class="text-left">Stuts2+Spring+Mybatis</h3>

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术。</p>
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

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术。</p>
                    <br>
                    <button id="sm" class="btn btn-block btn-success">立即体验</button>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-3 text-center">
                    <h3 class="text-left">Spring+Hibernate</h3>

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术。</p>
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

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术。</p>
                    <br>
                    <button id="s2h" class="btn btn-block btn-danger">立即体验</button>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-3 text-center">
                    <h3 class="text-left">Struts2+Mybatis</h3>

                    <p class="text-left">基于maven的主流框架SSH,除去繁杂的配置，这里为您一键生成，免去您搭建框架的烦恼，方便您快速开发和学习新的技术。</p>
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
</body>
</html>
