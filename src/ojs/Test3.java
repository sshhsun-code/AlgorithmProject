package ojs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sshhsun
 *
 *��Ŀ����
�����ƣ�ÿ�������ƴ�С�ͻ�ɫ��ɣ��ƴ�С2~10��J��Q��K��A���ƻ�ɫΪ���ҡ����ҡ�÷�����������ֻ�ɫ֮һ�� 
�ж�����:
����1��ͬ��˳��ͬһ��ɫ��˳�ӣ������2����3����4����5����6��
����2��������������ͬ���� + ���ţ������A����A÷��A����A + ����K��
����3����«��������ͬ���� + һ�ԣ������5����5÷��5 + ����9÷��9��
����4��ͬ����ͬһ��ɫ���緽��3����7����10����J����Q��
����5��˳�ӣ���ɫ��һ����˳�ӣ������2����3����4����5����6��
����6��������������ͬ + ���ŵ���
����7��������
˵����
1���������ﲻ������ƴ�С�ͻ�ɫ��ȫ��ͬ���ơ�
2��ǰ������ͱȺ�������ʹ���ͬ��˳���������������ơ�
 *
 *
 *˼·��ʹ��һЩ���õļ���ǰ�ڽ������ݵ�Ԥ������������ж�
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
		int[] nums = new int[5];  // ��¼�ƵĴ�С
        String[] colors = new String[5];  // ��¼�ƵĻ�ɫ
      
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
		for (int i = 0; i < nums.length; i++) {// ͳ�������С����
			if (numMap.containsKey(nums[i])) {
				numMap.put(nums[i], numMap.get(nums[i]) + 1);
			} else {
				numMap.put(nums[i], 1);
			}
		}
		
		for (int i = 0; i < colors.length; i++) {// ͳ��ÿ�ֻ�ɫ������
			if (colorMap.containsKey(colors[i])) {
				colorMap.put(colors[i], colorMap.get(colors[i]) + 1);
			} else {
				colorMap.put(colors[i], 1);
			}
		}
		
		boolean isFlush = colorMap.size() == 1;//ͬ��
	    boolean isStraight = true; //˳��
	     
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
            // �����һ���Ʋ��Ǹպñ�ǰһ�Ŵ�һ����˳��
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
                    return 2; // ����
                }
                if (count == 2 || count == 3) {
                    return 3; // ��«
                }
            }
        }
        
        if (isFlush) {
            return 4; // ͬ��
        }
        
        if (isStraight) {
            return 5; // ˳��
        }
        
        for (Integer count : numMap.values()) {
            if (count == 3) {
                return 6; // ����
            }
        }
        
		return 7;
	}

}
