$(document).ready(function() {
	console.log("loginType : ", loginType);
	console.log("email : ", email);
	console.log("registNum : ", registNum);

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

	// loginType 화면 분기화
	if (loginType == "non") { // 미로그인
		$(".userinfo").css("display", "none");
		$("#email").css("display", "none");
		$("#registNum").css("display", "none");
	} else if (loginType == "normal") { // 일반로그인
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
		// 사업자회원 로그인정보 AJAX
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
				$("#registNum").append("사업자명칭 : " + name + "<br/>");
				$("#registNum").append("사업자번호 : " + registNum);
			}
		});
	}

	$("#s_left").click(function() {
		window.open("http://localhost:8080/ladaka/hospitalSearch", "_self");
	});
	$("#s_right1").click(function() {
		window.open("http://localhost:8080/ladaka/pharmSearch", "_self");
	});
	$("#s_right2").click(function() {
		window.open("http://localhost:8080/ladaka/emergencySearch", "_self");
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

	//	facebooklogin();

	$("input[name=keyword]").keydown(function(key) {
		if (key.keyCode == 13) {
			keywordSearch();
		}
	});

});

/*function keywordPress() {
 keywordSearch();
 }*/

function keywordSearch() {
	$("#result").empty();
	var keyword = $("#keyword").val();

	if (keyword == "") {
		alert("키워드를 입력해주세요.");
	} else {
		//alert(keyword);

		var param = {};
		param.keyword = keyword;

		// 키워드검색 ajax
		$.ajax({
			type : "POST",
			url : "/ladaka/searchKeyword",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : param,
			dataType : "json",
			async : false,
			error : function(xhr, status, error) {
				console.log("ajax error code:" + xhr.status);
			},
			success : function(data) {
				var result = data.searchKeyword;
				//				console.log(result);

				if (result == "") {
					alert("해당 키워드 검색결과 없음");
				} else {
					for (var index = 0; index < result.length; index++) {
						console.log(result[index].YADM_NM);

						$("#result").append(result[index].YADM_NM + "<br/>");
					}
				}
				
			}
		});

	}
}

function mypage() {
	window.open("http://localhost:8080/ladaka/mypage", "_self");
}

function facebooklogin() {
	FB.getLoginStatus(function(response) {
		console.log(response);
		console.log(response.status);

		if (response.status == "connected") {
			alert("이미 페이스북 로그인 됨");

		} else {
			FB.login(function(response) {
				console.log(response);
				console.log(response.status);
			});
		}
	});

};

