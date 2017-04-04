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

	<div>

		<!-- 상단 -->
		<div>
			<div id="title">
				<div style="float: left;">
					<a href="javascript:;" id="back">뒤로</a>
				</div>
				<div>비밀번호찾기</div>
			</div>
		</div>
		<!--// 상단 -->

		<p style="font-size: 12px;">가입한 Email로 비밀번호 변경 메일이 발송됩니다.</p>
		
		<div style="float: left; margin-bottom: 30px;">
			<h5>이메일</h5>
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
		
		<button id="findpw" style="width: 100%;">비밀번호 찾기</button>

	</div>

</body>
</html>