package sorting_algorithm;

/**
 * Title: ���������е�ϣ�����������ڳ�ʼ����    
 * Description: �ֱ�Լ��Ϊgap��gap�������н���ֱ�Ӳ������򣬲�����Сgap,ֱ��Ϊ 1 
 * 
 *              �տ�ʼʱ��gap�ϴ�ÿ��������Ԫ�ؽ��٣������ٶȽϿ죻
 *              ����������ڣ�gap��С��ÿ��������Ԫ�ؽ϶࣬���󲿷�Ԫ�ػ����������������ٶ��ԽϿ졣                
 * 
 *              ʱ�临�Ӷȣ�O(n) ~ O(n^2)
 *              �ռ临�Ӷȣ�O(1)
 *              ��    ��   �ԣ����ȶ�
 *              �ڲ�����(���������������Ԫ����ȫ���ڴ�)
 *              
 *  �ο��� 
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
		
		System.out.println("=============����=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		
		System.out.println("\n=============�����=============");
		shellSort(num);
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
	
    /**
     * ϣ������ ������������ڲ���ʱ���ý�����
     * @param arr
     */
    public static void shellSort(int []arr){
        //����gap��������С����
       for(int gap=arr.length/2;gap>0;gap/=2){
           //�ӵ�gap��Ԫ�أ�����������������ֱ�Ӳ����������
           for(int i=gap;i<arr.length;i++){
               int j = i;
               while(j-gap>=0 && arr[j]<arr[j-gap]){
                   //����������ý�����
                   swap(arr,j,j-gap);
                   j-=gap;
               }
           }
       }
    }
    
    /**
     * ��������Ԫ��
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
