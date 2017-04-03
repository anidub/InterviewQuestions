package InterviewBit;

public class ArraysFirstMissingPositiveNumber {
/*	Given an unsorted integer array, find the first missing positive integer.
	Given [1,2,0] return 3,
			[3,4,-1,1] return 2,
			[-8, -7, -6] returns 1
			Your algorithm should run in O(n) time and use constant space.
			http://n00tc0d3r.blogspot.com/2013/03/find-first-missing-positive.html
*/	public static void main(String[] args) {
		int[] arr = {3,4,-1,1};
		System.out.println(firstMissingPositive(arr));

	}
	
	 public static int firstMissingPositive(int[] A) {  
		   // in-place swap (bucket sort)  
		   int i = 0;  
		   while (i < A.length) {  
		     if (A[i] > 0 && A[i] <= A.length && A[i] != i+1 && A[i] != A[A[i]-1]) {  
		       int temp = A[A[i]-1];  
		       A[A[i]-1] = A[i];  
		       A[i] = temp;  
		     } else {  
		       ++i;  
		     }  
		   }  
		   // find the first positive missing integer  
		   i = 0;  
		   while (i < A.length && A[i] == i+1) 
			   ++i;  
		   return i+1;  
		 }
}
