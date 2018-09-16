package hw_ojs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author sshhsun
 * 计算字符个数
 * 
 * 
 题目描述
写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
1
输入描述
输入一个有字母和数字以及空格组成的字符串，和一个字符。
1
输出描述
输出输入字符串中含有该字符的个数。
1
输入例子
ABCDEF
A
1
2
输出例子
1
 *
 */
public class Test02 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // 是否还有其它的行，一次可以测试多行
        while (scanner.hasNext()) {
            String input = scanner.next();
            String ch = scanner.next();
            System.out.println(countCharNumber(input, ch));
        }
        scanner.close();
    }

	private static int countCharNumber(String input, String ch) {
		HashMap<String, Integer> map = new HashMap<>();
		int conut = 0;
		input = input.toLowerCase();
		ch = ch.toLowerCase();
		for (int i = 0; i < input.toCharArray().length; i++) {
			if (input.charAt(i) == ch.charAt(0)) {
				conut ++;
			}
		}
		
		return conut;
	}

}
