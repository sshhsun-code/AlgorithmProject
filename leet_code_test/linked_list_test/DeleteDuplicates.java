package linked_list_test;

/**
 * 
 * ɾ�����������е��ظ�Ԫ��
 * 
 * ����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
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
