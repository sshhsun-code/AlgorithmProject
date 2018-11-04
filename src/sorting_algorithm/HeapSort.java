package sorting_algorithm;

/**
 * 
 * Title: ������(ѡ������)����������(����)�������ڳ�ʼ����     
 * Description: �ֽ��������е���Ϊ���ѣ�Ȼ��ÿ�ν��Ѷ�Ԫ�����βԪ�ؽ�������С�ѵķ�Χ��ֱ��������С��1
 * ʱ�临�Ӷȣ�O(nlgn)
 * �ռ临�Ӷȣ�O(1) 
 * �� �� �ԣ����ȶ�
 * �ڲ�����(���������������Ԫ����ȫ���ڴ�)
 * 
 * 
 * 
 *  * 
 * �ο���
 * 
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * 
 * �ܽ��¶�����Ļ���˼·��
 * 
 a.���������й�����һ���ѣ���������������ѡ��󶥶ѻ�С����;

b.���Ѷ�Ԫ����ĩβԪ�ؽ����������Ԫ��"��"������ĩ��;

c.���µ����ṹ��ʹ������Ѷ��壬Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ�أ�����ִ�е���+�������裬ֱ��������������
 * 
 * 
 * @author CM
 *
 */
public class HeapSort {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 4, 2, 7, 9, 8, 3, 6 };

		System.out.println("=============����=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		System.out.println("\n=============�������=============");
		sort(num);

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}
	
    public static void sort(int []arr){
        //1.�����󶥶�
        for(int i=arr.length/2-1;i>=0;i--){
            //�ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
            adjustHeap(arr,i,arr.length);
        }
        //2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//���Ѷ�Ԫ����ĩβԪ�ؽ��н���
            adjustHeap(arr,0,j);//���¶Զѽ��е���
        }

    }
	
	
	public static void adjustHeap(int []arr,int i,int length) {
		int temp = arr[i];
		
		for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {//��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
			if(k+1<length && arr[k] < arr[k+1]){//������ӽ��С�����ӽ�㣬kָ�����ӽ��
                k++;
            }
            if(temp < arr[k] ){//����ӽڵ���ڸ��ڵ㣬���ӽڵ�ֵ�������ڵ㣨���ý��н�����
                arr[i] = arr[k];
                i = k;//i ʼ��ָ�������Χ�ڵ����ֵ��index
            }else{
                break;
            }
		}
		
		arr[i] = temp;//��tempֵ�ŵ����յ�λ��
	}
	
    /**
     * ����Ԫ��
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
