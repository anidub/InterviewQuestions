package numbers;

import java.util.HashSet;
/*
 * //https://www.geeksforgeeks.org/find-the-element-that-appears-once/
 * Given an array where every element occurs three times, except one element which occurs only once. Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.
Examples:
Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
Output: 2
 */
public class AppearsOnce {

	public static void main(String[] args) {
		int[] array = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
		System.out.println(apearsOnce(array));
		System.out.println(appearOnceUsingSetBits(array));
	}
	
	//Time complexity : O(n) Space: O(n)
	public static int apearsOnce(int[] arr){
		HashSet<Integer> set = new HashSet<Integer>();
		int thriceSum = 0;
		int sum = 0;
		for(int i = 0 ; i < arr.length; i++){
			if(!set.contains(arr[i])){
				set.add(arr[i]);
				thriceSum += 3 * arr[i];
			}
			sum += arr[i];
		}
		int result = (thriceSum - sum)/2;
		return result;		
	}

	
/*	Time Complexity: O(n)
	Auxiliary Space: O(1)*/
	static final int INT_SIZE = 32;
	public static int appearOnceUsingSetBits(int[] arr){
		int x, sum;
		int result = 0;
		for(int i = 0; i < INT_SIZE; i++){
			// Find sum of set bits at ith position in all array elements
			sum = 0;
			x = (1 << i);
			for(int j = 0; j < arr.length; j++){
				if((arr[j] & x) == 0){
					sum++;
				}				
			}
			// The bits with sum not multiple of 3, are the bits of element with single occurrence.
			if((sum % 3) == 0){
				result |= x;
			}
		}
		return result;
	}
}
