package string_test;

public class StrToInt {

	/**
	 * ���ַ���ת��������
	 * 
	 * �ص㿼�� �������
	 * 
	 * 			if (symbol == 0 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10)))
			{
				return 0;
			}
			else if (symbol == 1 && (result > -1 * (Integer.MIN_VALUE / 10) || (result == -1 * (Integer.MIN_VALUE / 10) && temp > -1 * (Integer.MIN_VALUE % 10))))
			{
				return 0;
			}
			
			�ֱ�Ϊ������� ���������
			
			�ο���
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
		// �ж������Ƿ�Ϸ�
		if (str == null || str.trim().equals("")) {
			flag = true;
			return 0;
		}
		// symbol=0,˵������Ϊ����;symbol=1������Ϊ����;start�������ֵ�һλ�Ƿ�Ϊ����λ
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
			 * ������Ϊjava���ŵ�һ�ж��Ƿ�����Ǵ���ģ��ٸ����� ������Ϊvalue=2147483648ʱ���ڼ�����ڲ��ı�ʾӦ����-2147483648
			 * ��Ȼvalue>Integer.MAX_VALUE�ǲ�������
			 */
		}
		// ע�⣺java��-1��n�η������ã�(-1)^n .'^'�������
		// ע�⣬��value=-2147483648ʱ��value=-value
		result = (int) Math.pow(-1, symbol) * result;
		return result;
	}

}
