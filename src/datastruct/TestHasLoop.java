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
		System.out.println("�Ƿ��л��ṹ  "  +  hasLoop);	
		
		Node head = reverseLinkedList(n1);
		while (head != null) {
			System.out.println( head.val + "---->");	
			head = head.next;
		}
	}

	public static boolean hasCircle(Node L)
	{
		if(L==null) return false;//������Ϊ��ʱ��������û�л�
		if(L.next==null) return false;//��������ֻ��ͷ��㣬����ͷ����nextΪ�գ�������û�л�
		Node p=L.next;//p��ʾ��ͷ��㿪ʼÿ��������һ����ָ��
		Node q=L.next.next;//q��ʾ��ͷ��㿪ʼÿ��������������ָ��
		while(q!=null) //q��Ϊ��ִ��whileѭ��
		{
			if(p==q) return true;//p��q��ȣ��������л�
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
