package string_test;

/**
 * 字符串 全排列
 * 
 * 参考
 * https://github.com/sshhsun-code/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.06.md#%E5%AD%97%E7%AC%A6%E4%B8%B2%E7%9A%84%E5%85%A8%E6%8E%92%E5%88%97
 * 
 * 
 * https://www.cnblogs.com/liuzhen1995/p/6395361.html
 * 
 * 
 * @author sshhsun
 *
 */
public class CalcAllPermutation {

	public static void main(String[] args) {
		String test = "abcd"; 
		callAllPermutation(test.toCharArray(), 0, test.length() - 1);

	}
	
	public static void callAllPermutation(char[] arrayA,int start,int end) {
		
		if (start == end) {//start == end时候，说明交换流程结束，就开始打印此次排序后的序列
			for (int i = 0; i < arrayA.length; i++) {
				System.out.print(arrayA[i]);
			}
			System.out.println("");
		} else {
			for (int i = start; i <= end; i++) {
				swap(arrayA, i, start);
				callAllPermutation(arrayA, start+1, end);
				swap(arrayA, i, start);
			}
		}
		
	}
	
	private static void swap(char[] arrayA,int m,int n){
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }

}
