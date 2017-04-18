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
<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
<script src="js/commonFunc.js" type="text/javascript" charset="utf-8"></script>

<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<link rel="stylesheet" href="css/healingCamp.css">
</head>
<body>

	<div class="container">

		<!-- 상단 -->
		<div class="title">
			<div>
				<button class="back" onclick="goHome()">
					<img src="images/back.png" alt="뒤로">뒤로
				</button>
				<div>로그인</div>
			</div>
		</div>
		<!--// 상단 -->

		<div class="loginType">
			<div>
				<input type='radio' name='find_type' id='find_type1' value="개인회원" checked /> <label for='find_type1'>개인회원 로그인</label>
			</div>
			<div>
				<input type='radio' name='find_type' id='find_type2' value="사업자회원" /> <label for='find_type2'>사업자회원 로그인</label>
			</div>
		</div>

		<!-- 개인회원 로그인 -->
		<div class="userNormal" id="userNormal">
			<div class="emailForm" style="float: left; margin-bottom: 30px;">
				<span>이메일</span> <br />
				<div>
					<input type='text' id='user_email' maxlength='40' placeholder="이메일" /> @ <input type="text" name="str_email" id="str_email" style="width: 100px;" disabled value="naver.com">
					<select style="width: 100px; margin-right: 10px" name="selectEmail" id="selectEmail">
						<option value="1">직접입력</option>
						<option value="naver.com" selected>naver.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="nate.com">nate.com</option>
						<option value="yahoo.co.kr">yahoo.co.kr</option>
						<option value="gmail.com">gmail.com</option>
					</select>
				</div>
				<br /> <span>비밀번호 (4자이상)</span>
				<div>
					<input type='password' id='user_pw' placeholder="비밀번호" />
				</div>
			</div>
		</div>
		<!--// 개인회원 로그인 -->

		<!-- 사업자회원 로그인 -->
		<div class="userBusiness" id="userBusiness" style="display: none;">
			<div class="registNumForm" style="float: left; margin-bottom: 30px;">
				<span>사업자등록번호</span> <br />
				<div>
					<input type='text' id='business_num1' maxlength='10' placeholder="사업자등록번호10자리" /> - <input type="text" id="business_num2" maxlength='2' placeholder="일련번호2자리" />
				</div>
				<br /> <span>비밀번호 (4자이상)</span>
				<div>
					<input type='password' id='user_pw2' placeholder="비밀번호" />
				</div>
				<div id="pwcnt"></div>
			</div>

		</div>
		<!--// 사업자회원 로그인 -->

		<div class="login">
			<button onclick="login()">로그인</button>
		</div>

		<div class="login">
			<button style="background-color: RoyalBlue" onclick="facebooklogin();">페이스북 로그인</button>
		</div>

		<div class="login">
			<button style="background-color: yellow; color: black;" onclick="createKakaotalkLogin();">카카오톡 로그인</button>
		</div>

		<div class="bottonBtn">
			<div>
				<button class="findPwGo" id="findPw">비밀번호찾기</button>
			</div>
			<div id="goRegistDiv">
				<button class="goRegistGo" id="goRegist">일반회원가입</button>
			</div>
			<div id="goRegist2Div" style="display: none">
				<button class="goRegistGo" id="goRegist2">병원외 사업자회원 가입</button>
			</div>
		</div>

		<div style="padding: 20px;"></div>

		<div class="notice">
			<span>* 병원 회원 가입을 하시려면 병원찾기 > 병원 리스트에서 해당 병원 선택 후 병원 회원 가입 신청을 해주셔야 합니다.</span>
		</div>

		<!-- 푸터 -->
		<div class="footer">
			<p>상호 : 라다카주식회사 사업자등록번호: 214-88-81992 대표자: 이봉민 서울특별시 강남구 도산대로 209 옐로오투오 9층 통신판매업신고: 제2011-서울강남-00557 ALL RIGHT RESERVED. ©goodoc 이용약관  및  개인정보취급방침</p>
		</div>
		<!--// 푸터 -->

	</div>

</body>
</html>