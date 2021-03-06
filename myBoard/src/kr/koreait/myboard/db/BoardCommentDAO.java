package kr.koreait.myboard.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.koreait.myboard.vo.BoardCommentVO;

public class BoardCommentDAO {
	public static int insertComment(BoardCommentVO param) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_board_comment "
				+ " (i_board, content, i_user) "
				+ " VALUES "
				+ " (?, ?, ?) ";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_board());
			ps.setString(2, param.getContent());
			ps.setInt(3, param.getI_user());
			result = ps.executeUpdate();
			
		} catch (Exception e) {		
			e.printStackTrace();
		} finally {
			DbBridge.close(con,  ps);			
		}
		
		return result;
	}
	
	public static List<BoardCommentVO> getBoardCommentList(int i_board) {
		List<BoardCommentVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT "
				+ " A.i_comment, A.content, A.r_dt, A.i_user "
				+ " , B.u_nickname as user_nm, C.img as user_img "
				+ " FROM t_board_comment A "
				+ " INNER JOIN t_user B "
				+ " ON A.i_user = B.i_user "
				+ " LEFT JOIN t_user_img C "
				+ " ON B.i_user = C.i_user "
				+ " AND C.seq = 1 "
				+ " WHERE A.i_board = ? ";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, i_board);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int i_comment = rs.getInt("i_comment");
				String content = rs.getString("content");
				String r_dt = rs.getString("r_dt");
				int i_user = rs.getInt("i_user");
				String user_nm = rs.getString("user_nm");
				String user_img = rs.getString("user_img");
				
				BoardCommentVO vo = new BoardCommentVO();
				vo.setI_comment(i_comment);
				vo.setContent(content);
				vo.setR_dt(r_dt);
				vo.setI_user(i_user);
				vo.setUser_nm(user_nm);
				vo.setUser_img(user_img);
				
				list.add(vo);
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return list;
	}
	
	public static int delComment(BoardCommentVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM t_board_comment "
				+ " WHERE i_comment = ? AND i_user = ? ";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_comment());
			ps.setInt(2,  param.getI_user());
			
			result = ps.executeUpdate();			
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps);
		}
		
		return result;
	}
	
	
}
