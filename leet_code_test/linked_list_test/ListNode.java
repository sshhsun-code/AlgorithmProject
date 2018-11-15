package linked_list_test;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	public static ListNode getHead() {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		
		a.next = b;
		b.next = c;
		c.next = d;
		
		return a;
	}
	
	public static void printfListNode(ListNode head) {
		
		while (head != null) {
			System.out.print(head.val + "--->");
			
			head = head.next;
		}
		System.out.print("NULL");
		System.out.println("");
	}
}
