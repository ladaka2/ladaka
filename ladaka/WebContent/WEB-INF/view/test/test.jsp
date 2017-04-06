<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%
	//
	String name = "";
	
	ArrayList list = (ArrayList)request.getAttribute("result");
	System.out.println(list.toString());
	for(int i=0; i<list.size(); i++) {
		HashMap map = new HashMap<String, Object>();
		map = (HashMap)list.get(i);
		System.out.println(map.get("NAME"));
		name = map.get("NAME").toString();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	라다카 테스트!!!<br/>
	<%=name%>
</body>
</html>