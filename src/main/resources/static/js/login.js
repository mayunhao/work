$(function() {
	/*
	 * 1. 让登录按钮在得到和失去焦点时切换图片
	 */
	$("#submit").hover(
		function() {
			$("#submit").attr("src", "/goods/images/login2.jpg");
		},
		function() {
			$("#submit").attr("src", "/goods/images/login1.jpg");
		}
	);
	
	/*
	 * 2. 给注册按钮添加submit()事件，完成表单校验
	 */
	$("#submit").submit(function(){
		$("#msg").text("");
		var bool = true;
		$(".input").each(function() {
			var inputName = $(this).attr("name");
			if(!invokeValidateFunction(inputName)) {
				bool = false;
			}
		});
		return bool;
	});
	
	/*
	 * 3. 输入框得到焦点时隐藏错误信息
	 */
	$(".input").focus(function() {
		var inputName = $(this).attr("name");
		$("#" + inputName + "Error").css("display", "none");
	});
	
	/*
	 * 4. 输入框推动焦点时进行校验
	 */
	$(".input").blur(function() {
		var inputName = $(this).attr("name");
		invokeValidateFunction(inputName);
	})
});

/*
 * 输入input名称，调用对应的validate方法。
 * 例如input名称为：loginname，那么调用validateLoginname()方法。
 */
function invokeValidateFunction(inputName) {
	if(validateusername() == true ){
//		console.log("SSSSSSSSS");
		inputName = inputName.substring(0, 1).toUpperCase() + inputName.substring(1);
		var functionName = "validate" + inputName;
		return "(" + functionName + ")";	
	}
	
	if(validateuserpwd() == true ){
//		console.log("SSSSSSSSS");
		inputName = inputName.substring(0, 1).toUpperCase() + inputName.substring(1);
		var functionName = "validate" + inputName;
		return "(" + functionName + ")";	
	}
}

/*
 * 校验登录名
 */
function validateusername() {
//	console.log("XXXXXXXXX");
	var bool = true;
	$("#usernameerror").css("display", "none");
	var value = $("#username").val();
	if(!value) {// 非空校验
		$("#usernameerror").css("display", "");
		$("#usernameerror").text("用户名不能为空！");
		bool = false;
	} else if(value.length < 3 || value.length > 20) {//长度校验
		$("#usernameerror").css("display", "");
		$("#usernameerror").text("用户名长度必须在3 ~ 20之间！");
		bool = false;
	}
	console.log(bool);
	return bool;
}

/*
 * 校验密码
 */
function validateuserpwd() {
	var bool = true;
	$("#userpwderror").css("display", "none");
	var value = $("#userpwd").val();
	if(!value) {// 非空校验
		$("#userpwderror").css("display", "");
		$("#userpwderror").text("密码不能为空！");
		bool = false;
	} else if(value.length < 3 || value.length > 20) {//长度校验
		$("#userpwderror").css("display", "");
		$("#userpwderror").text("密码长度必须在3 ~ 20之间！");
		bool = false;
	}
	console.log(bool);
	return bool;
}

/*
 * 校验验证码
 */
function validateVerifyCode() {
	var bool = true;
	$("#verifyCodeError").css("display", "none");
	var value = $("#verifyCode").val();
	if(!value) {//非空校验
		$("#verifyCodeError").css("display", "");
		
		$("#verifyCodeError").text("验证码不能为空！");
		bool = false;
	} else if(value.length != 4) {//长度不为4就是错误的
		$("#verifyCodeError").css("display", "");
		$("#verifyCodeError").text("错误的验证码！");
		bool = false;
	} else {//验证码是否正确
		$.ajax({
			cache: false,
			async: false,
			type: "POST",
			dataType: "json",
			data: {method: "ajaxValidateVerifyCode", verifyCode: value},
			url: "/goods/UserServlet",
			success: function(flag) {
				if(!flag) {
					$("#verifyCodeError").css("display", "");
					$("#verifyCodeError").text("错误的验证码！");
					bool = false;					
				}
			}
		});
	}
	return bool;
}
