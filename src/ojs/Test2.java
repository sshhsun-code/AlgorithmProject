package ojs;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author sshhsun
 * 
 * 
题目二


LISP语言唯一的语法就是括号要配对。
形如 (OP P1 P2 ...)，括号内元素由单个空格分割。
其中第一个元素OP为操作符，后续元素均为其参数，参数个数取决于操作符类型
注意：参数 P1, P2 也有可能是另外一个嵌套的 (OP P1 P2 ...)
当前OP类型为 add / sub / mul / div（全小写），分别代表整数的加减乘除法
简单起见，所有 OP 参数个数均为 2
举例:
- 输入：(mul 3 -7) 输出：-21
- 输入：(add 1 2) 输出：3
- 输入：(sub (mul 2 4) (div 9 3)) 输出：5
- 输入：(div 1 0) 输出：error
题目涉及数字均为整数，可能为负；不考虑32位溢出翻转。
除零错误时，输出 "error"，除法遇除不尽，取整，即 3/2 = 1
 *
 *
 *  测试用例：
  
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
		
		Stack<Integer> numberBuffer = new Stack<Integer>();//存放操作数
		Stack<String> operationBuffer = new Stack<String>();//存放操作字符
		int mark = 0;//作为一个操作时的开始位置
		int ParameterOne = 0;
		int ParameterTwe = 0;
		
		for(int index = 0;index<inputString.length();index++) {
			if('(' == inputString.charAt(index)) {
				operationBuffer.push(inputString.substring(index+1, index+4));
				index += 4;
				mark = index + 1;
			} else if (')' == inputString.charAt(index)) {
				if(mark < index) {
					numberBuffer.push(Integer.parseInt(inputString.substring(mark, index)));//此时的index位于操作数的下一个位置
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
						numberBuffer.push(Integer.parseInt(inputString.substring(mark, index)));//此时的index位于操作数的下一个位置
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
