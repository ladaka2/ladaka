$(document).ready(function() {

	$("#s_left").click(function() {
		alert("가까운 병원 찾기");
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
