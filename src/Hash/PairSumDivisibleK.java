package Hash;

import java.util.HashMap;
/*
 * Check if an array can be divided into pairs whose sum is divisible by k
3.4
Given an array of integers and a number k, write a function that returns true
 if given array can be divided into pairs such that sum of every pair is divisible by k
 
 * https://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
 * Input: arr[] = {9, 7, 5, 3}, 
           k = 6
Output: True
We can divide array into (9, 3) and
(7, 5). Sum of both of these pairs 
is a multiple of 6.
 * Input: arr[] = {9, 7, 5, 3}, 
           k = 6
Output: True
We can divide array into (9, 3) and
(7, 5). Sum of both of these pairs 
is a multiple of 6.

1) If length of given array is odd, return false. 
    An odd length array cannot be divided in pairs.
2) Traverse input array and count occurrences of 
    all remainders. 
      freq[arr[i] % k]++
3) Traverse input array again. 
   a) Find remainder of current element.
   b) If remainder divides k into two halves, then
      there must be even occurrences of it as it
      forms  pair with itself only.
   c) If remainder is 0, then then there must be 
      even occurrences.
   c) Else, number of occurrences of current 
      remainder must be equal to number of 
       occurrences of "k - current remainder".
 */
public class PairSumDivisibleK {

	public static void main(String[] args) {
		int arr[] = { 9, 7, 5, 3 };
        int k = 6;
        System.out.println(checkIfPairsSumDivisbleK(arr, k));
	}
	
	public static Boolean checkIfPairsSumDivisbleK(int[] arr, int k){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : arr){
			int remainder = i % k;
			map.put(remainder, map.getOrDefault(remainder, 0) + 1);
		}
		
		for(int i : arr){
			int remainder = i % k;
			
			if(2 * remainder == k){
				if(map.get(remainder) % 2 == 1){
					return false;
				}
			}else if(remainder == 0){
				if(map.get(remainder) % 2 == 1){
					return false;
				}
			}else{
				if(map.get(k - remainder) != map.get(remainder)){
					return false;
				}
			}
		}
		return true;
	}
}
