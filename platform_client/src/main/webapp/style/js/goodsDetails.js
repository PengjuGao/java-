/**
 * Created by Jeff on 2015/4/16.
 */
$(
    function () {
        $(".display1").mouseover(
            function () {
                $(".personMid2").css("display","block");
                $(".li1").css({"background":"white","border-left":"1px solid #d1d1d1","border-right":"1px solid #d1d1d1"});
            }
        );
        $(".display1").mouseout(
            function () {
                $(".personMid2").css("display","none");
                $(".li1").css({"background":"url(images/icon2.png) no-repeat 60px center","border-left":"none","border-right":"none"});
            }
        );
        $(".display3").mouseover(
            function () {
                $(".shopCarPull2").css("display","block");
                $(".li3").css({"background":"white","border-left":"1px solid #d1d1d1","border-right":"1px solid #d1d1d1"});
            }
        );
        $(".display3").mouseout(
            function () {
                $(".shopCarPull2").css("display","none");
                $(".li3").css({"background":"url(images/icon5.png) no-repeat left","border-left":"none","border-right":"none"});
            }
        );
        $(".display4").mouseover(
            function () {
                $(".onPhone2").css("display","block");
                $(".li4").css({"background":"white","border-left":"1px solid #d1d1d1","border-right":"1px solid #d1d1d1"});
            }
        );
        $(".display4").mouseout(
            function () {
                $(".onPhone2").css("display","none");
                $(".li4").css({"background":"url(images/icon6.png) no-repeat 0 center","border-left":"none","border-right":"none"});
            }
        );
        $(".display5").mouseover(
            function () {
                $(".shopPull2").css("display","block");
                $(".li7").css({"background":"white","border-left":"1px solid #d1d1d1","border-right":"1px solid #d1d1d1"});
            }
        );
        $(".display5").mouseout(
            function () {
                $(".shopPull2").css("display","none");
                $(".li7").css({"background":"url(images/icon2.png) no-repeat 65px center","border-left":"none","border-right":"none"});
            }
        );
        $(".goodsPull").mouseover(
            function () {
                $(".allGoodsPull2").css("display","block")
            }
        );
        $(".goodsPull").mouseout(
            function () {
                $(".allGoodsPull2").css("display","none")
            }
        );
        $(".goods1").mouseover(
            function () {
                $(".aside_nav2").css("display","block");
                $(".aside_nav2_1").css("display","block");
                $(".goods1").css("background","#0a427d");
                $(".goods1 span").css("background","url(images/nav_icons.png) no-repeat 0 -201px");
            }
        );
        $(".goods1").mouseout(
            function () {
                $(".aside_nav2").css("display","none")
                $(".aside_nav2_1").css("display","none")
                $(".goods1").css("background","#116fd1");
                $(".goods1 span").css("background","url(images/nav_icons.png) no-repeat");
            }
        );
        $(".goods2").mouseover(
            function () {
                $(".aside_nav2").css("display","block")
                $(".aside_nav2_2").css("display","block")
                $(".goods2").css("background","#0a427d");
                $(".goods2 span").css("background","url(images/nav_icons.png) no-repeat 0 -240px");
            }
        );
        $(".goods2").mouseout(
            function () {
                $(".aside_nav2").css("display","none")
                $(".aside_nav2_2").css("display","none")
                $(".goods2").css("background","#116fd1");
                $(".goods2 span").css("background","url(images/nav_icons.png) no-repeat 0 -40px");
            }
        );
        $(".goods3").mouseover(
            function () {
                $(".aside_nav2").css("display","block")
                $(".aside_nav2_3").css("display","block")
                $(".goods3").css("background","#0a427d");
                $(".goods3 span").css("background","url(images/nav_icons.png) no-repeat 0 -283px");
            }
        );
        $(".goods3").mouseout(
            function () {
                $(".aside_nav2").css("display","none")
                $(".aside_nav2_3").css("display","none")
                $(".goods3").css("background","#116fd1");
                $(".goods3 span").css("background","url(images/nav_icons.png) no-repeat 0 -83px");
            }
        );
        $(".goods4").mouseover(
            function () {
                $(".aside_nav2").css("display","block")
                $(".aside_nav2_4").css("display","block")
                $(".goods4").css("background","#0a427d");
                $(".goods4 span").css("background","url(images/nav_icons.png) no-repeat 0 -323px");
            }
        );
        $(".goods4").mouseout(
            function () {
                $(".aside_nav2").css("display","none")
                $(".aside_nav2_4").css("display","none")
                $(".goods4").css("background","#116fd1");
                $(".goods4 span").css("background","url(images/nav_icons.png) no-repeat 0 -122px");
            }
        );
        $(".goods5").mouseover(
            function () {
                $(".aside_nav2").css("display","block");
                $(".aside_nav2_5").css("display","block");
                $(".goods5").css("background","#0a427d");
                $(".goods5 span").css("background","url(images/nav_icons.png) no-repeat 0 -362px");
            }
        );
        $(".goods5").mouseout(
            function () {
                $(".aside_nav2").css("display","none");
                $(".aside_nav2_5").css("display","none");
                $(".goods5").css("background","#116fd1");
                $(".goods5 span").css("background","url(images/nav_icons.png) no-repeat 0 -159px");
            }
        );
        $(".aside_nav2_1").mouseover(
            function () {
                $(".aside_nav2").css("display","block");
                $(".aside_nav2_1").css("display","block");
                $(".goods1").css("background","#0a427d");
                $(".goods1 span").css("background","url(images/nav_icons.png) no-repeat 0 -201px");
            }
        );
        $(".aside_nav2_1").mouseout(
            function () {
                $(".aside_nav2").css("display","none")
                $(".aside_nav2_1").css("display","none")
                $(".goods1").css("background","#116fd1");
                $(".goods1 span").css("background","url(images/nav_icons.png) no-repeat");
            }
        );
        $(".aside_nav2_2").mouseover(
            function () {
                $(".aside_nav2").css("display","block")
                $(".aside_nav2_2").css("display","block")
                $(".goods2").css("background","#0a427d");
                $(".goods2 span").css("background","url(images/nav_icons.png) no-repeat 0 -240px");
            }
        );
        $(".aside_nav2_2").mouseout(
            function () {
                $(".aside_nav2").css("display","none")
                $(".aside_nav2_2").css("display","none")
                $(".goods2").css("background","#116fd1");
                $(".goods2 span").css("background","url(images/nav_icons.png) no-repeat 0 -40px");
            }
        );
        $(".aside_nav2_3").mouseover(
            function () {
                $(".aside_nav2").css("display","block")
                $(".aside_nav2_3").css("display","block")
                $(".goods3").css("background","#0a427d");
                $(".goods3 span").css("background","url(images/nav_icons.png) no-repeat 0 -283px");
            }
        );
        $(".aside_nav2_3").mouseout(
            function () {
                $(".aside_nav2").css("display","none")
                $(".aside_nav2_3").css("display","none")
                $(".goods3").css("background","#116fd1");
                $(".goods3 span").css("background","url(images/nav_icons.png) no-repeat 0 -83px");
            }
        );
        $(".aside_nav2_4").mouseover(
            function () {
                $(".aside_nav2").css("display","block")
                $(".aside_nav2_4").css("display","block")
                $(".goods4").css("background","#0a427d");
                $(".goods4 span").css("background","url(images/nav_icons.png) no-repeat 0 -323px");
            }
        );
        $(".aside_nav2_4").mouseout(
            function () {
                $(".aside_nav2").css("display","none")
                $(".aside_nav2_4").css("display","none")
                $(".goods4").css("background","#116fd1");
                $(".goods4 span").css("background","url(images/nav_icons.png) no-repeat 0 -122px");
            }
        );
        $(".aside_nav2_5").mouseover(
            function () {
                $(".aside_nav2").css("display","block")
                $(".aside_nav2_5").css("display","block")
                $(".goods5").css("background","#0a427d");
                $(".goods5 span").css("background","url(images/nav_icons.png) no-repeat 0 -362px");
            }
        );
        $(".aside_nav2_5").mouseout(
            function () {
                $(".aside_nav2").css("display","none");
                $(".aside_nav2_5").css("display","none");
                $(".goods5").css("background","#116fd1");
                $(".goods5 span").css("background","url(images/nav_icons.png) no-repeat 0 -159px");
            }
        );
        $("#a5").click(
            function () {
                fun1();
            }
        );
        $("#a6").click(
            function () {
                fun2()
            }
        );
        $("#a7").click(
            function () {
                fun3();
            }
        );
        $("#a5").css({"border":"solid red 1px"});
        $("#a5").val("1");
        function fun1() {
            var x = $("#img1").attr("src");
            $("#bigPic").attr("src",x);
            $("#a5").css({"border":"solid red 1px"});
            $("#a5").val("1");
            $("#a6").val("0");
            $("#a7").val("0");
            $("#a8").val("0");
            $("#a9").val("0");
            $("#a6").css("border","hidden");
            $("#a7").css("border","hidden");
            $("#a8").css("border","hidden");
            $("#a9").css("border","hidden");
        }
        function fun2() {
            var x = $("#img2").attr("src");
            $("#bigPic").attr("src",x);
            $("#a6").css({"border":"solid red 1px"});
            $("#a5").val("0");
            $("#a6").val("1");
            $("#a7").val("0");
            $("#a8").val("0");
            $("#a9").val("0");
            $("#a5").css("border","hidden");
            $("#a7").css("border","hidden");
            $("#a8").css("border","hidden");
            $("#a9").css("border","hidden");
        }
        function fun3() {
            var x = $("#img3").attr("src");
            $("#bigPic").attr("src",x);
            $("#a7").css({"border":"solid red 1px"});
            $("#a5").val("0");
            $("#a6").val("0");
            $("#a7").val("1");
            $("#a8").val("0");
            $("#a9").val("0");
            $("#a6").css({"border":"hidden"});
            $("#a5").css("border","hidden");
            $("#a8").css("border","hidden");
            $("#a9").css("border","hidden");
        }
        $("#a8").click(
            function () {
                fun4();
            }
        );
        function fun4(){
            var x = $("#img4").attr("src");
            $("#bigPic").attr("src",x);
            $("#a8").css({"border":"solid red 1px"});
            $("#a5").val("0");
            $("#a6").val("0");
            $("#a7").val("0");
            $("#a8").val("1");
            $("#a9").val("0");
            $("#a6").css("border","hidden");
            $("#a7").css("border","hidden");
            $("#a5").css("border","hidden");
            $("#a9").css("border","hidden");
        }
        function fun5() {
            var x = $("#img5").attr("src");
            $("#bigPic").attr("src",x);
            $("#a9").css({"border":"solid red 1px"});
            $("#a5").val("0");
            $("#a6").val("0");
            $("#a7").val("0");
            $("#a8").val("0");
            $("#a9").val("1");
            $("#a6").css("border","hidden");
            $("#a7").css("border","hidden");
            $("#a8").css("border","hidden");
            $("#a5").css("border","hidden");
        }
        $("#a9").click(
            function () {
                fun5();
            }
        );
        $(".next").click(
            function () {
                var x1 = $("#a5").val();
                var x2 = $("#a6").val();
                var x3 = $("#a7").val();
                var x4 = $("#a8").val();
                var x5 = $("#a9").val();
                if(x1 == 1){
                    fun2();
                }
                else if(x2 ==1){
                    fun3();
                }
                else if(x3 ==1){
                    fun4();
                }else if(x4 ==1){
                    fun5();
                }else if(x5 ==1){
                    fun1();
                }
            }
        );
        $(".last").click(
            function () {
                var x1 = $("#a5").val();
                var x2 = $("#a6").val();
                var x3 = $("#a7").val();
                var x4 = $("#a8").val();
                var x5 = $("#a9").val();
                if(x1 == 1){
                    fun5();
                }
                else if(x2 ==1){
                    fun1();
                }
                else if(x3 ==1){
                    fun2();
                }else if(x4 ==1){
                    fun3();
                }else if(x5 ==1){
                    fun4();
                }
            }
        );
        $("#menuL1").click(
            function () {
				 $(".productDetails").css("display","block");
               $(".productConsult").css("display","none");
                $(".standard").css("display","none");

                $("#menuL1").css({"border-bottom":"hidden","border-top":"2px solid #0f7ef1"});
                $("#menuL2").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL3").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL4").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL1").css("background","white");
                $("#menuL1").css("border-right","1px solid #d1d1d1");
                $("#menuL2").css("border-right","1px solid white");
                $("#menuL3").css("border-right","1px solid white");
                $("#menuL2").css("background","url(images/shopDetails/sline.png) no-repeat right");
                $("#menuL3").css("background","url(images/shopDetails/sline.png) no-repeat right");
                $("#menuL4").css("background","none");
                $(".comUp").css("display","none");
                $(".comCopy").css("display","none");
				
                $(".zixunMenu").css("border-top","1px solid #d1d1d1");
            }
        );
        $("#menuL2").click(
            function () {
                $(".productDetails").css("display","none");
                $(".standard").css("display","block");

                $("#menuL2").css({"border-bottom":"hidden","border-top":"2px solid #0f7ef1"});
                $("#menuL1").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL3").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL4").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL1").css("border-right","1px solid #d1d1d1");
                $("#menuL2").css("border-right","1px solid #d1d1d1");
                $("#menuL3").css("border-right","1px solid white");
                $("#menuL2").css("background","white");
                $("#menuL1").css("background","none");
                $("#menuL3").css("background","url(images/shopDetails/sline.png) no-repeat right");
                $("#menuL4").css("background","none");
                $(".comUp").css("display","none");
                $(".comCopy").css("display","none");
                $(".zixunMenu").css("border-top","1px solid #d1d1d1");
            }
        );
        $("#menuL3").click(
            function () {
                $(".productDetails").css("display","none");
                $(".standard").css("display","none");

                $("#menuL1").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL2").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL3").css({"border-bottom":"hidden","border-top":"2px solid #0f7ef1"});
                $("#menuL4").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL3").css("border-right","1px solid #d1d1d1");
                $("#menuL1").css("border-right","1px solid white");
                $("#menuL2").css("border-right","1px solid #d1d1d1");
                $("#menuL1").css("background","url(images/shopDetails/sline.png) no-repeat right");
                $("#menuL2").css("background","none");
                $("#menuL3").css("background","white");
                $("#menuL4").css("background","none");
                $(".comUp").css("display","block");
                $(".comCopy").css("display","none");
                $(".zixunMenu").css("border-top","1px solid #d1d1d1");
				$(".productDetails").css("display","none");
            }
        );
        $("#menuL4").click(
            function () {
                $(".productDetails").css("display","none");
                $(".standard").css("display","none");

                $("#menuL4").css({"border-bottom":"hidden","border-top":"2px solid #0f7ef1"});
                $("#menuL2").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL3").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL1").css({"border-bottom":"solid 1px #d1d1d1","border-top":"2px solid #d1d1d1"});
                $("#menuL3").css("border-right","1px solid #d1d1d1");
                $("#menuL1").css("border-right","1px solid white");
                $("#menuL2").css("border-right","1px solid white");
                $("#menuL4").css("background","white");
                $("#menuL2").css("background","url(images/shopDetails/sline.png) no-repeat right");
                $("#menuL3").css("background","none");
                $("#menuL1").css("background","url(images/shopDetails/sline.png) no-repeat right");
                $(".comUp").css("display","none");
                $(".comCopy").css("display","block");
                $(".zixunMenu").css("border-top","none");
				$(".productConsult").css("display","block");
            }
        );
        $(".comL1").click(
            function () {
                $(".commentPage").css("display","block");
                $(".goodCom").css("display","none");
                $(".midCom").css("display","none");
                $(".badCom").css("display","none");
                $(".comL1").css({"background":"white","border-top":"2px #0f7ef1 solid","height":"45px","border-bottom":"1px #d1d1d1 hidden"});
                $(".comL2").css({"background":"url(images/shopDetails/sline.png) no-repeat right","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL3").css({"background":"url(images/shopDetails/sline.png) no-repeat right","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL4").css({"background":"none","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL1").css("border-right","1px solid #d1d1d1");
                $(".comL2").css("border-right","1px solid white");
                $(".comL3").css("border-right","1px solid white");

            }
        );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
        $(".comL2").click(
            function () {
                $(".goodCom").css("display","block");
                $(".commentPage").css("display","none");
                $(".midCom").css("display","none");
                $(".badCom").css("display","none");
                $(".comL2").css({"background":"white","border-top":"2px #0f7ef1 solid","height":"45px","border-bottom":"1px #d1d1d1 hidden"});
                $(".comL1").css({"background":"none","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL3").css({"background":"url(images/shopDetails/sline.png) no-repeat right","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL4").css({"background":"none","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL1").css("border-right","1px solid #d1d1d1");
                $(".comL2").css("border-right","1px solid #d1d1d1");
                $(".comL3").css("border-right","1px solid white");

            }
        );
        $(".comL3").click(
            function () {
                $(".midCom").css("display","block");
                $(".goodCom").css("display","none");
                $(".commentPage").css("display","none");
                $(".badCom").css("display","none");
                $(".comL3").css({"background":"white","border-top":"2px #0f7ef1 solid","height":"45px","border-bottom":"1px #d1d1d1 hidden"});
                $(".comL2").css({"background":"none","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL1").css({"background":"url(images/shopDetails/sline.png) no-repeat right","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL4").css({"background":"none","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL1").css("border-right","1px solid white");
                $(".comL2").css("border-right","1px solid #d1d1d1");
                $(".comL3").css("border-right","1px solid #d1d1d1");

            }
        );
        $(".comL4").click(
            function () {
                $(".badCom").css("display","block");
                $(".goodCom").css("display","none");
                $(".midCom").css("display","none");
                $(".commentPage").css("display","none");
                $(".comL4").css({"background":"white","border-top":"2px #0f7ef1 solid","height":"45px","border-bottom":"1px #d1d1d1 hidden"});
                $(".comL2").css({"background":"url(images/shopDetails/sline.png) no-repeat right","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL3").css({"background":"none","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL1").css({"background":"url(images/shopDetails/sline.png) no-repeat right","border-top":"2px solid #d1d1d1","border-bottom":"1px #d1d1d1 solid"});
                $(".comL1").css("border-right","1px solid white");
                $(".comL2").css("border-right","1px solid white");
                $(".comL3").css("border-right","1px solid #d1d1d1");

            }
        );
        $("#div1").click(
            function () {
                $("#div1").css({"border":"#d50900 1px solid"});
                $("#div2").css({"border":"#d1d1d1 1px solid"});
                $("#div3").css({"border":"#d1d1d1 1px solid"});
                var x =$("#div1").html();
                $("#hidInp").val(x);
            }
        );
        $("#div2").click(
            function () {
                $("#div2").css({"border":"#d50900 1px solid"});
                $("#div1").css({"border":"#d1d1d1 1px solid"});
                $("#div3").css({"border":"#d1d1d1 1px solid"});
                var x =$("#div2").html();
                $("#hidInp").val(x);
            }
        );
        $("#div3").click(
            function () {
                $("#div3").css({"border":"#d50900 1px solid"});
                $("#div2").css({"border":"#d1d1d1 1px solid"});
                $("#div1").css({"border":"#d1d1d1 1px solid"});
                var x =$("#div3").html();
                $("#hidInp").val(x);
            }
        );

        $("#sub").click(
            function () {
                var x = document.ff.input1.value;
                if(x > 0){
                    x = x - 1;
                    document.ff.input1.value = x;
                }
                else{
                    alert("最小为0。");
                }
            }
        );
        $("#plus").click(
            function () {
                var x = document.ff.input1.value;
                x = parseInt(x,10);
                x = x + 1;
                document.ff.input1.value = x;
            }
        );
        $("#page2").click(
            function () {
                $("#page2").removeClass("onePage");
                $("#page2").addClass("onPage");
                $("#page1").removeClass("onPage");
                $("#page1").addClass("onePage");
                $("#last1").css("display","block");
            }
        );
        $("#last1").click(
            function () {
                var x = $("#page1").text();
                var y = $("#page2").text();
                var z = $("#page3").text();
                if(x == 1){
                    $("#page1").removeClass("onePage");
                    $("#page1").addClass("onPage");
                    $("#page2").removeClass("onPage");
                    $("#page2").addClass("onePage");
                    $("#last1").css("display","none");
                }
                else{
                    x = x - 1;
                    y = y - 1;
                    z = z - 1;
                    $("#page1").text(x);
                    $("#page2").text(y);
                    $("#page3").text(z);
                }
            }
        );
        $("#last2").click(
            function () {
                var x = $("#page4").text();
                var y = $("#page5").text();
                var z = $("#page6").text();
                if(x == 1){
                    $("#page4").removeClass("onePage");
                    $("#page4").addClass("onPage");
                    $("#page5").removeClass("onPage");
                    $("#page5").addClass("onePage");
                    $("#last2").css("display","none");
                }
                else{
                    x = x - 1;
                    y = y - 1;
                    z = z - 1;
                    $("#page4").text(x);
                    $("#page5").text(y);
                    $("#page6").text(z);
                }
            }
        );
        $("#last4").click(
            function () {
                var x = $("#page10").text();
                var y = $("#page11").text();
                var z = $("#page12").text();
                if(x == 1){
                    $("#page10").removeClass("onePage");
                    $("#page10").addClass("onPage");
                    $("#page11").removeClass("onPage");
                    $("#page11").addClass("onePage");
                    $("#last4").css("display","none");
                }
                else{
                    x = x - 1;
                    y = y - 1;
                    z = z - 1;
                    $("#page10").text(x);
                    $("#page11").text(y);
                    $("#page12").text(z);
                }
            }
        );
        $("#next1").click(
            function () {
                var x = $("#page1").text();
                var y = $("#page2").text();
                var z = $("#page3").text();
                x = parseInt(x,10);
                y = parseInt(y,10);
                z = parseInt(z,10);
                x = x + 1;
                y = y + 1;
                z = z + 1;
                var a = $("#last1").css("display");
                if(a == "none"){
                    $("#page2").removeClass("onePage");
                    $("#page2").addClass("onPage");
                    $("#page1").removeClass("onPage");
                    $("#page1").addClass("onePage");
                    $("#last1").css("display","block");
                }
                else{
                $("#page1").text(x);
                $("#page2").text(y);
                $("#page3").text(z);
                $("#last1").css("display","block");
                $("#page2").removeClass("onePage");
                $("#page2").addClass("onPage");
                $("#page1").removeClass("onPage");
                $("#page1").addClass("onePage");
                }
            }
        );
        $("#next2").click(
            function () {
                var x = $("#page4").text();
                var y = $("#page5").text();
                var z = $("#page6").text();
                x = parseInt(x,10);
                y = parseInt(y,10);
                z = parseInt(z,10);
                x = x + 1;
                y = y + 1;
                z = z + 1;
                var a = $("#last2").css("display");
                if(a == "none"){
                    $("#page5").removeClass("onePage");
                    $("#page5").addClass("onPage");
                    $("#page4").removeClass("onPage");
                    $("#page4").addClass("onePage");
                    $("#last2").css("display","block");
                }
                else{
                    $("#page4").text(x);
                    $("#page5").text(y);
                    $("#page6").text(z);
                    $("#last2").css("display","block");
                    $("#page5").removeClass("onePage");
                    $("#page5").addClass("onPage");
                    $("#page4").removeClass("onPage");
                    $("#page4").addClass("onePage");
                }
            }
        );
        $("#next4").click(
            function () {
                var x = $("#page10").text();
                var y = $("#page11").text();
                var z = $("#page12").text();
                x = parseInt(x,10);
                y = parseInt(y,10);
                z = parseInt(z,10);
                x = x + 1;
                y = y + 1;
                z = z + 1;
                var a = $("#last4").css("display");
                if(a == "none"){
                    $("#page11").removeClass("onePage");
                    $("#page11").addClass("onPage");
                    $("#page10").removeClass("onPage");
                    $("#page10").addClass("onePage");
                    $("#last4").css("display","block");
                }
                else{
                    $("#page10").text(x);
                    $("#page11").text(y);
                    $("#page12").text(z);
                    $("#last4").css("display","block");
                    $("#page11").removeClass("onePage");
                    $("#page11").addClass("onPage");
                    $("#page10").removeClass("onPage");
                    $("#page10").addClass("onePage");
                }
            }
        );
        $("#page1").click(
            function () {
                var x = $("#page1").text();
                var y = $("#page2").text();
                var z = $("#page3").text();
                if(x == 1){
                    $("#page1").removeClass("onePage");
                    $("#page1").addClass("onPage");
                    $("#page2").removeClass("onPage");
                    $("#page2").addClass("onePage");
                    $("#last1").css("display","none");
                }
                else{
                    x = x - 1;
                    y = y - 1;
                    z = z - 1;
                    $("#page1").text(x);
                    $("#page2").text(y);
                    $("#page3").text(z);
                }
            }
        );
        $("#page3").click(
            function () {
                var x = $("#page1").text();
                var y = $("#page2").text();
                var z = $("#page3").text();
                x = parseInt(x,10);
                y = parseInt(y,10);
                z = parseInt(z,10);
                x = x + 1;
                y = y + 1;
                z = z + 1;
                $("#page1").text(x);
                $("#page2").text(y);
                $("#page3").text(z);
                $("#last1").css("display","block");
                $("#page2").removeClass("onePage");
                $("#page2").addClass("onPage");
                $("#page1").removeClass("onPage");
                $("#page1").addClass("onePage");
            }
        );
        $("#page4").click(
            function () {
                var x = $("#page4").text();
                var y = $("#page5").text();
                var z = $("#page6").text();
                if(x == 1){
                    $("#page4").removeClass("onePage");
                    $("#page4").addClass("onPage");
                    $("#page5").removeClass("onPage");
                    $("#page5").addClass("onePage");
                    $("#last2").css("display","none");
                }
                else{
                    x = x - 1;
                    y = y - 1;
                    z = z - 1;
                    $("#page4").text(x);
                    $("#page5").text(y);
                    $("#page6").text(z);
                }
            }
        );
        $("#page5").click(
            function () {
                $("#page5").removeClass("onePage");
                $("#page5").addClass("onPage");
                $("#page4").removeClass("onPage");
                $("#page4").addClass("onePage");
                $("#last2").css("display","block");
            }
        );
        $("#page6").click(
            function () {
                var x = $("#page4").text();
                var y = $("#page5").text();
                var z = $("#page6").text();
                x = parseInt(x,10);
                y = parseInt(y,10);
                z = parseInt(z,10);
                x = x + 1;
                y = y + 1;
                z = z + 1;
                $("#page4").text(x);
                $("#page5").text(y);
                $("#page6").text(z);
                $("#last2").css("display","block");
                $("#page5").removeClass("onePage");
                $("#page5").addClass("onPage");
                $("#page4").removeClass("onPage");
                $("#page4").addClass("onePage");
            }
        );
        $("#page10").click(
            function () {
                var x = $("#page10").text();
                var y = $("#page11").text();
                var z = $("#page12").text();
                if(x == 1){
                    $("#page10").removeClass("onePage");
                    $("#page10").addClass("onPage");
                    $("#page11").removeClass("onPage");
                    $("#page11").addClass("onePage");
                    $("#last4").css("display","none");
                }
                else{
                    x = x - 1;
                    y = y - 1;
                    z = z - 1;
                    $("#page10").text(x);
                    $("#page11").text(y);
                    $("#page12").text(z);
                }
            }
        );
        $("#page11").click(
            function () {
                $("#page11").removeClass("onePage");
                $("#page11").addClass("onPage");
                $("#page10").removeClass("onPage");
                $("#page10").addClass("onePage");
                $("#last4").css("display","block");
            }
        );
        $("#page12").click(
            function () {
                var x = $("#page10").text();
                var y = $("#page11").text();
                var z = $("#page12").text();
                x = parseInt(x,10);
                y = parseInt(y,10);
                z = parseInt(z,10);
                x = x + 1;
                y = y + 1;
                z = z + 1;
                $("#page10").text(x);
                $("#page11").text(y);
                $("#page12").text(z);
                $("#last4").css("display","block");
                $("#page11").removeClass("onePage");
                $("#page11").addClass("onPage");
                $("#page10").removeClass("onPage");
                $("#page10").addClass("onePage");
            }
        );
        var text1 = $("#titleP").text();
        if(text1 == ""){
            $("#titleH2").css("line-height","35px");
        }
        /*店铺没保*/
        if(0){
            $(".title").css({"padding-left":"0px","background":"url()"})
        }
        var display1 = $("#youHui").css("display");
        if(display1 == "none"){
            $(".salesPro").css("margin-top","30px");
        }
        var shouCang = 0;
        $(".span2").click(
            function (){
                shouCang = 1;
                $(".span2").text("已收藏");
                $(".span2").css("background","url()");
                $(".span2").css("cursor","default");
            }
        )
        if(shouCang == 1){
            $(".span2").css("background","url()");
            $(".span2").text("已收藏");
            $(".span2").css("cursor","default");
        }
        /*$(".share").mouseover(
            function () {
                $(".share1").css("display","block");
            }
        );
        $(".share").mouseout(
            function () {
                $(".share1").css("display","none");
            }
        );*/
        window.onload = function () {
            menuFix();
        };
        function menuFix(){
            var obj = document.getElementById("menuFix");
            var menuFixTop = obj.offsetTop+1;
            window.onscroll = function () {
                changePos(menuFixTop);
            };
        }
        function changePos(height){
            var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
            if(scrollTop<height){
                $("#menuFix").css("position","relative");
            }else
            {
                $("#menuFix").css("position","fixed");
                $("#menuFix").css("top","0");
            }
        }


        function timer()
        {
            var ts = (new Date(2018, 11, 11, 9, 0, 0)) - (new Date());//计算剩余的毫秒数
            var dd = parseInt(ts / 1000 / 60 / 60 / 24, 10);//计算剩余的天数
            var hh = parseInt(ts / 1000 / 60 / 60 % 24, 10);//计算剩余的小时数
            var mm = parseInt(ts / 1000 / 60 % 60, 10);//计算剩余的分钟数
            var ss = parseInt(ts / 1000 % 60, 10);//计算剩余的秒数
            var ms = parseInt(ts /100 %10,10);
            dd = checkTime(dd);
            hh = checkTime(hh);
            mm = checkTime(mm);
            ss = checkTime(ss);
            $(".day1").html(dd);
            $(".hour1").html(hh);
            $(".minute1").html(mm);
            $(".second1").html(ss);
            $(".second2").html(ms);
        }
        function checkTime(i)
        {
            if (i < 10) {
                i = "0" + i;
            }
            return i;
        }
        setInterval(timer,100);
        $(".zixunMenu li").click(
            function () {
                $(".zixunMenu li").css("color","#666666");
                $(this).css("color","#0f7ef1");
            }
        );
        $(".zixunQue").click(
            function () {
                $(".pop_up").css("display","block");
            }
        );
        $(".forClose").click(
            function () {
                $(".pop_up").css("display","none");
            }
        );
        $(".span1").click(
            function () {
                $(".share1").css("display","block");
            }
        );
        $(".shareTitle b").click(
            function () {
                $(".share1").css("display","none");
            }
        );
    }
);

