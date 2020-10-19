package bbs.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class EditAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//요청한 contentType을 얻어냅니다. 
		String c_type = request.getContentType();  //get방식은 null, post방식은 application~... , 파일 첨부시 multipart~... 로 출력됩니다.
		String viewPath = null;
		
		//POST 방식으로 요청되었을 때와 multipart로 요청되었을 때를 구별하여
		//뷰 페이지를 또는 작업을 다르게 해야합니다.
		
		if(c_type.startsWith("application")) {
			//POST방식으로 요청된경우
			String b_idx = request.getParameter("b_idx");
			BbsVO vo = BbsDAO.getBbs(b_idx);
			if(vo != null) {
				request.setAttribute("vo", vo);
			}
			viewPath = "/bbs/edit.jsp";
			
		}else if(c_type.startsWith("mutipart")) {
			
			ServletContext application = request.getServletContext();
			
			try {
				String path = application.getRealPath("/bbs_upload");
				
				MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy()); //이때 첨부파일이 있다면 업로드 됩니다.
				
				//나머지 파라미터들을 받아줍니다.
				String b_idx = mr.getParameter("b_idx");  //b_idx는 기본키로 없으면 수정불가합니다.
				String cPage = mr.getParameter("cPage");  //Controller?type=view로 보낼 때 필요합니다.
				String subject = mr.getParameter("subject");
				String writer = mr.getParameter("writer");
				String content = mr.getParameter("content");
				
				//첨부파일이 있었는지 확인합니다.
				File f = mr.getFile("file");
				String fname = null;
				if(f != null)
					fname = f.getName(); //동일한 파일명이 있었다면 파일명이 변경되었을 가능성이 있습니다.
				
				String ip = request.getRemoteAddr();
				
				BbsDAO.editBbs(b_idx, subject, content, fname, ip);
				
				viewPath = "Controller?type=view&cPage="+cPage+"&b_idx"+b_idx;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
