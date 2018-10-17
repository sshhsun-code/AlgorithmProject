package sorting_algorithm;

import java.util.Arrays;

/**
 * 
 * 
 * �鲢��������������̣����顱�͡����������У����顱��ָ��ԭ���зֳɰ������У��ֱ�������н��еݹ�����
 * ��������ָ���ź���ĸ������кϲ���ԭ���С��鲢�����㷨��һ�����͵ĵݹ��㷨�����Ҳ�Ǹ�������Ϊ��
 * ���������㷨������������㷨��ȣ��鲢�����㷨�������ڳ�ʼ���У�������һ���ȶ��������㷨������
 * Ҫ��ԭ����һ����С�ĸ����洢�ռ䡣
 * 
 * �鲢����MERGE-SORT�������ù鲢��˼��ʵ�ֵ����򷽷������㷨���þ���ķ��Σ�divide-and-conquer������
 * �����η��������(divide)��һЩС������Ȼ��ݹ���⣬����(conquer)�Ľ׶��򽫷ֵĽ׶εõ��ĸ���"�޲�"��һ�𣬼��ֶ���֮
 * 
 * 
 * �ο���
 * 
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 * 
 * 
 * @author CM
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 4, 2, 7, 9, 8, 3, 6 };

		System.out.println("=============����=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		mergeSort(num);
		
		System.out.println("\n=============�鲢�����=============");

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}
	
    public static void mergeSort(int[] target) {
        int[] copy = Arrays.copyOf(target, target.length);    // �ռ临�Ӷ�O(n)
        mergeSort(target, copy, 0, target.length - 1);
    }

	private static void mergeSort(int[] target, int[] copy, int left, int right) {
		if (left < right) {
			int mid = (left + right) /2;
			mergeSort(target, copy, left, mid);
			mergeSort(target, copy, mid + 1, right);
			merge(target, copy, left, mid, right);
		}
		
	}
	
    /**
     * @description ��·�鲢�㷨
     * @author rico
     * @created 2017��5��20�� ����3:59:16
     * @param target
     *            ���ڴ洢�鲢���
     * @param left
     *            ��һ�������ĵ�һ��Ԫ������λ��
     * @param mid
     *            ��һ�����������һ��Ԫ������λ��
     * @param right
     *            �ڶ������������һ��Ԫ������λ��
     * @return
     */
    public static void merge(int[] target, int[] copy, int left, int mid,
            int right) {

        // s1,s2�Ǽ��ָ�룬index �Ǵ��ָ��
        int s1 = left;
        int s2 = mid + 1;
        int index = left;

        // ������δ����꣬�����Ƚ�
        while (s1 <= mid && s2 <= right) {
            if (copy[s1] <= copy[s2]) { // �ȶ���
                target[index++] = copy[s1++];
            } else {
                target[index++] = copy[s2++];
            }
        }

        // ����һ����δ����꣬����
        while (s1 <= mid) {
            target[index++] = copy[s1++];
        }

        // ���ڶ�����δ����꣬����
        while (s2 <= right) {
            target[index++] = copy[s2++];
        }

        // ���¸������� copy
        for (int i = left; i <= right; i++) {
            copy[i] = target[i];
        }
    }

}
