package InterviewBit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreesRootToLeafPathSum {
///https://www.interviewbit.com/problems/path-sum/
/*	Given a BINARY TREEand a sum, 
	determine if the tree has a root-to-leaf path such that adding up all the values 
	along the path equals the given sum.*/	
	public static void main(String[] args) {		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.left.left = new TreeNode(5);
		root.left.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(16);
		root.right.right = new TreeNode(20);
		root.right.left = new TreeNode(14);	
		System.out.println(minLenSumPathBST(root,23,0));
	}
	
//http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
//http://code.geeksforgeeks.org/180tZj	
	ArrayList<Integer> result = new ArrayList<Integer>();
	public boolean hasRootToLeafPath(TreeNode root, int sum){
		if(root == null){
			return (sum==0);
		}
		Boolean hasPath = false;
		result.add(root.data);
		int subSum = sum - root.data;
		if(subSum == 0 && root.left == null && root.right == null)
			return true;
		if(root.left != null){
			hasPath = hasPath || hasRootToLeafPath(root.left, subSum);
		}
		if(root.right != null){
			hasPath = hasPath || hasRootToLeafPath(root.right, subSum);
		}
		if(!hasPath)
			result.remove(result.size()-1);
		return hasPath;
	}
	
	//Iterative//http://www.programcreek.com/2013/01/leetcode-path-sum/
	public boolean HasPathSum(TreeNode root, int sum){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (stack.size() > 0 && root != null){
            TreeNode current = stack.pop();
            if (current.left == null && current.right == null){
                if (current.data == sum) return true;
            }
            if (current.right != null){
                current.right.data = current.data + current.right.data;
                stack.push(current.right);
            }
            if (current.left != null){
                current.left.data = current.data + current.left.data;
                stack.push(current.left);
            }
        }
        return false;
    }
	
/*	Given a BST, find out the minimum length form root to leaf with sum S. Note that: 
		a) Path from root to leaf node. 
		b) Sum of node of the path is S. 
		c) if multiple such path exist, print minimum length path. 
		d) What is advantage of BST rather than BT used for this algorithm, 
		how it improve the performance. in BST, is it required to explore both side ?
		https://www.careercup.com/question?id=5768074967908352
		http://www.zrzahid.com/minimum-length-sum-path/
		*/
	private static int minLenSumPathBST(final TreeNode root, final int sum, final int len) {
	    if (root == null) {
	        return Integer.MAX_VALUE;
	    }

	    // find the remaining sum as we are including current node in the current path
	    final int remainingSum = sum - root.data;
	    // If remaining sum is zero and it is a leaf node then we found a complete path from root to a leaf.
	    if (remainingSum == 0 && root.left == null && root.right == null) {
	        return len + 1;
	    }
	    // If remaining sum is less than current node value then we search remaining in the left subtree.
	    else if (remainingSum <= root.data) {
	    	 int l = minLenSumPathBST(root.left, remainingSum, len + 1);
	         // if search in left subtree fails to find such path only then we search in the right subtree
	         if (l == Integer.MAX_VALUE) {
	             l = minLenSumPathBST(root.right, remainingSum, len + 1);
	         }
	         return l;	        
	    }
	    // If remaining sum is greater than current node value then we search remaining in the right subtree.
	    else {
	    	 int l = minLenSumPathBST(root.right, remainingSum, len + 1);
	         // if search in right subtree fails to find such path only then we search in the left subtree
	         if (l == Integer.MAX_VALUE) {
	             l = minLenSumPathBST(root.left, remainingSum, len + 1);
	         }
	         return l;
	    }
	}
	
	//Binary Tree
	private static int minLenSumPathBT(final TreeNode root, final int sum, final int len) {
	    if (root == null) {
	        return Integer.MAX_VALUE;
	    }

	    final int diff = sum - root.data;
	    if (diff == 0 && root.left == null && root.right == null) {
	        return len + 1;
	    } else {
	        return Math.min(minLenSumPathBT(root.left, diff, len + 1), minLenSumPathBT(root.right, diff, len + 1));
	    }
	}
	

}
