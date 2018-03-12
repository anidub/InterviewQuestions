package HashGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/*
 * https://ide.geeksforgeeks.org/ZGB6Rx
 * https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 * Print all subarrays with 0 sum
3.5
Given an array, print all subarrays in the array which has sum 0.

Examples:

Input:  arr = [6, 3, -1, -3, 4, -2, 2,
             4, 6, -12, -7]
Output:  
Subarray found from Index 2 to 4
Subarray found from Index 2 to 6          
Subarray found from Index 5 to 6
Subarray found from Index 6 to 9
Subarray found from Index 0 to 10

Time Complexity : O(n2)

Maintain sum of elements encountered so far in a variable (say sum).
If current sum is 0, we found a subarray starting from index 0 and ending at index current index
Check if current sum exists in the hash table or not.
If current sum exists in the hash table, that means we have subarray(s) present with 0 sum that ends at current index.
Insert current sum into the hash table
 */
public class FindAllZeroSumSubarrays {

	static class Node{
		int start;
		int end;
		
		public Node(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) {
		 int[] arr={6, 3, -1, -3, 4, -2, 2,4, 6, -12, -7};
		 getAllZeroSums(arr);
	}
	
	public static ArrayList<Node> getAllZeroSums(int[] arr){
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Node> result = new ArrayList<Node>();
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			// if sum is 0, we found a subarray starting from index 0 and ending at index i
			if(sum == 0){
				result.add(new Node(0, i));
			}
			 // If sum already exists in the map there exists at-least one subarray ending at index i with 0 sum
			if(map.get(sum) != null){
				ArrayList<Integer> list = map.get(sum);
				Iterator it = list.iterator();
				while(it.hasNext()){
					result.add(new Node(((Integer) it.next()) + 1, i));
				}
				map.get(sum).add(i);
			}else{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(sum, list);
			}
		}
		return result;
	}
}