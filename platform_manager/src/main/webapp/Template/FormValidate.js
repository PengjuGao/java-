$("#registerForm").validate({
		rules : {
			phone: {
				required: true,
				regex:"^(((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))+\\d{8})$",
				remote: {
					url: "/register/check_user", 
					type: "post",
					dataType : "json", 
					data: { phone: function(){ return $("#phone").val()}}
				}
			}
		},
		messages: {
			phone: {
				required: "请输入手机号",
				regex: "手机号格式不正确",
				remote : $.format("手机号被占用,请重新输入")
			}
		},
		errorPlacement: function(error, element) {
			var errorText = error.text();
			if(element.attr("name")=="contactCode"){
				var hint = '<font color="red">'+errorText+'</font>';
				$("#smsMsg").html(hint);
				return false;
				}

			
			if(errorText.length>0){
				element.parent().children(".msg-tips").html("<label style='color:red'>"+errorText+"</label>");
			}else{
				$("#smsMsg").html("");
				element.parent().children(".msg-tips").html("");
			}
		},
		success:function(element){
			if(element.attr("name")=="managerId"){
				element.parent().children(".msg-tips").html("");
				return false;
				}
	    },
		submitHandler : function(form){
			$("#btnRegister").prop("disabled",true);
			var url = $('#registerForm').attr("action");
		    var data= $('#registerForm').serialize();
			$.ajax({
				type: 'POST',
				url: url,
				data: data,
				dataType: "json",
				success: function(result){
					if(result.errorCode){
						if(result.errorCode==60101){
							alertMsg(result.message);
						}else{
							alertMsg("提交注册信息有误，请重试！");
						}
						$("#btnRegister").prop("disabled",false);
						return false;
					} else {
						$("#userName").val(result.userName);
						$("#btnRegister").css("display","block");
						$("#form4Submit").attr("action","/authuser/showAuthUserPage");
						$("#form4Submit").attr("method","post");
						$("#form4Submit").submit();
					}
					return false;
				}
			});
		}
	});