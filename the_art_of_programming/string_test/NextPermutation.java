package string_test;

/**
 * @author sshhsun
 * 
 * �ֵ�������
 * 
 * �ο�
 * 
 * https://github.com/sshhsun-code/The-Art-Of-Programming-By-July/blob/master/ebook/zh/01.06.md
 * 
 * 
 * 
 * ����˵����������Ҫ��21543����һ�����У����ǿ��Դ����������ɨ��ÿ���������ĸ���������������ж��������Ǹ������һ���������б�����������ڣ���ô������������󣩣����ǿ��Կ������һ������������ǣ�x = 1��

��1Ӧ�����󵽶��٣�1��������������������һϵ��������С���Ǹ���������y = 3���ʴ�ʱ21543����һ������Ӧ�ñ�Ϊ23xxx����Ȼ xxx(��Ӧ֮ǰ��B����Ӧ��С�����ţ��������������ҵ��ȡ�21543���󣬵��ֵ�˳����С��23145���ҵ���23145�պñ�21543��

��������ӿ��Եó�next_permutation�㷨����Ϊ��

next_permutation�㷨

����

������������λ��ai < ai+1��ai �������������λ

���裨���ҡ�һ������һ��ת��

�ҵ�������������ң�һ���������λλ��i��x = ai

�ҵ������е�iλ�ұ����һ����ai ���λ��j��y = aj

����x��y

�ѵ�(i+ 1)λ�����Ĳ��ַ�ת

�����������21543��������ô��Ӧ��next_permutation�㷨�Ĺ������£�

x = 1��
y = 3
1��3����
��23541
��ת541
��23145
23145��Ϊ�����21543����һ������
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

		//���ҵ�������������ң�һ���������λλ��i��x = ai
		for (i = num - 2; (i >= 0) && (perm[i] >= perm[i + 1]); --i){
			;
		}
		// �Ѿ��ҵ���������
		if (i < 0){
			return false;
		}

		int k;
		//���ҵ������е�iλ�ұ����һ����ai ���λ��j��y = aj
		for (k = num - 1; (k > i) && (perm[k] <= perm[i]); --k){
			;
		}

		//�۽���x��y
		swap(perm,i, k);
		//�ܰѵ�(i+ 1)λ�����Ĳ��ַ�ת
		reverse(perm, i + 1, num);
		return true;
	}
	
	private static void reverse(char[] arrayA,int m,int n){
		//todo  m��n���з�ת
	}
	
	private static void swap(char[] arrayA,int m,int n){
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }

}
