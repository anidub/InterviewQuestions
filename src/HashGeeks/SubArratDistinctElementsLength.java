package HashGeeks;

import java.util.HashSet;
/*
 * https://www.geeksforgeeks.org/subarrays-distinct-elements/
 * Subarrays with distinct elements
Given an array, the task is to calculate the sum of lengths of contiguous subarrays having all elements distinct.
Input :  arr[] = {1, 2, 3}
Output : 10
{1, 2, 3} is a subarray of length 3 with 
distinct elements. Total length of length
three = 3.
{1, 2}, {2, 3} are 2 subarray of length 2 
with distinct elements. Total length of 
lengths two = 2 + 2 = 4
{1}, {2}, {3} are 3 subarrays of length 1
with distinct element. Total lengths of 
length one = 1 + 1 + 1 = 3
Sum of lengths = 3 + 4 + 3 = 10

Input :  arr[] = {1, 2, 1}
Output : 7

Input :  arr[] = {1, 2, 3, 4}
Output : 20
Time Complexity : O(n) Note that the inner loop runs n times in total as j goes from 0 to n across all outer loops. So we do O(2n) operations which is same as O(n).
https://ide.geeksforgeeks.org/1sw6IH
 */
public class SubArratDistinctElementsLength {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		System.out.println("Sum of lengths of all subarrays with unique element = "+sumoflength(arr));
	}
	
	public static int sumoflength(int arr[]){
	   // For maintaining distinct elements.
	   HashSet<Integer> set = new HashSet<Integer>();
	 
	    // Initialize ending point and result
	    int j = 0, ans = 0;
	 
	    // Fix starting point
	    for (int i=0; i< arr.length; i++){
	        // Find ending point for current subarray with distinct elements.
	        while (j < arr.length && !set.contains(arr[j])){
	            set.add(arr[j]);
	            j++;
	        }
	 
	        // Calculating and adding all possible length subarrays in arr[i..j]
	        ans += ((j - i) * (j - i + 1))/2;
	 
	        // Remove arr[i] as we pick new stating point from next
	        set.remove(arr[i]);
	    }	 
	    return ans;
	}
}