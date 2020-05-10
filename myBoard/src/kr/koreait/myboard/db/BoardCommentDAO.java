package kr.koreait.myboard.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
