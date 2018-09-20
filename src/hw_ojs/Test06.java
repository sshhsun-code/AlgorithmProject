package hw_ojs;

import java.util.Scanner;

/**
 * @author CM
 * 
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
详细描述：
函数接口说明：
    public String getResult(long ulDataInput)
输入参数：
    long ulDataInput：输入的正整数
返回值：
    String
    
    输入一个long型整数
    
    按照从小到大的顺序输出它的所有质数的因子，以空格隔开
    
    
    
    输入例子
    
    180
    
    输出例子
    
    2 2 3 3 5
 *
 */
public class Test06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            long num = scan.nextLong();
            isPrimerFactors(num);
        }

	}


		 private static void isPrimerFactors(long num)
		    {
		        long number = num;
		        while(number != 1)
		        {
		            for(int i = 2; i <= number ;i++)
		            {
		                if(number % i == 0)
		                {
		                    number /= i;
		                    System.out.print(i + " ");
		                    break;
		                }
		            }
		        }
		    }

}
