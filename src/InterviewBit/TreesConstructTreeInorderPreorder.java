package InterviewBit;

import java.util.HashMap;

public class TreesConstructTreeInorderPreorder {
//learn how indexing is done
//https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/	
/*Input :  Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

Return :    1
           / \
          2   3
 http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/         
Time Complexity: O(n^2). 
char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
O/P:Inorder traversal of constructed tree is :
D B E A F C
Worst case occurs when tree is left skewed. Example Preorder and Inorder traversals for worst case are {A, B, C, D} and {D, C, B, A}.*/
	public static void main(String[] args) {
		int[] inorder= {2,1,3};
		int[] preorder = {1,2,3};
		constructTree(inorder,preorder);

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
	
	public static TreeNode constructTree(int[] inorder, int[] preorder){
		if(inorder == null && preorder == null) return null;
		if(inorder == null || preorder == null || inorder.length != preorder.length) return null;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++){
			map.put(inorder[i], i);
		}
		return constructTreeNode(map,inorder, 0, inorder.length-1, preorder);
	}
	
	static int index = 0;
	public static TreeNode constructTreeNode(HashMap<Integer, Integer> map, int[] inorder, int start, int end, int[] preorder){
		if(index == inorder.length|| start > end) return null;
		TreeNode node = new TreeNode(preorder[index]);

		int inorderindex = map.get(preorder[index]);
		index++;
		node.left = constructTreeNode(map, inorder, start, inorderindex-1, preorder);
		node.right = constructTreeNode(map, inorder, inorderindex+1,end, preorder);
		return node;		
	}
}
