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
<script src="js/goRegist2.js" type="text/javascript" charset="utf-8"></script>
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
				<div>병원 회원가입</div>
			</div>
		</div>
		<!--// 상단 -->

		<div class="registForm" style="float: left; margin-bottom: 30px;">
			<div>
				<span>사업자 명칭</span>
				<div class="notice">
					<span>병원 회원의 경우 병원 상세보기에서 선택된 병원 명칭이 그대로 입력됨(수정 불가)</span>
				</div>
				<div>
					<input type='text' id='business_nm' maxlength='40' placeholder="사업자 명칭" />
				</div>
			</div>
			<div>
				<span>사업자 등록 번호</span>
				<div class="notice">
					<span>(아이디로 사용함. 직영점이 여러 개일 경우 일련번호에 번호가입. 입력하지 않으면 자동으로 OO으로 입력됨</span>
				</div>
				<div>
					<input type='text' id='business_num1' maxlength='10' placeholder="사업자등록번호10자리" /> -
					<input type="text" id="business_num2" maxlength='2' placeholder="일련번호2자리" />
				</div>
			</div>

			<div>
				<div class="pw">
					<span>비밀번호 (4자이상)</span>
					<div>
						<input type='password' id='user_pw' placeholder="비밀번호" />
					</div>
				</div>
				<div class="pw">
					<span>비밀번호 확인 (4자이상)</span>
					<div>
						<input type='password' id='user_pw_re' placeholder="비밀번호 확인" />
					</div>
				</div>
			</div>
			
			<div style="float: left;">
				<span>사업자 등록증 사본 제출</span>
				<input type="file">
				<div class="notice">
					<span>병원 회원 검증을 위해 사업자 등록증 사본을 제출하셔야 합니다.</span>
				</div>
			</div>
			
			<div>
				<div style="float: left; width: 40%;">
					<span>담당자 이름</span>
					<div>
						<input type='text' id='managerName' placeholder="담당자 이름" />
					</div>
				</div>
				<div style="float: left; width: 40%;">
					<span>담당자 휴대폰 번호</span>
					<div>
						<input type="text" name="managerNum" id="managerNum" placeholder="담당자 휴대폰 번호" maxlength="13" />
					</div>
				</div>
			</div>
			
			
			<div style="float: left;">
				<span>담당자 이메일</span>
				<div>
					<input type='text' id='user_email' maxlength='40' placeholder="담당자 이메일" /> @
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
			
			<div style="float: left;">
				<span>진료 키워드</span>
				<textarea id="hospitalKeyword" style="width: 100%;" rows="5" cols="100" placeholder="병원의 전문 분야 (예 : 여드름, 피부 클리닉, 보톡스, 여의사 산부인과등) 40자 이내로 입력해 주세요."></textarea>
			</div>

			<div>
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