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
	request.setCharacterEncoding("utf-8");

	//파라미터로 넘어오는 u_name이 어드민일때만
	//'관리자님 환영합니다.' 메세지를 출력하고 나머지는 
	//'님 환영합니다.' 출력할려고합니다.

%>

	<c:if test="${param.u_name  =='어드민'}">
		<h2>${param.u_name }관리자님 환영합니다.</h2> <%-- eq로 변경가능합니다. --%>
	</c:if>
	
	<c:if test="${param.u_name  !='어드민'}">
		<h2>${param.u_name }님 환영합니다.</h2>  <%-- ne로 변경가능합니다. --%>
	</c:if>
</body>
</html> 