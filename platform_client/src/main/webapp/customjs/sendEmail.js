/**
 * Created by gaopengju on 2017/1/6.
 */
//发送验证码
var countdown = 0;
$(function () {
    $("#sendVerifyCode").bind("click", function () {
        var urlStr = "/platform/email/sendVerifyCode";
        var email = $("#email").val();
        var sendType = $("input[name=sendType]").val();
        if (email == null || email == "") {
            $(this).removeAttr("type","button");
            $("#sendVerifyCode").removeAttr("disabled");
            return;
        }else{
            $(this).attr("type","button");
        }
        countdown=60;
        settime($(this));
        $.ajax({
            type: "POST",
            url: urlStr,
            data: {"email": email,"sendType":sendType},
            cache: false,
            async: false,
            dataType: "json",
            success: function (data) {
                var code = data.code;
                var message = data.message;
                if (code == 200) {
                    $("#errorMsg").html("邮件发送成功，请前往查询");
                    $("#error-modal-dialog").modal("show");
                } else {
                    $("#errorMsg").html(message);
                    $("#error-modal-dialog").modal("show");
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $("#errorMsg").html("网络异常");
                $("#error-modal-dialog").modal("show");
            }
        });
    });


    function settime(obj) { //发送验证码倒计时
        if (countdown == 0) {
            obj.attr('disabled',false);
            obj.html("获取验证码");
            countdown = 60;
            return;
        } else {
            obj.attr('disabled',true);
            obj.html("重新发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(function() {
                settime(obj) }
            ,1000)
    }
})

