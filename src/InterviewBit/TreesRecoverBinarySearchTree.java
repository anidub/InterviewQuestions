package InterviewBit;

import java.util.Stack;

public class TreesRecoverBinarySearchTree {
	/*Two elements of a binary search tree (BST) are swapped by mistake.
	Tell us the 2 values swapping which the tree will be restored.
	https://www.interviewbit.com/problems/recover-binary-search-tree/
*/
	public static void main(String[] args) {
		TreeNode root =  new TreeNode(15);	//			15
	    root.left = new TreeNode(10);		//	10				20
	    root.right = new TreeNode(20);		//8		12		25		16
	    root.left.left = new TreeNode(8);//
	    root.left.right = new TreeNode(12);
	 /*   root.right.left = new TreeNode(16);
	    root.right.right = new TreeNode(25);*/
	    root.right.left = new TreeNode(25);
	    root.right.right = new TreeNode(16);
	    recoverMorris(root);

	}
//http://stackoverflow.com/questions/11824946/in-a-bst-two-nodes-are-randomly-swapped-we-need-to-find-those-two-nodes-and-swap
	/* Returns true if the given tree is a binary search tree (efficient version). */
	public static int isBST(TreeNode node){
	  TreeNode x = null;
	  return(isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE,x));
	}

	/* Returns true if the given tree is a BST and its values are >= min and <= max. */
	public static int isBSTUtil(TreeNode node, int min, int max, TreeNode x){
	  /* an empty tree is BST */
	  if (node==null) return 1;

	  /* false if this node violates the min/max constraint */
	  if (node.data < min || node.data > max) {
	     if (x == null) {
	        x = node;//same the first incident where BST property is not followed.
	     }
	     else {
	        //here we second node, so swap it with *x.
	        int tmp = node.data;
	        node.data = x.data;
	        x.data = tmp;
	     }
	     //return 0;
	     return 1;//have to return 1; as we are not checking here if tree is BST, as we know it is not BST, and we are correcting it.
	  }
	  /* otherwise check the subtrees recursively,tightening the min or max constraint */
	// Allow only distinct values
	  if(node.left != null) return isBSTUtil(node.left, min, node.data-1, x);
	  if(node.right != null) return isBSTUtil(node.right, node.data+1, max, x);  // Allow only distinct values
	  return 1;
	}	
	 
//2nd method//works  time O(n) and uses O(h) spaces, where n is the number of nodes in the tree and h is the height of the tree	   
//http://n00tc0d3r.blogspot.com/2013/05/recover-binary-search-tree.html	
	public void recoverTree(TreeNode root) {
		TreeNode cur = root, pre = null, first = null, second = null;
		// in order travesal should return a sorted list
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (cur != null) { // find the left most child
			stack.push(cur);
			cur = cur.left;
		}
		while (!stack.isEmpty()) {
			cur = stack.pop();

			// is it wrong?
			if (pre != null && cur.data < pre.data) {
				if (first == null) {
					// the first wrong item should be the bigger one
					first = pre;
					second = cur; // there is a chance that the two were swapped
				} else {
					// the second wrong item should be the smaller one
					second = cur;
					break;
				}
			}
			// go to right child and repeat
			pre = cur;
			cur = cur.right;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		}
		swap(first, second);
	}  
	private static void swap(TreeNode a, TreeNode b) {
		if (a == null || b == null)	return;
		int tmp = a.data;
		a.data = b.data;
		b.data = tmp;		
	} 
	
// time O(n) and uses O(1) space! 	
//http://n00tc0d3r.blogspot.com/2013/05/recover-binary-search-tree.html	
private static void recoverMorris(TreeNode root) {
TreeNode pre = null, cur = root, n1 = null, n2 = null;
	while (cur != null) {
		if (cur.left != null) {
			TreeNode p = cur.left;
			while (p.right != null && p.right != cur) {
				p = p.right;
			}
			if (p.right == null) { // set right to successor
				p.right = cur;
				cur = cur.left;
			} else { // visit and revert the change
				p.right = null;
				if (pre.data > cur.data) {
					n2 = cur;
					if (n1 == null)
						n1 = pre;
				}
				pre = cur;
				cur = cur.right;
			}
		} else { // visit
			if (pre != null && pre.data > cur.data) {
				n2 = cur;
				if (n1 == null)
					n1 = pre;
			}
			pre = cur;
			cur = cur.right;
		}
	}
	swap(n1, n2);
}
}