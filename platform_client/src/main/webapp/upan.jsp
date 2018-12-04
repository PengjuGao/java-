<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>装机U盘,一键装机</title>
    <title>java框架生成</title>
    <meta name="description" content="蓝光U盘3,蓝光U宝3,装机U盘" />
    <meta name="keyword" content="蓝光U盘3,蓝光U宝3,装机U盘" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style/css/blue2.css">
    <link href="style/css/font-awesome.min.430.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="style/css/magic-check.css">
    <link rel="shortcut icon" href="style/img/favicon.ico" />
    <script type="text/javascript" src="style/js/jquery.min.203.js"></script>
    <script type="text/javascript" src="style/js/bootstap.min.334.js"></script>

    <!-- Bootstrap -->
    <!-- <link rel="stylesheet" href="css/bootstrap-ie6.min.css">-->
    <!-- <link rel="stylesheet" href="css/ie.css">-->
    <link rel="stylesheet" href="style/css/reset.css"/>
    <link rel="stylesheet" href="style/css/hy_common.css" />
    <link rel="stylesheet" href="style/css/com_m980.css" />
    <link rel="stylesheet" href="style/css/zx_lpxq.css">

    <!-- WARNING: Respond.js 不支持file://方式的访问 -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <![endif]-->
    <style>
        li{
            background-color: #2fa4e7;
        }
    </style>
