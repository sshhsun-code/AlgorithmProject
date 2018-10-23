package hw_ojs;

import java.util.Scanner;

public class Main {

	public Main() {

	}

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
					for (int index = 0; index < num; index++) {
						result.append(array[i]);
					}
					num = 0;
					numStr = new StringBuilder();
				} else {
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
