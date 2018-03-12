package TreeGeeks;

import java.util.HashMap;
/*
 * https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 * Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. Print all sums through different vertical lines.

Examples:

      1
    /   \
  2      3
 / \    / \
4   5  6   7
The tree has 5 vertical lines

Vertical-Line-1 has only one node 4 => vertical sum is 4
Vertical-Line-2: has only one node 2=> vertical sum is 2
Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
Vertical-Line-4: has only one node 3 => vertical sum is 3
Vertical-Line-5: has only one node 7 => vertical sum is 7

So expected output is 4, 2, 12, 3 and 7

Time Complexity: O(n)

https://www.geeksforgeeks.org/vertical-sum-in-binary-tree-set-space-optimized/
 */
public class VerticalSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        getVerticalSum(root);
	}
	
	public static void getVerticalSum(TreeNode root){
		if(root == null) return;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		calculateSum(root, map, 0);
		if(map != null){
			System.out.println(map.entrySet());
		}
	}
	
	public static void calculateSum(TreeNode root, HashMap<Integer, Integer> map, int horizontalDistance){
		if(root == null) return;
		int prevSum = map.get(horizontalDistance) == null ? 0 : map.get(horizontalDistance);
		map.put(horizontalDistance, prevSum + root.data);
		calculateSum(root.left, map, horizontalDistance-1);		
		calculateSum(root.right, map, horizontalDistance+1);
	}
	
	/*
	 * https://www.geeksforgeeks.org/vertical-sum-in-binary-tree-set-space-optimized/
	 */
	static class LinkedListNode{
		int data;
		LinkedListNode previous;
		LinkedListNode next;
		
		public LinkedListNode(int data){
			this.data = data;
			this.previous = null;
			this.next = null;
		}
	}
	
	public static void getVerticalSumm(TreeNode root){
		LinkedListNode node = new LinkedListNode(0);
		verticalSum(node, root);
		while(node.previous != null){
			node = node.previous;
		}
		while(node != null){
			System.out.println(node.data);
			node = node.next;
		}		
	}
	public static void verticalSum(LinkedListNode node, TreeNode root){
		if(root == null) return;
		
		node.data = node.data + root.data;
		if(root.left != null){
			if(node.previous == null){
				node.previous = new LinkedListNode(0);
				node.previous.next = node;
			}
			verticalSum(node.previous, root.left);
		}
		
		if(root.right != null){
			if(node.next == null){
				node.next = new LinkedListNode(0);
				node.next.previous = node;
			}
			verticalSum(node.next, root.right);			
		}
	}
}