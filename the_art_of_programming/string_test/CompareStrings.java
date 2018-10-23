package string_test;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * https://github.com/sshhsun-code/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.02.md
 * 
 * https://www.lintcode.com/problem/compare-strings/description
 * @author sshhsun
 *
 */
public class CompareStrings {
	
	public static void main(String[] args) {
		boolean isContains = new CompareStrings().compareStrings("ABCD", "ACD");
		System.out.println(isContains);
	}
	
    public boolean compareStrings(String A, String B) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < A.toCharArray().length; i++) {
			set.add(A.charAt(i));
		}
        for (int i = 0; i < B.toCharArray().length; i++) {
			if (!set.contains(B.charAt(i))) {
				return false;
			}
			set.remove(B.charAt(i));
		}
    	return true;
    }
    
    public boolean compareStrings2(String A, String B) {
        int[] counts = new int[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = 0;
        }
        for (int i = 0; i < A.length(); i++) {
            counts[A.charAt(i) - 'A'] ++;
        }
        for (int i = 0; i < B.length(); i++) {
            counts[B.charAt(i) - 'A'] --;
            if (counts[B.charAt(i) - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }

}
