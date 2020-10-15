package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 사용자가 선택한 페이지 번호를 받아야합니다.
		
		String cPage = request.getParameter("cPage");
		int p = 1;
		
		if(cPage != null) {
			p = Integer.parseInt(cPage);
		}else {
			//사용자가 선택한 페이지가 없는 경우...
			
		}
		
		//현재 페이지값(p)를 이용하여 begin과 end를 구해야 합니다.

		
		String bname = request.getParameter("bname");
		if(bname == null)
			bname = "BBS";
		
		//원하는 게시판의 목록을 얻어낸다.
		BbsVO[] ar = BbsDAO.getList(1, 10, bname);
		
		//View Page 에서 표현할 것들을 request에 저장합니다.
		request.setAttribute("ar", ar);
		
		return "/bbs/list.jsp";
	}

}
