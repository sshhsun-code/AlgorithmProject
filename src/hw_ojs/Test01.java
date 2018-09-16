package hw_ojs;

import java.util.Scanner;

/**
 * @author sshhsun
 *�㷨���ַ������һ�����ʵĳ���
 *
 ��Ŀ����
�����ַ������һ�����ʵĳ��ȣ������Կո������
1
��������
һ���ַ���
1
�������
����N�����һ�����ʵĳ��ȡ�
1
��������
hello world
1
�������
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
