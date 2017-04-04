$(document).ready(function() {
	$("#back").click(function() {
		back();
	})

	$("[name=checkAll]").click(function() {
		allCheckFunc(this);
	});
	$("[name=checkOne]").each(function(index) {
		$(this).click(function() {
			oneCheckFunc($(this));
			alert('checked' + index);
		});
	});
	
	//이메일 입력방식 선택
	$('#selectEmail').change(function() {
		$("#selectEmail option:selected").each(function() {
			if ($(this).val() == '1') { //직접입력일 경우
				$("#str_email").val(''); //값 초기화
				$("#str_email").attr("disabled", false); //활성화
			} else { //직접입력이 아닐경우
				$("#str_email").val($(this).text()); //선택값 입력
				$("#str_email").attr("disabled", true); //비활성화
			}
		});
	});

	//성별 입력방식 선택
	$('#gender').change(function() {
		$("#gender option:selected").each(function() {
			if ($(this).val() == '1') { //직접입력일 경우
				$("#genderInput").val(''); //값 초기화
				$("#genderInput").attr("disabled", false); //활성화
			} else { //직접입력이 아닐경우
				$("#genderInput").val($(this).text()); //선택값 입력
				$("#genderInput").attr("disabled", true); //비활성화
			}
		});
	});

	// 회원가입 신청 클릭
	$("#registTrue").click(function() {
		var email = $("#user_email").val() + "@" + $("#str_email").val();
		var nickname = $("#user_nickname").val();
		var password = $("#user_pw").val();
		var passwordRe = $("#user_pw_re").val();
		var gender = $("#genderInput").val();
		var bornyear = $("#bornYear").val();
		
		//console.log(email + " / " + nickname + " / " + password + " / " + gender + " / " + bornyear);
		
		if (password != passwordRe) {
			alert("비밀번호를 확인해주세요.");
			return;
		} else {
			
			var param = {};
			param = {};
			param.email = email;
			param.nickname = nickname;
			param.password = password;
			param.gender = gender;
			param.bornyear = bornyear;
			
			$.ajax({
				type : "POST",
				url : "/ladaka/goRegistAjax",
				contentType : "application/x-www-form-urlencoded; charset=UTF-8",
				data : param,
				dataType : "json",
				async : false,
				error : function(xhr, status, error) {
					console.log("ajax error code:" + xhr.status);
				},
				success : function(data) {

				}
			});
			
		}
		
	});

});

function allCheckFunc(obj) {
	$("[name=checkOne]").prop("checked", $(obj).prop("checked")); // 필수
	$("[name=checkTwo]").prop("checked", $(obj).prop("checked")); // 선택
}

/* 체크박스 체크시 전체선택 체크 여부 */
function oneCheckFunc(obj) {
	var allObj = $("[name=checkAll]");
	var objName = $(obj).attr("name");
	
	if ($(obj).prop("checked")) {
		checkBoxLength = $("[name=" + objName + "]").length;
		checkedLength = $("[name=" + objName + "]:checked").length;

		if (checkBoxLength == checkedLength) {
			allObj.prop("checked", true);
		} else {
			allObj.prop("checked", false);
		}
	} else {
		allObj.prop("checked", false);
	}
}

function term1() {
	window.open("http://localhost:8080/ladaka/term1", "_self");
}

function term2() {
	//window.open("http://localhost:8080/ladaka/term2", "_self");
}

function term3() {
	//window.open("http://localhost:8080/ladaka/term3", "_self");
}