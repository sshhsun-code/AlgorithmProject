package ojs;

import java.util.Scanner;

/**
 * @author sshhsun
 * 
 * 题目一：
  有一种简易压缩算法：针对全部由小写英文字母组成的字符串，将其中连续超过两个相同字母的部分压缩为连续个数加该字母，其他部分保持原样不变。

  例如：字符串“aaabbccccd”经过压缩成为字符串“3abb4cd”。

  请您编写一个unzip函数，根据输入的字符串，判断其是否为合法压缩过的字符串，若输入合法则输出解压缩后的字符串，否则输出字符串“!error”来报告错误。
  
  
  测试用例：
  
  2abcde
  
  @
  
  3aa
  
  aaa5b
  
  3abb4cd
  
 *
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			handleInput(scanner.nextLine());
		}

		scanner.close();
	}

	private static void handleInput(String input) {
		if (!isInputOk(input)) {
			System.out.println("!error");
		}
	}

	private static boolean isInputOk(String input) {
		char[] array = input.toCharArray();

		int num = 0;
		StringBuilder result = new StringBuilder();
		StringBuilder numStr = new StringBuilder();
		char lastChar = 0;//记录上一个append的字母，如果本次连续append的字母与上一个相同，则输入非法，如 a4a
		if (isNum(input.charAt(input.length() - 1))) {//最后一个字母为数字时候,直接返回false
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			int j = i + 1;
			if (isNum(array[i])) {//当前位置为数字时候,判断其后面的字母是否与下一个字母相同
				if (j < array.length && array[j] >= 'a' && array[j] <= 'z' ) {
					if (j + 1 < array.length && array[j] == array[j + 1]) {
						return false;
					}
				}
				numStr.append(array[i]);
				
			} else if (array[i] >= 'a' && array[i] <= 'z') {//当前位置为字母时,判断其后面的字母，以及下一个字母，三个是否相等
				if (j + 1 < array.length) {
					if (array[i] == array[j] && array[j] == array[j + 1]) {
						return false;
					}
				}
				if (numStr.length() > 0) {
					num = Integer.parseInt(numStr.toString());
					if (num < 3) {//当前数字小于3时，直接返回false
						return false;
					}

					if (lastChar == array[i]) {//如果本次连续append的字母与上一个相同，则输入非法
						return false;
					}
					lastChar = array[i];
					for (int index = 0; index < num; index++) {
						result.append(array[i]);
					}
					num = 0;
					numStr = new StringBuilder();
				} else {
					lastChar = array[i];
					result.append(array[i]);
				}
				
			} else {//当前位置为非法字符，直接返回false
				return false;//非法字符
			}
		}
		System.out.println(result.toString());
		return true;
	}

	private static boolean isNum(char c) {
		return c >= '0' && c <= '9';
	}


}
