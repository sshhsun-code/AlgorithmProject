package sorting_algorithm;

/**
 * 基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分
 * 的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以
 * 此达到整个数据变成有序序列
 * 
 * 快速排序的思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一
 * 部分的所有数据都要小(划分过程)，然后再按此方法对这两部分数据分别进行快速排序(快速排序过程)，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。快速排序是一种不稳定的排序算法
 * 
 * 
 * 参考：
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
     * 快排算法实现，递归调用
     */
    private static void quickSort(int[] arr, int lIndex, int rIndex) {
        if (lIndex >= rIndex) return;
        int center = partitionScan(arr, lIndex, rIndex);
        quickSort(arr, lIndex, center-1);
        quickSort(arr, center+1, rIndex);
    }

    /**
     * 扫描一轮，以基准值将待排序划分为左右两部分，使得基准值左侧所有值都小于右侧
     *
     * @return 本轮扫描结束后，返回基准值的数组索引
     */
    private static int partitionScan(int[] arr, int lptr, int rptr) {
        // 三数取中算法得到本轮扫描的基准值的数组索引，基准值也叫协调值
        int baseIndex = fetchBaseIndex(arr, lptr, rptr);
        // 当然三数取中只是为了优化算法效率，也可以直接指定基准值索引为lptr或rptr如下
        // int baseIndex = lptr; // int baseIndex = rptr;
        System.out.println("----> PartitionScan BaseIndex: " + baseIndex);

        // 从两侧向中间扫描，直到左指针与右指针碰撞则本轮扫描结束
        // 如下代码，先从右向左扫描，再从左向右扫描
        // 当然也可以先从左向右扫描，在从右向左扫描
        while (lptr < rptr) {
            // 先从右向左扫描
            while (rptr>baseIndex && arr[rptr]>=arr[baseIndex]) {
                rptr--;
            }
            // 发现小于基准值数据，则右侧指针rptr停下来，交换位置，更新基准值索引
            swap(arr, rptr, baseIndex);
            baseIndex = rptr;

            // 再从左向右扫描
            while (lptr<baseIndex && arr[lptr]<=arr[baseIndex]) {
                lptr++;
            }
            // 发现大于基准值数据，则左侧指针lptr停下来，交换位置，更新基准值索引
            swap(arr, lptr, baseIndex);
            baseIndex = lptr;
        }
        return baseIndex;
    }

    /**
     * 三数取中算法，找出协调值(基准值)的数组索引下标
     * 三数取中算法可针对不同的待排序数据相应调整，以优化快排算法效率
     * 找出的协调值越趋近于数据样本均值，算法效率越高
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
