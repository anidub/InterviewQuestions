package InterviewBit;

public class TreesConstructTreeInorderPreorder {
//learn how indexing is done
//https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/	
/*Input :  Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

Return :    1
           / \
          2   3
 http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/         
Time Complexity: O(n^2). Worst case occurs when tree is left skewed. */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TreeNode construct(int[] inorder, int[] preorder){
		if(inorder == null && preorder == null) return null;
		if(inorder == null || preorder == null || inorder.length != preorder.length) return null;
		return construct(inorder,0,inorder.length-1,preorder,0);
	}
	
	public static TreeNode construct(int[] inorder, int start, int end, int[] preorder, int preorderindex){
		if(start > end) return null;
		
		int nodeValue = preorder[preorderindex];
		int i;
		TreeNode node = new TreeNode(nodeValue);
		for(i = start; i <= end; i++){
			if(inorder[i] == nodeValue)
				break;
		}
		
		node.left = construct(inorder, start, i-1,preorder, preorderindex + 1);// since the index has to the  element just after the discovered element i.e nodevalue
		node.right = construct(inorder, i+1,end, preorder, preorderindex+i-start+1);// since the index has to the  element just after the last element
		return node;		
	}
}
