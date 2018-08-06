package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode-cn.com/problems/two-sum/description/
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。  
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 
 * */

public class TwoSum {

	public TwoSum() {
		// TODO Auto-generated constructor stub
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] {3, 2, 4};
		System.out.println(twoSum(num, 6));
	}

	
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
        
        for (int i = 0; i < nums.length; i++) {
			int tempNum = target - nums[i];
			if (map.containsKey(tempNum) && map.get(tempNum) != i) {
				return new int[]{i, map.get(tempNum)};
			}
		}
    	return null;
    }

}
