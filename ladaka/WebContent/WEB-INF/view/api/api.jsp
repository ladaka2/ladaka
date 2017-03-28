<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>API CALL TEST</title>
	<script src="js/jquery-3.2.0.min.js"></script>
</head>

<script>
	$(document).ready(function(){
		alert("1111");
		
		var param = {};
		
		$.ajax({
			type : "POST"
			, url : "http://localhost:8080/ladaka/apiGet"
			, data : param
			//, dataType : "xml"
			, dataType : "json"
			, success : parseXml
			, error : function() { alert("error!!"); }
		});
	});
	
	function parseXml(data) {
		alert(data);
	}
</script>

<body>
	API CALL TEST!!!
	
</body>
</html>