import java.util.HashSet;

public class StringCode {

	public static int maxRun(String str) {
		if(str.equals("")) return 0;
		int result = 1;
		int currentResult = 1;
		char c = str.charAt(0);
		for(int i = 1; i < str.length(); ++i){
			if(str.charAt(i) == c){
				currentResult ++;
			}else{
				result = Math.max(result, currentResult);
				c = str.charAt(i);
				currentResult = 1;
			}
		}
		return result;
	}

	public static String blowup(String str) {
		String result = "";
		if(str.equals("")) return "";
		int i;
		for(i = 0; i < str.length() - 1; ++i){
			char c = str.charAt(i);
			if(Character.isDigit(c)){
				char n = str.charAt(i + 1);
				result += replaceDigit(c, n);
			}else{
				result += c;
			}
		}

		char c = str.charAt(i);
		if(!Character.isDigit(c)) result += c;

		return result;
	}

	public static boolean stringIntersect(String a, String b, int len) {
		if(len > a.length() || len > b.length()) return false;
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i <= a.length() - len; ++i){
			String sub = a.substring(i, i + len);
			set.add(sub);
		}
		for(int i = 0; i <= b.length() - len; ++i){
			String sub = b.substring(i, i + len);
			if(set.contains(sub)) return true;
		}
		return false;
	}

	/** --------------------private methods for decomposition--------------------------- **/
	private static String replaceDigit(char c, char n){
		String result = "";
		for(int i = 0; i < c - '0'; ++i){
			result += n;
		}
		return result;
	}
}
