package InterviewBit;

import java.util.ArrayList;

public class TreesAllSumRootToLeafPaths {
/*	https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/
		Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
			Given the below binary tree and sum = 22,
			              5
			             / \
			            4   8
			           /   / \
			          11  13  4
			         /  \    / \
			        7    2  5   1
			return
			[  [5,4,11,2],
			   [5,8,4,5]
			]
			http://www.programcreek.com/2014/05/leetcode-path-sum-ii-java/*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<ArrayList<Integer>> allRootToLeafSum(TreeNode root, int target){
		ArrayList<ArrayList<Integer>> result = 	new ArrayList<ArrayList<Integer>>();
		if(root == null) return result;
		ArrayList<Integer> path = new ArrayList<Integer>();
		find(root, 0, target, result, path);
		return result;
	}
	
	public void find(TreeNode node, int currentSum, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path){
		if(node == null)
			return;
		path.add(node.data);
		if(node.left == null && node.right == null){
			currentSum += node.data;
			if(currentSum == target){
				result.add(path);
			}
			path.remove(path.size()-1);
			return;
		}
		currentSum += node.data;
		find(node.left, currentSum, target, result, path);
		find(node.right, currentSum, target, result, path);
		path.remove(path.size()-1);
	}

}
