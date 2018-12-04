/**
 * Created by Jeff on 2015/5/19.
 */

$(
    function () {
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
        $("#page2").click(
            function () {
                $("#page2").removeClass("onePage");
                $("#page2").addClass("onPage");
                $("#page1").removeClass("onPage");
                $("#page1").addClass("onePage");
                $("#last1").css("display","block");
            }
        );
        $(".pubKind li").click(
            function () {
                $(".pubKind li").css("background","url(images/ask/icon.png) no-repeat left");
                $(this).css("background","url(images/ask/icon1.png) no-repeat left");
            }
        );
        var right = 0;
        $(".advByMes").click(
            function () {
                if(right == 0){
                    $(this).css("background","url(images/ask/wrong.png) no-repeat left");
                    right = 1;
                }
                else{
                    $(this).css("background","url(images/ask/right.png) no-repeat left");
                    right = 0;
                }
            }
        );
     //   document.getElementById('search2').value='请输入关键字';
   //     document.getElementById('search2').style.color = '#dadada';
       // document.getElementById('search2').onfocus = function(){
//            if(document.getElementById('search2').value=='请输入关键字'){
//                document.getElementById('search2').value= '';
//                document.getElementById('search2').style.color = '#000';
//            }
//        };
  //      document.getElementById('search2').onblur = function(){
//            if(document.getElementById('search2').value==''){
//                document.getElementById('search2').value= '请输入关键字';
//                document.getElementById('search2').style.color = '#dadada';
//            }
//        };
    }
);