$(document).ready(function() {
	
	//$("#result").empty();
	var keyword = $("#keyword").val();
	
	if (keyword == "") {
		alert("키워드를 입력해주세요.");
	} else {
		//alert(keyword);

		var param = {};
		param.keyword = keyword;

		// 키워드검색 ajax
		$.ajax({
			type : "POST",
			url : "/ladaka/searchKeyword",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			data : param,
			dataType : "json",
			async : false,
			error : function(xhr, status, error) {
				console.log("ajax error code:" + xhr.status);
			},
			success : function(data) {
				var result = data.searchKeyword;
				//				console.log(result);

				if (result == "") {
					alert("해당 키워드 검색결과 없음");
				} else {
					for (var index = 0; index < result.length; index++) {
						console.log(result[index].YADM_NM);

						$("#result").append(result[index].YADM_NM + "<br/>");
					}
				}
				
			}
		});

	}
});

