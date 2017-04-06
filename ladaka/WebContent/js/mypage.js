$(document).ready(function() {
	console.log("loginType : ", loginType);
	console.log("email : ", email);
	console.log("registNum : ", registNum);
	
	// loginType 화면 분기화
	if (loginType == "non") { // 미로그인
		$("#contentVisible").css("display", "none");
	} else if (loginType == "normal"){ // 일반로그인
		$("#nonLogin").css("display", "none");
		$("#normalLogin").css("display", "block");
		$("#email").append("이메일 : " + email);
	} else { // 기타로그인
		$("#nonLogin").css("display", "none");
		$("#businessLogin").css("display", "block");
		$("#registNum").append("사업자번호 : " + registNum);
	}
	
	// 즐겨찾기카운트
	var bookmarkCnt = "1";
	var bookmarkCntHtml = "즐겨찾기 (" + bookmarkCnt + ")";
	$('#contents1').append(bookmarkCntHtml);
	
	// 보유포인트
	var point = "100"
	var pointHtml = "보유 포인트 (" + point + ")";
	$('#contents2').append(pointHtml);
	
	// 신청이벤트
	var event = "1"
	var eventHtml = "신청이벤트 (" + event + ")";
	$('#contents3').append(eventHtml);
	
	// 보유쿠폰
	var coupon = "1"
	var couponHtml = "보유쿠폰 (" + coupon + ")";
	$('#contents4').append(couponHtml);
	
	$("#nonLogin").click(function() {
		window.open("http://localhost:8080/ladaka/login", "_self");
	});
});

function menu1() {
	alert("롬");
}

function menu2() {
	alert("클럽");
}

function menu3() {
	alert("후원");
}

function menu4() {
	alert("이벤트");
}

function menu5() {
	alert("쿠폰");
}

function contents1() {
	alert("즐겨찾기");
}

function contents2() {
	alert("보유포인트");
}

function contents3() {
	alert("신청이벤트");
}

function contents4() {
	alert("보유쿠폰");
}

function contents5() {
	alert("고객센터");
}

function contents6() {
	alert("설정");
}
