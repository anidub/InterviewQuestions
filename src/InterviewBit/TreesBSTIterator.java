package InterviewBit;

import java.util.Stack;

public class TreesBSTIterator {
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

public boolean hasNext(){
	return !st.isEmpty();
}

public int next(){
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
