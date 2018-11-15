package linked_list_test;

/**
 * Ðý×ªÁ´±í
 * @author sshhsun
 *
 */
public class RrotateRight {
	
	public static void main(String[] args) {
		ListNode head = ListNode.getHead();
		ListNode.printfListNode(head);
		ListNode result = new RrotateRight().rotateRight(head, 5);
		ListNode.printfListNode(result);
	}
	
	   private int getLength(ListNode head) {
	        int length = 0;
	        while (head != null) {
	            length ++;
	            head = head.next;
	        }
	        return length;
	    }
	   
	   public ListNode rotateRight(ListNode head, int n) {
		   
		   if (head == null || n <= 0) {
			return head;
		}
		   
		   int length = getLength(head);
	        n = n % length;
	        
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        head = dummy;
	        
	        ListNode tail = dummy;
	        for (int i = 0; i < n; i++) {
	            head = head.next;
	        }
	        
	        while (head.next != null) {
				tail = tail.next;
				head = head.next;
			}
	        
	        head.next = dummy.next;
	        dummy.next = tail.next;
	        tail.next = null;
	        
		   return dummy.next;
	   }
}
