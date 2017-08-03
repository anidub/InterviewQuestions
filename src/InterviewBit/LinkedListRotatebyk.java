package InterviewBit;

import InterviewBit.LinkedListRemoveDuplicates.LinkedListNode;
///https://www.interviewbit.com/problems/rotate-list/
public class LinkedListRotatebyk {

	public static void main(String[] args) {
		LinkedListNode n = new LinkedListNode(-1);
		n.next = new LinkedListNode(1);
		n.next.next = new LinkedListNode(2);
		n.next.next.next = new LinkedListNode(3);
		n.next.next.next.next = new LinkedListNode(4);
		n.next.next.next.next.next = new LinkedListNode(5);
		n.next.next.next.next.next.next = new LinkedListNode(6);	
		LinkedListNode h = rotatebyK(n, 3);display(h);
	}
	public static void display(LinkedListNode h){
		while(h != null){
			System.out.print("-->" + h.data); h = h.next;
		}
	}
	
	public static LinkedListNode rotatebyK(LinkedListNode A,int k){
		  int length; LinkedListNode node;  LinkedListNode head;
		    if (A == null) return null;		        
		    node = A;   length = 0;		    
		    while (node != null) {
		    	length++;
		        node = node.next;
		    }		    
		    k = k % length;		    
		    if (k == 0) return A;		    
		    node = A;LinkedListNode last = null;		    
		    for (int i = 0; i < length - k; i++) {
		        last = node;
		        node = node.next;
		    }		        
		    last.next = null;
		    head = node;		    
		    while (node.next != null)
		        node = node.next;
		        
		    node.next = A;		    
		    return head;
	}
}