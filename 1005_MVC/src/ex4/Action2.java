package ex4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action2 {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//나머지 파라미터들(name, age)를 받습니다.
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		if(name != null && age != null) {
			//받은 값들을 저장할 vo객체를 생성합니다.
			DataVO dvo = new DataVO();
			dvo.setName(name);
			dvo.setAge(Integer.parseInt(age));
			
			//준비된 vo를 jsp에서 표현할 수 있도록 request에 저장합니다.
			request.setAttribute("dvo", dvo );  //jsp에서 쓸려고하는 이름
		}
		
		return "/ex4/data.jsp";
	}
}
