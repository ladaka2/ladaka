<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="content-Type" content="text/html; charset=utf-8" />
<meta name="format-detection" content="telephone=no">
<title>힐링캠프</title>
<script src="js/jquery-3.2.0.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/mypage.js" type="text/javascript" charset="utf-8"></script>
<script src="js/commonFunc.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="css/healingCamp.css">
<script type="text/javascript">
	var loginType = "${loginType}";
	var registNum = "${registNum}";
</script>
</head>
<body>

	<div>

		<!-- 상단 -->
		<div>
			<div>
				<div>
					<div id="title">마이페이지</div>
				</div>
			</div>
		</div>
		<!--// 상단 -->

		<div class="UserInfo">
			
			<!-- 로그인 안한 경우 -->
			<div>
				<button id="nonLogin" >로그인/회원가입</button>
				<div style="float: right;">
					<a href="javascript:;" onclick="goHome()">홈이동</a>
				</div>
			</div>
			<!--// 로그인 안한 경우 -->
			
			<!-- 일반 회원 로그인 한 경우 -->
			<div id="normalLogin" style="display: none">
				닉네임/일반회원
			</div>
			<!--// 일반 회원 로그인 한 경우 -->
			
			<!-- 병원회원 로그인 한 경우 -->
			<div id="businessLogin" style="display: none">
				<div id="registNum"></div>
				병원회원
			</div>
			<!--// 병원회원 로그인 한 경우 -->

			<div id="menuCategory">
				<div class="menu" onclick="menu1()">롬</div>
				<div class="menu" onclick="menu2()">클럽</div>
				<div class="menu" onclick="menu3()">후원</div>
				<div class="menu" onclick="menu4()">이벤트</div>
				<div class="menu" onclick="menu5()">쿠폰</div>
			</div>
		</div>
		
		<div class="contents">
			<div id="contentVisible" style="display: block">
				<div class="conLeft" onclick="contents1()" id="contents1"></div>
				<div class="conRight" onclick="contents2()" id="contents2"></div>
				<div class="conLeft" onclick="contents3()" id="contents3"></div>
				<div class="conRight" onclick="contents4()" id="contents4"></div>
			</div>
			
			<div class="conLeft" onclick="contents5()">고객센터</div>
			<div class="conRight" onclick="contents6()">설정</div>
		</div>

		<!-- 푸터 -->
		<div class="footer">상호: 라다카주식회사 사업자등록번호: 214-88-81992 대표자: 이봉민 서울특별시 강남구 도산대로 209 옐로오투오 9층 통신판매업신고: 제2011-서울강남-00557 ALL RIGHT RESERVED. ©goodoc 이용약관  및  개인정보취급방침</div>
		<!--// 푸터 -->

	</div>

</body>
</html>