<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>가까운 병원 찾기</title>
	<script src="js/jquery-3.2.0.min.js"></script>
	<script src="js/angular.min.js"></script>
</head>

<script>
	var param = {};
	
	$(document).ready(function(){
		//search(1);
	});
	
	//angular js
	var app = angular.module("app", []);
	
	app.controller('appCtrl', function($scope, $http) {
		$http({
			method: "GET",
			url: "http://localhost:8080/ladaka/hospitalSearchAjax"
		}).then(function successCallback(response) {
			$scope.message = response.data.result;
			$scope.rows = response.data.result;
		}, function errorCallback(response) {
			//error
			
		})
		
	});
	
</script>

<body>
	<div>
		<table border="1">
			<thead>
			</thead>
			<tbody>
				<tr>
					<td>지도</td>
					<td ng-app="app" ng-controller="appCtrl">
						<!--  
						<div>{{ message }}</div>
						-->
						<div ng-repeat="row in rows">
							{{ row.YADM_NM }}
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>

</html>