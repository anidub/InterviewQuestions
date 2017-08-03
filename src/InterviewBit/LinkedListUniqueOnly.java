package InterviewBit;

import java.util.TreeMap;

import InterviewBit.LinkedListRemoveDuplicates.LinkedListNode;

public class LinkedListUniqueOnly {
/*//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	Given 1->2->3->3->4->4->5, return 1->2->5.
			Given 1->1->1->2->3, return 2->3.*/
	public static void main(String[] args) {
	/*	LinkedListNode n = new LinkedListNode(-1);
		n.next = new LinkedListNode(3);
		n.next.next = new LinkedListNode(2);
		n.next.next.next = new LinkedListNode(10);
		n.next.next.next.next = new LinkedListNode(7);
		n.next.next.next.next.next = new LinkedListNode(6);
		n.next.next.next.next.next.next = new LinkedListNode(-22);
		n.next.next.next.next.next.next.next = new LinkedListNode(-22);
		LinkedListNode result = unique(n);*/
		LinkedListNode n = new LinkedListNode(-1);
		n.next = new LinkedListNode(2);
		n.next.next = new LinkedListNode(4);
		n.next.next.next = new LinkedListNode(6);
		n.next.next.next.next = new LinkedListNode(8);
		n.next.next.next.next.next = new LinkedListNode(10);
		n.next.next.next.next.next.next = new LinkedListNode(12);
		n.next.next.next.next.next.next.next = new LinkedListNode(14);
/*		LinkedListNode n2 = new LinkedListNode(-1);
		n2.next = new LinkedListNode(1);
		n2.next.next = new LinkedListNode(3);
		n2.next.next.next = new LinkedListNode(5);
		n2.next.next.next.next = new LinkedListNode(7);
		n2.next.next.next.next.next = new LinkedListNode(9);
		n2.next.next.next.next.next.next = new LinkedListNode(11);
		n2.next.next.next.next.next.next.next = new LinkedListNode(13);*/
		LinkedListNode result = unique(n);
		display(result);
		

	}
	
	public static LinkedListNode unique(LinkedListNode head){
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		LinkedListNode temp = head;
		while(temp != null){
			if(treeMap.containsKey(temp.data)){
				treeMap.put(temp.data, treeMap.get(temp.data)+1);
			}else
				treeMap.put(temp.data, 1);
			temp = temp.next;
		}
		LinkedListNode current = null;
		temp = null;
		for(Integer i : treeMap.keySet()){
			if(treeMap.get(i) <= 1){
				LinkedListNode obj = new LinkedListNode(i);
				if(temp == null) current = obj;
				else temp.next = obj;
				temp = obj;
			}
		}
		return current;
	}
	 public static void display(LinkedListNode h){
			while(h != null){
				System.out.print("-->" + h.data); 
				h = h.next;
			}
		}
	 

}
