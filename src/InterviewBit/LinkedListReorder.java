package InterviewBit;

import java.util.ArrayList;

import InterviewBit.LinkedListRemoveDuplicates.LinkedListNode;
//https://www.interviewbit.com/problems/reorder-list/
/*Given a singly linked list
    L: L0 -> L1 -> … -> Ln-1 -> Ln,
reorder it to:
    L0-> Ln -> L1 -> Ln-1 -> L2 -> Ln-2-> …*/
public class LinkedListReorder {

	public static void main(String[] args) {
		LinkedListNode n = new LinkedListNode(-1);
		n.next = new LinkedListNode(1);
		n.next.next = new LinkedListNode(2);
		n.next.next.next = new LinkedListNode(3);
		n.next.next.next.next = new LinkedListNode(4);
		n.next.next.next.next.next = new LinkedListNode(5);
		n.next.next.next.next.next.next = new LinkedListNode(6);
		//LinkedListNode node = 
		//reorderLista(n); display(n);
		reor(n);//display(n);
	}
public static LinkedListNode reorderList(LinkedListNode A) {	    
	    if (A == null)  return null;	    
	    LinkedListNode node = A;	    
	    ArrayList<LinkedListNode> list = new ArrayList<LinkedListNode>();	    
	    while (node != null) {
	        list.add(node);
	        node = node.next;
	    }
	    
	    int first = 0;
	    int n = list.size();
	    int last = n - 1;
	    LinkedListNode temp;	    
	    while (first < last) {	        
            node = list.get(first);
            temp = list.get(last);
            temp.next = node.next;
            node.next = temp;            
            if (temp.next == temp)
                temp.next = null;            
            first++;
            last--;	        
	    }	    
	    if (first == last) {
	        node = list.get(first);
	        node.next = null;
	    }	    
	    return A;
	}
//https://github.com/interviewcoder/leetcode/blob/master/src/_143_ReorderList/Solution.java
public static void reorderLista(LinkedListNode head) {//Time : O(N) ; Space: O(1)
    if (head == null || head.next == null) {
        return;
    }
    LinkedListNode fast = head;
    LinkedListNode slow = head;
    // let slow stops at the middle node
    while (fast != null && fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    // reverse from slow.next to end
    LinkedListNode preMiddle = slow;
    LinkedListNode preCurrent = slow.next;
    while (preCurrent.next != null) {
    	LinkedListNode current = preCurrent.next;
        preCurrent.next = current.next;
        current.next = preMiddle.next;
        preMiddle.next = current;
    }

    LinkedListNode l2 = preMiddle.next;
    slow.next = null;

    // merge two lists (l2 might be one node less than l1)
    LinkedListNode l1 = head;
    LinkedListNode dummy = new LinkedListNode(0);
    LinkedListNode node = dummy;
    while (l2 != null) {
        node.next = l1;
        l1 = l1.next;
        node = node.next;
        node.next = l2;
        l2 = l2.next;
        node = node.next;
    }
    // last node in list1
    node.next = l1;
    LinkedListNode ss = dummy;
   
    display(ss.next); // if you want return value return ss;
    System.out.println();
}

public static void display(LinkedListNode h){
	while(h != null){
		System.out.print("-->" + h.data); h = h.next;
	}
}

//works
public static void reor(LinkedListNode head){
	LinkedListNode result = null;
	if(head == null) return;
	LinkedListNode current = head;
	LinkedListNode slow = current; LinkedListNode fast = current;
	while(fast.next != null && fast.next.next != null){
		fast = fast.next.next;
		slow = slow.next;
	}
	LinkedListNode rightNode = slow.next;
	slow.next = null;
	LinkedListNode rightRev = rev(rightNode);
	LinkedListNode lefthead = head;
	result = new LinkedListNode(0);
	LinkedListNode node = result;
	while(rightRev != null){
		node.next = lefthead;
		lefthead = lefthead.next;
		node = node.next;
		node.next = rightRev;
		rightRev = rightRev.next;
		node = node.next;
	}
	node.next = lefthead;
	 display(result.next);
	//return result.next;	
}

public static LinkedListNode rev(LinkedListNode head){
	LinkedListNode prev = null; LinkedListNode current = head;
	LinkedListNode node;
	while(current != null){
		node = current.next;
		current.next = prev;
		prev = current;
		current = node;
	}
	return prev;
}
}
