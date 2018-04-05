package HashGeeks;

import java.util.HashMap;
/*
 * https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 * Input: {-3, 2, 3, 1, 6}
Output: false
There is no subarray with zero sum.
Input: {4, 2, -3, 1, 6}
Output: true 
There is a subarray with zero sum from index 1 to 3.

Time Complexity : O(n)
 */
public class ZeroSumExists {

	public static void main(String[] args) {
		 int arr[] = {-3, 2, 3, 1, 6};
		System.out.println(ifZeroSumExits(arr));
	}

	public static boolean ifZeroSumExits(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			if(arr[i] == 0 || sum == 0 || map.get(sum) != null){
				return true;
			}
			map.put(sum, i);
		}
		return false;
	}
}