package InterviewBit;

public class ArraysSortSubArray {
//http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
//O(n)	
	//https://www.interviewbit.com/problems/maximum-unsorted-subarray/
	
/*
 * 2 two other solutions
 * 1) a)Find the first element which breaks the sorting order from 0. : start index
 *    b) Find the last elements which break the sorting order reverse length-1 : endindex
 *    c)find the immediately next higher element in the arr[0] to startindex	 	
 *    d)find the immediately next lower element in the arr.length-1 to  [endindex]
 *    o(n)
 *  2)sort the array nlogn
 *   compare which indexes have changed
 *   
 */
	public void sortSubArray(int[] arr){
		int s,e;
		int min, max;
		if(arr.length < 2) return;
		
		for(s = 0; s < arr.length-1; s++){
			if(arr[s] > arr[s+1])
				break;
		}
		if(s == arr.length - 1) return;
		
		for(e = arr.length-1; e > 0; e--){
			if(arr[e] <arr[e-1])
				break;
		}
		
		min = arr[s];max = arr[e];
		for(int i = s+1; i <= e; i++){
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		
		for(int i = 0; i < s; i++){
			if(arr[i] > min){
				s = i;
				break;
			}
		}
		
		for(int j = arr.length-1; j >= e+1; j--){
			if(arr[j] < max){
				e = j;
				break;
			}
		}
	}
	public static void main(String[] args) {		

	}
}
