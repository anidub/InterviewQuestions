package HashGeeks;

import java.util.HashMap;
/*
 * Largest subarray with equal number of 0s and 1s
Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. Expected time complexity is O(n).

Examples:

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 (Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4
https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 */
public class EqualNumberOfZerosOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
/*
 * Time Complexity: O(n^2)
Auxiliary Space: O(1)
 */
	public static int maxSize(int[] arr){
		if(arr == null) return -1;
		 int sum = 0;
		 int maxsize = -1; 
		 int startIndex = 0;int endindex = 0;
		
		for(int i = 1; i < arr.length - 1; i++){
			sum = (arr[i] == 0) ? -1 : 1;
			for(int j = i+1; j < arr.length; j++){
				if(arr[j] == 0)
					sum += -1;  
				else
						sum += 1;
				
				if(sum == 0 && maxsize < j-i+1){
					maxsize = j-i+1;
					startIndex = i;
				}
			}
		}
		endindex = startIndex + maxsize -1;
		if(maxsize == -1) return -1;
		else
			 System.out.println(startIndex+" to "+endindex);
		return maxsize;		
	}
	/*
	 * https://ide.geeksforgeeks.org/21Ar47jmHR
	 * Time Complexity: O(n)
		Auxiliary Space: O(n)
	 */
	public static int maxSizeHash(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0; int startindex = 0; int endindex = 0; int maxsize = -1;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 0) arr[i] = -1;
		}
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			if(sum == 0){
				maxsize = i+1;
				endindex = i;
			}
			if(map.containsKey(sum)){
				int previous = map.get(sum);
				maxsize = Math.max(maxsize, endindex-previous);
				if(maxsize == endindex-previous){
					startindex = previous + 1;
					endindex = i;
				}
			}else{
				map.put(sum, i);
			}
		}
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == -1) arr[i] = 0;
		}
		startindex = endindex - maxsize + 1;
		System.out.println(startindex + " to " + endindex);
		return maxsize;
	}
}
