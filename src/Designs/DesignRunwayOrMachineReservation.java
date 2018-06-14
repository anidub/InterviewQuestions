package Designs;

public class DesignRunwayOrMachineReservation {
/*
 * https://www.geeksforgeeks.org/data-structure-for-future-reservations-for-a-single-resource/
 * Design a runway reservation system where one runway and each flight takes k min to use runway
 * Design a data structure to do reservations of future jobs on a single machine under following constraints.
1) Every job requires exactly k time units of the machine.
2) The machine can do only one job at a time. 
3) Time is part of the system. Future Jobs keep coming at different times. Reservation of a future job is done only if there is no existing reservation 
within k time frame (after and before)
4) Whenever a job finishes (or its reservation time plus k becomes equal to current time), it is removed from system.

Binary Search Tree to maintain set of reserved jobs. For every reservation request, insert it only when there is no conflicting reservation. 
While inserting job, do “within k time frame check”. If there is a k distant node on insertion path from root, then reject the reservation request, otherwise do the reservation.
 */
	public static class TreeNode{
		int time;
		TreeNode left; TreeNode right;
		public TreeNode(int time){
			this.time = time; 
			this.left = null;this.right = null;
		}
	}
	
	static TreeNode root = null;
	public static TreeNode insert(TreeNode root, int time, int k){
		if(root == null){
			root = new TreeNode(time);
		}
		if(time < root.time + k && time > root.time - k)
			return root;
		
		if(time < root.time)
			return insert(root.left, time, k);
		else
			return insert(root.right, time, k);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
