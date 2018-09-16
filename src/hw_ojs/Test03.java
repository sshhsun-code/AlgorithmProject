package hw_ojs;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author sshhsun
 * 
 * �����������
 * 
 * ��Ŀ����
��������ѧУ����һЩͬѧһ����һ���ʾ���飬Ϊ��ʵ��Ŀ͹��ԣ������ü����������N��1��1000֮������������N��100����
Ȼ���ٰ���Щ����С�������򣬰����źõ�˳��ȥ��ͬѧ�����顣����Э��������ɡ�ȥ�ء��롰���򡱵Ĺ�����
Input Param 
n               ����������ĸ���     
inputArray      n�����������ɵ����� 

Return Value
OutputArray    ����������������

ע������������֤�����������ȷ�ԣ�������������֤��
1
2
3
4
5
6
7
8
9
10
��������
������У���������������ĸ�������������Ӧ����������
1
�������
���ض��У������Ľ��
1
��������
11
10
20
40
32
67
40
20
89
300
400
15
1
2
3
4
5
6
7
8
9
10
11
12
�������
10
15
20
32
40
67
89
300
400
 *
 *
 *
 *
 *
 *�ܽ᣺TreeSetʵ��Tree�Ǻ��������ʵ�������ܣ�ͬʱʵ��Set�ӿڣ������Զ�ȥ�أ�����
 */
public class Test03 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // ��ȡ�����������
            int num = scanner.nextInt();
            // ������������
            Set<Integer> set = new TreeSet<>();
            while ((--num) >= 0) {
                set.add(scanner.nextInt());
            }

            System.out.print(setToString(set));
        }
	
	

}

	private static String setToString(Set<Integer> set) {
		Iterator<Integer> it=set.iterator();
		StringBuilder builder = new StringBuilder(128);
		while(it.hasNext()){
			builder.append(it.next()).append("\n");
        }
		return builder.toString();
	}
	
}
