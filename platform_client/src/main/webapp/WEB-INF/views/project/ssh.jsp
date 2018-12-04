<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Struts2 Spring Hibernate</title>
    <meta name="description" content="java框架在线生成,一键生成，省时省力，免去您搭建框架的烦恼，直接上手开发，希望能对您有帮助" />
    <meta name="keyword" content="java框架在线生成,在线生成java框架,java框架,java framework,java 框架在线生成,java主流框架" />
    <script type="text/javascript" src="/customjs/makeFramework.js"></script>
</head>
<body oncontextmenu="return false">
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">功能菜单</h3>
                    </div>
                    <div class="panel-body">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <button type="button" name="ssh" class="btn btn-block btn-primary">Struts2 Spring Hibernate</button>
                            </li>
                            <li class="list-group-item"><button type="button" name="ssm" class="btn btn-block btn-success">Struts2 Spring Mybatis</button></li>
                            <li class="list-group-item"><button type="button" name="s2h" class="btn btn-block btn-warning">Struts2 Hibernate</button></li>
                            <li class="list-group-item"><button type="button" name="s2m" class="btn btn-block btn-danger">Struts2 Mybatis</button></li>
                            <li class="list-group-item"><button type="button" name="sh" class="btn btn-block btn-info">Spring Hibernate</button></li>
                            <li class="list-group-item"><button type="button" name="sm" class="btn btn-block btn-success">Spring Mybatis</button></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="panel panel-primary">
                    <div class="panel-heading"><h3 class="panel-title">Struts2 Spring Hibernate 框架</h3></div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-2">
                                <img src="/style/img/new_maven1.jpg" alt="java框架生成" class="img-thumbnail" width="100px" height="108px"/>
                            </div>
                            <div class="col-md-2">
                                <img src="/style/img/new_struts21.jpg" alt="java框架生成" class="img-thumbnail" width="100px" height="108px"/>
                            </div>
                            <div class="col-md-2">
                                <img src="/style/img/new_spring1.jpg" alt="java框架生成" class="img-thumbnail" width="100px" height="108px"/>
                            </div>
                            <div class="col-md-2">
                                <img src="/style/img/new_hibernate1.jpg" alt="java框架生成" class="img-thumbnail" width="100px" height="100px"/>
                            </div>
                            <div class="col-md-2">
                                <img src="/style/img/new_mysql.jpg" alt="java框架生成" class="img-thumbnail" width="100px" height="100px"/>
                            </div>
                        </div>
                        <div class="col-md-12"><hr></div>
                        <form class="form-group" method="post" action="/platform/framework/doMakeFramework">
                            <input type="hidden" name="frameworkType" value="ssh">
                            <input type="hidden" name="token" value="${submitToken}">
                            <input type="hidden" name="webFramework" value="structs2">
                            <input type="hidden" name="ormFramework" value="hibernate">
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">项目名称</span>
                                <input type="text" class="form-control" maxlength="20" placeholder="请输入项目名称" name="project"  required>
                            </div>
                            <div class="col-md-12"><hr></div>
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">java 包名</span>
                                <input type="text" class="form-control" maxlength="25"  placeholder="请输入项目包名" name="packageName" required>
                            </div>
                            <div class="col-md-12"><hr></div>
                            <h4>数据库连接池</h4>
                            <ul class="list-inline">
                                <li>
                                    <input class="magic-radio" type="radio" name="databasePool" checked="checked" id="C3P0" value="C3P0">
                                    <label for="C3P0">C3P0</label>
                                </li>
                                <li>
                                    <input class="magic-radio" type="radio" name="databasePool" id="DBCP" VALUE="DBCP">
                                    <label for="DBCP">DBCP</label>
                                </li>
                                <li>
                                    <input class="magic-radio" type="radio" name="databasePool" id="Proxool" value="Proxool">
                                    <label for="Proxool">Proxool</label>
                                </li>
                                <li>
                                    <input class="magic-radio" type="radio" name="databasePool" id="bonecp" value="Bonecp">
                                    <label for="bonecp">BoneCP</label>
                                </li>
                                <li class="hidden">
                                    <input class="magic-radio" type="radio" name="databasePool" id="Druid" value="Druid">
                                    <label for="Druid">Druid</label>
                                </li>
                            </ul>
                            <div class="col-md-12"><hr></div>
                            <h4>缓存服务</h4>
                            <ul class="list-inline">
                                <li>
                                    <input class="magic-radio" checked="checked" type="radio" name="cache" id="ehcache" value="ehcache">
                                    <label for="ehcache">Ehcache</label>
                                </li>
                                <li>
                                    <input class="magic-radio" type="radio" name="cache" id="memcache" value="memcached">
                                    <label for="memcache">Memcache</label>
                                </li>
                                <li>
                                    <input class="magic-radio" type="radio" name="cache" id="redis" value="redis">
                                    <label for="redis">Redis</label>
                                </li>
                            </ul>
                            <div class="col-md-12"><hr></div>
                            <h4>视图类型</h4>
                            <ul class="list-inline">
                                <li>
                                    <input class="magic-radio" checked="checked" type="radio" name="template" id="jsp" value="jsp">
                                    <label for="jsp">JSP</label>
                                </li>
                                <li>
                                    <input class="magic-radio" type="radio" name="template" id="freemaker" value="freemaker">
                                    <label for="freemaker">Freemarker</label>
                                </li>
                                <li>
                                    <input class="magic-radio" type="radio" name="template" id="velocity" value="velocity">
                                    <label for="velocity">Velocity</label>
                                </li>
                            </ul>
                            <div class="col-md-12"><hr></div>
                            <h4>JS 框架</h4>
                            <ul class="list-inline">
                                <li>
                                    <input class="magic-radio" type="radio" checked="checked" name="jsFramework" id="jQuery" value="jQuery">
                                    <label for="jQuery">jQuery</label>
                                </li>
                                <li class="hidden">
                                    <input class="magic-radio" type="radio" name="jsFramework" id="vue" value="vue">
                                    <label for="vue">vue</label>
                                </li>
                                <li class="hidden">
                                    <input class="magic-radio" type="radio" name="jsFramework" id="anglarJS" value="anglarJS">
                                    <label for="anglarJS">anglarJS</label>
                                </li>
                            </ul>
                            <div class="col-md-12"><hr></div>
                            <h4>Html 框架</h4>
                            <ul class="list-inline">
                                <li>
                                    <input class="magic-radio" type="radio" checked="checked" name="htmlFramework" id="bootstrap" value="bootstrap">
                                    <label for="bootstrap">Bootstrap</label>
                                </li>
                                <li class="hidden">
                                    <input class="magic-radio" type="radio" name="htmlFramework" id="dwz" value="dwz">
                                    <label for="dwz">DWZ</label>
                                </li>
                                <li>
                                    <input class="magic-radio" type="radio" name="htmlFramework" id="amazeUI" value="amazeUI">
                                    <label for="amazeUI">Amaze UI</label>
                                </li>
                                <li class="hidden">
                                    <input class="magic-radio" type="radio" name="htmlFramework" id="easyUI" value="easyUI">
                                    <label for="easyUI">Easy UI</label>
                                </li>
                            </ul>
                            <div class="col-md-12"><hr></div>
                            <h4>网页修饰框架sitemesh</h4>
                            <input class="magic-radio" type="radio" checked="checked" name="sitemesh" id="sitemesh" value="yes">
                            <label for="sitemesh">SiteMesh</label>
                            <div class="col-md-12"><hr></div>
                            <shiro:guest>
                                <button type="button" class="btn btn-block btn-primary" data-toggle="modal" data-target="#modal-dialog" id="alterBtn">立即生成</button>
                            </shiro:guest>
                            <shiro:authenticated>
                                <button type="submit" class="btn btn-block btn-primary">立即生成</button>
                            </shiro:authenticated>                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
