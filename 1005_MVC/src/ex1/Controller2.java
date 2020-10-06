package ex1;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller2
 */
@WebServlet("/Controller2")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// type이라는 파라미터를 받는다.
		// 그 값이 "date"이면 "/ex2/data.jsp"로 forward한다. 이때 표현될 값은 현재날짜이다.
		String type = request.getParameter("type");
		
		String viewPath = null;
		if(type != null && type.equals("date")) {
			//현재 날짜 구하기
			Date now = new Date(System.currentTimeMillis());
			
			//now은 Date객체이며 현재 날짜를 기억하고 있다. 이것을 하나의 문자열로 받아낸다.
			String nowDate = now.toString();
			
			//현재 날짜를 문자열로 변환된 값을 request에 저장!
			request.setAttribute("now", nowDate);
			
			viewPath = "/ex2/date.jsp";
		}else if(type != null && type.equals("greet")) {
			request.setAttribute("str", "안녕하세요~! 반갑습니다.");
			
			viewPath = "/ex2/greet.jsp";
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(viewPath);
		
		// 지정된 jsp로 forward한다.
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
