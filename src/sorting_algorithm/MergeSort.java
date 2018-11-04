package sorting_algorithm;

import java.util.Arrays;

/**
 * 
 * 
 * 归并排序包含两个过程：”归”和”并”。其中，”归”是指将原序列分成半子序列，分别对子序列进行递归排序；
 * ”并”是指将排好序的各子序列合并成原序列。归并排序算法是一个典型的递归算法，因此也是概念上最为简
 * 单的排序算法。与快速排序算法相比，归并排序算法不依赖于初始序列，并且是一种稳定的排序算法，但需
 * 要与原序列一样大小的辅助存储空间。
 * 
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略
 * （分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之
 * 
 * 
 * 参考：
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

		System.out.println("=============输入=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		mergeSort(num);
		
		System.out.println("\n=============归并排序后=============");

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}
	
    public static void mergeSort(int[] target) {
        int[] copy = Arrays.copyOf(target, target.length);    // 空间复杂度O(n)
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
     * @description 两路归并算法
     * @author rico
     * @created 2017年5月20日 下午3:59:16
     * @param target
     *            用于存储归并结果
     * @param left
     *            第一个有序表的第一个元素所在位置
     * @param mid
     *            第一个有序表的最后一个元素所在位置
     * @param right
     *            第二个有序表的最后一个元素所在位置
     * @return
     */
    public static void merge(int[] target, int[] copy, int left, int mid,
            int right) {

        // s1,s2是检查指针，index 是存放指针
        int s1 = left;
        int s2 = mid + 1;
        int index = left;

        // 两个表都未检查完，两两比较
        while (s1 <= mid && s2 <= right) {
            if (copy[s1] <= copy[s2]) { // 稳定性
                target[index++] = copy[s1++];
            } else {
                target[index++] = copy[s2++];
            }
        }

        // 若第一个表未检查完，复制
        while (s1 <= mid) {
            target[index++] = copy[s1++];
        }

        // 若第二个表未检查完，复制
        while (s2 <= right) {
            target[index++] = copy[s2++];
        }

        // 更新辅助数组 copy
        for (int i = left; i <= right; i++) {
            copy[i] = target[i];
        }
    }

}
