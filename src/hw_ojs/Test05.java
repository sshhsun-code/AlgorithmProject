package hw_ojs;

import java.util.Scanner;

/**
 * @author sshhsun
 *
 *����ת��
 *
 *
 ��Ŀ����
д��һ�����򣬽���һ��ʮ�����Ƶ���ֵ�ַ������������ֵ��ʮ�����ַ�����������ͬʱ���� ��

��������
����һ��ʮ�����Ƶ���ֵ�ַ�����
�������
�������ֵ��ʮ�����ַ���
��������
0xA
�������
10




ע����Ƴ˷��ı��Σ���������������չ
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
