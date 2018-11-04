package sorting_algorithm;

/**
 * Title: ѡ�������е�ֱ��ѡ�����������ڳ�ʼ����     
 * Description: ÿһ�� (�����i�ˣ�i = 0,1,...)�ں����n-i��������Ԫ����ѡ����СԪ����Ϊ�������еĵ�i��Ԫ��
 *              ʱ�临�Ӷȣ��������O(n^2)��ƽ������O(n^2)���������O(n^2)
 *              �ռ临�Ӷȣ�O(1)
 *              ��    ��   �ԣ����ȶ�
 *              �ڲ�����(���������������Ԫ����ȫ���ڴ�) 
 * 
 * 
 * 
 * @author CM
 *
 */
public class StraightSelectSort {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 4, 2, 7, 9, 8, 3, 6 };

		System.out.println("=============����=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		System.out.println("\n=============ֱ��ѡ�������=============");
		selectSort(num);

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}

	public static int[] selectSort(int[] target) {
		if (target != null && target.length > 0) {

			for (int i = 0; i < target.length; i++) {
				int min = i;
				for (int j = i + 1; j < target.length; j++) {

					if (target[j] < target[min]) {
						min = j;
					}
				}

				if (min != i) { // ���²��ȶ������أ�����
					int temp = target[min];
					target[min] = target[i];
					target[i] = temp;
				}

			}
		}

		return target;
	}

}
