$(document).ready(function() {
	$("#back").click(function() {
		back();
	})

	var cellPhone = document.getElementById('managerNum');
	cellPhone.onkeyup = function(event) {
		event = event || window.event;
		var _val = this.value.trim();
		this.value = autoHypenPhone(_val);
	}

	$("[name=checkAll]").click(function() {
		allCheckFunc(this);
	});
	$("[name=checkOne]").each(function(index) {
		$(this).click(function() {
			oneCheckFunc($(this));
		});
	});

	// 이메일 입력방식 선택
	$('#selectEmail').change(function() {
		$("#selectEmail option:selected").each(function() {
			if ($(this).val() == '1') { // 직접입력일 경우
				$("#str_email").val(''); // 값 초기화
				$("#str_email").attr("disabled", false); // 활성화
			} else { // 직접입력이 아닐경우
				$("#str_email").val($(this).text()); // 선택값 입력
				$("#str_email").attr("disabled", true); // 비활성화
			}
		});
	});

	// 이메일 한글입력 방지
	$("input[name=user_email]").keyup(function(event) {
		if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
			var inputVal = $(this).val();
			$(this).val(inputVal.replace(/[^a-z0-9]/gi, ''));
		}
	});

	// 회원가입 신청 클릭
	$("#registTrue").click(function() {
		var businessName = $("#business_nm").val();
		var businessNumFirst = $("#business_num1").val();
		var businessNumSecond = $("#business_num2").val();
		var businessNum = $("#business_num1").val() + "-" + $("#business_num2").val();
		var registPic = "";
		var password = $("#user_pw").val();
		var passwordRe = $("#user_pw_re").val();
		var managerName = $("#managerName").val();
		var managerNum = $("#managerNum").val();
		var emialFirst = $("#user_email").val();
		var email = $("#user_email").val() + "@" + $("#str_email").val();
		var hospitalKeyword = $("#hospitalKeyword").val();

		console.log(businessName + " / " + businessNum + " / " + password + " / " + email + " / " + hospitalKeyword);

		if (password != passwordRe) {
			alert("비밀번호를 확인해주세요.");
			return;
		} else if (businessName == "") {
			alert("사업자 명칭을 기입해주세요.");
		} else if (businessNumFirst == "" || businessNumSecond == "") {
			alert("사업자 등록번호를 기입해주세요.");
		} else if (password.length < 4) {
			alert("비밀번호는 4글자 이상으로 기입해주세요.");
		} else if (password == "" || passwordRe == "") {
			alert("비밀번호를 기입해주세요.");
		} else if (managerName == "") {
			alert("담당자 이름을 기입해주세요.");
		} else if (managerNum == "") {
			alert("담당자 휴대번호를 기입해주세요.");
		} else if (emialFirst == "") {
			alert("담당자 이메일을 기입해주세요.");
		}	else if (businessNumFirst.length < 10) {
			alert("사업자등록번호는 10자리 입니다.");
		} else if (businessNumSecond.length < 2) {
			alert("일련번호는 2자리 입니다.");
		} else if (hospitalKeyword != "") {
			if (hospitalKeyword.length > 40) {
				alert("진료키워드는 40자이내로 기입부탁드립니다.");
				return;
			}
		} else {
			
			var checkOne1 = $("input[name=checkOne]:eq(0)");
			var checkOne2 = $("input[name=checkOne]:eq(1)");
			
			if ((checkOne1.prop("checked") == true) && (checkOne2.prop("checked") == true)) {
				
				var param = {};
				param = {};
				param.businessName = businessName;
				param.businessNum = businessNum;
				param.registPic = registPic;
				param.password = password;
				param.managerName = managerName;
				param.managerNum = managerNum;
				param.email = email;
				param.hospitalKeyword = hospitalKeyword;

				$.ajax({
					type : "POST",
					url : "/ladaka/goRegistAjax2",
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

function autoHypenPhone(str) {
	str = str.replace(/[^0-9]/g, '');
	var tmp = '';
	if (str.length < 4) {
		return str;
	} else if (str.length < 7) {
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3);
		return tmp;
	} else if (str.length < 11) {
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3, 3);
		tmp += '-';
		tmp += str.substr(6);
		return tmp;
	} else {
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3, 4);
		tmp += '-';
		tmp += str.substr(7);
		return tmp;
	}
	return str;
}

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
	// window.open("http://localhost:8080/ladaka/term2", "_self");
}

function term3() {
	// window.open("http://localhost:8080/ladaka/term3", "_self");
}