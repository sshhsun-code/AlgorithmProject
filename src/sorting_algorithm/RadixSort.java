package sorting_algorithm;

/**
 * 分配排序的基本思想：用空间换时间。在整个排序过程中，无须比较关键字，而是通过用额外的空间来”分配”和”收集”
 * 来实现排序，它们的时间复杂度可达到线性阶：O(n)。其中，基数排序包括两个过程：首先，将目标序列各元素分配
 * 到各个桶中(分配过程)；然后，将各个桶中的元素按先进先出的顺序再放回去(收集过程)，如此往复，一共需要进行d
 * 趟，d为元素的位数。


第一步
以LSD为例，假设原来有一串数值如下所示：
73, 22, 93, 43, 55, 14, 28, 65, 39, 81
首先根据个位数的数值，在走访数值时将它们分配至编号0到9的桶子中：
0
1 81
2 22
3 73 93 43
4 14
5 55 65
6
7
8 28
9 39
第二步
接下来将这些桶子中的数值重新串接起来，成为以下的数列：
81, 22, 73, 93, 43, 14, 55, 65, 28, 39
接着再进行一次分配，这次是根据十位数来分配：
0
1 14
2 22 28
3 39
4 43
5 55
6 65
7 73
8 81
9 93
第三步
接下来将这些桶子中的数值重新串接起来，成为以下的数列：
14, 22, 28, 39, 43, 55, 65, 73, 81, 93
这时候整个数列已经排序完毕；如果排序的对象有三位数以上，则持续进行以上的动作直至最高位数为止。


基数排序的发明可以追溯到1887年赫尔曼·何乐礼在打孔卡片制表机(Tabulation Machine)上的贡献。
它是这样实现的：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后
，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个
有序序列。基数排序的方式可以采用LSD（Least significant digital）或MSD（Most significa
nt digital），LSD的排序方式由键值的最右边开始，而MSD则相反，由键值的最左边开始。



Title: 分配排序中的基数排序，不依赖于初始序列  
 * Description: 不是在对元素进行比较的基础上进行排序，而是采用 "分配 + 收集" 的办法 
 * 
 *              首先，将目标序列各元素分配到各个桶中；
 *              其次，将各个桶中的元素按先进先出的顺序再放回去
 *              如此往复...             
 * 
 *              时间复杂度：O(d*(r+n))或者 O(dn),d 的大小一般会受到 n的影响
 *              空间复杂度：O(rd + n)或者 O(n)
 *              稳    定   性：稳定
 *              内部排序(在排序过程中数据元素完全在内存)
 * 
 * @author CM
 *
 */
public class RadixSort {

	public static void main(String[] args) {

		int[] num = new int[] { 12, 4, 24, 97, 119, 68, 23, 60 };

		System.out.println("=============输入=============");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

		radixSort(num, 10, 3);
		
		System.out.println("\n=============归并排序后=============");

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}

	}
	
	
    /**     
     * @description 分配 + 收集
     * @author rico       
     * @created 2017年5月21日 下午9:25:52     
     * @param target 待排序数组
     * @param r 基数
     * @param d 元素的位数
     * @param n 待排序元素个数
     * @return     
     */
    public static int[] radixSort(int[] target, int r, int d){
        if (target != null && target.length != 1 ) {

            int[][] bucket = new int[r][target.length];  // 一共有基数r个桶，每个桶最多放n个元素
            int digit;  // 获取元素对应位上的数字，即装入那个桶
            int divisor = 1;   // 定义每一轮的除数，1, 10, 100, ...
            int[] count = new int[r];   // 统计每个桶中实际存放元素的个数

            for (int i = 0; i < d; i++) {  // d 位的元素，需要经过分配、收集d次即可完成排序

                // 分配
                for (int ele : target) {   
                    digit = (ele/divisor) % 10;  // 获取元素对应位上的数字(巧妙！！！)
                    bucket[digit][count[digit]++] = ele; // 将元素放入对应桶，桶中元素数目加1
                }

                // 收集
                int index = 0;  // 目标数组的下标
                for (int j = 0; j < r; j++) {
                    int k = 0;    // 用于按照先进先出顺序获取桶中元素
                    while(k < count[j]){
                        target[index++] = bucket[j][k++];  // 按照先进先出依次取出桶中的元素
                    }
                    count[j] = 0;  // 计数器归零
                }
                divisor *= 10;  //用于获取元素对应位数字
            }
        }
        return target;
    }

}
