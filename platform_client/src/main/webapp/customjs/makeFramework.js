/**
 * Created by kris on 2016/12/30.
 */
$(function () {
    $("li button").bind("click",function () {
        var name = $(this).attr("name");
        location.href = "/platform/framework/gotoMakePage?type="+name;
    });
    //未登陆提示登陆然后跳转
    $("#alterBtn").bind("click",function(){
        //$("form").submit();
    })
});
