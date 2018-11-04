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
 * �ο���
 * 
 * 
https://blog.csdn.net/justloveyou_/article/details/72730597
 * 
 * 
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
public class HeapSort2 {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 4, 2, 7, 9, 8, 3, 6 };

		System.out.println("=============����=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		System.out.println("\n=============�������=============");
		heapSort(num);

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}
	
    public static int[] heapSort(int[] target) {
        if (target != null && target.length > 1) {

            // ����Ϊ����
            int pos = (target.length - 2) / 2;
            while (pos >= 0) {
                shiftDown(target, pos, target.length - 1);
                pos--;
            }

            // ������
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
     * @description ���϶��µ���Ϊ����
     * @author rico       
     * @created 2017��5��25�� ����9:45:40     
     * @param target
     * @param start
     * @param end     
     */
    private static void shiftDown(int[] target, int start, int end) {
        int i = start;
        int j = 2 * start + 1;
        int temp = target[i];
        while (j <= end) {   // ��������
            if (j < end && target[j + 1] > target[j]) {  //�ҳ��ϴ���Ů
                j = j + 1;
            }
            if (target[j] <= temp) {  // ���״�����Ů
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
