package TreeGeeks;
/*
 * https://www.geeksforgeeks.org/find-median-bst-time-o1-space/
 * Find median of BST in O(n) time and O(1) space
Given a Binary Search Tree, find median of it.

If no. of nodes are even: then median = ((n/2th node + (n+1)/2th node) /2
If no. of nodes are odd : then median = (n+1)th node.
1- Count the no. of nodes in the given BST
   using Morris Inorder Traversal.
2- Then Perform Morris Inorder traversal one 
   more time by counting nodes and by checking if 
   count is equal to the median point.
   To consider even no. of nodes an extra pointer
   pointing to the previous node is used.
 */
public class MedianBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(50);
        root.left     = new TreeNode(30);
        root.right     = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        System.out.println(getMedian(root));
	}

	public static int getMedian(TreeNode root){
		if(root == null) return 0;
		int count = getCount(root);
		TreeNode current = root;
		int currentCount = 0;
		TreeNode prev = root;
		while(current != null){
			if(current.left == null){
				currentCount++;
				if(count % 2 != 0 && currentCount == ((count+1)/2)){
					return current.data;
				}else if(count % 2 == 0 && currentCount == (count/2)+1){
					return (prev.data + current.data)/2;
				}
				prev = current;
				current = current.right;
			}else{
				TreeNode pre = current.left;
				while(pre.right != null && pre.right != current){
					pre = pre.right;
				}
				if(pre.right == null){
					pre.right = current;
					prev = current;
					current = current.left;
				}else{
					pre.right = null;
					currentCount++;
					if(count % 2 != 0 && currentCount == ((count+1)/2)){
						return current.data;
					}else if(count % 2 == 0 && currentCount == (count/2) + 1){
						return (prev.data + current.data)/2;
					}
					prev = current;
					current = current.right;
				}
			}
		}
		return 0;
	}
	
	public static int getCount(TreeNode root){
		int count = 0;
		TreeNode current = root;
		while(current != null){
			if(current.left == null){
				count++;
				current = current.right;
			}else{
				TreeNode predecessor = current.left;
				while(predecessor.right != null && predecessor.right != current){
					predecessor = predecessor.right;					
				}
				if(predecessor.right == null){
					predecessor.right = current;
					current = current.left;
				}else{
					predecessor.right = null;
					count++;
					current = current.right;
				}
			}
		}
		return count;
	}
}
