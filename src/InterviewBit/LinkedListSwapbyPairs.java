package InterviewBit;

import InterviewBit.LinkedListRemoveDuplicates.LinkedListNode;
//http://www.jiuzhang.com/solutions/swap-nodes-in-pairs/
///https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
//Given a linked list, swap every two adjacent nodes and return its head.
public class LinkedListSwapbyPairs {

	public static void main(String[] args) {
		LinkedListNode n = new LinkedListNode(1);
		n.next = new LinkedListNode(2);
		n.next.next = new LinkedListNode(3);
		n.next.next.next = new LinkedListNode(4);
		n.next.next.next.next = new LinkedListNode(5);
		n.next.next.next.next.next = new LinkedListNode(6);
		n.next.next.next.next.next.next = new LinkedListNode(7);
		LinkedListNode node = swapPairs(n); display(node);
	}
	
	public static LinkedListNode swapPairs(LinkedListNode head) {
		LinkedListNode dummy = new LinkedListNode(0);
		dummy.next = head;
		head = dummy;
		while (head.next != null && head.next.next != null) {
			LinkedListNode n1 = head.next, n2 = head.next.next;
			head.next = n2;
			n1.next = n2.next;
			n2.next = n1;
			// move to next pair
			head = n1;
		}
		return dummy.next;
	}
public static void display(LinkedListNode h){
	while(h != null){
		System.out.print("-->" + h.data); h = h.next;
	}
}
}
