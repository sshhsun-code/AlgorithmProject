package hw_ojs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author sshhsun
 * �����ַ�����
 * 
 * 
 ��Ŀ����
д��һ�����򣬽���һ������ĸ�������Լ��ո���ɵ��ַ�������һ���ַ���Ȼ����������ַ����к��и��ַ��ĸ����������ִ�Сд��
1
��������
����һ������ĸ�������Լ��ո���ɵ��ַ�������һ���ַ���
1
�������
��������ַ����к��и��ַ��ĸ�����
1
��������
ABCDEF
A
1
2
�������
1
 *
 */
public class Test02 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // �Ƿ����������У�һ�ο��Բ��Զ���
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
