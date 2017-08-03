package InterviewBit;

import java.util.LinkedList;
import java.util.Queue;

public class TreesMaxDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Height of tree is " + shortestPathFromRootToLeaf(root));
}
//	http://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
	public static int maxDepth(TreeNode node) {		  
	        if (node == null) return 0;	  
	      //done using level order..height is number of levels
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	  // Enqueue Root and initialize height
	        q.add(node);
	        int height = 0;	  
	        while (true){
	          // nodeCount (queue size) indicates number of nodes at current level.
	            int nodeCount = q.size();
	            if (nodeCount == 0)
	                return height;
	   //everytime it goes to next level, height increases         
	            height++;	  
// Dequeue all nodes of current level and Enqueue all nodes of next level
	            while (nodeCount > 0){
	                TreeNode newnode = q.poll();
	                if (newnode.left != null)
	                    q.add(newnode.left);
	                if (newnode.right != null)
	                    q.add(newnode.right);
	                nodeCount--;
	            }
		}
}
	
	//recursive
	public int heightandsize(TreeNode root){
		if(root == null) return 0;
		int l = heightandsize(root.left);
		int r = heightandsize(root.right);
		return l > r ? l+1:r+1;
	}
	
	public static int shortestPathFromRootToLeaf(TreeNode node){
		if(node == null) return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		int height = 0;
		while(true){
			int nodecount = queue.size();
			if(nodecount == 0) return height;
			height++;
			while(nodecount > 0){
				TreeNode temp = queue.poll();
				//where no more next levels
				if(temp.left == null && temp.right == null)
					return height;
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null) 
					queue.add(temp.right);
				nodecount--;
			}
		}
	}
	
	
	//http://www.programcreek.com/2013/02/leetcode-minimum-depth-of-binary-tree-java/
	public int shortestpatroottolead(TreeNode root){
		if(root == null) return 0;
		int height = 0;
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		Queue<Integer> heightQueue = new LinkedList<Integer>();
		
		nodeQueue.add(root);
		heightQueue.add(1);
		
		while(!nodeQueue.isEmpty()){
			TreeNode temp = nodeQueue.poll();
			height = heightQueue.poll();
			if(temp.left == null && temp.right == null){
				return height;
			}
			
			if(temp.left != null){
				nodeQueue.add(temp.left);
				heightQueue.add(height+1);
			}
			if(temp.right != null){
				nodeQueue.add(temp.right);
				heightQueue.add(height+1);
			}
		}		
		return height;
	}
	
	
	//http://www.programcreek.com/2013/02/leetcode-minimum-depth-of-binary-tree-java/
	public static int shortestPathRootToLeafRecursive(TreeNode root){
		return shortestPathRootToLeafRecursive(root, 0);
	}
	
	public static int shortestPathRootToLeafRecursive(TreeNode root, int depth) {
		if (root == null)
			return 0;
		int depth1 = shortestPathRootToLeafRecursive(root.left, depth + 1);
		int depth2 = shortestPathRootToLeafRecursive(root.right, depth + 1);

		return Math.min(depth1, depth2) + depth;
	}	
}