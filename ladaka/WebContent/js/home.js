$(document).ready(function() {
	console.log("loginType : ", loginType);
	console.log("email : ", email);
	console.log("registNum : ", registNum);
	
	// loginType 화면 분기화
	if (loginType == "non") { // 미로그인
		$(".userinfo").css("display", "none");
		$("#email").css("display", "none");
		$("#registNum").css("display", "none");
	} else if (loginType == "normal"){ // 일반로그인
		// 일반회원 로그인정보 AJAX
		$.ajax({
			type : "POST",
			url : "/ladaka/userInfo",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "json",
			async : false,
			error : function(xhr, status, error) {
				console.log("ajax error code:" + xhr.status);
			},
			success : function(data) {
				var nickname = data.userinfo[0].NICKNAME;
				
				$("#registNum").css("display", "none");
				$("#email").css("display", "block");
				$("#email").append("닉네임 : " + nickname + "	|	");
				$("#email").append("이메일 : " + email);
			}
		});
	} else { // 기타로그인
		// 병원회원 로그인정보 AJAX
		$.ajax({
			type : "POST",
			url : "/ladaka/userInfo",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			dataType : "json",
			async : false,
			error : function(xhr, status, error) {
				console.log("ajax error code:" + xhr.status);
			},
			success : function(data) {
				var name = data.userinfo[0].NAME;
				
				$("#email").css("display", "none");
				$("#registNum").css("display", "block");
				$("#registNum").append("병원명칭 : " + name + "<br/>");
				$("#registNum").append("사업자번호 : " + registNum);
			}
		});
	}
	
	$("#s_left").click(function() {
		window.open("http://localhost:8080/ladaka/hospitalSearch", "_self");
	});
	$("#s_right1").click(function() {
		alert("가까운 약국 찾기");
	});
	$("#s_right2").click(function() {
		alert("가까운 응급실 찾기");
	});
	$("#s_center1").click(function() {
		alert("뷰티 & 피트니스");
	});
	$("#s_center2").click(function() {
		alert("힐링캠프");
	});
	$("#s_center3").click(function() {
		alert("후원 배너 1");
	});
	$("#s_bottom1").click(function() {
		alert("이벤트");
	});
	$("#s_bottom2").click(function() {
		alert("쿠폰");
	});

});

function keywordSearch() {
	alert("키워드검색");
}

function mypage() {
	window.open("http://localhost:8080/ladaka/mypage", "_self");
}