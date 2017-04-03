package InterviewBit;

import java.util.ArrayList;
import java.util.Stack;

public class TreesRootToLeafPathSum {
///https://www.interviewbit.com/problems/path-sum/
/*	Given a binary tree and a sum, 
	determine if the tree has a root-to-leaf path such that adding up all the values 
	along the path equals the given sum.*/	
	public static void main(String[] args) {		
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
}
