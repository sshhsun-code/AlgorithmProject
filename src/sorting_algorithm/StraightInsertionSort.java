package sorting_algorithm;

/**
 * 
 * Title: 插入排序中的直接插入排序，依赖于初始序列    
 * Description: 在有序序列中不断插入新的记录以达到扩大有序区到整个数组的目的
 *              时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
 *              空间复杂度：O(1)
 *              稳    定   性：稳定
 *              内部排序(在排序过程中数据元素完全在内存)
 * @author CM
 *
 */
public class StraightInsertionSort {

	public StraightInsertionSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] {6, 2, 4, 5,3,0};
		
		System.out.println("=============输入=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		
		System.out.println("\n=============排序后=============");
		insertSort(num);
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}

	public static int[] insertSort(int[] target) {

		if (target != null && target.length > 0) {
			for (int i = 1; i < target.length; i++) {
				for (int j = i; j > 0; j--) {
					
					if (target[j] < target[j - 1]) {
						int temp = target[j];
                        target[j] = target[j-1];
                        target[j-1] = temp;
					}

				}
			}
		}

		return target;
	}

}
