package hw_ojs;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author sshhsun
 * 
 * 明明的随机数
 * 
 * 题目描述
明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤100），
然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
Input Param 
n               输入随机数的个数     
inputArray      n个随机整数组成的数组 

Return Value
OutputArray    输出处理后的随机整数

注：测试用例保证输入参数的正确性，答题者无需验证。
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
输入描述
输入多行，先输入随机整数的个数，在输入相应个数的整数
1
输出描述
返回多行，处理后的结果
1
输入例子
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
输出例子
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
 *总结：TreeSet实现Tree是红黑树，已实现排序功能，同时实现Set接口，所以自动去重！！！
 */
public class Test03 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 读取输入的数字数
            int num = scanner.nextInt();
            // 存放输入的数字
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
