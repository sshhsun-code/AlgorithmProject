package hw_ojs;

import java.util.Scanner;

/**
 * @author sshhsun
 *
 *字符串分隔
 *
 *
 *
题目描述
•连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

输入描述
连续输入字符串(输入2次,每个字符串长度小于100)
输出描述
输出到长度为8的新字符串数组
输入例子
abc
123456789
输出例子
abc00000
12345678
90000000
 */
public class Test04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder(256);
        while (scanner.hasNext()) {
            builder.setLength(0);
            String input = scanner.nextLine();
            stringSplit(builder, input);
            input = scanner.nextLine();
            stringSplit(builder, input);
            System.out.print(builder);
        }

        scanner.close();
    }

	private static void stringSplit(StringBuilder builder, String input) {
		if (input == null || input.length() < 1) {
			return;
		}
		
		int position = 0;
		
		while((position += 8) < input.length()) {
			builder.append(input.substring(position - 8, position)).append("\n");
		}
		
		if (input.length() <= position) {

			builder.append(input.substring(position - 8, input.length()));
			
			for (int i = input.length(); i < position; i++) {
                builder.append(0);
            }
            builder.append("\n");
		}
	}
	
	
	private static void stringSplit2(StringBuilder builder, String str) {
        if (str == null || str.length() < 1) {
            return;
        }

        int pos = 0;
        while ((pos += 8) < str.length()) {
            builder.append(str.substring(pos - 8, pos)).append("\n");

        }

        // 如果str.length() < pos，说明最后的不足8个字符或者刚好8个
        if (str.length() <= pos) {
            builder.append(str.substring(pos - 8, str.length()));

            for (int i = str.length(); i < pos; i++) {
                builder.append(0);
            }
            builder.append("\n");
        }
    }

}
