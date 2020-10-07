package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인을 했는지? 안했는지? 알아봅니다.
		//(로그인을 했다면 session에 "vo"라는 이름으로 저장이 되어있습니다.
		
		//먼저 HttpSession을 얻어낸다.
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("vo");//"vo"라는 이름으로 저장된 객체를 얻어냅니다.
		boolean chk = false;
		if(obj != null)
			chk = true;
		
		request.setAttribute("login_chk", chk);
		
		return "/jsp/index.jsp";
	}

}
