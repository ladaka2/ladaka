<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>가까운 병원 찾기</title>
	<script src="js/jquery-3.2.0.min.js"></script>
</head>

<script>
	var param = {};
	var latitude = 0;
	var longitude = 0;
	
	$(document).ready(function(){
		navGeo();
		
		$("#searchBtn").click(function(){
			search();
		});
		
	});
	
	function search() {
		navGeo();
		
		param = {};
		param.latitude = $("#latitude").val();
		param.longitude = $("#longitude").val();
		
		$.ajax({
			type : "POST"
			, url : "/ladaka/hospitalSearchAjax"
			, data : param
			//, dataType : "xml"
			, dataType : "json"
			, success : parseJson
			, error : function() { alert("error!!"); }
		});
		
	}
	
	function parseJson(data) {
		var html = "";
		
		//alert(data.response.body.totalCount);
		/*
		$("#span").html(data.response.body.pageNo+"/"+data.response.body.totalCount);
		*/
		$.each(data.result, function(index, entry){
			html += "<div>";
				html += entry["YADM_NM"];
				html += "<br/>";
				html += entry["SGGU_CD_NM"] + " " + entry["EMDONG_NM"];
				html += "<br/>";
				html += entry["DISTANCE"];
				html += "<br/>";
				html += entry["X_POS"] + "/" + entry["Y_POS"];
			html += "</div>";
		});
		$("#listTd").html(html);
		
		//page
		html = "";
		
	}
	
	function navGeo() {
		if(navigator.geolocation) {
			//geolocation is available
			navigator.geolocation.getCurrentPosition(showMap);
			function showMap(position) {
				latitude = position.coords.latitude;
				longitude = position.coords.longitude;
				
				$("#latitude").val(latitude);
				$("#longitude").val(longitude);
			}
		} else {
			alert("I'm sorry, but geolocation services are not supported by your browser.");
		}
	}
	
</script>

<body>
	
	<div>
		<from>
			<input type="text" id="latitude" name="latitude" />
			<input type="text" id="longitude" name="longitude" />
			<input type="button" id="searchBtn" value="search" />
		</from>
		<table border="1">
			<thead>
			</thead>
			<tbody>
				<tr>
					<td>지도</td>
					<td id=listTd>
						<div>
							
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
</body>

</html>