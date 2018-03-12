package TreeGeeks;

import java.util.HashMap;
import java.util.Stack;
/*
 * https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
 */
public class CloneRandomNodeTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.random = root.left.right;
	    root.left.left.random = root;
	    root.left.right.random = root.right;
	    printInorderRec(root);
	    TreeNode copied = cloneTree(root);
	    System.out.println("-----------");
	    printInorderRec(copied);
	}

	public static TreeNode cloneTree(TreeNode root){
		if(root == null) return null;
		HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
		TreeNode copied = copyLeftRight(root, map); 
		copyRandom(root, copied, map);
		return copied;
	}
	
	// This function creates clone by copying key and left and right pointers
	// This function also stores mapping from given tree node to clone.
	public static TreeNode copyLeftRight(TreeNode root, HashMap<TreeNode, TreeNode> map){
		if(root == null) return null;
		TreeNode copied  = new TreeNode(root.data);
		map.put(root, copied);
		copied.left = copyLeftRight(root.left, map);
		copied.right = copyLeftRight(root.right, map);
		return copied;
	}
	
	// This function copies random node by using the hashmap built by copyLeftRightNode()
	public static void copyRandom(TreeNode root, TreeNode copied, HashMap<TreeNode, TreeNode> map){
		if(copied == null) return;
		copied.random = map.get(root.random);
		copyRandom(root.left, copied.left, map);
		copyRandom(root.right, copied.right, map);
	}
	
	public static void printInorder(TreeNode root){
		if(root == null) return;		
		printInorder(root.left);
		System.out.print("[ " + root.data);
		if(root.random != null){
			System.out.print(" " + root.random.data + " ], ");
		}else{
			System.out.print(" Null], ");
		}
		System.out.println();
		printInorder(root.right);
	}
	
	public static void printInorderRec(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(stack.isEmpty() && root != null){
			if(root.left != null){
				stack.push(root.left);
			}else{
				root = stack.pop();
				System.out.print("[ " + root.data);
				if(root.random != null){
					System.out.print(" " + root.random.data + " ], ");
				}else{
					System.out.print(" Null], ");
				}
				root = root.right;
			}
		}
		printInorder(root.left);
		System.out.print("[ " + root.data);
		if(root.random != null){
			System.out.print(" " + root.random.data + " ], ");
		}else{
			System.out.print(" Null], ");
		}
		System.out.println();
		printInorder(root.right);
	}
	
}
