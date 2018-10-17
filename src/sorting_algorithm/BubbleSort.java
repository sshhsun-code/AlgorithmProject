package sorting_algorithm;

/**
 * 
 * Title: 交换排序中的冒泡排序 ，一般情形下指的是优化后的冒泡排序，最多进行n-1次比较，依赖于初始序列  
 * Description:因为越大的元素会经由交换慢慢"浮"到数列的顶端(最后位置)，最大的数最后才确定下来，所以称为冒泡排序
 * 时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2) 
 * 空间复杂度：O(1) 
 * 稳 定 性：稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 * 
 * 冒泡排序的思想：根据序列中两个元素的比较结果来对换这两个记录在序列中的位置，将键值较大的记录向序列的尾部移动，键值较小的记录向序
 * 列的前部移动。因此，每一趟都将较小的元素移到前面，较大的元素自然就逐渐沉到最后面了，也就是说，最大的元素最后才能确定，这就是冒泡。
 * 冒泡排序是一种稳定的排序算法
 * 
 * 
 * 冒泡排序的基本思想是，对相邻的元素进行两两比较，顺序相反则进行交换，这样，每一趟会将最小或最大的元素“浮”到顶端，最终达到完全有序
 * 
 * 在冒泡排序的过程中，如果某一趟执行完毕，没有做任何一次交换操作，比如数组[5,4,1,2,3]，执行了两次冒泡，也就是两次外循环之后，分别将
 * 5和4调整到最终位置[1,2,3,4,5]。此时，再执行第三次循环后，一次交换都没有做，这就说明剩下的序列已经是有序的，排序操作也就可以完成了，
 * 来看下代码
 * 
 * 
 * @author CM
 *
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		
		int[] num = new int[] { 1, 4, 2, 7, 9, 8, 3, 6 };

		System.out.println("=============输入=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		System.out.println("\n=============冒泡排序后=============");
		bubbleSort(num);

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		
		
	}
	
	/**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;//设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已然完成。
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
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
