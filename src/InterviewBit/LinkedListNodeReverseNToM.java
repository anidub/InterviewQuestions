package InterviewBit;

import InterviewBit.LinkedListRemoveDuplicates.LinkedListNode;
/*https://www.interviewbit.com/problems/reverse-link-list-ii/
	Reverse a linked list from position m to n. Do it in-place and in one-pass.
	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	return 1->4->3->2->5->NULL.*/
public class LinkedListNodeReverseNToM {
	public static void main(String[] args){
		LinkedListNode n = new LinkedListNode(-1);
		n.next = new LinkedListNode(1);
		n.next.next = new LinkedListNode(2);
		n.next.next.next = new LinkedListNode(3);
		n.next.next.next.next = new LinkedListNode(4);
		n.next.next.next.next.next = new LinkedListNode(5);
		n.next.next.next.next.next.next = new LinkedListNode(6);
		LinkedListNode h = reverseBetween(n, 2,4);display(h);
	}
	
	
	public static LinkedListNode reverseNM(LinkedListNode head, int m, int n){
		if(m >= n) return head;
		LinkedListNode node = head;
		LinkedListNode prev = null;
		m--; n--;
		for(int i = 0; i < m; i++){
			prev = node;
			node = node.next;
		}
		if(prev != null)
			prev.next = reverse(node, n - m + 1);
		else
			head = reverse(node, n - m + 1);
		return head;
	}
	
	public static LinkedListNode reverse(LinkedListNode node, int k){
		if(node == null) return null;
		LinkedListNode previous = null;
		LinkedListNode last = node; 
		LinkedListNode nextNode;
		LinkedListNode current = node;
		while(current != null && k > 0){
			nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
			k--;		
		}
		last.next = current;
		return previous;
	}
	public static void display(LinkedListNode h){
		while(h != null){
			System.out.print("-->" + h.data); h = h.next;
		}
	}
	
	//http://n00tc0d3r.blogspot.com/2013/05/reverse-linked-list.html
	public static LinkedListNode reverseBetween(LinkedListNode head, int m, int n) {  
		LinkedListNode dummy = new LinkedListNode(0);  
		   dummy.next = head;  
		   
		   // first if the first position, begin is the node before first.  
		   LinkedListNode pre = dummy, cur=head;  
		   int pos = 1;  
		   
		   // find the first  
		   while (pos < m && cur != null) {  
		     pre = cur;  
		     cur = cur.next;  
		     ++pos;  
		   }  
		   
		   // reverse the list  
		   while (pos < n && cur != null) {  
			   LinkedListNode nt = cur.next.next;  
		     cur.next.next = pre.next;  
		     pre.next = cur.next;  
		     cur.next = nt;  
		     ++pos;  
		   }  
		   
		   return dummy.next;  
		 }  
}
