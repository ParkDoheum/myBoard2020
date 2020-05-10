package kr.koreait.myboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.koreait.myboard.db.BoardCommentDAO;
import kr.koreait.myboard.vo.BoardCommentVO;
import kr.koreait.myboard.vo.UserVO;

@WebServlet("/boardComment")
public class BoardCommentSev extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		
		String i_comment = request.getParameter("i_comment");		
		int int_comment = Utils.parseStringToInt(i_comment, 0);
		
		System.out.println("int_comment: " + int_comment);
		System.out.println("i_user: " + loginUser.getI_user());
		
		BoardCommentVO param = new BoardCommentVO();
		param.setI_comment(int_comment);
		param.setI_user(loginUser.getI_user());
		
		int result = BoardCommentDAO.delComment(param);
		response.sendRedirect("/boardDetail?i_board=" + i_board);
	}

	//등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		
		String i_board = request.getParameter("i_board");
		int int_board = Utils.parseStringToInt(i_board, 0);
		String content = request.getParameter("content");
		
		System.out.println("int_board: " + int_board);
		System.out.println("content: " + content);
		System.out.println("i_user: " + loginUser.getI_user());
		
		BoardCommentVO param = new BoardCommentVO();
		param.setI_board(int_board);
		param.setContent(content);
		param.setI_user(loginUser.getI_user());
		
		int result = BoardCommentDAO.insertComment(param);
		response.sendRedirect("/boardDetail?i_board=" + i_board 
				+ "&commentResult=" + result);
		
	}

}






