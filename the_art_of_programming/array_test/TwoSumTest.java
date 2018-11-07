package array_test;

/**
 * @author sshhsun
 * 
 * Ѱ�Һ�Ϊ��ֵ��������
 * 
 * https://github.com/sshhsun-code/The-Art-Of-Programming-By-July/blob/master/ebook/zh/02.02.md
 *
 */
public class TwoSumTest {
	
	public static void main(String[] args) {
		
		int[] data = new int[] {1, 2, 5, 6, 9, 10, 15, 22};
		new TwoSumTest().TwoSum(data, 19);
	}
	
	void TwoSum(int data[], int sum)
	{
		//sort(s, s+n);   ������������ģ��Ǿ������ź���O(N log N)

		int begin = 0;
		int end = data.length - 1;

		//��ͷ�бƣ��������ָ������ɨ�跨���ܾ���ķ�����O(N)
		while (begin < end)
		{
			long currSum = data[begin] + data[end];

			if (currSum == sum)
			{
				//��ĿֻҪ�������������������һ�Լ���
				String result = String.format("%d %d\n", data[begin], data[end]);
				System.out.println(result);

				//�����Ҫ������������������ԣ�����Ҫ��������������䣺
				//begin++
				//end--
				break;
			}
			else{
				if (currSum < sum)
					begin++;
				else
					end--;
			}
		}
	}

}
