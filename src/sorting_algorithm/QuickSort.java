package sorting_algorithm;

/**
 * ����˼���ǣ�ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�������һ����
 * ���������ݶ�ҪС��Ȼ���ٰ��˷����������������ݷֱ���п�����������������̿��Եݹ���У���
 * �˴ﵽ�������ݱ����������
 * 
 * ���������˼�룺ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�������һ
 * ���ֵ��������ݶ�ҪС(���ֹ���)��Ȼ���ٰ��˷����������������ݷֱ���п�������(�����������)��
 * ����������̿��Եݹ���У��Դ˴ﵽ�������ݱ���������С�����������һ�ֲ��ȶ��������㷨
 * 
 * 
 * �ο���
 * 
 * https://github.com/wondertwo/wondertwoCube/blob/master/%E7%AE%97%E6%B3%95%E9%9B%86%E5%90%88/%E7%BB%8F%E5%85%B
 * 8%E6%8E%92%E5%BA%8F%EF%BC%9A%E5%BF%AB%E6%8E%92%26%E5%BD%92%E5%B9%B6%E4%BB%A3%E7%A0%81%E8%A7%A3%E6%9E%90.md
 * 
 * 
 * https://www.cnblogs.com/chengxiao/p/6262208.html * 
 * 
 * 
 * https://blog.csdn.net/justloveyou_/article/details/72730597
 * 
 * @author CM
 * 
 * 
 *
 */
public class QuickSort {
	
    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 7,9, 2};
        print(arr);
        System.out.println("--------------------------------");
        quickSort(arr, 0, arr.length-1);
        System.out.println("--------------------------------");
        print(arr);
    }

    //***************************************************************

    /**
     * �����㷨ʵ�֣��ݹ����
     */
    private static void quickSort(int[] arr, int lIndex, int rIndex) {
        if (lIndex >= rIndex) return;
        int center = partitionScan(arr, lIndex, rIndex);
        quickSort(arr, lIndex, center-1);
        quickSort(arr, center+1, rIndex);
    }

    /**
     * ɨ��һ�֣��Ի�׼ֵ�������򻮷�Ϊ���������֣�ʹ�û�׼ֵ�������ֵ��С���Ҳ�
     *
     * @return ����ɨ������󣬷��ػ�׼ֵ����������
     */
    private static int partitionScan(int[] arr, int lptr, int rptr) {
        // ����ȡ���㷨�õ�����ɨ��Ļ�׼ֵ��������������׼ֵҲ��Э��ֵ
        int baseIndex = fetchBaseIndex(arr, lptr, rptr);
        // ��Ȼ����ȡ��ֻ��Ϊ���Ż��㷨Ч�ʣ�Ҳ����ֱ��ָ����׼ֵ����Ϊlptr��rptr����
        // int baseIndex = lptr; // int baseIndex = rptr;
        System.out.println("----> PartitionScan BaseIndex: " + baseIndex);

        // ���������м�ɨ�裬ֱ����ָ������ָ����ײ����ɨ�����
        // ���´��룬�ȴ�������ɨ�裬�ٴ�������ɨ��
        // ��ȻҲ�����ȴ�������ɨ�裬�ڴ�������ɨ��
        while (lptr < rptr) {
            // �ȴ�������ɨ��
            while (rptr>baseIndex && arr[rptr]>=arr[baseIndex]) {
                rptr--;
            }
            // ����С�ڻ�׼ֵ���ݣ����Ҳ�ָ��rptrͣ����������λ�ã����»�׼ֵ����
            swap(arr, rptr, baseIndex);
            baseIndex = rptr;

            // �ٴ�������ɨ��
            while (lptr<baseIndex && arr[lptr]<=arr[baseIndex]) {
                lptr++;
            }
            // ���ִ��ڻ�׼ֵ���ݣ������ָ��lptrͣ����������λ�ã����»�׼ֵ����
            swap(arr, lptr, baseIndex);
            baseIndex = lptr;
        }
        return baseIndex;
    }

    /**
     * ����ȡ���㷨���ҳ�Э��ֵ(��׼ֵ)�����������±�
     * ����ȡ���㷨����Բ�ͬ�Ĵ�����������Ӧ���������Ż������㷨Ч��
     * �ҳ���Э��ֵԽ����������������ֵ���㷨Ч��Խ��
     */
    private static int fetchBaseIndex(int[] arr, int l, int r) {
        int centerIndex = (l + r) /2;

        boolean isLowLowerThanHigh = arr[l] < arr[r];
        if (isLowLowerThanHigh) {
            if (arr[centerIndex] < arr[l]) {
                return l;
            }
            if (arr[centerIndex] > arr[r]) {
                return r;
            }
            return centerIndex;
        }
        else {
            if (arr[centerIndex] < arr[r]) {
                return r;
            }
            if (arr[centerIndex] > arr[l]) {
                return l;
            }
            return centerIndex;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
        print(arr);
    }

    private static void print(int[] arr) {
        for (int var : arr) {
            System.out.print(var + "\t");
        }
        System.out.println();
    }

}
