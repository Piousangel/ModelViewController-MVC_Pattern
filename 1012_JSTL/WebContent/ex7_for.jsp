<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] ar = {"자바","스프링","파이썬","Lombook"};

	request.setAttribute("arr", ar);
%>

<%-- <c:set var="ar" value="<%=ar %>"/>    기억합시다...   --%>

<%-- 어떤회원이 언제 어떤책을 빌려갔는지 테이블 만들기 --%>


	<h1>JSTL for 연습</h1>
	<ul>
		<c:forEach var="ss" items="${arr}" varStatus="st">
			<li>${ss }</li>
		</c:forEach>
	</ul>
</body>
</html>

