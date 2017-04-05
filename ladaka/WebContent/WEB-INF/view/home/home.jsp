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
</script>
</head>
<body>

	<div>

		<!-- 상단 -->
		<div>
			<div>
				<div>
					<div id="title">
						힐링캠프
						<img id="menu" src="images/menu.png" alt="menu" onclick="mypage()">
						<img id="magnify" src="images/magnify.png" alt="magnify" onclick="keywordSearch()">
					</div>
				</div>
			</div>
		</div>
		<!--// 상단 -->

		<div class="container">
			<div class="s_left" id="s_left">가까운 병원 찾기</div>
			<div class="s_right1" id="s_right1">가까운 약국 찾기</div>
			<div class="s_right2" id="s_right2">가까운 응급실 찾기</div>
			<div class="s_center1" id="s_center1">뷰티 & 피트니스</div>
			<div class="s_center2" id="s_center2">힐링캠프</div>
			<div class="s_center3" id="s_center3">
				<!-- 후원 배너 1 -->
				<img src="images/test.jpg" alt="banner">
			</div>
			<div class="s_bottom1" id="s_bottom1">이벤트</div>
			<div class="s_bottom2" id="s_bottom2">쿠폰</div>
		</div>

	</div>

</body>
</html>