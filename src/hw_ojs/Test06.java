package hw_ojs;

import java.util.Scanner;

/**
 * @author CM
 * 
 * ����:����һ�������������մ�С�����˳����������������������ӣ���180����������Ϊ2 2 3 3 5 ��
��ϸ������
�����ӿ�˵����
    public String getResult(long ulDataInput)
���������
    long ulDataInput�������������
����ֵ��
    String
    
    ����һ��long������
    
    ���մ�С�����˳����������������������ӣ��Կո����
    
    
    
    ��������
    
    180
    
    �������
    
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
