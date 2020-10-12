<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> EL : Expression Language(표현언어)</h1>
	<h2>
		map구조 또는 List구조 등의 컬렉션 접근을 유용하게 해 주는
		문법을 가진 표현언어입니다.
	</h2>
	<h2>
		표현언어가 가지는 기본객체: <br/>
		-param : 파라미터 값 <br/>
		-requestScope : 요청객체<br/>
		-sessionScope : HttpSession객체<br/> 
	</h2>
	<h2>${param.s_id }</h2>
	<h2>${param.s_pw }</h2> <%-- 파라미터 값들은 반드시 param. 을 붙여 사용합니다. --%>
	<h2>${param.cPage }</h2>
</body>
</html>