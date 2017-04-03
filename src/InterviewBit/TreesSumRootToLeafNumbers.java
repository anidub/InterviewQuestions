package InterviewBit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreesSumRootToLeafNumbers {
/*	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	An example is the root-to-leaf path 1->2->3 which represents the number 123.
	Find the total sum of all root-to-leaf numbers % 1003.
	https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
*/	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
	private static final int MOD = 1003;	    
	public int sumNumbers(TreeNode root) {		
	    return sum(root, 0) % MOD;		    
	}
		
	public int sum(TreeNode node, int num) {
		if (node == null)return 0;

		if (node.left == null && node.right == null) {
			int newNum = num * 10 + node.data;
			newNum %= MOD;
			return newNum;
		}

		num = num * 10 + node.data;
		num %= MOD;

		int leftSum = sum(node.left, num);
		int rightSum = sum(node.right, num);

		return (leftSum + rightSum) % MOD;
	}
	//http://www.programcreek.com/2014/05/leetcode-sum-root-to-leaf-numbers-java/
	public static int RootToLeafNumbers(TreeNode root){
		int sum = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> sumQueue = new LinkedList<Integer>();
		queue.add(root);sumQueue.add(root.data);
		
		while(!queue.isEmpty()){
			TreeNode n = queue.poll();
			Integer tempSum = sumQueue.poll();
			
			if(n.left == null && n.right == null){
				sum = sum + tempSum;
			}
			if(n.left != null){
				queue.add(n.left);
				sumQueue.add(tempSum * 10 + n.left.data);
			}
			if(n.right != null){
				queue.add(n.right);
				sumQueue.add(tempSum * 10 + n.right.data);
			}
		}
		return sum%MOD;
	}

	
	/*This method does the above work but more importantly it is for
	 * understanding how dfs would work if we have to go through every
	 * value and construct all the root to leaf paths.
	 * http://www.programcreek.com/2014/05/leetcode-sum-root-to-leaf-numbers-java/
	 */
	public int sumNumbersRecursive(TreeNode root) {
	    int result = 0;
	    if(root==null)
	        return result;
	 //contains all root to leaf paths
	    ArrayList<ArrayList<TreeNode>> all = new ArrayList<ArrayList<TreeNode>>();
	    ArrayList<TreeNode> l = new ArrayList<TreeNode>();
	    l.add(root);
	    dfs(root, l, all);
	 
	    for(ArrayList<TreeNode> a: all){
	        StringBuilder sb = new StringBuilder();
	        for(TreeNode n: a){
	            sb.append(String.valueOf(n.data));
	        }
	        int currValue = Integer.valueOf(sb.toString());
	        result = result + currValue;
	    }	 
	    return result;
	}
	 
	public void dfs(TreeNode n, ArrayList<TreeNode> l,  ArrayList<ArrayList<TreeNode>> all){
	    if(n.left==null && n.right==null){
	        ArrayList<TreeNode> t = new ArrayList<TreeNode>();
	        t.addAll(l);
	        all.add(t);
	    }
	 
	    if(n.left!=null){
	        l.add(n.left);
	        dfs(n.left, l, all);
	        l.remove(l.size()-1);
	    }
	 
	    if(n.right!=null){
	        l.add(n.right);
	        dfs(n.right, l, all);
	        l.remove(l.size()-1);
	    }	 
	}
}