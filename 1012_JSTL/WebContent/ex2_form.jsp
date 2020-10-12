<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 연습</h1>
	<form action="ex2_ok.jsp" method="post">
		<label for="s_id">ID :</label>
		<input type="text" id="s_id" name="s_id"/><br/>
		
		<label for="s_pw">PW :</label>
		<input type="password" id="s_pw" name="s_pw"/><br/>
		
		<input type="hidden" name="cPage" value="2"/>
		
		<input type="button" value="로그인"
			onclick="sendData(this.form)"/>
			
		<label for="s_phone">Phone:</label>
		<select id="s_phone" name="s_phone">
			<option value="010">010</option>
			<option value="010">011</option>
			<option value="010">016</option>
		</select>
		
		<label for="s_phone1">-</label>
		<input type="text" id="s_phone1" name="s_phone"/>
		
		<label for="s_phone2">-</label>
		<input type="text" id="s_phone2" name="s_phone"/>
	</form>
	
	<script type="text/javascript">
		function sendData(frm){
			//유효성검사 생략
			
			//사용자가 입력한 id값 받아오기
			var s_id = document.getElementById("s_id");
			
			//var s_pw = document.getElementById("s_pw");
			var s_pw = frm.s_pw;
			
			if(s_id.value.trim().length == 0){
				alert("id를 입력하세요.");
				s_id.value = "";
				s_id.focus();
			}
			
			//비밀번호 유효성 검사
			if(s_pw.value.trim().length == 0){
				alert("pw를 입력하세요.");
				s_pw.value = "";
				s_pw.focus();
			}
			
			frm.submit(); //서버로 파라미터 값들을 보냅니다.
		}
	</script>
</body>
</html>