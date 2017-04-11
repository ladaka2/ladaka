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
<script src="js/findPw.js" type="text/javascript" charset="utf-8"></script>
<script src="js/commonFunc.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="css/healingCamp.css">
</head>
<body>

	<div class="container">

		<!-- 상단 -->
		<div class="title">
			<div>
				<button class="back" id="back">
					<img src="images/back.png" alt="뒤로">뒤로
				</button>
				<div>비밀번호찾기</div>
			</div>
		</div>
		<!--// 상단 -->
		
		<div class="notice">
			<span>가입한 Email로 비밀번호 변경 메일이 발송됩니다.</span>
		</div>
		
		<div class="emailForm" style="float: left; margin-bottom: 30px;">
			<span>이메일</span>
			<br/>
			<div>
				<input type='text' id='user_email' maxlength='40' placeholder="이메일" /> @
				<input type="text" name="str_email" id="str_email" style="width: 100px;" disabled value="naver.com">
				<select style="width: 100px; margin-right: 10px" name="selectEmail" id="selectEmail">
					<option value="1">직접입력</option>
					<option value="naver.com" selected>naver.com</option>
					<option value="hanmail.net">hanmail.net</option>
					<option value="nate.com">nate.com</option>
					<option value="yahoo.co.kr">yahoo.co.kr</option>
					<option value="gmail.com">gmail.com</option>
				</select>
			</div>
		</div>
		
		<div class="findpwDiv">
			<button class="findpw" id="findpw">비밀번호 찾기</button>
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