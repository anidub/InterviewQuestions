package InterviewBit;

public class TreeConstructTreePeorderPostorder {
/*	Construct Full Binary Tree from given preorder and postorder traversal
	Given two arrays that represent preorder and postorder traversals of a full binary tree, construct the binary tree.
	A Full Binary Tree is a binary tree where every node has either 0 or 2 children
	It is not possible to construct a general Binary Tree from preorder and postorder traversals 
	But if know that the Binary Tree is Full, we can construct the tree without ambiguity.
	http://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
	In pre[], the leftmost element is root of tree. Since the tree is full and array size is more than 1. The value next to 1 in pre[],
	 must be left child of root. So we know 1 is root and 2 is left child. 
	How to find the all nodes in left subtree? We know 2 is root of all nodes in left subtree. 
	All nodes before 2 in post[] must be in left subtree. 
	If you are given two traversal sequences, can you construct the binary tree?
	Therefore, following combination can uniquely identify a tree.

Inorder and Preorder.
Inorder and Postorder.
Inorder and Level-order.

And following do not.
Postorder and Preorder.
Preorder and Level-order.
Postorder and Level-order.*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode construct(int[] preorder, int[] postorder){
		if(preorder == null || postorder == null || preorder.length != postorder.length){
			return null;
		}
		return construct(preorder, postorder, 0, postorder.length-1);
	}
	
	static int preIndex = 0;
	public static TreeNode construct(int[] preorder, int[] postorder, int start, int end){
		if(preIndex > preorder.length || start > end) return null;
		TreeNode node = new TreeNode(preorder[preIndex]);
		if(start == end) return node;
		int i = 0;
		++preIndex;
		for(i = start; i < end; i++){
			if(preorder[preIndex] == postorder[i]);
				break;
		}
		node.left = construct(preorder, postorder, start,i);
		node.right = construct(preorder, postorder, i+1,end);
		return node;
	}
}
