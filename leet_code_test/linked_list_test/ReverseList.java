package linked_list_test;

/**
 * ·´×ªÁ´±í
 * @author sshhsun
 *
 */
public class ReverseList {
	
	public static void main(String[] args) {
		ListNode head = ListNode.getHead();
		ListNode.printfListNode(head);
		ListNode result = new ReverseList().reverseList(head);
		
		ListNode.printfListNode(result);
	}

    public ListNode reverseList(ListNode head) {
    	
    	ListNode result = null;
    	
    	while (head != null) {
			ListNode temp = head.next;
			
			head.next = result;
			
			result = head;
			
			head = temp;
		}
    	
        return result;
        		
    }
}
