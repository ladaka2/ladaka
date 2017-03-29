/* login.js */
$(document).ready(function() {
	var userType = $(":input:radio[name=find_type]:checked").val();
	console.log(userType);

	$("input[name=find_type]").change(function() {
		var userType2 = $(this).val();
		console.log(userType2);

		if (userType2 == "사업자회원") {
			$("#userNormal").css("display", "none");
			$("#userBusiness").css("display", "block");
		} else {
			$("#userNormal").css("display", "block");
			$("#userBusiness").css("display", "none");
		}

		$('.user_email').val('');
		$('.user_pw').val('');

	})

	$("#back").click(function() {
		alert("뒤로");
	})

	$("#findPw").click(function() {
		alert("비밀번호찾기");
	})

	$("#goRegist").click(function() {
		alert("회원가입");
	})

});

function login() {
	userType = $(":input:radio[name=find_type]:checked").val();

	if (userType == "개인회원") {
		var email = $('#user_email').val();
		var pw = $('#user_pw').val();
	} else {
		var email = $('#user_email2').val();
		var pw = $('#user_pw2').val();
	}

	alert("http://localhost:8080/ladaka/login?" + email + "&" + pw);
	//	window.open("http://localhost:8080/ladaka/login?" + email + "&" + pw);

	// 회원정보 조회
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/ladaka/userLogin",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		async : false,
		error : function() {
			alert("ajax error");
		},
		success : function(result) {
			console.log(result);
		}

	});

	$('#user_email').val('');
	$('#user_pw').val('');
	$('#user_email2').val('');
	$('#user_pw2').val('');
}
