package InterviewBit;

import java.util.HashMap;
import java.util.Map;
/*Clone a two pointer linkedlist where one is next and other is random
https://www.interviewbit.com/problems/copy-list/
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
Return a deep copy of the list.O(n)*/	
public class HashingCopyList {
	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		node1.random = node3;
		node2.random = node4;
		node3.random = node1;
		node4.random = node2;
		node4.next = null;
		RandomListNode head = node1;
		updateRandomList(head);
		copyRandomList(head);

	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode node, newHead, newNode;
		HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<RandomListNode,RandomListNode>();
		node = head;
		newHead = null;
		while (node != null) {
			newNode = new RandomListNode(node.label);
			if (newHead == null)
				newHead = newNode;
			hashMap.put(node, newNode);//key->node value->node.label
			node = node.next;
		}

		for (Map.Entry<RandomListNode, RandomListNode> entry : hashMap.entrySet()) {
			node = entry.getKey();
			newNode = entry.getValue();

			if (node.next != null) {
				newNode.next = hashMap.get(node.next);
			}
			if (node.random != null) {
				newNode.random = hashMap.get(node.random);
			}
		}
		return newHead;
	}
	
	public static RandomListNode updateRandomList(RandomListNode head) {
		RandomListNode node, newHead, newNode;
		HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<RandomListNode,RandomListNode>();
		node = head;
		newHead = null;
		while (node != null) {
			newNode = new RandomListNode(node.label);
			if(newHead == null) newHead = newNode;
			hashMap.put(node, newNode);//key->node value->node.label
			node = node.next;
		}

		for (Map.Entry<RandomListNode, RandomListNode> entry : hashMap.entrySet()) {
			node = entry.getKey();
			newNode = entry.getValue();
			
			if(node.random != null){
				newNode.next = hashMap.get(node.random);
			}
			
			if(node.next != null){
				newNode.random = hashMap.get(node.next);
			}			
		}
		return newHead;
	}
}
