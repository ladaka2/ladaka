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
	
	//이메일 한글입력 방지
	$("input[name=user_email]").keyup(function(event){ 
		if (!(event.keyCode >=37 && event.keyCode<=40)) {
			var inputVal = $(this).val();
			$(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
		}
	});

	// 회원가입 신청 클릭
	$("#registTrue").click(function() {
		var businessName = $("#business_nm").val();
		var businessNum = $("#business_num1").val() + "-" + $("#business_num2").val();
		var registPic = "";
		var password = $("#user_pw").val();
		var passwordRe = $("#user_pw_re").val();
		var managerName = $("#managerName").val();
		var managerNum = $("#managerNum").val();
		var email = $("#user_email").val() + "@" + $("#str_email").val();
		var hospitalKeyword = $("#hospitalKeyword").val();

		console.log(businessName + " / " + businessNum + " / " + password + " / " + email + " / " + hospitalKeyword);

		if (password != passwordRe) {
			alert("비밀번호를 확인해주세요.");
			return;
		} else {

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

				}
			});

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
	//window.open("http://localhost:8080/ladaka/term2", "_self");
}

function term3() {
	//window.open("http://localhost:8080/ladaka/term3", "_self");
}