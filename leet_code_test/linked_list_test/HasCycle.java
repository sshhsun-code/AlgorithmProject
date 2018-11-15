package linked_list_test;

/**
 * 
 * 环形链表
 * 
 * 参考
 * 
 * https://www.jianshu.com/p/ef71e04241e4
 * 
 * https://www.jianshu.com/p/ef71e04241e4
 * 
 * @author sshhsun
 *
 */
public class HasCycle {
	
    /**
     * 
     * 判断是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        
    	if (head == null || head.next == null) {
            return false;
        }
    	
    	ListNode fast = head.next;
    	
    	ListNode slow = head;
    	
    	while (fast != slow) {
			if (fast == null || fast.next == null) {
				return false;
			}
			
			fast = fast.next.next;
    		
			slow = slow.next;
		}
    	
    	return true;
    }
    
   /**
    * 
    * 判断 单链表 环的入口点
 * @param head
 * @return
 */
public ListNode getCycleEnter(ListNode head) {
        
    	if (head == null || head.next == null) {
            return null;
        }
    	
    	ListNode fast = head.next;
    	
    	ListNode slow = head;
    	
    	while (fast != slow) {
			if (fast == null || fast.next == null) {
				return null;
			}
			
			fast = fast.next.next;
    		
			slow = slow.next;
		}
    	
    	ListNode result = head;
    	fast = fast.next;
    	
    	while (fast != result) {
			fast = fast.next;
			result = result.next;
		}
    	
    	return fast;
    }

}
