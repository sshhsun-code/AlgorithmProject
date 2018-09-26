package ojs;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author sshhsun
 * 
 * 
��Ŀ��


LISP����Ψһ���﷨��������Ҫ��ԡ�
���� (OP P1 P2 ...)��������Ԫ���ɵ����ո�ָ
���е�һ��Ԫ��OPΪ������������Ԫ�ؾ�Ϊ���������������ȡ���ڲ���������
ע�⣺���� P1, P2 Ҳ�п���������һ��Ƕ�׵� (OP P1 P2 ...)
��ǰOP����Ϊ add / sub / mul / div��ȫСд�����ֱ���������ļӼ��˳���
����������� OP ����������Ϊ 2
����:
- ���룺(mul 3 -7) �����-21
- ���룺(add 1 2) �����3
- ���룺(sub (mul 2 4) (div 9 3)) �����5
- ���룺(div 1 0) �����error
��Ŀ�漰���־�Ϊ����������Ϊ����������32λ�����ת��
�������ʱ����� "error"����������������ȡ������ 3/2 = 1
 *
 *
 *  ����������
  
 (mul 3 -7)
  
 (div 5 (sub 4 (add 3 1)))
  
 (sub (mul 2 4) (div 9 3))

  
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			handleStr(scanner.nextLine());
		}

		scanner.close();
	}
	
	private static void handleStr(String input) {
		StringBuffer inputString = new StringBuffer(input);
		
		Stack<Integer> numberBuffer = new Stack<Integer>();//��Ų�����
		Stack<String> operationBuffer = new Stack<String>();//��Ų����ַ�
		int mark = 0;//��Ϊһ������ʱ�Ŀ�ʼλ��
		int ParameterOne = 0;
		int ParameterTwe = 0;
		
		for(int index = 0;index<inputString.length();index++) {
			if('(' == inputString.charAt(index)) {
				operationBuffer.push(inputString.substring(index+1, index+4));
				index += 4;
				mark = index + 1;
			} else if (')' == inputString.charAt(index)) {
				if(mark < index) {
					numberBuffer.push(Integer.parseInt(inputString.substring(mark, index)));//��ʱ��indexλ�ڲ���������һ��λ��
					index++;
					mark = index+1;
				}
				ParameterTwe = numberBuffer.pop();
				ParameterOne = numberBuffer.pop();
				
				switch(operationBuffer.pop()) {
				case "add":
					numberBuffer.push(ParameterOne + ParameterTwe);
					break;
				case "sub":
					numberBuffer.push(ParameterOne - ParameterTwe);
					break;
				case "mul":
					numberBuffer.push(ParameterOne * ParameterTwe);
					break;
				case "div":
					if(ParameterTwe == 0) { 
						System.out.println("error");
						return;
						}
					else{
						numberBuffer.push(ParameterOne / ParameterTwe);
						}
					break;
				}
				
			}else {
				if(' ' == inputString.charAt(index)) {
					if(mark < index) {
						numberBuffer.push(Integer.parseInt(inputString.substring(mark, index)));//��ʱ��indexλ�ڲ���������һ��λ��
						//index++;
						mark = index+1;
					}
				}
			}
		}
		
		while(!operationBuffer.isEmpty()) {
			ParameterTwe = numberBuffer.pop();
			ParameterOne = numberBuffer.pop();
			
			switch(operationBuffer.pop()) {
			case "add":
				numberBuffer.push(ParameterOne + ParameterTwe);
				break;
			case "sub":
				numberBuffer.push(ParameterOne - ParameterTwe);
				break;
			case "mul":
				numberBuffer.push(ParameterOne * ParameterTwe);
				break;
			case "div":
				if(ParameterTwe == 0) { 
					System.out.println("error");
					return;
					}
				else {
					numberBuffer.push(ParameterOne / ParameterTwe);
					}
				break;
			}
			
		}
		
		System.out.println(numberBuffer.pop().toString());
		return;
	}

}
