package kr.koreait.myboard.vo;

public class BoardCommentVO {
	private int i_board;	
	private String content;
	private int i_user;
	private String r_dt;
	
	private int user_nm;
	private int user_img;
	
	public int getI_board() {
		return i_board;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public int getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(int user_nm) {
		this.user_nm = user_nm;
	}
	public int getUser_img() {
		return user_img;
	}
	public void setUser_img(int user_img) {
		this.user_img = user_img;
	}
	
	
}
