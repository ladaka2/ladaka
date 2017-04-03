$(document).ready(function() {
	$("#back").click(function() {
		back();
	})
	
	$("#allCheck").change(function() {
		// 전체체크박스 선택
		if ($("#allCheck").prop("checked")) {
			$("input[type=checkbox]").prop("checked", true);
		} else {
			$("input[type=checkbox]").prop("checked", false);
		}
		checkboxCheck();
	});
});

function checkboxCheck() {
	var ruleCheck = $("#ruleCheck");
	if (ruleCheck.find("table tr td input:checkbox:checked").size() == ruleCheck.find("table tr td input:checkbox").size()) {
		alert(1);
		return true;
	} else {
		alert(2);
		return false;
	}
}
