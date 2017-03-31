<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="content-Type" content="text/html; charset=utf-8" />
<meta name="format-detection" content="telephone=no">
<title>로그인</title>
<script src="js/jquery-3.2.0.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
<script src="js/commonFunc.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

	<div>

		<!-- 상단 -->
		<div>
			<div class="topSearch_in">
				<a href="javascript:;" id="back">뒤로</a>
				<div>로그인</div>
			</div>
		</div>
		<!--// 상단 -->

		<!-- 개인회원 로그인 -->
		<div id="userNormal">
			<div>
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
			<div>
				<h5>비밀번호 (4자이상)</h5>
				<div>
					<input type='password' id='user_pw' placeholder="비밀번호" />
				</div>
			</div>
		</div>
		<!--// 개인회원 로그인 -->

		<!-- 사업자회원 로그인 -->
		<div id="userBusiness" style="display: none;">
			<div>
				<h5>사업자등록번호</h5>
				<div>
					<input type='text' id='business_num1' maxlength='10' placeholder="사업자등록번호10자리" /> -
					<input type="text" id="business_num2" maxlength='2' placeholder="일련번호2자리" />
				</div>
			</div>
			<div>
				<h5>비밀번호 (4자이상)</h5>
				<div>
					<input type='text' id='user_pw2' placeholder="비밀번호" />
				</div>
				<div id="pwcnt"></div>
			</div>
		</div>
		<!--// 사업자회원 로그인 -->

		<div>
			<div></div>
		</div>
		<div>
			<div>
				<input type='radio' name='find_type' id='find_type1' value="개인회원" checked /> <label for='find_type1'>개인회원 로그인</label>
			</div>
		</div>
		<div>
			<div>
				<input type='radio' name='find_type' id='find_type2' value="사업자회원" /> <label for='find_type2'>사업자회원 로그인</label>
			</div>
		</div>
		<div">
			<div>
				<button onclick="login()">로그인</button>
			</div>
		</div>

		<div style="padding-top: 40px;">
			<div>
				<button id="findPw">비밀번호찾기</button>
			</div>
			<div id="goRegistDiv">
				<button id="goRegist">일반회원가입</button>
			</div>
			<div id="goRegist2Div" style="display: none">
				<button id="goRegist2">병원외 사업자회원 가입</button>
				<p>
				* 병원 회원 가입을 하시려면 병원찾기 > 병원 리스트에서 해당 병원 선택 후 병원 회원 가입 신청을 해주셔야 합니다.
				</p>
			</div>
		</div>

	</div>
	
	<input type="hidden" id="registNumImsi" name="registNumImsi" value="">

</body>
</html>