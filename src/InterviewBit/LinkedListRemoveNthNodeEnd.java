package InterviewBit;

import InterviewBit.LinkedListRemoveDuplicates.LinkedListNode;

public class LinkedListRemoveNthNodeEnd {

	public static void main(String[] args) {
		LinkedListNode n = new LinkedListNode(-1);
		n.next = new LinkedListNode(2);
		n.next.next = new LinkedListNode(4);
		n.next.next.next = new LinkedListNode(6);
		n.next.next.next.next = new LinkedListNode(8);
		n.next.next.next.next.next = new LinkedListNode(10);
		n.next.next.next.next.next.next = new LinkedListNode(12);
		n.next.next.next.next.next.next.next = new LinkedListNode(14);
		LinkedListNode result = removeNth(n,2);

	}
	public static LinkedListNode removeNth(LinkedListNode n, int k){
		LinkedListNode temp = n;
		int count = 1;
		while(temp.next != null){
			count++;
			temp = temp.next;
		}
		if(k >= count) return n.next;
		int tempcount = count - k;
		count = 1;
		temp = n;
		while(count < tempcount){
			count++;
			temp = temp.next;
		}
		temp.next = temp.next.next;
		return n;
	}
}
