package HashGeeks;

import java.util.HashMap;
/*
 * Given an unsorted array of integers, find a subarray which adds to a given number. If there are more than one subarrays with sum as the given number, print any of them.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
Ouptut: Sum found between indexes 0 to 3
Time complexity : O(n)
 */
public class findSubArrayWithGivenSum {
	public static void main(String[] args) {
		 int arr[] = {10, 2, -2, -20, 10};
		 subArrayGivenSum(arr, -10);
	}

	public static void subArrayGivenSum(int[] arr, int sum){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int currSum = 0;
		
		for(int i = 0; i < arr.length; i++){
			currSum += arr[i];
			 // if curr_sum is equal to target sum we found a subarray starting from index 0 and ending at index i
			if(currSum == sum){
				System.out.println("Found between  0 "  + " : " + i);
				return;
			}
			
			 // If curr_sum - sum already exists in map we have found a subarray with target sum
			if(map.containsKey(sum - currSum)){
				System.out.println("Found between " + map.get(currSum - sum) + " " + i);
				return;
			}
			map.put(currSum, i);
		}
		System.out.println("not found");
	} 
}