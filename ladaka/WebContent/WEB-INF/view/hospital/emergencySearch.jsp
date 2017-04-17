<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<title>가까운 응급실 찾기</title>
	<link rel="stylesheet" href="css/healingCamp.css">
	<script src="js/jquery-3.2.0.min.js"></script>
	<script src="js/emergencySearch.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=hPZ0iy84b4nPIbb1qobj"></script>
</head>

<body>
	
	<div class="container">
		<!-- 상단 -->
		<div class="title">
			<div>
				<button class="gohome" onclick="location.href='/ladaka/home'">
					<img src="images/house.png" alt="홈">홈
				</button>
				가까운 응급실 찾기
				<button class="menu" id="menu" onclick="location.href='/ladaka/mypage'">
					<img src="images/star.png" alt="마이페이지">마이페이지
				</button>
				<button class="magnify" id="magnify" onclick="keywordSearch()">
					<img src="images/magnifying-glass.png" alt="검색">검색
				</button>
			</div>
			
			<div class="userinfo">
				<div id="email"></div>
				<div id="registNum"></div>
			</div>
		</div>
		<!--// 상단 -->
		
		<!-- 콘텐츠 -->
		<div class="contents">
			<from>
				<input type="text" id="latitude" name="latitude" />
				<input type="text" id="longitude" name="longitude" />
				<br/>
				<select id="searchType1" name="searchType1">
					<option value="distance">현위치기준</option>
				</select>
				<input type="button" id="searchBtn" value="search" />
			</from>
			
			<div>
				<div id="map" style="width:49%;height:500px;float:left;" ></div>
				<div id="lstDiv" style="width:49%;height:500px;display:inline-block;"></div>
			</div>
			
		</div>
		<!--// 콘텐츠 -->
		
	</div>
	
	<div class="hideBtn" id="hideBtn" onclick="hideBtn();">
		<button>지도</button>
	</div>
	<div class="hideBtn" id="listBtn" onclick="listBtn();" style="display: none">
		<button>목록</button>
	</div>
	
</body>


</html>



