package hw_ojs;

import java.util.Scanner;

/**
 * @author sshhsun
 *算法：字符串最后一个单词的长度
 *
 题目描述
计算字符串最后一个单词的长度，单词以空格隔开。
1
输入描述
一行字符串
1
输出描述
整数N，最后一个单词的长度。
1
输入例子
hello world
1
输出例子
5
 *
 */
public class Test01 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			String input = scanner.nextLine();
			if (input.equals(" ")) {
				return;
			}
			System.out.println(findLastWordLength2(input));
        }

        scanner.close();
	}

	private static int findLastWordLength(String input) {
		
		int last = input.length() - 1;
		
		while (last >= 0 && input.charAt(last) == ' ') {
			last --;
		}
		
		int position = last - 1;
		
		while (position >=0 && input.charAt(position) != ' ') {
			position --;
		}
		
		
		return last - position;
	}

	private static int findLastWordLength2(String input) {
		  String[] arr = input.split(" ");
	      return(arr[arr.length-1].length());	
	}

}
