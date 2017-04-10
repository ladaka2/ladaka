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

	//이메일 한글입력 방지
	$("input[name=user_email]").keyup(function(event) {
		if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
			var inputVal = $(this).val();
			$(this).val(inputVal.replace(/[^a-z0-9]/gi, ''));
		}
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
		var emialFirst = $("#user_email").val();
		var email = $("#user_email").val() + "@" + $("#str_email").val();
		var nickname = $("#user_nickname").val();
		var password = $("#user_pw").val();
		var passwordRe = $("#user_pw_re").val();
		var gender = $("#genderInput").val();
		var bornyear = $("#bornYear").val();

		if (password != passwordRe) {
			alert("비밀번호를 확인해주세요.");
			return;
		} else if (emialFirst == "") {
			alert("이메일을 기입해주세요.");
		} else if (nickname == "") {
			alert("닉네임을 기입해주세요.");
		} else if (password.length < 4) {
			alert("비밀번호는 4글자 이상으로 기입해주세요.");
		} else if (password == "" || passwordRe == "") {
			alert("비밀번호를 기입해주세요.");
		} else if (bornyear == "") {
			alert("출생연도를 선택해주세요.");
		} else {

			var checkOne1 = $("input[name=checkOne]:eq(0)");
			var checkOne2 = $("input[name=checkOne]:eq(1)");
			
			if ((checkOne1.prop("checked") == true) && (checkOne2.prop("checked") == true)) {
				
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
						alert("회원가입 되었습니다. 로그인해주세요.");
						window.open("http://localhost:8080/ladaka/login", "_self");
					}
				});
				
			} else {
				alert("필수항목은 모두 체크해주세요");
			}

		}

	});

});

function allCheckFunc(obj) {
	$("[name=checkOne]").prop("checked", $(obj).prop("checked"));
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