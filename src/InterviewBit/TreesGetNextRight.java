package InterviewBit;

import java.util.LinkedList;
import java.util.Queue;

public class TreesGetNextRight {
/*	https://zhengresearch.wordpress.com/2012/12/25/connect-nodes-at-same-level-using-constant-extra-space/
		https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
			Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \  / \
	    4->5->6->7 -> NULL
	    The complexity of above algorithm mainly based on getNextRight().
The time complexity of getNextRight() is O(p), which p is average elements in each level, p = O(log(n)). 
Worse in a complete binary tree, best in a single-pathed tree)
Which say, in best case, we call zero time of getNextRight().
Which each node visited once. So it's O(n)
(Case like a complete binary tree, a kind of no-sibling-gap tree)
But o.w. if there're k nodes need to call getNextRight().
The whole time complexity is O(k*log(n)).
Since k <= n, so worse case is O(n*log(n)). (Upper bound)
But worse case only happen in single-pathed tree.
Also the average case is O(n*log(n)).
It's fast enough, previous post provided a O(n) way but need O(n) extra space.*/
protected class TreeLinkNode{
	int data;
	TreeLinkNode left, right, next;
	public TreeLinkNode(int data){
		this.data = data;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void connectAnyTreeNonRec(TreeLinkNode root) {
		if (root == null) return;
		 // Set nextRight for root
		root.next = null;
		TreeLinkNode head = root;
		while (head != null) {
			TreeLinkNode p = head;
			while (p != null) {
				TreeLinkNode rightSibling = getNextRight(p);
				if (p.left != null) {
					if (p.right != null) {
						p.left.next = p.right;
						p.right.next = rightSibling;
					} else
						p.left.next = rightSibling;
				} else if (p.right != null)
					p.right.next = rightSibling;

				p = p.next;
			}

			if (head.left != null)
				head = head.left;
			else if (head.right != null)
				head = head.right;
			else
				head = getNextRight(head);
		}
	}
	
	 private TreeLinkNode getNextRight(TreeLinkNode p){
	        TreeLinkNode temp = p.next;
	        while (temp != null){
	            if (temp.left != null)
	                return temp.left;
	            else if (temp.right != null)
	                return temp.right;	 
	            temp = temp.next;
	        }
	        return null;
	    }
	 
	
	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> queue1 = new LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> queue2 = new LinkedList<TreeLinkNode>();
		if (root == null)return;

		queue1.add(root);
		TreeLinkNode node, prev = null;
		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			prev = null;
			while (!queue1.isEmpty()) {
				node = queue1.remove();

				if (prev != null)
					prev.next = node;

				prev = node;

				if (node.left != null)
					queue2.add(node.left);

				if (node.right != null)
					queue2.add(node.right);
			}
			prev = null;
			while (!queue2.isEmpty()) {
				node = queue2.remove();

				if (prev != null)
					prev.next = node;

				prev = node;

				if (node.left != null)
					queue1.add(node.left);

				if (node.right != null)
					queue1.add(node.right);
			}
		}
	}
}