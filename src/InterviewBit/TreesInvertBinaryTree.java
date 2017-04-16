package InterviewBit;

public class TreesInvertBinaryTree {
//Given a binary tree, invert the binary tree and return it.//O(n)
// give mirror image of binary tree	
/*	  	1					1							
	   /   \        ->            
	  2     3			3			2
	 / \   / \		7		6	5		4
	4   5 6   7*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
}

