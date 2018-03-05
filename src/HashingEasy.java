import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HashingEasy {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 1, 4, 5};
		containsElementDistanceK(arr,3);
	}
	
	/*
	 * https://www.geeksforgeeks.org/convert-an-array-to-reduced-form-set-1-simple-and-hashing/
	 * Given an array with n distinct elements, convert the given array to a form where all elements are in range from 0 to n-1. The order of elements is same, i.e., 0 is placed in place of smallest element, 1 is placed for second smallest element, … n-1 is placed for largest element.

Input:  arr[] = {10, 40, 20}
Output: arr[] = {0, 2, 1}

Input:  arr[] = {5, 10, 40, 30, 20}
Output: arr[] = {0, 1, 4, 3, 2}
Expected time complexity is O(n Log n).
Can also use Binary search...Space complexity will be O(1)
Time complexity : O(nlogn) Space: O(n)
	 */
	public static int[] arrayReducedForm(int[] arr){
		int[] result = new int[arr.length];
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < arr.length; i++){
			map.put(arr[i], i);
		}
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++){
			result[i] = map.get(arr[i]);					
		}
		return result;
	}
	
	/*
	 * https://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
	 * Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array. Write a function that returns true if array contains duplicates within k distance.

Examples:

Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Time complexity : O(n)
Space : O(k)
	 */
	public static boolean containsElementDistanceK(int[] arr, int k){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++){
			if(set.contains(arr[i]))
				return true;
			else{
				set.add(arr[i]);
			}
			if(i >= k){
				set.remove(arr[i-k]);
			}
		}
		return false;
	}
	
	/*
	 * https://www.geeksforgeeks.org/given-an-array-of-pairs-find-all-symmetric-pairs-in-it/Input: arr[] = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}}
	 * Two pairs (a, b) and (c, d) are said to be symmetric if c is equal to b and a is equal to d. For example (10, 20) and (20, 10) are symmetric. Given an array of pairs find all symmetric pairs in it.

It may be assumed that first elements of all pairs are distinct.
Output: Following pairs have symmetric pairs
        (30, 40)
        (5, 10)  
        Time Complexity : O(n) 
	 */	
	public static void findSymmetricPairs(int[][] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++){
			 // First and second elements of current pair
            int first = arr[i][0];
            int sec   = arr[i][1];
            
            Integer val = map.get(sec);            
            // If found and value in hash matches with first element of this pair, we found symmetry
            if (val != null && val == first)
               System.out.println("(" + sec + ", " + first + ")");
            else  // Else put sec element of this pair in hash
            	map.put(first, sec);
		}
	}
	
	/*
	 * https://www.geeksforgeeks.org/group-multiple-occurrence-of-array-elements-ordered-by-first-occurrence/
	 * Given an unsorted array with repetitions, the task is to group multiple occurrence of individual elements. The grouping should happen in a way that the order of first occurrences of all elements is maintained.

Examples:

Input: arr[] = {5, 3, 5, 1, 3, 3}
Output:        {5, 5, 3, 3, 3, 1}
	 */
	public static void groupMultipleByFirstOccurence(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		for(int i = 0; i < arr.length; i++){
			int count = map.get(arr[i]);
			while(count != 0){
				System.out.println(arr[i]);
			}
			map.remove(arr[i]);
		}		
	}
	
	/*
	 * https://www.geeksforgeeks.org/count-pairs-with-given-sum/
	 * Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’.

Examples:
Input  :  arr[] = {1, 5, 7, -1}, 
          sum = 6
Output :  2
Pairs with sum 6 are (1, 5) and (7, -1)
	 */
	public static int countPairsWithSum(int[] arr, int sum){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		int twiceCount = 0;
		for(int i = 0; i < arr.length; i++){
			if(map.get(sum - arr[i]) != null){
				twiceCount += map.get(sum - arr[i]);
			}
			if((sum - arr[i]) == arr[i])
				twiceCount--;
		}
		return twiceCount/2;
	}

}
