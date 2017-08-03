package situations;

import java.util.PriorityQueue;
/*
 * http://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
 * Time complexity is O(nlog(k)). Space complexity is O(k) for storing the top k numbers.
 */
class ArrayContainer implements Comparable<ArrayContainer>{
	   int i;
	   public ArrayContainer(int i){
		   this.i = i;
	   }

	public int compareTo(ArrayContainer o) { // for sorted order (lowest first)
		if(this.i < o.i)
			return -1;
		return 1;
	}
	   
}
public class findKthLargestElement {
	
	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		System.out.println(findKthLargestMinHeap(arr,2));

	}
	
	public static int findKthLargestMinHeap(int[] nums, int k) {
	    PriorityQueue<ArrayContainer> q = new PriorityQueue<ArrayContainer>(k);
	    for(int i: nums){
	        q.offer((new ArrayContainer(i)));
	 	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }	 
	    return q.peek().i;
	}
	
	public int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}	 
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}

//http://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
	//Average case time is O(n), worst case time is O(n^2)
	public int getKth(int k, int[] nums, int start, int end) {	 
		int pivot = nums[end];	 
		int left = start;
		int right = end;
	 
		while (true) {	 
			while (nums[left] < pivot && left < right) {
				left++;
			}	 
			while (nums[right] >= pivot && right > left) {
				right--;
			}	 
			if (left == right) {
				break;
			}	 
			swap(nums, left, right);
		}
	 
		swap(nums, left, end);
	 
		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
	 
	public void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
}
