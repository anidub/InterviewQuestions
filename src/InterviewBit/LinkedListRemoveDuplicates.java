package InterviewBit;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.TreeMap;

public class LinkedListRemoveDuplicates {
/*https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
	http://stackoverflow.com/questions/19532307/converting-an-array-into-a-linkedlist		
*/	
	protected static class LinkedListNode{
		int data;
		LinkedListNode next;
		public LinkedListNode(int d){
			this.data = d;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		LinkedListNode n = new LinkedListNode(-1);
		n.next = new LinkedListNode(1);
		n.next.next = new LinkedListNode(2);
		n.next.next.next = new LinkedListNode(2);
		n.next.next.next.next = new LinkedListNode(3);
		n.next.next.next.next.next = new LinkedListNode(3);
		n.next.next.next.next.next.next = new LinkedListNode(4);
		LinkedListNode result = removdDupSorted(n);
	}
	

public static LinkedListNode removdDup(LinkedListNode n){
	LinkedListNode head = n;
	Hashtable ht = new Hashtable();
	LinkedListNode currentNode = head.next;
	LinkedListNode previous = head;
	int count = 0;
	while(currentNode != null){
		if(ht.contains(currentNode.data)){
			previous.next = currentNode.next;
			currentNode = currentNode.next;
		}else{
			ht.put(count,currentNode.data);
			count++;
			previous = currentNode;
			currentNode = currentNode.next;
		}
		
	}
	return head;
}
//when given linkedlist is sorted
public static LinkedListNode removdDupSorted(LinkedListNode n){
	TreeMap<Integer,Integer> ht = new TreeMap<Integer,Integer>();
	LinkedListNode copy = n;
	while(copy != null){
		ht.put(copy.data, ht.getOrDefault(copy.data, 0) + 1);
		copy = copy.next;
	}
	
	LinkedListNode head = null, temp = null;
	LinkedListNode result = null;
	for(Integer i : ht.keySet()){
		if(ht.get(i) <= 1){
			LinkedListNode obj = new LinkedListNode(i);
			if(temp == null) head = obj;
			else temp.next = obj;
			temp = obj;
			
		}
	}
	 while (head != null) {
         System.out.print("-->"+head.data);
         head = head.next;
    }
	return head;
}

public static LinkedListNode delDup(LinkedListNode head){
	if(head == null) return head;
	HashSet<Integer> hs = new HashSet<Integer>();
	hs.add(head.data);
	LinkedListNode current = head.next;
	LinkedListNode previous = head;
	while(current != null){
		if(hs.contains(current.data)){
			previous.next = current.next;
			current = current.next;
		}else{
			hs.add(current.data);
			previous.next = current;
			current = current.next;
		}
	}
	return head;	
}
}