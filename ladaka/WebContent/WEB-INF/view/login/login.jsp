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
					<div><input type='text' id='user_email' maxlength='40' placeholder="필수" /></div>
				</div>
				<div>
					<h5>비밀번호 (4자이상)</h5>
					<div><input type='text' id='user_pw' placeholder="필수"/></div>
				</div>
			</div>
			<!--// 개인회원 로그인 -->
			
			<!-- 사업자회원 로그인 -->
			<div id="userBusiness" style="display: none;">
				<div>
					<h5>사업자등록번호</h5>
					<div><input type='text' id='user_email2' maxlength='40' placeholder="필수" /></div>
				</div>
				<div>
					<h5>비밀번호 (4자이상)</h5>
					<div><input type='text' id='user_pw2' placeholder="필수"/></div>
					<div id="pwcnt"></div>
				</div>
			</div>
			<!--// 사업자회원 로그인 -->
			
			<div>
				<div></div>
			</div>
			<div>
				<div><input type='radio' name='find_type' id='find_type1'  value="개인회원" checked />
					<label for='find_type1'>개인회원 로그인</label>
				</div>
			</div>
			<div>
				<div><input type='radio' name='find_type' id='find_type2' value="사업자회원"/>
					<label for='find_type2'>사업자회원 로그인</label>
				</div>
			</div>
			<div>
				<div>
					<button onclick="login()">로그인</button>
				</div>
			</div>

			<div>
				<div>
					<button id="findPw">비밀번호찾기</button>
				</div>
				<div>
					<button id="goRegist">일반회원가입</button>
				</div>
			</div>


	</div>

</body>
</html>