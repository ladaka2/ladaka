$(document).ready(function() {
	$("#back").click(function() {
		back();
	})

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

	$("#findpw").click(function() {
		alert("비밀번호 찾기");
	});
});
