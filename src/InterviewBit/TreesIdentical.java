package InterviewBit;

import java.util.LinkedList;
import java.util.Queue;
/*//https://www.interviewbit.com/problems/identical-binary-trees/
Given two binary trees, write a function to check if they are equal or not.*/
public class TreesIdentical {
	public static class TreeNode{
		int value;
		TreeNode left; TreeNode right;
		
		public TreeNode(int value){
			this.value = value;
		}
		public TreeNode(TreeNode right, TreeNode left, int value){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2),
		n3 = new TreeNode(3), n4 = new TreeNode(4), n5 = new TreeNode(5); 
		n1.left = n2;
		n2.right = n3;
		n1.right = n4;
		n2.left = n5;
		TreeNode m1 = new TreeNode(1);
		m1.left = n2;
		n2.right = n3;
		m1.right = n4;
		n2.left = n5;
		int issymetric = isSameTree(n1,m1);
		System.out.println(issymetric);

	}
	public static int isSameTree(TreeNode root1, TreeNode root2) {//O(n)
		if(root1 == null&& root2==null)	return 1;
			
			Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
			Queue<TreeNode> queue2 = new LinkedList<TreeNode>();			
			queue1.add(root1);queue2.add(root2);			
			while(!queue1.isEmpty()&& !queue1.isEmpty()){				
				TreeNode tempNode1 = queue1.poll();
				TreeNode tempNode2 = queue2.poll();					
					if(tempNode1.value==tempNode2.value){
					  if(tempNode1.left!=null&& tempNode2.left!=null) {
						 queue1.add(tempNode1.left);
					     queue2.add(tempNode2.left);
					  }
					  if(tempNode1.left!=null|| tempNode2.left!=null)  return 0;
					 if(tempNode1.right!=null&&tempNode2.right!=null) {
						queue2.add(tempNode2.right);
					    queue1.add(tempNode1.right);
					 }
					 if(tempNode1.right!=null||tempNode2.right!=null)return 0;
					}
					else
						return 0;				
			}
			return 1;
	}
	//recursive
public boolean sameTree(TreeNode A, TreeNode B) {//O(n)	    
	    if (A == null && B == null) return true;	        
	    if (A == null || B == null) return false;	        
	    if (A.value != B.value) return false;	    
	    boolean isLeftSame = sameTree(A.left, B.left);
        boolean isRightSame = sameTree(A.right, B.right);
        return A.value==B.value && isLeftSame && isRightSame;   
	}
}
