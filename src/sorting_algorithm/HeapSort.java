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
 * 
 * 
 *  * 
 * 参考：
 * 
 * https://www.cnblogs.com/chengxiao/p/6129630.html
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
public class HeapSort {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 4, 2, 7, 9, 8, 3, 6 };

		System.out.println("=============输入=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		System.out.println("\n=============堆排序后=============");
		sort(num);

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}
	
    public static void sort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }
	
	
	public static void adjustHeap(int []arr,int i,int length) {
		int temp = arr[i];
		
		for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
			if(k+1<length && arr[k] < arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(temp < arr[k] ){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;//i 始终指向调整范围内的最大值的index
            }else{
                break;
            }
		}
		
		arr[i] = temp;//将temp值放到最终的位置
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
