package string_test;

import java.util.Arrays;

/**
 * ²Î¿¼
 * https://www.jiuzhang.com/solution/rotate-string/
 * https://github.com/sshhsun-code/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.01.md
 * @author sshhsun
 *
 */
public class RotateString {
	
	public static void main(String[] args) {
		char[] str = "abcdefg".toCharArray();
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
		System.out.println("");
		new RotateString().rotateString(str, 4);
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
	}
	
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0)
            return;
            
        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }
    
    private void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

}
