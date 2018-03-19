package situations;
/*
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.

 */
public class partitionProblem {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 5, 9, 12 };
		int n = arr.length;
		System.out.println(partitionRecursive(arr));
	}
	
	//Time Complexity: O(2^n) In worst case, this solution tries two possibilities (whether to include or exclude) for every element.
	public static boolean partitionRecursive(int[] arr){
		int sum = 0;
		for(int i : arr) 
			sum += i;
		if(sum % 2 != 0) return false;
		return partitionRecursive(arr, arr.length, sum/2);		
	}
	
	public static boolean partitionRecursive(int[] arr, int length, int sum){
		 // Base Cases
		if(sum == 0)
			return true;
		if(length == 0 && sum != 0) 
			return false;
	     // If last element is greater than sum, then ignore it
		if(arr[length-1] > sum)
			return partitionRecursive(arr, length-1, sum);
		  /* else, check if sum can be obtained by any of
        the following
     (a) including the last element
     (b) excluding the last element  */
		return partitionRecursive(arr, length-1, sum) || partitionRecursive(arr, length-1, sum-arr[length-1]);
	}
	
	//USE THIS
	//https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation

}
