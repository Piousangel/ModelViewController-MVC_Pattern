<%@page import="ex4.DataVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Object obj = request.getAttribute("ar");

	if(obj !=null){
		DataVO[] ar = (DataVO[])obj;
		for(DataVO vo : ar){
%>	
		<h2>이름 :<%= vo.getName()%>,  나이 : <%= vo.getAge() %></h2>		
<% 			
		}
	}
%>
<hr/>  <%-- 구분선 --%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
	
	<h1>JSTL for문 연습</h1>
	<c:forEach items="${ar}" var="vo">  <%-- for(DataVO vo : ar) --%>
		<h2>${vo.name}, ${vo.age }</h2>
	</c:forEach>


</body>
</html>