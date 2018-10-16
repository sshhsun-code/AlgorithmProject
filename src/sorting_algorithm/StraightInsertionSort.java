package sorting_algorithm;

/**
 * 
 * Title: ���������е�ֱ�Ӳ������������ڳ�ʼ����    
 * Description: �����������в��ϲ����µļ�¼�Դﵽ���������������������Ŀ��
 *              ʱ�临�Ӷȣ��������O(n)��ƽ������O(n^2)���������O(n^2)
 *              �ռ临�Ӷȣ�O(1)
 *              ��    ��   �ԣ��ȶ�
 *              �ڲ�����(���������������Ԫ����ȫ���ڴ�)
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
		
		System.out.println("=============����=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		
		System.out.println("\n=============�����=============");
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
