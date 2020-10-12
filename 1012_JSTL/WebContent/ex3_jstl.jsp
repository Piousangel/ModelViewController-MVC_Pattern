<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--
		JSTL(JSP Standard Tag Library)
			자바기반의 웹환경에서 지원하는 확장된 Tag를
			사용할 수 있도록 제공되는 라이브러리(Tag로 제어문 지원)
			
			먼저 JSTL라이브러리가 필요합니다.
			http://tomcat.apache.org/ Tomcat프로젝트에서 다운받아
			WEB-INF/lib에 standard.jar , jstl.jar을 넣어줍니다.
 --%>
 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSTL 변수선언 --%>
	
	<c:set var="idx" value="100"/> <%-- int idx = 100; --%>
	<%--
		스크립트요소에서 정의한 변수를 JSTL에서는 바로 사용하지 못합니다.
		따라서 jsp요소를 jstl요소로 바꿔주어야 합니다.
	 --%>
	 
	 <%
	 	int value = 9;
	 %>
	 <c:set var="value" value="<%=value %>"/>  <%-- jsp요소를 jstl요소로 바꾸는 방법 --%>
	 
	 <c:if test="${idx >= 10}">
	 	<h2>idx의 값이 10이상 입니다.</h2>
	 </c:if>
	 <c:if test="${idx < 10}">
	 	<h2>idx의 값이 10미만 입니다.</h2>
	 </c:if>
	 
	 <c:if test="${value >= 10}">
	 	<h2>value의 값이 10이상 입니다.</h2>
	 </c:if>
	 <c:if test="${value < 10}">
	 	<h2>value의 값이 10미만 입니다.</h2>
	 </c:if>
	
</body>
</html>