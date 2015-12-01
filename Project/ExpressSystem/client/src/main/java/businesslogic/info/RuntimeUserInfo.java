package businesslogic.info;

public class RuntimeUserInfo {
	private static String userNum = null;
	
	private RuntimeUserInfo() {	}
	
	public static void setUserNum (String num) {
		userNum = num;
	}
	
	public static String getNum() {
		return userNum;
	}
}
