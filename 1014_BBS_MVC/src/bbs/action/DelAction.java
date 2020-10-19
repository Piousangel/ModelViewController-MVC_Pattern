package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.BbsDAO;

public class DelAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//삭제기능을 수행하는 Action -> 기본키를 받아서 삭제를 수행합니다. view.jsp에서 호출합니다.
		
		String b_idx = request.getParameter("b_idx");
		String cPage = request.getParameter("cPage");
		
		BbsDAO.delBbs(b_idx);
		
		
		
		
		return "Controller?type=list&cPage="+cPage;  //페이지 값을 주면서 controller에서 list action을 수행합니다.
	}

}
