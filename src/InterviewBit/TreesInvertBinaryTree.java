package InterviewBit;

import java.util.LinkedList;
import java.util.Queue;

public class TreesInvertBinaryTree {
//Given a binary tree, invert the binary tree and return it.//O(n)
// give mirror image of binary tree	
/*	  	1					1							
	   /   \        ->            
	  2     3			3			2
	 / \   / \		7		6	5		4
	4   5 6   7*/
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		TreeNode newtree = invertTree(root);

	}
//https://www.interviewbit.com/problems/invert-the-binary-tree/
	public static TreeNode invert(TreeNode root){
		if(root ==null) return root;
		root.left = invert(root.left);
		root.right = invert(root.right);
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}
	
	//http://www.programcreek.com/2014/06/leetcode-invert-binary-tree-java/
	public static TreeNode invertTree(TreeNode root) {

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	 
	    if(root!=null){
	        queue.add(root);
	    }
	 
	    while(!queue.isEmpty()){
	        TreeNode p = queue.poll();
	        if(p.left!=null)
	            queue.add(p.left);
	        if(p.right!=null)
	            queue.add(p.right);
	 
	        TreeNode temp = p.left;
	        p.left = p.right;
	        p.right = temp;
	    }
	 
	    return root;    
	}
	
	public static TreeNode inverta(TreeNode root){
		if(root == null) return null;
		helper(root);
		return root;
	}
	
	public static void helper(TreeNode root){
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if(root.left != null) helper(root.left);
		if(root.right != null) helper(root.right);
	}
}
