package string_test;

public class StrToInt {

	/**
	 * 把字符串转换成整数
	 * 
	 * 重点考虑 溢出处理
	 * 
	 * 			if (symbol == 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)))
			{
				return 0;
			}
			else if (symbol == 1 && (result > -1 * (Integer.MIN_VALUE / 10) || (result == -1 * (Integer.MIN_VALUE / 10) && temp > -1 * (Integer.MIN_VALUE % 10))))
			{
				return 0;
			}
			
			分别为正溢出， 反溢出处理
			
			参考：
			https://github.com/sshhsun-code/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.03.md
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int result = StrToInt("+2147483647");
		System.out.println("" + result);
	}

	static boolean flag = false;

	public static int StrToInt(String str) {
		boolean flag = false;
		// 判断输入是否合法
		if (str == null || str.trim().equals("")) {
			flag = true;
			return 0;
		}
		// symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
		int symbol = 0;
		int start = 0;
		char[] chars = str.trim().toCharArray();
		if (chars[0] == '+') {
			start = 1;
		} else if (chars[0] == '-') {
			start = 1;
			symbol = 1;
		}
		int result = 0;
		for (int i = start; i < chars.length; i++) {
			if (chars[i] > '9' || chars[i] < '0') {
				flag = true;
				return 0;
			}
			int temp = (int) (chars[i] - '0');

//			if ((result - (int) (chars[i] - '0')) / 10 != result) {
//				flag = true;
//				return 0;
//			}
			
			if (symbol == 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)))
			{
				return 0;
			}
			else if (symbol == 1 && (result > -1 * (Integer.MIN_VALUE / 10) || (result == -1 * (Integer.MIN_VALUE / 10) && temp > -1 * (Integer.MIN_VALUE % 10))))
			{
				return 0;
			}

			result = result * 10 + (int) (chars[i] - '0');
			/*
			 * 本人认为java热门第一判断是否溢出是错误的，举个反例 当输入为value=2147483648时，在计算机内部的表示应该是-2147483648
			 * 显然value>Integer.MAX_VALUE是不成立的
			 */
		}
		// 注意：java中-1的n次方不能用：(-1)^n .'^'异或运算
		// 注意，当value=-2147483648时，value=-value
		result = (int) Math.pow(-1, symbol) * result;
		return result;
	}

}
