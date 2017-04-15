package InterviewBit;

import java.util.Stack;

public class TreesBSTIterator {
/*https://www.interviewbit.com/problems/bst-iterator/
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.*/
	private Stack<TreeNode> st;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
public void solution(TreeNode root){
	if(root == null) return;
	TreeNode node = root;
	while(node != null){
		st.push(node);
		node = node.left;
	}
}

public boolean hasNext(){//time : O(1) space : O(h) 
	return !st.isEmpty();
}

public int next(){//time : O(1) space : O(h) 
	boolean hNex = hasNext();
	if(!hNex) return -1;
	TreeNode root = st.pop();
	int val = root.data;
	root = root.right;
	while(root != null){
		st.push(root);
		root = root.left;
	}
	return val;
}
}
