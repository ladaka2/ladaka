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
	var latitude;
	var longitude;
	
	$(document).ready(function(){
		//search(1);
		/* */
		if(navigator.geolocation) {
			//geolocation is available
			navigator.geolocation.getCurrentPosition(showMap);
			function showMap(position) {
				latitude = position.coords.latitude;
				longitude = position.coords.longitude;
				
				//alert(latitude+"/"+longitude);
				$("#latitude").val(latitude);
				$("#longitude").val(longitude);
				//$scope.latitude = latitude;
				//$scope.longitude = longitude;
				
				$("#latitude").change();
				$("#longitude").change();
			}
		} else {
			alert("I'm sorry, but geolocation services are not supported by your browser.");
		}
		
	});
	
	//angular js
	var app = angular.module("myApp", []);
	
	app.controller('appCtrl', function($scope, $http) {
		$scope.search = function() {
			
			/* 
			if(navigator.geolocation) {
				//geolocation is available
				navigator.geolocation.getCurrentPosition(showMap);
				function showMap(position) {
					latitude = position.coords.latitude;
					longitude = position.coords.longitude;
					
					$scope.latitude = latitude;
					$scope.longitude = longitude;
					
					//$("#latitude").change();
					//$("#longitude").change();
				}
			} else {
				alert("I'm sorry, but geolocation services are not supported by your browser.");
			}
			*/
			
			alert(latitude);
			
			
			$http({
				method : "POST"
				, data : {latitude: $scope.latitude, longitude: $scope.longitude}
				, url : "http://localhost:8080/ladaka/hospitalSearchAjax"
			}).then(function successCallback(response) {
				$scope.message = response.data.result;
				$scope.rows = response.data.result;
			}, function errorCallback(response) {
				//error
				
			})
		
		};
		
		$scope.search();
	});
	
	
</script>

<body>
	
	<div ng-app="myApp" ng-controller="appCtrl">
		<from>
			<input type="text" id="latitude" name="latitude" ng-model="latitude" value="1"/>
			<input type="text" id="longitude" name="longitude" ng-model="longitude" value="2"/>
			<input type="button" id="searchBtn" value="search" ng-click="search()">
		</from>
		<table border="1">
			<thead>
			</thead>
			<tbody>
				<tr>
					<td>지도</td>
					<td>
						<!--  
						<div>{{ message }}</div>
						-->
						<div ng-repeat="row in rows">
							{{ row.YADM_NM }}<br/>
							({{ row.SGGU_CD_NM}} {{ row.EMDONG_NM}})<br/>
							[{{ row.X_POS}} {{ row.Y_POS}}]
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>



</body>

</html>