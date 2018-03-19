package HashGeeks;

import java.util.HashSet;

/*
 * https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
 * Given an array of integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.
 * Input:  arr[] = {10, 12, 11};
Output: Length of the longest contiguous subarray is 3

Input:  arr[] = {10, 12, 12, 10, 10, 11, 10};
Output: Length of the longest contiguous subarray is 2 
Time complexity : O(n2)
 */
public class LongestContinguous {

	public static void main(String[] args) {		
		int[] arr1 =  {10, 12, 12, 10, 10, 11, 10};
		System.out.println(longestContiguousSequence(arr1));
	}
	
	public static int longestContiguousSequence(int[] arr){
		int result = 1;
		int start = 0; int end = 0;
		for(int i = 0; i < arr.length-1; i++){
			HashSet<Integer> set = new HashSet<Integer>();
			set.add(arr[i]);
			int max = arr[i]; int min = arr[i];
			for(int j = i+1; j < arr.length; j++){
				// If current element is already in hash set, then this subarray cannot contain contiguous elements
				if(set.contains(arr[j]))
					break;
				
				// Else add current element to hash set and update min, max if required.
				set.add(arr[j]);
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				
				if(max - min == j-i){
					if(result < j-i+1){
						result = j-i+1;
						start = i; end = j;
					}
				}
			}
		}
		for(int i = start; i <= end; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return result;		
	}
}