package InterviewBit;

public class TreesContstructfromInorder {
	 /* Given an inorder traversal of a cartesian tree, construct the tree. 
	 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
	 Note: You may assume that duplicates do not exist in the tree.//O(n)
https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
Input : [1 2 3]
Return :   
          3
         /
        2
       /
      1*/
	public static void main(String[] args) {
		
	}
	
	public static TreeNode fromInorder(int[] arr, int start, int end){
	    if(arr == null || arr.length == 0)
            return null;
		if(start > end) return null;
		int max = Integer.MIN_VALUE;
		int i;
		for(i = start; i < end; i++){
			if(max < arr[i]) 
				max = arr[i];
		}
		
		TreeNode node = new TreeNode(max);
		if(start == end) return node;
		node.left = fromInorder(arr,start , i-1);
		node.right = fromInorder(arr, i+1, end);
		return node;
	}
}