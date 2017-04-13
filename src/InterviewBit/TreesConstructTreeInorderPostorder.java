package InterviewBit;

public class TreesConstructTreeInorderPostorder {
/*//Given inorder and postorder traversal of a tree, construct the binary tree.
	Input :  Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]
Return : 
            1
           / \
          2   3
https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-postorder/
http://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
in[]   = {4, 8, 2, 5, 1, 6, 3, 7}
post[] = {8, 4, 5, 2, 6, 7, 3, 1} 

Output : Root of below tree
          1
       /     \
     2        3
   /    \   /   \
  4     5   6    7
    \
      8*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode construct(int[] inorder, int[] postorder){
		if(inorder == null && postorder == null) return null;
		if(inorder == null || postorder == null) return null;
		if(inorder.length != postorder.length) return null;
		return construct(inorder,0,inorder.length-1,postorder,postorder.length-1);
	}
	
	public static TreeNode construct(int[] inorder, int start, int end, int[] postorder, int postindex){
		  if (start > end)  return null;
		int nodevalue = inorder[postindex];
		TreeNode node = new TreeNode(nodevalue);
		int i;
		for(i = start; i <= end; i++){
			if(inorder[i] == nodevalue)
				break;
		}
		node.left = construct(inorder, start,i-1, postorder, postindex - (end - i +1));// since the postindex has to the  element just after the discoverd element i.e nodevalue
		node.right = construct(inorder, i+1, end, postorder, postindex-1);// since the postindex has to the  element just before the last element
		return node;
	}
}
