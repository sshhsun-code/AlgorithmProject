package string_test;

/**
 * @author sshhsun
 * 
 * 字典序排列
 * 
 * 参考
 * 
 * https://github.com/sshhsun-code/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.06.md
 * 
 * 
 * 
 * 比如说，现在我们要找21543的下一个排列，我们可以从左至右逐个扫描每个数，看哪个能增大（至于如何判定能增大，是根据如果一个数右面有比它大的数存在，那么这个数就能增大），我们可以看到最后一个能增大的数是：x = 1。

而1应该增大到多少？1能增大到它右面比它大的那一系列数中最小的那个数，即：y = 3，故此时21543的下一个排列应该变为23xxx，显然 xxx(对应之前的B’）应由小到大排，于是我们最终找到比“21543”大，但字典顺序尽量小的23145，找到的23145刚好比21543大。

由这个例子可以得出next_permutation算法流程为：

next_permutation算法

定义

升序：相邻两个位置ai < ai+1，ai 称作该升序的首位

步骤（二找、一交换、一翻转）

找到排列中最后（最右）一个升序的首位位置i，x = ai

找到排列中第i位右边最后一个比ai 大的位置j，y = aj

交换x，y

把第(i+ 1)位到最后的部分翻转

还是拿上面的21543举例，那么，应用next_permutation算法的过程如下：

x = 1；
y = 3
1和3交换
得23541
翻转541
得23145
23145即为所求的21543的下一个排列
 * 
 * 
 * 
 * https://www.jianshu.com/p/db90675cb82b
 * 
 * 
 * 
 *
 */
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	boolean CalcAllPermutation(char[] perm, int num){
		int i;

		//①找到排列中最后（最右）一个升序的首位位置i，x = ai
		for (i = num - 2; (i >= 0) && (perm[i] >= perm[i + 1]); --i){
			;
		}
		// 已经找到所有排列
		if (i < 0){
			return false;
		}

		int k;
		//②找到排列中第i位右边最后一个比ai 大的位置j，y = aj
		for (k = num - 1; (k > i) && (perm[k] <= perm[i]); --k){
			;
		}

		//③交换x，y
		swap(perm,i, k);
		//④把第(i+ 1)位到最后的部分翻转
		reverse(perm, i + 1, num);
		return true;
	}
	
	private static void reverse(char[] arrayA,int m,int n){
		//todo  m到n进行翻转
	}
	
	private static void swap(char[] arrayA,int m,int n){
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }

}
