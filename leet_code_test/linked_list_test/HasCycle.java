package linked_list_test;

/**
 * 
 * ��������
 * 
 * �ο�
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
     * �ж��Ƿ��л�
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
    * �ж� ������ ������ڵ�
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
