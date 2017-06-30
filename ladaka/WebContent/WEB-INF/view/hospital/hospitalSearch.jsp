<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<title>가까운 병원 찾기</title>
	<link rel="stylesheet" href="css/healingCamp.css">
	<script src="js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=hPZ0iy84b4nPIbb1qobj"></script>
	<script src="js/hospitalSearch.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
	
	<div class="container">
		<!-- 상단 -->
		<div class="title">
			<div>
				<button class="gohome" onclick="location.href='/ladaka/home'">
					<img src="images/house.png" alt="홈">홈
				</button>
				가까운 병원 찾기
				<button class="menu" id="menu" onclick="location.href='/ladaka/mypage'">
					<img src="images/star.png" alt="마이페이지">마이페이지
				</button>
				<button class="magnify" id="magnify" onclick="keywordSearch()">
					<img src="images/magnifying-glass.png" alt="검색">검색
				</button>
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
				<select id="dgsbjtCd" name="dgsbjtCd">
					<option value="">전체</option>
					<option value="01">내과</option>
					<option value="02">신경과</option>
					<option value="03">정신건강의학과</option>
					<option value="04">외과</option>
					<option value="05">정형외과</option>
					<option value="06">신경외과</option>
					<option value="07">흉부외과</option>
					<option value="08">성형외과</option>
					<option value="09">마취통증의학과</option>
					<option value="10">산부인과</option>
					<option value="11">소아청소년과</option>
					<option value="12">안과</option>
					<option value="13">이비인후과</option>
					<option value="14">피부과</option>
					<option value="15">비뇨기과</option>
					<option value="16">영상의학과</option>
					<option value="17">방사선종양학과</option>
					<option value="18">병리과</option>
					<option value="19">진단검사의학과</option>
					<option value="20">결핵과</option>
					<option value="21">재활의학과</option>
					<option value="22">핵의학과</option>
					<option value="23">가정의학과</option>
					<option value="24">응급의학과</option>
					<option value="25">직업환경의학과</option>
					<option value="26">예방의학과</option>
					<option value="49">치과</option>
					<option value="50">구강악안면외과</option>
					<option value="51">치과보철과</option>
					<option value="52">치과교정과</option>
					<option value="53">소아치과</option>
					<option value="54">치주과</option>
					<option value="55">치과보존과</option>
					<option value="56">구강내과</option>
					<option value="57">영상치의학과</option>
					<option value="58">구강병리과</option>
					<option value="59">예방치과</option>
					<option value="80">한방내과</option>
					<option value="81">한방부인과</option>
					<option value="82">한방소아과</option>
					<option value="83">한방안·이비인후·피부과</option>
					<option value="83">한방안이비인후피부과</option>
					<option value="84">한방신경정신과</option>
					<option value="85">침구과</option>
					<option value="86">한방재활의학과</option>
					<option value="87">사상체질과</option>
					<option value="88">한방응급</option>
				</select>
				<input type="button" id="searchBtn" value="search" />
			</from>
			
			<div>
				<div id="map" style="width:49%;height:500px;float:left;" ></div>
				<div id="lstDiv" style="width:49%;height:500px;display:inline-block;"></div>
			</div>
			
		</div>
		<!--// 콘텐츠 -->
		
		<div class="hideBtn" id="hideBtn" onclick="hideBtn();">
			<button>지도</button>
		</div>
		<div class="hideBtn" id="listBtn" onclick="listBtn();" style="display: none">
			<button>목록</button>
		</div>
		
	</div>
	
</body>


</html>



