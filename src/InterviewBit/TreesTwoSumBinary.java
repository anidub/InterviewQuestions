package InterviewBit;

import java.util.Stack;

public class TreesTwoSumBinary {

	public static void main(String[] args) {
		TreeNode root =  new TreeNode(15);
		    root.left = new TreeNode(10);
		    root.right = new TreeNode(20);
		    root.left.left = new TreeNode(8);
		    root.left.right = new TreeNode(12);
		    root.right.left = new TreeNode(16);
		    root.right.right = new TreeNode(25);
		    System.out.println(twoSum(root,33));
	}

	public static boolean twoSum(TreeNode root, int target) {
		if (root == null)
			return false;
		Stack<TreeNode> st1 = new Stack<TreeNode>();
		Stack<TreeNode> st2 = new Stack<TreeNode>();
		int val1 = 0;
		int val2 = 0;
		boolean s1 = false;
		boolean s2 = false;
		TreeNode curr1 = root;
		TreeNode curr2 = root;
		while (true) {

			while (s1 == false) {
				if (curr1 != null) {
					st1.push(curr1);
					curr1 = curr1.left;
				} else {
					if (st1.isEmpty()) {
						s1 = true;
					} else {
						curr1 = st1.pop();
						val1 = curr1.data;
						curr1 = curr1.right;
						s1 = true;
					}
				}
			}

			while (s2 == false) {
				if (curr2 != null) {
					st2.push(curr2);
					curr2 = curr2.right;
				} else {
					if (st2.isEmpty()) {
						s2 = true;
					} else {
						curr2 = st2.pop();
						val2 = curr2.data;
						curr2 = curr2.left;
						s2 = true;
					}
				}
			}
			if ((val1 != val2) && val1 + val2 == target) {
				System.out.println(val1 + " " + val2);
				return true;
			} else if (val1 + val2 > target)
				s2 = false;
			else if (val1 + val2 < target)
				s1 = false;

			if (val1 >= val2)
				return false;
		}
	}
}