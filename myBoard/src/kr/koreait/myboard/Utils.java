package kr.koreait.myboard;

public class Utils {
	
	//String > int 바꿔주는 메소드입니다.
	public static int parseStringToInt(String str, int def) {
		try {
			def = Integer.parseInt(str);
		} catch(Exception e) {}		
		return def;
	}

}
