$(document).ready(function() {
	console.log("loginType : ", loginType);
	console.log("email : ", email);
	console.log("registNum : ", registNum);
	
	// loginType 화면 분기화
	if (loginType == "non") { // 미로그인
		$("#email").css("display", "none");
		$("#registNum").css("display", "none");
	} else if (loginType == "normal"){ // 일반로그인
		$("#email").css("display", "block");
		$("#registNum").css("display", "none");
		$("#email").append("이메일 : " + email);
	} else { // 기타로그인
		$("#registNum").css("display", "block");
		$("#registNum").append("사업자번호 : " + registNum);
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