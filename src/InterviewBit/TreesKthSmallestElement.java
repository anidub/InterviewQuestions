package InterviewBit;

import java.util.Stack;

public class TreesKthSmallestElement {
/*	Given a binary search tree, write a function to find the kth smallest element in the tree.
	https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
		http://www.programcreek.com/2014/07/leetcode-kth-smallest-element-in-a-bst-java/
		We can also do this in O(logn) (solution not here) if 
		http://stackoverflow.com/questions/2329171/find-kth-smallest-element-in-a-binary-search-tree-in-optimum-way
		read the one with 142 likes
*/    public static int kthsmallest(TreeNode root, int k) {//O(n)
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		int result = -1;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
		int i = 0;
		while (!stack.isEmpty()) {
			TreeNode t = stack.pop();
			i++;

			if (i == k){
				result = t.data;
				break;
			}
			TreeNode r = t.right;
			while (r != null) {
				stack.push(r);
				r = r.left;
			}
		}
		return result;
    }

//using O(1) space by using morris traversal
//http://www.geeksforgeeks.org/kth-smallest-element-in-bst-using-o1-extra-space/
public static int kth(TreeNode root, int k){
	if(root == null) return -1;
	TreeNode current = root;
	TreeNode predecessor;
	int count = 0;
	int kthsmall = 0;
	while(current != null){
		if(current.left == null){
			count++;
			if(count == k){
				kthsmall = current.data;
			}
			current = current.right;
		}else{
			predecessor = current.left;
			while(predecessor.right != null && predecessor.right != current)
				predecessor = predecessor.right;
			if(predecessor.right == null){
				predecessor.right = current;
				current = current.left;
			}else{
				predecessor.right = null;
				count++;
				if(count == k)
					kthsmall = current.data;
				current = current.right;
			}
		}
	}
	return kthsmall;
}

public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		kthsmallest(root,2);
	}	
}