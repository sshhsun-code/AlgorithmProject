package hw_ojs;

import java.util.Scanner;

/**
 * @author CM
 * 
 * 取近似值
参与人数：22时间限制：1秒空间限制：32768K
通过比例：57.14%
最佳记录：0 ms|8460K （来自  kd丹妮儿）
 算法知识视频讲解
题目描述

写出一个程序，接受一个浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
输入描述:

输入一个浮点数值


输出描述:

输出该数值的近似整数值

输入例子:

5.5

输出例子:

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
