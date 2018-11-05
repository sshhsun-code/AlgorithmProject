package datastruct;

public class TestHasLoop {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		boolean hasLoop = hasCircle(n1);
		System.out.println("是否有环结构  "  +  hasLoop);	
		
		Node head = reverseLinkedList(n1);
		while (head != null) {
			System.out.println( head.val + "---->");	
			head = head.next;
		}
	}

	public static boolean hasCircle(Node L)
	{
		if(L==null) return false;//单链表为空时，单链表没有环
		if(L.next==null) return false;//单链表中只有头结点，而且头结点的next为空，单链表没有环
		Node p=L.next;//p表示从头结点开始每次往后走一步的指针
		Node q=L.next.next;//q表示从头结点开始每次往后走两步的指针
		while(q!=null) //q不为空执行while循环
		{
			if(p==q) return true;//p与q相等，单链表有环
			p=p.next;
			q=q.next.next;
		}
		return false;
 }
	
	static Node reverseLinkedList(Node node) {
	    if (node == null || node.next == null) {
	        return node;
	    } else {
	        Node headNode = reverseLinkedList(node.next);
	        node.next.next = node;
	        node.next = null;
	        return headNode;
	    }
	}
}
