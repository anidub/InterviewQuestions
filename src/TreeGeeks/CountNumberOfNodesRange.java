package TreeGeeks;

public class CountNumberOfNodesRange {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
        root.left     = new TreeNode(5);
        root.right     = new TreeNode(50);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(100);
        System.out.println(getCountNodesInRange(root, 5, 45));

	}
/*
 * https://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/
 * Given a Binary Search Tree (BST) and a range, count number of nodes that lie in the given range.
 * Time complexity: O(h + k) where h is height of BST and k is number of nodes in given range.
 */
	public static int getCountNodesInRange(TreeNode root, int low, int high){
		if(root == null) return 0;
		if(root.data >= low && root.data <= high){
			return 1 + getCountNodesInRange(root.left, low, high) + getCountNodesInRange(root.right, low, high);
		}else if(root.data < low){
			return getCountNodesInRange(root.right, low, high);
		}else{
			return getCountNodesInRange(root.left, low, high);
		}				
	}
	
	/*
	 * https://www.geeksforgeeks.org/count-bst-subtrees-that-lie-in-given-range/
	 * Count of nodes where all the nodes under that node *including this node* (or subtree rooted with that node) lie in the given range.
	 * The idea is to traverse the given Binary Search Tree (BST) in bottom up manner. For every node, recur for its subtrees, if subtrees are in range
	 *  and the nodes is also in range, 
	 * then increment count and return true (to tell the parent about its status). Count is passed as a pointer so that it can be incremented across all function calls.
	 * O(n): Going for every subtree
	 */
	public static class Count{
		int count;
		public Count(int count){
			this.count = count;
		}
	}
	
	public static int getCountSubTreeInRange(TreeNode root, int low, int high){
		if(root == null) return 0;
		Count count = new Count(0);
		getCountSubTreeInRangeUtil(root, low, high, count);
		return count.count;
	}
	
	public static boolean inRange(TreeNode root, int low, int high){
		return (root.data >= low && root.data <= high);
	}
	
	public static boolean getCountSubTreeInRangeUtil(TreeNode root, int low, int high, Count count){
		if(root == null) return true;
		
		boolean left = getCountSubTreeInRangeUtil(root.left, low, high, count);
		boolean right = getCountSubTreeInRangeUtil(root.right, low, high, count);
	
		if(left && right && inRange(root, low, high)){
			count.count++;
			return true;
		}else{
			return false;
		}
	}
}