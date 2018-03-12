package HashGeeks;

import java.util.HashSet;
/*
 * https://www.geeksforgeeks.org/longest-consecutive-subsequence/
 * Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Examples

Input: arr[] = {1, 9, 3, 10, 4, 20, 2};
Output: 4
The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements
 */
public class LongestConsecutiveSubSequence {

	public static void main(String[] args) {
		int[] arr = {1, 9, 3, 10, 4, 20, 2};
		System.out.println(longestConsecutive(arr));
	}

	public static int longestConsecutive(int[] arr){
		int result = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++)
			set.add(arr[i]);
		
		// if current element is the starting element of a sequence
		for(int i = 0; i < arr.length; i++){
			if(!set.contains(arr[i]-1)){
				// Then check for next elements in the sequence
				int j = arr[i];
				while(set.contains(j)){
					j++;
				}
				 // update  optimal length if this length is more
				result = Math.max(result, j - arr[i]);	
			}
		}
		return result;
	}
}