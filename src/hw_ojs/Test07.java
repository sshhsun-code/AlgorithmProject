package hw_ojs;

import java.util.Scanner;

/**
 * @author CM
 * 
 * ȡ����ֵ
����������22ʱ�����ƣ�1��ռ����ƣ�32768K
ͨ��������57.14%
��Ѽ�¼��0 ms|8460K ������  kd���ݶ���
 �㷨֪ʶ��Ƶ����
��Ŀ����

д��һ�����򣬽���һ��������ֵ���������ֵ�Ľ�������ֵ�����С�������ֵ���ڵ���5,����ȡ����С��5��������ȡ����
��������:

����һ��������ֵ


�������:

�������ֵ�Ľ�������ֵ

��������:

5.5

�������:

6
 *
 */
public class Test07 {

	public Test07() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            float input = scanner.nextFloat();
            System.out.println(floatToNearInt(input));
        }

        scanner.close();
    }
	
	private static int floatToNearInt(float f) {
        return (int) ((f*10 + 5)/10);
    }

}
