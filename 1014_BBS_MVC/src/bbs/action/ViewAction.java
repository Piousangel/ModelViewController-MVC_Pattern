package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class ViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//파라미터 받기
		String cPage = request.getParameter("cPage");
		
		//게시물을 구별할 수 있는 기본키 값
		String b_idx = request.getParameter("b_idx");
		
		BbsVO vo = BbsDAO.getBbs(b_idx);
		
		if(vo != null)
			request.setAttribute("vo", vo);
		
		//접속 후 한번도 읽지 않았던 게시물이면 조회수 증가를 시킵니다(다음에)
		
		
		return "bbs/view.jsp";
	}

}
