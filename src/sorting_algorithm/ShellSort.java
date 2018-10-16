package sorting_algorithm;

/**
 * Title: 插入排序中的希尔排序，依赖于初始序列    
 * Description: 分别对间隔为gap的gap个子序列进行直接插入排序，不断缩小gap,直至为 1 
 * 
 *              刚开始时，gap较大，每个子序列元素较少，排序速度较快；
 *              待到排序后期，gap变小，每个子序列元素较多，但大部分元素基本有序，所以排序速度仍较快。                
 * 
 *              时间复杂度：O(n) ~ O(n^2)
 *              空间复杂度：O(1)
 *              稳    定   性：不稳定
 *              内部排序(在排序过程中数据元素完全在内存)
 *              
 *  参考： 
 *  https://blog.csdn.net/justloveyou_/article/details/72730597
 *  
 *  https://www.cnblogs.com/chengxiao/p/6104371.html
 * 
 * 
 * @author CM
 *
 */
public class ShellSort {

	public ShellSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] {1,4,2,7,9,8,3,6};
		
		System.out.println("=============输入=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		
		System.out.println("\n=============排序后=============");
		shellSort(num);
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
	
    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     * @param arr
     */
    public static void shellSort(int []arr){
        //增量gap，并逐步缩小增量
       for(int gap=arr.length/2;gap>0;gap/=2){
           //从第gap个元素，逐个对其所在组进行直接插入排序操作
           for(int i=gap;i<arr.length;i++){
               int j = i;
               while(j-gap>=0 && arr[j]<arr[j-gap]){
                   //插入排序采用交换法
                   swap(arr,j,j-gap);
                   j-=gap;
               }
           }
       }
    }
    
    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
	

}
