package InterviewBit;

import InterviewBit.LinkedListRemoveDuplicates.LinkedListNode;
/*/https://www.interviewbit.com/problems/reverse-link-list-ii/
 * http://n00tc0d3r.blogspot.com/2013/06/simplify-path.html
	Reverse a linked list from position m to n. Do it in-place and in one-pass.
	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	return 1->4->3->2->5->NULL*/
public class LinkedListNodeReverseMN {

	public static void main(String[] args) {
		LinkedListNode n = new LinkedListNode(-1);
		n.next = new LinkedListNode(1);
		n.next.next = new LinkedListNode(2);
		n.next.next.next = new LinkedListNode(3);
		n.next.next.next.next = new LinkedListNode(4);
		n.next.next.next.next.next = new LinkedListNode(5);
		n.next.next.next.next.next.next = new LinkedListNode(6);
		LinkedListNode node = reverseBetween(n,2,4); display(node);
	}
	public static LinkedListNode reverseBetween(LinkedListNode A, int m, int n) {		
	    int i;
	    LinkedListNode node = A;
	    LinkedListNode prev = null;
	    m--; n--;	    
	    for (i = 0; i < m; i++) {
	       prev = node;
	       node = node.next;
	    }	    
	    if (prev != null)
    	    prev.next = reverseList(node, n - m + 1);
    	else
    	    A = reverseList(node, n - m + 1);	    
	    return A;
	}
	
    public static LinkedListNode reverseList(LinkedListNode A, int count) {	    
    	LinkedListNode node, prev, temp, last;	    
	    node = A; last = A;	    
	    if (node == null)  return null;	    
	    prev = null;
	    while (node != null && count > 0) {	        
	        temp = node.next;
	        node.next = prev;
	        prev = node;
	        node = temp;
	        count--;
	    }	    
	    last.next = node;	    
	    return prev;
	}
    public static void display(LinkedListNode h){
		while(h != null){
			System.out.print("-->" + h.data); h = h.next;
		}
	}
}