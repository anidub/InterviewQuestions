package InterviewBit;

import InterviewBit.LinkedListRemoveDuplicates.LinkedListNode;

public class LinkedListReverseEveryK {
/*	https://www.interviewbit.com/problems/k-reverse-linked-list/
	Given a singly linked list and an integer K, reverses the nodes of the
	list K at a time and returns modified linked list.
	Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
	You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
	http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
	http://code.geeksforgeeks.org/MsVoP4
*/	public static void main(String[] args) {
		LinkedListNode n = new LinkedListNode(1);
		n.next = new LinkedListNode(2);
		n.next.next = new LinkedListNode(3);
		n.next.next.next = new LinkedListNode(4);
		n.next.next.next.next = new LinkedListNode(5);
		n.next.next.next.next.next = new LinkedListNode(6);
		//n.next.next.next.next.next.next = new LinkedListNode(6);
		LinkedListNode node = reverseByKIterative(n,2); display(node);

	}
	//studied/Time Complexity: O(n)
	public static LinkedListNode reverseByK(LinkedListNode head, int k){
		boolean check = checkboundary(head,k);
		
		if(!check) {
			System.out.println("k great than size");
			return head;
		}else{
			return getReverseByK(head,k);
		}
	}
	public static boolean checkboundary(LinkedListNode head, int k){
		int count = 0;
		LinkedListNode temp = head;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		if(k > count) return false;
		return true;
	}
public static LinkedListNode getReverseByK(LinkedListNode head, int k){		
		LinkedListNode previous = null; LinkedListNode next = null;
		LinkedListNode current = head;
		int count = 0;
		while(count < k && current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			count++;
		}
		if(next != null)
			head.next = getReverseByK(next,k);
		
			return previous;
	}
	
	
	public static void display(LinkedListNode h){
		while(h != null){
			System.out.print("-->" + h.data); h = h.next;
		}
	}
	//studied
	public static LinkedListNode reverseByKIterative(LinkedListNode head, int k){
		if(head == null || k == 0) return head;
		LinkedListNode previous = null;LinkedListNode prevFirst = null;
		LinkedListNode next = null; LinkedListNode current = head;
		LinkedListNode newHead = null;
		
		while(current != null){
			previous = null;
			LinkedListNode first = current;
			int count = k;
			while(current != null && count != 0){
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
				count--;
			} 
			if(prevFirst == null){
				newHead = previous;
			}else
				prevFirst.next = previous;
			
			prevFirst = first;			
		}
		return newHead;
	}
}
