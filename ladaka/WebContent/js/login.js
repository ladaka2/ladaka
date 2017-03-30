$(document).ready(function() {
	var userType = $(":input:radio[name=find_type]:checked").val();
	console.log(userType);

	$("input[name=find_type]").change(function() {
		var userType2 = $(this).val();
		console.log(userType2);

		if (userType2 == "사업자회원") {
			$("#userNormal").css("display", "none");
			$("#userBusiness").css("display", "block");
			$("#goRegistDiv").css("display", "none");
			$("#goRegist2Div").css("display", "block");
		} else {
			$("#userNormal").css("display", "block");
			$("#userBusiness").css("display", "none");
			$("#goRegistDiv").css("display", "block");
			$("#goRegist2Div").css("display", "none");
		}

		// input 초기화
		$('#user_email').val('');
		$('#user_pw').val('');
		$('#business_num1').val('');
		$('#user_pw2').val('');
	})

	//이메일 입력방식 선택
	$('#selectEmail').change(function() {
		$("#selectEmail option:selected").each(function() {
			if ($(this).val() == '1') { //직접입력일 경우
				$("#str_email").val(''); //값 초기화
				$("#str_email").attr("disabled", false); //활성화
			} else { //직접입력이 아닐경우
				$("#str_email").val($(this).text()); //선택값 입력
				$("#str_email").attr("disabled", true); //비활성화
			}
		});
	});

	$("#back").click(function() {
		back();
	})

	$("#findPw").click(function() {
		window.open("http://localhost:8080/ladaka/findPw", "_self");
	})

	$("#goRegist").click(function() {
		window.open("http://localhost:8080/ladaka/goRegist", "_self");
	})
	
	$("#goRegist2").click(function() {
		window.open("http://localhost:8080/ladaka/goRegist2", "_self");
	})

});

function login() {
	userType = $(":input:radio[name=find_type]:checked").val();

	if (userType == "개인회원") {
		nullCheck();
	} else {
		nullCheck2();
	}
}

function nullCheck() {
	var email = $('#user_email').val();
	var pw = $('#user_pw').val();
	if (email == '') {
		alert("email null");
		$('#user_email').focus();
		return;
	} else if (pw == '') {
		alert("pw null");
		$('#user_pw').focus();
		return;
	} else if (pw.length < 4) {
		alert("비밀번호 4자이상");
		$('#user_pw').focus();
		return;
	} else {
		console.log("http://localhost:8080/ladaka/login?" + email + "&" + pw);
		//	window.open("http://localhost:8080/ladaka/login?" + email + "&" + pw);
		searchUser();
	}
}

function nullCheck2() {
	var business_num1 = $('#business_num1').val();
	var business_num2 = $('#business_num2').val();
	var pw = $('#user_pw2').val();
	if (business_num1 == '' || business_num1.length < 10) {
		alert("business_num1 null");
		$('#business_num1').focus();
		return;
	} else if (business_num2 == ''  || business_num2.length < 2) {
		alert("business_num2 null");
		$('#business_num2').focus();
		return;
	} else if (pw == '') {
		alert("pw null");
		$('#user_pw2').focus();
		return;
	} else if (pw.length < 4) {
		alert("비밀번호 4자이상");
		$('#user_pw2').focus();
		return;
	} else {
		console.log("http://localhost:8080/ladaka/login?" + business_num1 + "&" + business_num2);
		//	window.open("http://localhost:8080/ladaka/login?" + business_num1 + "&" + business_num2);
		searchUser2();
	}
}

function searchUser() {
	// 일반 회원정보 조회
	$.ajax({
		type : "POST",
		url : "/ladaka/userLogin",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		dataType : "json",
		async : false,
		error : function(xhr, status, error) {
			console.log("ajax error code:" + xhr.status);
		},
		success : function(data) {
			console.log(data.list[0].item.EMAIL);
			console.log(data.list[0].item.PSWORD);

			var userEmail = data.list[0].item.EMAIL;
			var userPsword = data.list[0].item.PSWORD;

			var email = $('#user_email').val() + "@" + $('#str_email').val()
			var pw = $('#user_pw').val();

			if (email == userEmail && pw == userPsword) {
				window.open("http://localhost:8080/ladaka/goHome", "_self");
				return;
			} else {
				alert("로그인실패");
				return;
			}
		}
	});
}

function searchUser2() {
	// 사업자 회원정보 조회
	$.ajax({
		type : "POST",
		url : "/ladaka/userLogin2",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		dataType : "json",
		async : false,
		error : function(xhr, status, error) {
			console.log("ajax error code:" + xhr.status);
		},
		success : function(data) {
			console.log(data.list[0].item.REGIST_NUM);
			console.log(data.list[0].item.PSWORD);
			
			var userRegistNum = data.list[0].item.REGIST_NUM;
			var userPsword = data.list[0].item.PSWORD;
			
			var registNum = $('#business_num1').val() + "-" + $('#business_num2').val()
			var pw = $('#user_pw2').val();
			
			if (registNum == userRegistNum && pw == userPsword) {
				window.open("http://localhost:8080/ladaka/goHome", "_self");
				return;
			} else {
				alert("로그인실패");
				return;
			}
		}
	});
}
