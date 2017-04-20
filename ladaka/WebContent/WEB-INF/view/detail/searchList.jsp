<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>힐링캠프</title>
<link rel="stylesheet" href="css/healingCamp.css">
<script src="js/jquery-3.2.0.min.js"></script>
<script src="js/searchList.js" type="text/javascript" charset="utf-8"></script>
<script src="js/commonFunc.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=hPZ0iy84b4nPIbb1qobj"></script>
<%
request.setCharacterEncoding("utf-8");
String keyword = request.getParameter("keyword");
%>
</head>

<body>

	<div class="container">
		<!-- 상단 -->
		<div class="title">
			<div>
				<button class="gohome" onclick="location.href='/ladaka/home'">
					<img src="images/house.png" alt="홈">홈
				</button>
				검색결과
				<button class="menu" id="menu" onclick="location.href='/ladaka/mypage'">
					<img src="images/star.png" alt="마이페이지">마이페이지
				</button>
				<button class="back" onclick="back()">
					<img src="images/back.png" alt="뒤로">뒤로
				</button>
			</div>
		</div>
		<!--// 상단 -->
		
		<!-- 콘텐츠 -->
		<div id="result">
		</div>
		<!--// 콘텐츠 -->
		
		<!-- 푸터 -->
		<div class="footer">
			<p>상호	: 라다카주식회사 사업자등록번호: 214-88-81992 대표자: 이봉민 
			서울특별시 강남구 도산대로 209 옐로오투오 9층 통신판매업신고: 
			제2011-서울강남-00557 ALL RIGHT RESERVED. ©goodoc 이용약관  및  개인정보취급방침</p>
		</div>
		<!--// 푸터 -->
		
	</div>
	
	<input type="hidden" value="<%=keyword%>" id="keyword">
	
</body>


</html>



