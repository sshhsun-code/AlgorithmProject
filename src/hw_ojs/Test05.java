package hw_ojs;

import java.util.Scanner;

/**
 * @author sshhsun
 *
 *进制转换
 *
 *
 题目描述
写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）

输入描述
输入一个十六进制的数值字符串。
输出描述
输出该数值的十进制字符串
输入例子
0xA
输出例子
10




注意进制乘法的变形！！！从里向外扩展
 */
public class Test05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(hexToDec(input));
        }
        scanner.close();
    }
	
    private static int hexToDec(String hex) {
        final int BASE = 16;
        int result = 0;

        for (int i = 2; i < hex.length(); i++) {
            result = result * BASE + hexToNum(hex.charAt(i));
        }
        return result;
    }
	
	private static int hexToNum(char ch) {
		
		if (ch >= '0' && ch <= '9') {
			return ch - '0';
		} else if (ch >= 'a' && ch <= 'z') {
			return ch - 'a' + 10;
		} else {
			return ch - 'A' + 10;			
		}
	}

}
