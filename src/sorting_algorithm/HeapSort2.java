package sorting_algorithm;

/**
 * 
 * Title: 堆排序(选择排序)，升序排序(最大堆)，依赖于初始序列     
 * Description: 现将给定序列调整为最大堆，然后每次将堆顶元素与堆尾元素交换并缩小堆的范围，直到将堆缩小至1
 * 时间复杂度：O(nlgn)
 * 空间复杂度：O(1) 
 * 稳 定 性：不稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 * 
 * 参考：
 * 
 * 
https://blog.csdn.net/justloveyou_/article/details/72730597
 * 
 * 
 * 
 * 总结下堆排序的基本思路：
 * 
 a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;

b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;

c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 * 
 * 
 * @author CM
 *
 */
public class HeapSort2 {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 4, 2, 7, 9, 8, 3, 6 };

		System.out.println("=============输入=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		System.out.println("\n=============堆排序后=============");
		heapSort(num);

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}
	
    public static int[] heapSort(int[] target) {
        if (target != null && target.length > 1) {

            // 调整为最大堆
            int pos = (target.length - 2) / 2;
            while (pos >= 0) {
                shiftDown(target, pos, target.length - 1);
                pos--;
            }

            // 堆排序
            for (int i = target.length-1; i > 0; i--) {
                int temp = target[i];
                target[i] = target[0];
                target[0] = temp;
                shiftDown(target, 0, i-1);
            }
            return target;
        }
        return target;
    }


    /**     
     * @description 自上而下调整为最大堆
     * @author rico       
     * @created 2017年5月25日 上午9:45:40     
     * @param target
     * @param start
     * @param end     
     */
    private static void shiftDown(int[] target, int start, int end) {
        int i = start;
        int j = 2 * start + 1;
        int temp = target[i];
        while (j <= end) {   // 迭代条件
            if (j < end && target[j + 1] > target[j]) {  //找出较大子女
                j = j + 1;
            }
            if (target[j] <= temp) {  // 父亲大于子女
                break;
            } else {
                target[i] = target[j];
                i = j;
                j = 2 * j + 1;
            }
        }
        target[i] = temp;
    }
    
    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
