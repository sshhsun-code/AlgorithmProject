package linked_list_test;

/**
 * 
 * 删除排序链表中的重复元素
 * 
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @author sshhsun
 *
 */
public class DeleteDuplicates {
	
	public static void main(String[] args) {
		ListNode head = getHead();
		
		ListNode.printfListNode(head);
		ListNode result = new DeleteDuplicates().deleteDuplicates(head);
		
		ListNode.printfListNode(result);
		
	}
	
	public static ListNode getHead() {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(2);
		
		a.next = b;
		b.next = c;
		c.next = d;
		
		return a;
	}
	
    public ListNode deleteDuplicates(ListNode head) {
    	
    	if (head == null) {
			return head;
		}
    	
    	ListNode temp = head;
    	
    	while (temp.next != null) {
			
    		if (temp.val == temp.next.val) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
    		
		}
    	
        return head;
    }
}
