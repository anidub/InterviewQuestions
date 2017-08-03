package InterviewBit;

import InterviewBit.LinkedListRemoveDuplicates.LinkedListNode;
/*///https://github.com/shawnfan/LintCode/blob/master/Java/Insertion%20Sort%20List.java
Sort a linked list using insertion sort.
//https://www.interviewbit.com/problems/insertion-sort-list/
*/public class LinkedListInsertionSort {

	public static void main(String[] args) {
		LinkedListNode n = new LinkedListNode(-1);
		n.next = new LinkedListNode(3);
		n.next.next = new LinkedListNode(2);
		n.next.next.next = new LinkedListNode(10);
		n.next.next.next.next = new LinkedListNode(7);
		n.next.next.next.next.next = new LinkedListNode(6);
		n.next.next.next.next.next.next = new LinkedListNode(-22);
		LinkedListNode result = insertionSortList(n);display(result);
	}
	
	
	public static LinkedListNode insertionSortList(LinkedListNode head) {
		if (head == null) return null;
		LinkedListNode dummy = new LinkedListNode(0);
		while (head != null) {
			LinkedListNode node = dummy;
			while (node.next != null && node.next.data < head.data) {
				node = node.next;
			}
			LinkedListNode temp = head.next;
			head.next = node.next;
			node.next = head;
			head = temp;
		}
		return dummy.next;
	}
	
	  public static void display(LinkedListNode h){
			while(h != null){
				System.out.print("-->" + h.data); h = h.next;
			}
		}
	}
