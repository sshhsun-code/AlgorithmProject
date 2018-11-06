package string_test;

/**
 * 
 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÊÇ »ØÎÄ×Ö·û´®
 * 
 * ²Î¿¼£º
 * 
 * https://github.com/sshhsun-code/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.04.md
 * 
 * @author sshhsun
 *
 */
public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result = IsPalindrome("abbca");
		System.out.println("" + result);
	}
	
	private static boolean IsPalindrome(String str) {
		
		if (str == null || str.length() <= 0) {
			return false;
		}
		int start = 0;
		int end = str.length() - 1;
		
		while (start < end) {
			
			if (str.charAt(start) != str.charAt(end)) {
				
				return false;
				
			}
			start++;
			end--;
		}
		return true;
	}

}
