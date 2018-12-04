<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/20
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>软件下载</title>
    <meta name="description" content="软件下载，办公软件下载，360软件下载" />
    <script type="text/javascript">
        $(function () {
            $(".col-md-2").bind("click",function () {
                var len = $(this).children().length;
                if(len <=0){
                    return;
                }else {
                    var child = $(this).children("a").children("img");
                    var childSrc = child.attr("src");
                    var value = childSrc.split("/")[childSrc.split("/").length-1].split(".")[0];
                    location.href="/platform/home/doDownload?name="+value;
                }
            })
        })

    </script>
</head>
<body>
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12"><h3 class="text-center text-danger">办公软件</h3></div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <hr>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/xiaohei-big.png"
                                          class="img-responsive"  height="80px" width="80px"></a>
                <h4 >小黑记事本</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/kyzip-big.png"
                                                                  class="img-responsive" height="80px" width="80px"></a>
                <h4 >快压软件</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/number/ktw.png"
                                                                  class="img-responsive"  height="80px" width="80px"></a>
                <h4 >看图王</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/number/browser.png"
                                                                  class="img-responsive" height="80px" width="80px"></a>
                <h4 >2345 浏览器</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/number/pinyin.png"
                                                                  class="img-responsive" height="80px" width="80px"></a>
                <h4 >2345 输入法</h4>
            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <hr>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/360-big.png"
                                          class="img-responsive"  height="80px" width="80px"></a>
                <h4 >360 安全卫士</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/360-big-antivirus.png"
                                          class="img-responsive" height="80px" width="80px"></a>
                <h4 >360 杀毒</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/360-big-browser.png"
                                          class="img-responsive" height="80px" width="80px"></a>
                <h4 >360 浏览器</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/kyzip-big.png"
                                          class="img-responsive" height="80px" width="80px"></a>
                <h4 >快压软件</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/number/ktw.png"
                                          class="img-responsive"  height="80px" width="80px"></a>
                <h4 >看图王</h4>
            </div>
            <div class="col-md-1"></div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <hr>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/number/browser.png"
                                          class="img-responsive" height="80px" width="80px"></a>
                <h4 >2345 浏览器</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/number/pinyin.png"
                                          class="img-responsive" height="80px" width="80px"></a>
                <h4 >2345 输入法</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/number/pcsafe.png"
                                          class="img-responsive" height="80px" width="80px"></a>
                <h4 >2345 安全卫士</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/number/baoying-big.png"
                                                                  class="img-responsive" height="80px" width="80px"></a>
                <h4 >暴风影音</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer">
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div>
<div class="section hidden">
    <div class="container">
        <div class="row">
            <div class="col-md-12"><h3 class="text-center text-danger">游戏软件</h3></div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <hr>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/mfwz-big.png"
                                          class="img-responsive" height="80px" width="80px"></a>
                <h4 >魔法王座</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/tqcf-big.png"
                                          class="img-responsive" height="80px" width="80px"></a>
                <h4 >铁骑冲锋</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer">
                <a><img src="/style/img/software/dmbj-big.png"
                        class="img-responsive" height="80px" width="80px"></a>
                <h4 >盗墓笔记</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer">
                <a><img src="/style/img/software/number/big_lycq.png"
                        class="img-responsive" height="80px" width="80px"></a>
                <h4 >蓝月传奇</h4>
            </div>
            <div class="col-md-2" style="cursor: pointer"><a><img src="/style/img/software/number/big_snqxz.png"
                                          class="img-responsive" height="80px" width="80px"></a>
                <h4 >少年群侠传</h4>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div>
</body>
</html>
