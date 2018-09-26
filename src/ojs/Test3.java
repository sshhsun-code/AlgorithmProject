package ojs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sshhsun
 *
 *题目三：
五张牌，每张牌由牌大小和花色组成，牌大小2~10、J、Q、K、A，牌花色为红桃、黑桃、梅花、方块四种花色之一。 
判断牌型:
牌型1，同花顺：同一花色的顺子，如红桃2红桃3红桃4红桃5红桃6。
牌型2，四条：四张相同数字 + 单张，如红桃A黑桃A梅花A方块A + 黑桃K。
牌型3，葫芦：三张相同数字 + 一对，如红桃5黑桃5梅花5 + 方块9梅花9。
牌型4，同花：同一花色，如方块3方块7方块10方块J方块Q。
牌型5，顺子：花色不一样的顺子，如红桃2黑桃3红桃4红桃5方块6。
牌型6，三条：三张相同 + 两张单。
牌型7，其他。
说明：
1）五张牌里不会出现牌大小和花色完全相同的牌。
2）前面的牌型比后面的牌型大，如同花顺比四条大，依次类推。
 *
 *
 *思路：使用一些常用的集合前期进行数据的预处理，方便后续判断
 */
public class Test3 {
	
	static Map<String, Integer> numMap = new HashMap<>();
    static {
        numMap.put("2", 2);
        numMap.put("3", 3);
        numMap.put("4", 4);
        numMap.put("5", 5);
        numMap.put("6", 6);
        numMap.put("7", 7);
        numMap.put("8", 8);
        numMap.put("9", 9);
        numMap.put("10", 10);
        numMap.put("J", 11);
        numMap.put("Q", 12);
        numMap.put("K", 13);
        numMap.put("A", 14);
    }

	public static void main(String[] args) {
		int[] nums = new int[5];  // 记录牌的大小
        String[] colors = new String[5];  // 记录牌的花色
      
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String[] split = in.nextLine().split(" ");  
            
            nums[i] = numMap.get(split[0].toUpperCase());  
            colors[i] = split[1].toUpperCase();
        }
 
        int result = judgePoker(nums, colors);
 
        System.out.println(result);

	}
	
	private static int judgePoker(int[] nums, String[] colors) {
		Map<Integer, Integer> numMap = new HashMap<>();
		Map<String, Integer> colorMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {// 统计牌面大小数量
			if (numMap.containsKey(nums[i])) {
				numMap.put(nums[i], numMap.get(nums[i]) + 1);
			} else {
				numMap.put(nums[i], 1);
			}
		}
		
		for (int i = 0; i < colors.length; i++) {// 统计每种花色的数量
			if (colorMap.containsKey(colors[i])) {
				colorMap.put(colors[i], colorMap.get(colors[i]) + 1);
			} else {
				colorMap.put(colors[i], 1);
			}
		}
		
		boolean isFlush = colorMap.size() == 1;//同花
	    boolean isStraight = true; //顺子
	     
		for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        for (int i = 1; i < nums.length; i++) {
            // 如果后一张牌不是刚好比前一张大一则不是顺子
            if (nums[i] - 1 != nums[i - 1]) {
                isStraight = false;
                break;
            }
        }
        
        if (isFlush && isStraight) {
			return 1;
		}
        
        if (numMap.size() == 2) {
            for (Integer count : numMap.values()) {
                if (count == 1 || count == 4) {
                    return 2; // 四条
                }
                if (count == 2 || count == 3) {
                    return 3; // 葫芦
                }
            }
        }
        
        if (isFlush) {
            return 4; // 同花
        }
        
        if (isStraight) {
            return 5; // 顺子
        }
        
        for (Integer count : numMap.values()) {
            if (count == 3) {
                return 6; // 三条
            }
        }
        
		return 7;
	}

}
