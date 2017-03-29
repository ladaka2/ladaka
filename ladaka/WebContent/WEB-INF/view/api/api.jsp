<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>API CALL TEST</title>
	<script src="js/jquery-3.2.0.min.js"></script>
	<script src="js/angular.min.js"></script>
</head>

<script>
	var param = {};
	
	$(document).ready(function(){
		//search(1);
	});
	
	function search(no) {
		param = {};
		param.pageNo = no;
		
		$.ajax({
			type : "POST"
			, url : "http://localhost:8080/ladaka/apiGet"
			, data : param
			//, dataType : "xml"
			, dataType : "json"
			, success : parseJson
			, error : function() { alert("error!!"); }
		});
	}
	
	function parseJson(data) {
		var html = "";
		//alert(data.response.body.pageNo);
		//alert(data.response.body.totalCount);
		$("#span").html(data.response.body.pageNo+"/"+data.response.body.totalCount);
		
		$.each(data.response.body.items.item, function(index, entry){
			html += "<tr>";
				html += "<td>";
				html += entry["yadmNm"];
				html += "</td>";
				html += "<td>";
				html += entry["telno"];
				html += "</td>";
				html += "<td>";
				html += entry["addr"];
				html += "</td>";
			html += "</tr>";
		});
		$("#tableBody").html(html);
		
		//page
		html = "";
		
		
	}
</script>

<script>
	//angular js
	var app = angular.module("app", []);
	
	app.controller('appCtrl', function($scope, $http) {
		$http({
			method: "GET",
			url: "http://localhost:8080/ladaka/apiGet"
		}).then(function successCallback(response) {
			$scope.message = response.data.response.body.items;
			$scope.rows = response.data.response.body.items.item;
		}, function errorCallback(response) {
			//error
			
		})
		
		
	});
	
	

</script>

<body>
	API CALL TEST!!!<br/>
	<button onclick="location.href='/ladaka/apiGetToDB'">DB입력</button><br/><br/>
	
	<button>검색</button><br/>
	
	<span id="span">Loading...</span><br/>
	
	<table border="1">
		<thead>
		</thead>
		<tbody id="tableBody">
		<tr><td>Loading...</td></tr>
		</tbody>
	</table>
	<div id="page"></div>
	
	<div ng-app="app" ng-controller="appCtrl">
		<!--  
		<h1>{{ message }}</h1>
		-->
		<table border="1">
			<thead>
				<tr>
					<th>요양기호</th>
					<th>병원명</th>
					<th>병원주소</th>
					<th>읍면동명</th>
					<th>전화번호</th>
					<th>종별코드</th>
					<th>종별코드명</th>
					<th>시도코드</th>
					<th>시도명</th>
					<th>시군구코드</th>
					<th>시군구명</th>
					<th>우편번호</th>
					<th>x좌표</th>
					<th>y좌표</th>
				</tr>
			</thead>
			<tbody ng-repeat="row in rows">
				<tr>
					<td>{{ row.ykiho }}</td>
					<td>{{ row.yadmNm }}</td>
					<td>{{ row.addr }}</td>
					<td>{{ row.emdongNm }}</td>
					<td>{{ row.telno }}</td>
					<td>{{ row.clCd }}</td>
					<td>{{ row.clCdNm }}</td>
					<td>{{ row.sidoCd }}</td>
					<td>{{ row.sidoCdNm }}</td>
					<td>{{ row.sgguCd }}</td>
					<td>{{ row.sgguCdNm }}</td>
					<td>{{ row.postNo }}</td>
					<td>{{ row.XPos }}</td>
					<td>{{ row.YPos }}</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>

</html>