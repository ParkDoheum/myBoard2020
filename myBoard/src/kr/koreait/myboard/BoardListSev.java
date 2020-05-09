package kr.koreait.myboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.koreait.myboard.db.BoardDAO;
import kr.koreait.myboard.vo.UserVO;

@WebServlet("/boardList")
public class BoardListSev extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 체크
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect("/login");
			return;
		}
		int cnt = 10; //content view count
		
		//DB로부터 리스트를 가져온다.
		request.setAttribute("totalPageCnt", BoardDAO.getTotalPageCnt(cnt));
		request.setAttribute("list", BoardDAO.getBoardList());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/boardList.jsp");
		rd.forward(request, response);
	}


}





