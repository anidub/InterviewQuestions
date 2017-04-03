package InterviewBit;

import java.util.Stack;

public class TreesFlattenBinaryTree {
/*//https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
//Given a binary tree, flatten it to a linked list in-place.
	//o/p-> 
	1
    \
    2
     \
      3
       \
        4
         \
          5
           \
            6*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//http://n00tc0d3r.blogspot.com/2013/03/flatten-binary-tree-to-linked-list-in.html
	public static TreeNode flatten(TreeNode root) {
		if (root == null)
			return root;
		TreeNode rightTree = root.right;
		if(root.left != null){
			root.right = root.left;
			root.left = null;
			root = flatten(root.right);
		}
		if(rightTree != null){
			root.right = rightTree;
			root = flatten(root.right);
		}
		return root;
	}
	
	public static void flatenIterative(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> rightTreeStack = new Stack<TreeNode>();
		TreeNode current = root;
		while(current != null){
			if(current.left != null){
				if(current.right != null) rightTreeStack.push(current.right);
					current.right = current.left;
					current.left = null;
			}
			if(current.right == null && !rightTreeStack.isEmpty()){
				current.right = rightTreeStack.pop();
			}
			current = current.right;
		}
	}
	
	public static void flattenIterativeNoSpace(TreeNode root){
		if(root == null) return;
		TreeNode current = root;
		while(current != null){
			if(current.left != null){
				if(current.right != null){
					TreeNode next = current.left;
					while(next.right != null)next = next.right;
					next.right = current.right;
				}
				current.right = current.left;
				current.left = null;
			}
			current = current.right;
		}
	}
	
	
}
