package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String path = "/jsp/index.jsp";
		HttpSession session = request.getSession();
		
		session.removeAttribute("vo");
		
		return path;
	}

}
