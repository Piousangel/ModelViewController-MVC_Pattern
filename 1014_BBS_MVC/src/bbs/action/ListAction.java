package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class ListAction implements Action {
	
	int blockList =10;
	int blockPage = 5;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 사용자가 선택한 페이지 번호를 받아야합니다.
		
		String cPage = request.getParameter("cPage");
		int p = 1;
		
		if(cPage != null) {
			p = Integer.parseInt(cPage);
		}
		
		//현재 페이지값(p)를 이용하여 begin과 end를 구해야 합니다.

		
		String bname = request.getParameter("bname");
		if(bname == null)
			bname = "BBS";
		
		int rowTotal= BbsDAO.totalCount(bname);
		Paging page = new Paging(p, rowTotal, blockList, blockPage);
		
		//원하는 게시판의 목록을 얻어낸다.
		BbsVO[] ar = BbsDAO.getList(page.getBegin(), page.getEnd(), bname);
		
		//View Page 에서 표현할 것들을 request에 저장합니다.
		request.setAttribute("ar", ar);
		
		// 페이징 HTML코드를 저장합니다.
		request.setAttribute("p_code", page.getSb().toString());
		
		//list.jsp에서 앞에 번호를 출력하기 위해 필요한 변수 저장.
		request.setAttribute("rowTotal", rowTotal);
		request.setAttribute("nowPage", p);
		request.setAttribute("blockList", blockList);
		
		
		
		return "/bbs/list.jsp";
	}

}