</head>
    
    <body>
    <div class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><span>JAVA框架生成</span></a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li <c:if test="${fn:contains('/home.jsp',uri)} ">class="active"</c:if>>
                        <a href="/home.jsp" >首页</a>
                    </li>
                    <li <c:if test="${fn:contains('/platform/framework/gotoMakePage?type=ssh',uri) and uri ne '/'}">class="active"</c:if>>
                        <a href="/platform/framework/gotoMakePage?type=ssh">代码生成</a>
                    </li>
                    <li <c:if test="${fn:contains('/platform/home/gotoShow',uri) and uri ne '/'}">class="active"</c:if>>
                        <a href="/platform/home/gotoShow">使用说明</a>
                    </li>
                    <li <c:if test="${fn:contains('/platform/makeMoney/gotoMakeMoneyPage',uri) and uri ne '/'}">class="active"</c:if>>
                        <a href="/platform/makeMoney/gotoMakeMoneyPage"><font color="red">赚外快</font></a>
                    </li>
                    <shiro:user>
                        <li <c:if test="${fn:contains('/platform/user/gotoCenter?page=frameworkList',uri) and uri ne '/'}">class="active"</c:if>>
                            <a href="/platform/user/gotoCenter?page=frameworkList">用户中心</a>
                        </li >
                    </shiro:user>
                    <li <c:if test="${fn:contains('/platform/home/gotoDownload',uri) and uri ne '/'}">class="active"</c:if>>
                        <a href="/platform/home/gotoDownload">软件下载</a>
                    </li>
                    <li <c:if test="${fn:contains('/platform/makeMoney/gotoRewardPage',uri) and uri ne '/'}">class="active"</c:if>>
                        <a href="/platform/makeMoney/gotoRewardPage">赞赏</a>
                    </li>
                    <li <c:if test="${fn:contains('/platform/feedback/gotoFeedbackPage',uri) and uri ne '/'}">class="active"</c:if>>
                        <a href="/platform/feedback/gotoFeedbackPage">反馈</a>
                    </li>
                    <li>
                        <a href="http://uoowo.com/" target="_blank">柚沃科技</a>
                    </li>
                    <li>
                        <a href="http://bbs.anbig.com/index.php" target="_blank">自学编程窝</a>
                    </li>
                    <shiro:guest>
                        <li <c:if test="${fn:contains('/platform/login/goToLogin',uri) and uri ne '/'}">class="active"</c:if>>
                            <a href="/platform/login/goToLogin">登陆</a>
                        </li>
                        <li <c:if test="${fn:contains('/platform/register/gotoRegister',uri) and uri ne '/'}">class="active"</c:if>>
                            <a href="/platform/register/gotoRegister">注册</a>
                        </li>
                    </shiro:guest>
                    <shiro:user>
                        <li class="active">
                            <a href="#"> <shiro:principal property="nick"/> </a>
                        </li>
                        <li>
                            <a href="/platform/login/logout"> 退出 </a>
                        </li>
                    </shiro:user>
                </ul>
            </div>
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
    <div class="cl"></div>
    <section class="introduce">
        <div class="goods all">
            <div class="show">
                <div class="bigTu"></div>
                <div class="bigShow">
                    <div class="last"><a href="javascript:;"><img src="style/images/shopDetails/last2.png" alt=""/></a></div>
                    <div class="mainShow"><a href="javascript:;"><img id="bigPic" src="style/img/upan/upan1.png" alt=""/></a>
                        <div class="fangdajing"></div>
                    </div>
                    <div class="next"><a href="javascript:;"><img src="style/images/shopDetails/next2.png" alt=""/></a></div>
                </div>
                <div class="preview">
                    <a id="a5" href="javascript:;"><img id="img1" src="style/img/upan/upan1.png" alt=""/></a>
                    <a id="a6" href="javascript:;"><img id="img2" src="style/img/upan/upan1.png" alt=""/></a>
                    <a id="a7" href="javascript:;"><img id="img3" src="style/img/upan/upan2.png" alt=""/></a>
                    <a id="a8" href="javascript:;"><img id="img4" src="style/img/upan/upan3.png" alt=""/></a>
                    <a id="a9" href="javascript:;"><img id="img5" src="style/img/upan/upan4.png" alt=""/></a>
                </div>

                <div class="shareStore">
                    <!--<span class="span1 share">分享</span>--><span class="span2">收藏</span>
                    <div class="share2">
                        <div class="share1 share">
                            <div class="shareTitle"><span>分享到</span><b></b></div>
                            <a href="javascript:;" class="shareA1"></a>
                            <a href="javascript:;" class="shareA2"></a>
                            <a href="javascript:;" class="shareA3"></a>
                            <a href="javascript:;" class="shareA4"></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="buy">
                <div class="title">
                    <h2 id="titleH2">蓝光U宝3 智能安装系统U盘 电脑重装系统U盘 支持xp/win7/win8/win10 银色USB2.0,3.0</h2>
                    <p id="titleP">一键装机系统U盘,电脑小白不再愁</p>
                </div>
                <div class="price">
                    <div class="salesPro"><p class="forDui">单价：<b class="b1">80</b>元<br/></p></div>
                    <div class="highOp"><p><b>88</b><br/>下单</p></div>
                    <div class="soldOut"><p><b>35</b><br/>购买成功</p></div>
                </div>
                <div class="attribute-info">
                    <div class="" id="attr-box">
                        <div id="J_isku" class="sku-box">
                            <dl class="summary-attr">
                                <dt>颜色：</dt>
                                <dd>
                                    <a data-value="3:10" class="summary-attr-a color333 sku-item selected"><span>银色</span></a>
                                </dd></dl>
                            <dl class="summary-attr">
                                <dt>容量：</dt><dd>
                                <a data-value="5:49" class="summary-attr-a color333 sku-item"><span>16G</span></a>
                                <a data-value="5:50" class="summary-attr-a color333 sku-item selected"><span>32G</span></a>
                                <a data-value="5:51" class="summary-attr-a color333 sku-item">
                                <span>64G</span></a>
                                <a data-value="5:48" class="summary-attr-a color333 sku-item"><span>128G</span></a>
                            </dd></dl>
                        </div>
                        <dl class="summary-attr summary-attr-tips" id="attr-box-dl" style="display:none">请选择商品信息</dl>
                    </div>
                    <dl class="summary-attr">
                        <dt>数量：</dt>
                        <dd>
                            <div class="quantity-form">
                                <a href="javascript:void(0);" class="decrement btn-reduce">-</a>
                                <input id="buy-quantity" type="text" class="itxt" value="1" onchange="changeQuantity()">
                                <a href="javascript:void(0);" class="increment btn-add">+</a>
                            </div>
                            <!-- <em class="quota-tips red">此商品限购50件</em> -->
                        </dd>
                    </dl>
                    <dl class="summary-attr" style="margin-bottom: 10px;">
                        <dt></dt>
                        <dd class="pos-relative">
                            <p class="bubble-ie8">成功加入购物车！</p>
                            <a class="store-btn run">加入购物车</a><a class="store-btn buy-btn" id="buy">立即购买</a>
                        </dd>
                    </dl>
                </div>
            </div>
            <div class="mayNeed">
                <h3>您可能还会需要</h3>
                <div class="mayF"><a class="mayA" href=""><img src="style/images/shopDetails/mayF.png" alt="" id="mayFID"/></a><p><a class="hotA3" href="javascript:;">车载 空气进化器 十倍清洁</a><br/><b>1270分</b></p></div>
                <!--
                <div class="mayS"><a class="mayA" href=""><img src="images/shopDetails/mayS.png" alt="" id="maySID"/></a><p><a class="hotA3" href="javascript:;">奥迪A6雨刷器 特价促销</a><br/><b>270分</b></p></div>
                <div class="mayT"><a class="mayA" href=""><img src="images/shopDetails/mayT.png" alt="" id="mayTID"/></a><p><a class="hotA3" href="javascript:;">赫兹（HERTZ）DSK165.3</a><br/><b>1199分</b></p></div>
                -->
            </div>
        </div>
    </section>
    <div class="forLocation">
        <div></div>
    </div>
    <section class="details">
        <div class="detailsD all">

            <div class="asideLeft">
                <a class="xq"></a>
                <a name="gg" class="gg"></a>
                <a name="pj" class="pj"></a>
                <a name="zx" class="zx"></a>
                <!-- <div class="storeMess">
                     <div class="storeLogo"><a href=""><img src="images/shopDetails/storeLogo.png" alt=""/></a></div>
                     <div class="storeDet">
                         <h3>捷渡官方旗舰店</h3>
                         <p>1008-0040-800</p>
                         <div class="enterStore"><a href="javascript:;">进入店铺</a></div>
                         <div class="storePoint"><span>4.5</span>分</div>
                         <div class="fiveStar"><b class="redStar"></b><b class="redStar"></b><b></b><b></b><b></b></div>
                         <div>
                             <div class="truePro passFont"><div>正</div><span>正品保障</span></div>
                             <div class="sevenCha passFont"><div>七</div><span>七天退换</span></div>
                             <div class="brandStr passFont"><div>牌</div><span>品牌直营</span></div>
                         </div>
                     </div>
                 </div>-->
                <div class="classify">
                    <div class="classifyTitle"><h3>相关分类</h3></div>
                    <div class="classifyMenu">
                        <ul>
                            <li><a href="javascript:;">车载吸尘器</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="goodsDetail">
                <div class="goodsDetails">
                    <div class="mayUNeed">
                        <div class="needTitle">
                            <div class="needTitle1">您可能还会需要</div>
                            <div class="needOther"></div>
                        </div>
                        <div class="needMain">
                            <div class="needMain1"><a class="needA" href=""><img src="style/images/shopDetails/like1.png" alt=""/></a><p><a class="hotA2" href="javascript:;">车载 空气净化器 10倍清洁</a><b>1270分</b></p></div>
                            <div class="needMain1"><a class="needA" href=""><img src="style/images/shopDetails/like2.png" alt=""/></a><p><a class="hotA2" href="javascript:;">奥迪A6雨刷器 特价促销</a><b>270分</b></p></div>
                            <div class="needMain1 needMain2"><a class="needA" href=""><img src="style/images/shopDetails/like5.png" alt=""/></a><p><a class="hotA2" href="javascript:;">赫兹（HERTZ）DSK165.3</a><b>1199分</b></p></div>
                        </div>
                    </div>
                    <div class="products">
                        <div class="productsMenu" id="menuFix">
                            <ul>
                                <li id="menuL1"><a href="#xq"><span id="menuSp1">商品详情</span></a></li>
                                <li id="menuL2"><a href="#gg"><span id="menuSp2"></span></a></li>
                                <li id="menuL3"><a href="#pj"><span id="menuSp3"></span></a></li>
                                <li class="menuLi1" id="menuL4"><a href="#zx"><span id="menuSp4"></span></a></li>
                            </ul>
                        </div>
                        <div class="productDetails">
                            <div class="picIntro">
                                <img src="style/img/upan/upandetail1.jpg" alt=""/>
                                <img src="style/img/upan/upandetail2.jpg" alt=""/>
                                <img src="style/img/upan/upandetail4.jpg" alt=""/>
                                <img src="style/img/upan/upandetail3.jpg" alt=""/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!--------尾部-------->

    <div class="pop_up">
        <div class="pop_up_con">
            <span class="pop_up_bg"></span>
            <div class="pubAsk">
                <span class="forClose"><img src="style/images/searchResult/close.jpg" alt=""/></span>
                <h3 class="yh">发表咨询</h3>
                <div class="declare">
                    <span><b>声明：</b>您可在购买前对产品包装、颜色、运输、库存等方面进行咨询，我们有专人进行回复！因厂家随时会更改一些产品的包装、颜色、产地等参数，所以该回复仅在当时对提问者有效，其他网友仅供参考！咨询回复的工作时间为：周一至周五，9:00至18:00，请耐心等待工作人员回复。</span>
                </div>
                <div class="pubMain">
                    <form action="">
                        <div class="pubKind">
                            <span class="">咨询类型：</span>
                            <ul>
                                <li>商品咨询</li>
                                <li>库存及配送</li>
                                <li>支付问题</li>
                                <li>发票及保修</li>
                            </ul>
                        </div>
                        <div class="pubPas">
                            <span>咨询内容：</span>
                            <textarea name="pubInfo" id="" ></textarea>
                        </div>
                        <input type="submit" value="提交" class="setUp"/>
                        <span class="advByMes">有回复的时候短信通知</span>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="style/js/jquery-1.11.1.min.js"></script>
    <script src="style/js/goodsDetails.js"></script>

    <script type="text/javascript">
        $(document).ready(
            function() {

                $(window).scroll(function(e) {
                    var a=$(window).scrollTop();
                    var b=700;

                    if(a>b){
                        $('.xq').attr('name','xq');
                        $('.gg').attr('name','gg');
                        $('.pj').attr('name','pj');
                        $('.zx').attr('name','zx');

                    }else{
                        $('.xq').attr('name','');
                        $('.gg').attr('name','');
                        $('.pj').attr('name','');
                        $('.zx').attr('name','');
                    }
                });
                $('#menuFix').click(function(e) {
                    $('#menuFix').css('position','static')
                });
                var n =1;
                $('.preview a').click(function(e) {
                    var m = $(this).index();
                    $('.bigTu').css('background-image','url(style/img/upan/upan'+m+'.png)')
                    n=m;
                });


                $('.next').click(function(e) {

                    if(n<4){

                        n++;
                        $('.bigTu').css('background-image','url(style/img/upan/upan'+n+'.png)')
                    }else{
                        n=0;
                        $('.bigTu').css('background-image','url(style/img/upan/upan'+n+'.png)')
                    }

                });
                $('.last').click(function(e) {

                    if(n>0){
                        n--;
                        $('.bigTu').css('background-image','url(style/img/upan/upan'+n+'.png)')
                    }else{
                        n=4;
                        $('.bigTu').css('background-image','url(style/img/upan/upan'+n+'.png)')
                    }

                });

                $(".mainShow").mouseenter(
                    function(){
                        $(".fangdajing").show();
                        if(n ==1 ) {
                            $('.bigTu').css('background-image', 'url(style/img/upan/upan' + 1 + '.png)');
                        }
                        $(".bigTu").show();
                    }
                );

                $(".mainShow").mouseleave(
                    function(){
                        $(".fangdajing").hide();
                        $(".bigTu").hide();
                    }
                );

                $(".mainShow").mousemove(
                    function(e){
                        var x = e.pageX - $(".mainShow").offset().left - 177/2;
                        var y = e.pageY - $(".mainShow").offset().top - 177/2;

                        //验收：
                        if(x < 0){
                            x = 0;
                        }else if(x > 175){
                            x = 175;
                        }


                        if(y < 0){
                            y = 0;
                        }else if(y > 175){
                            y = 175;
                        }

                        $(".fangdajing").css(
                            {
                                "left":x,
                                "top":y
                            }
                        );


                        var fangdatux = -x * 800 / 350;
                        var fangdatuy = -y * 800 / 350;
                        $(".bigTu").css("background-position",fangdatux + "px " + fangdatuy + "px");
                    }
                );
            }
        );
    </script>
    <script type="text/javascript" src="style/js/return.js"></script>
    <script type="text/javascript" src="style/js/sitenav.js"></script>
    <script type="text/javascript" src="style/js/ask.js"></script>
    </body>

</html>