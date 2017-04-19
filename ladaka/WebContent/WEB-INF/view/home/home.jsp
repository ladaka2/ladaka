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
<script src="js/home.js" type="text/javascript" charset="utf-8"></script>
<script src="js/commonFunc.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="css/healingCamp.css">
<script type="text/javascript">
	var loginType = "${loginType}";
	var email = "${email}";
	var registNum = "${registNum}";
</script>
</head>
<body>

	<div class="container">

		<!-- 상단 -->
		<div class="title">
			<div>
				홈
				<button class="menu" id="menu" onclick="mypage()">
					<img src="images/star.png" alt="마이페이지">마이페이지
				</button>
				<button class="magnify" id="magnify" onclick="keywordSearch()">
					<img src="images/magnifying-glass.png" alt="검색">검색
				</button>
			</div>
			
			<div>
				<input type="text" id="keyword" value="" placeholder="검색어 입력" onkeypress="keywordPress()">
			</div>
			
			<div class="userinfo">
				<div id="email"></div>
				<div id="registNum"></div>
			</div>
		</div>
		<!--// 상단 -->

		<!-- 콘텐츠 -->
		<div class="contents">

			<div class="contentsSearch">
				<div class="conLeft">
					<div id="s_left">
						<p>가까운 병원 찾기</p>
					</div>
				</div>
				<div class="conright">
					<div id="s_right1">
						<p>가까운 약국 찾기</p>
					</div>
					<div id="s_right2">
						<p>가까운 응급실 찾기</p>
					</div>
				</div>
			</div>

			<div class="contentsMiddle">
				<div class="s_center1" id="s_center1">
					<p>뷰티 & 피트니스</p>
				</div>
				<div class="s_center2" id="s_center2">
					<p>힐링캠프</p>
				</div>
				<div class="s_center3" id="s_center3">
					<p>후원 배너 1</p>
				</div>
			</div>

			<div class="contentsBottom">
				<div class="s_bottom1" id="s_bottom1">
					<p>이벤트</p>
				</div>
				<div class="s_bottom2" id="s_bottom2">
					<p>쿠폰</p>
				</div>
			</div>
		</div>
		<!--// 콘텐츠 -->

		<div id="result">
		
		</div>

		<!-- 푸터 -->
		<div class="footer">
			<p>상호	: 라다카주식회사 사업자등록번호: 214-88-81992 대표자: 이봉민 
			서울특별시 강남구 도산대로 209 옐로오투오 9층 통신판매업신고: 
			제2011-서울강남-00557 ALL RIGHT RESERVED. ©goodoc 이용약관  및  개인정보취급방침</p>
		</div>
		<!--// 푸터 -->

	</div>

</body>
</html>