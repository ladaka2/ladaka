$(document).ready(function() {
	// facebook
	// Load the Facebook JS SDK Asynchronously
	(function(d) {
		var js, id = 'facebook-jssdk';
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement('script');
		js.id = id;
		js.async = true;
		js.src = "//connect.facebook.net/en_US/all.js";
		d.getElementsByTagName('head')[0].appendChild(js);
	}(document));

	window.fbAsyncInit = function() {
		FB.init({
			appId : 424443167912242,
			cookie : true, // enable cookies to allow the server to access 
			// the session
			xfbml : true, // parse social plugins on this page
			version : 'v2.1' // use version 2.1
		});
	};
	
	//kakaotalk
	Kakao.init("b2e018ab90ee0932951d915ff01ee80d");
	
	var userType = $(":input:radio[name=find_type]:checked").val();
	console.log(userType);

	$("input[name=find_type]").change(function() {
		var userType2 = $(this).val();
		console.log(userType2);

		if (userType2 == "사업자회원") {
			$("#fblogin").css("display", "none");
			$("#kakaologin").css("display", "none");
			$("#userNormal").css("display", "none");
			$("#userBusiness").css("display", "block");
			$("#goRegistDiv").css("display", "none");
			$("#goRegist2Div").css("display", "block");
		} else {
			$("#fblogin").css("display", "block");
			$("#kakaologin").css("display", "block");
			$("#userNormal").css("display", "block");
			$("#userBusiness").css("display", "none");
			$("#goRegistDiv").css("display", "block");
			$("#goRegist2Div").css("display", "none");
		}

		// input 초기화
		$('#user_email').val('');
		$('#user_pw').val('');
		$('#business_num1').val('');
		$('#business_num2').val('');
		$('#user_pw2').val('');
	})

	// 이메일 입력방식 선택
	$('#selectEmail').change(function() {
		$("#selectEmail option:selected").each(function() {
			if ($(this).val() == '1') { // 직접입력일 경우
				$("#str_email").val(''); // 값 초기화
				$("#str_email").attr("disabled", false); // 활성화
			} else { // 직접입력이 아닐경우
				$("#str_email").val($(this).text()); // 선택값 입력
				$("#str_email").attr("disabled", true); // 비활성화
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
		window.open("http://localhost:8080/ladaka/goRegist3", "_self");
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

function facebooklogin() {
	FB.getLoginStatus(function(response) {
		console.log(response);
		console.log(response.status);
		
		if (response.status == "connected") {
			alert("이미 페이스북 로그인 됨");
			$("#fbLoginValue").val(response.status);
//			window.open("http://localhost:8080/ladaka/home?fbLoginValue=" + response.status, "_self");
			window.open("http://localhost:8080/ladaka/home", "_self");
		} else if (response.status == "unknown") {
			FB.login(function(response) {
				console.log(response);
				console.log(response.status);
				if (response.status == "connected") {
					alert("페이스북 로그인 했습니다.");
					window.open("http://localhost:8080/ladaka/home", "_self");
				} else {
					// nothing
				}
			});
		}
	});
	
};

function getKakaotalkUserProfile(){
	Kakao.API.request({
		url: '/v1/user/me',
		success: function(res) {
			$("#kakao-profile").append(res.properties.nickname);
			$("#kakao-profile").append($("<img/>",{"src":res.properties.profile_image,"alt":res.properties.nickname+"님의 프로필 사진"}));
		},
		fail: function(error) {
			console.log(error);
		}
	});
}
function createKakaotalkLogin(){
		Kakao.Auth.login({
			persistAccessToken: true,
			persistRefreshToken: true,
			success: function(authObj) {
				getKakaotalkUserProfile();
				createKakaotalkLogout();
			},
			fail: function(err) {
				console.log(err);
			}
		});
}
function createKakaotalkLogout(){
	$("#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn").remove();
	var logoutBtn = $("<a/>",{"class":"kakao-logout-btn","text":"로그아웃"});
	logoutBtn.click(function(){
		Kakao.Auth.logout();
		createKakaotalkLogin();
		$("#kakao-profile").text("");
	});
	$("#kakao-logged-group").prepend(logoutBtn);
	
	if(Kakao.Auth.getRefreshToken()!=undefined&&Kakao.Auth.getRefreshToken().replace(/ /gi,"")!=""){
		createKakaotalkLogout();
		getKakaotalkUserProfile();
	}else{
		createKakaotalkLogin();
	}
}

// kakaotalk login

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
		// window.open("http://localhost:8080/ladaka/login?" + email + "&" +
		// pw);
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
	} else if (business_num2 == '' || business_num2.length < 2) {
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
		// window.open("http://localhost:8080/ladaka/login?" + business_num1 +
		// "&" + business_num2);
		searchUser2();
	}
}

function searchUser() {
	var param = {};
	var imsi1 = $('#user_email').val() + "@" + $('#str_email').val();
	var imsi2 = $('#user_pw').val();
	param = {};
	param.emailImsi = imsi1;
	param.pwImsi = imsi2;

	// 일반 회원정보 조회
	$.ajax({
		type : "POST",
		url : "/ladaka/userLogin",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : param,
		dataType : "json",
		async : false,
		error : function(xhr, status, error) {
			console.log("ajax error code:" + xhr.status);
		},
		success : function(data) {
			if (typeof data.list[0] != "undefined") {
				var userEmail = data.list[0].EMAIL;
				var userPsword = data.list[0].PSWORD;

				var email = $('#user_email').val() + "@" + $('#str_email').val()
				var pw = $('#user_pw').val();

				if (email == userEmail && pw == userPsword) {
					window.open("http://localhost:8080/ladaka/home", "_self");
					return;
				} else {
					alert("error");
					return;
				}
				
			} else {
				alert("로그인정보 확인해주세요.");
			}
			
		}
	});
}

function searchUser2() {
	var param = {};
	var imsi1 = $('#business_num1').val() + "-" + $('#business_num2').val();
	var imsi2 = $('#user_pw2').val();
	param = {};
	param.registNumImsi = imsi1;
	param.pwImsi = imsi2;

	// 사업자 회원정보 조회
	$.ajax({
		type : "POST",
		// url : "/ladaka/userLogin2",
		url : "/ladaka/userLogin3",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
		data : param,
		dataType : "json",
		async : false,
		error : function(xhr, status, error) {
			console.log("ajax error code:" + xhr.status);
		},
		success : function(data) {
			if (typeof data.list[0] != "undefined") {
				var userRegistNum = data.list[0].REGIST_NUM;
				var userPsword = data.list[0].PSWORD;

				var registNum = $('#business_num1').val() + "-" + $('#business_num2').val()
				var pw = $('#user_pw2').val();

				if (registNum == userRegistNum && pw == userPsword) {
					window.open("http://localhost:8080/ladaka/home", "_self");
					return;
				} else {
					alert("error");
					return;
				}
			} else {
				alert("로그인정보 확인해주세요.");
			}

		}
	});
}
