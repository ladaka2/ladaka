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
		param.dgsbjtCd = $("#dgsbjtCd").val();//진료과목
		
		//alert(param.dgsbjtCd);
		
		//본사 고정(좌표 없을시)
		if(latitude == "0") param.latitude = "37.4907489";
		if(longitude == "0") param.longitude = "127.0314723";
		
		$.ajax({
			type : "POST"
			, url : "/ladaka/hospitalSearchAjax"
			, data : param
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
		var distance = 0;
		var distanceDis = "";
		
		$.each(data.result, function(index, entry){
			distance = Number(entry["DISTANCE"]);
			if(distance >= 1) distanceDis = distance.toFixed(2) + "km";
			else {
				distance = distance * 1000;
				distanceDis = distance.toFixed(0) + "m";
			}
			
			html += "<div class='hospitalList'>";
				html += entry["YADM_NM"];
				html += "<br/>";
				html += distanceDis;
				html += " | ";
				html += entry["SGGU_CD_NM"] + " " + entry["EMDONG_NM"];
				html += "<br/>";
				html += entry["X_POS"] + "/" + entry["Y_POS"];
			html += "</div>";
		});
		$("#listTd").html(html);
		
		//page
		html = "";
		
		initBtn();
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
	
	
	function initBtn() {//버튼 연결
		$(".hospitalList").click(function(){
			$(".hospitalList").css("background-color", "#FFFFFF");
			$(this).css("background-color", "#FFFFF0");
		});
	}
</script>

<body>
	
	<div>
		<from>
			<input type="text" id="latitude" name="latitude" />
			<input type="text" id="longitude" name="longitude" />
			<input type="button" id="searchBtn" value="search" />
			<br/>
			<select id="searchType1" name="searchType1">
				<option value="distance">현위치기준</option>
			</select>
			<select id="dgsbjtCd" name="dgsbjtCd">
				<option value="">전체</option>
				<option value="01">내과</option>
				<option value="02">신경과</option>
				<option value="03">정신건강의학과</option>
				<option value="04">외과</option>
				<option value="05">정형외과</option>
				<option value="06">신경외과</option>
				<option value="07">흉부외과</option>
				<option value="08">성형외과</option>
				<option value="09">마취통증의학과</option>
				<option value="10">산부인과</option>
				<option value="11">소아청소년과</option>
				<option value="12">안과</option>
				<option value="13">이비인후과</option>
				<option value="14">피부과</option>
				<option value="15">비뇨기과</option>
				<option value="16">영상의학과</option>
				<option value="17">방사선종양학과</option>
				<option value="18">병리과</option>
				<option value="19">진단검사의학과</option>
				<option value="20">결핵과</option>
				<option value="21">재활의학과</option>
				<option value="22">핵의학과</option>
				<option value="23">가정의학과</option>
				<option value="24">응급의학과</option>
				<option value="25">직업환경의학과</option>
				<option value="26">예방의학과</option>
				<option value="49">치과</option>
				<option value="50">구강악안면외과</option>
				<option value="51">치과보철과</option>
				<option value="52">치과교정과</option>
				<option value="53">소아치과</option>
				<option value="54">치주과</option>
				<option value="55">치과보존과</option>
				<option value="56">구강내과</option>
				<option value="57">영상치의학과</option>
				<option value="58">구강병리과</option>
				<option value="59">예방치과</option>
				<option value="80">한방내과</option>
				<option value="81">한방부인과</option>
				<option value="82">한방소아과</option>
				<option value="83">한방안·이비인후·피부과</option>
				<option value="83">한방안이비인후피부과</option>
				<option value="84">한방신경정신과</option>
				<option value="85">침구과</option>
				<option value="86">한방재활의학과</option>
				<option value="87">사상체질과</option>
				<option value="88">한방응급</option>
			</select>
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