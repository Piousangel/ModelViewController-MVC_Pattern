<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${sessionScope.s_id }</h1>
	<h1>param.pw: ${param.pw }</h1>
	<h1>param["pw"]: ${param["pw"] }</h1>
	<hr/>
	<h1>${sessionScope.map.name }</h1>
	<h1>${sessionScope.map.id }</h1>
	<h1>${sessionScope.map.pw }</h1>
	
</body>
</html>