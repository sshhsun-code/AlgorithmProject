package ojs;

import java.util.Scanner;

/**
 * @author sshhsun
 * 
 * ��Ŀһ��
  ��һ�ּ���ѹ���㷨�����ȫ����СдӢ����ĸ��ɵ��ַ�������������������������ͬ��ĸ�Ĳ���ѹ��Ϊ���������Ӹ���ĸ���������ֱ���ԭ�����䡣

  ���磺�ַ�����aaabbccccd������ѹ����Ϊ�ַ�����3abb4cd����

  ������дһ��unzip����������������ַ������ж����Ƿ�Ϊ�Ϸ�ѹ�������ַ�����������Ϸ��������ѹ������ַ�������������ַ�����!error�����������
  
  
  ����������
  
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
		char lastChar = 0;//��¼��һ��append����ĸ�������������append����ĸ����һ����ͬ��������Ƿ����� a4a
		if (isNum(input.charAt(input.length() - 1))) {//���һ����ĸΪ����ʱ��,ֱ�ӷ���false
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			int j = i + 1;
			if (isNum(array[i])) {//��ǰλ��Ϊ����ʱ��,�ж���������ĸ�Ƿ�����һ����ĸ��ͬ
				if (j < array.length && array[j] >= 'a' && array[j] <= 'z' ) {
					if (j + 1 < array.length && array[j] == array[j + 1]) {
						return false;
					}
				}
				numStr.append(array[i]);
				
			} else if (array[i] >= 'a' && array[i] <= 'z') {//��ǰλ��Ϊ��ĸʱ,�ж���������ĸ���Լ���һ����ĸ�������Ƿ����
				if (j + 1 < array.length) {
					if (array[i] == array[j] && array[j] == array[j + 1]) {
						return false;
					}
				}
				if (numStr.length() > 0) {
					num = Integer.parseInt(numStr.toString());
					if (num < 3) {//��ǰ����С��3ʱ��ֱ�ӷ���false
						return false;
					}

					if (lastChar == array[i]) {//�����������append����ĸ����һ����ͬ��������Ƿ�
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
				
			} else {//��ǰλ��Ϊ�Ƿ��ַ���ֱ�ӷ���false
				return false;//�Ƿ��ַ�
			}
		}
		System.out.println(result.toString());
		return true;
	}

	private static boolean isNum(char c) {
		return c >= '0' && c <= '9';
	}


}
