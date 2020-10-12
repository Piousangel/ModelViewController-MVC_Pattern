<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Map"%>
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
	request.setCharacterEncoding("utf-8");

	String s_id = request.getParameter("s_id");
	String s_pw = request.getParameter("s_pw");
	session.setAttribute("s_id", s_id);
	session.setAttribute("s_pw", s_pw);

	//Map구조 생성
	Map<String, String> map = new Hashtable<String, String>();
	map.put("name", "홍길동");
	map.put("id", s_id);
	map.put("pw", s_pw);
	
	session.setAttribute("map", map);	
%>
	<h1>${param.s_id }</h1>
	<h1>${param.s_pw }</h1>
	<h1>${paramValues.s_phone[0] } -
		${paramValues.s_phone[1] } -
		${paramValues.s_phone[2] } </h1>
		
	<input type="button" value="다음페이지" onclick="exe()"/>    <%-- ex2_res.jsp로 이동합니다. --%>
	<br/>
	<input type="button" value="다음페이지" onclick="javascript: location.href ='ex2_res.jsp?pw=${param.s_pw}'"/>
	
	<script type="text/javascript">
		function exe(){
			
			//ex2_res.jsp이동
			
			location.href= "ex2_res.jsp?pw=${param.s_pw}";
		}
	</script>
</body>
</html>