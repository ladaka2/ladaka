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
<script src="js/goRegist.js" type="text/javascript" charset="utf-8"></script>
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
				<div>회원가입</div>
			</div>
		</div>
		<!--// 상단 -->

		<div class="registForm" style="float: left; margin-bottom: 30px;">
			<div>
				<span>이메일</span>
				<br/>
				<div>
					<input type='text' name="user_email" id='user_email' maxlength='40' placeholder="이메일*" /> @
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
				
				<div class="notice">
					<span>병원 회원을 위해 일반 회원의 경우 닉네임에 병원, 전문의, 일반의, 의사, 진료과목명들의 단어를 포함하여 사용할 수 없습니다.</span>
				</div>
			</div>
			
			<div class="nickName">
				<span>닉네임</span>
				<div>
					<input type='text' id='user_nickname' maxlength='40' placeholder="닉네임*" />
				</div>
			</div>

			<div>
				<div class="pw">
					<span>비밀번호 (4자이상)</span>
					<div>
						<input type='password' id='user_pw' placeholder="비밀번호*" />
					</div>
				</div>
				<div class="pw">
					<span>비밀번호 확인 (4자이상)</span>
					<div>
						<input type='password' id='user_pw_re' placeholder="비밀번호 확인*" />
					</div>
				</div>
			</div>

			<div class="gender">
				<span>성별</span>
				<div>
					<!-- 					<input type="text" id='gender' placeholder="성별" /> -->
					<input type="text" name="genderInput" id="genderInput" style="width: 100px;" disabled value="남">
					<select style="width: 100px; margin-right: 10px" name="gender" id="gender">
						<option value="남" selected>남</option>
						<option value="여">여</option>
					</select>
				</div>
			</div>
			<div class="bornYear">
				<span>출생 연도</span>
				<div>
					<input type="month" id='bornYear' placeholder="출생 연도" />
				</div>
			</div>

			<div class="notice">
				<span>* 만 14세 미만은 회원 가입이 안됩니다. 양해 부탁드립니다.</span>
			</div>

			<div class="termcheck">
				<table>
					<thead>
						<tr>
							<th><input type="checkbox" name="checkAll"></th>
							<th>전체선택</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="checkbox" name="checkOne">
							</td>
							<td>
							이용약관 동의 (필수)
								<div style="float: right; text-decoration: underline; color: blue;" onclick="term1();">
									내용보기
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox" name="checkOne">
							</td>
							<td>
							개인정보취급방침 동의 (필수)
								<div style="float: right; text-decoration: underline; color: blue;" onclick="term2();">
									내용보기
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<input type="checkbox" name="checkOne">
							</td>
							<td>
							위치정보 동의 (선택)
								<div style="float: right; text-decoration: underline; color: blue;" onclick="term3();">
									내용보기
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>

		<div>
			<button class="registTrue" id="registTrue">회원가입 신청</button>
		</div>

	</div>

</body>
</html>