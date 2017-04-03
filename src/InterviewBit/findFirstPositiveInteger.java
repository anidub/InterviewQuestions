package InterviewBit;

public class findFirstPositiveInteger {
//https://www.interviewbit.com/problems/first-missing-integer/
//Given an unsorted integer array, find the first missing positive integer.	
//O(N	
	public static void main(String[] args) {
		int[] arr = {3,4,-1,1};
		System.out.println(findFirstPositive(arr));
	}
	
	public static int findFirstPositive(int[] arr){
		int min = Integer.MAX_VALUE;int max = Integer.MIN_VALUE;
		int result = -1;		
		for(int i = 0 ; i < arr.length; i++){ //find max and min values in array
			if(arr[i] < min) min = arr[i];
			if(arr[i] > max) max = arr[i];
		}
		if(max <= 0){ //if max <= 0 return 1 since its least +ve integer
			result = 1; return result;
		}
		
		int diff = max +1; //for boolean size
		boolean[] bool = new boolean[diff];
		for(int i = 0; i < arr.length; i++){//fill in boolean arr for values more than 1
			int k = arr[i];
			if(k > 0){
				bool[k] = true;
			}
		}
		for(int i = 1; i < max; i++){//find first value for not true
			boolean val = bool[i];
			if(val != true){
				result = i;
				break;
			}
		}
		if(result == -1) result = max+1; // if array contains all +ve from 1 to n return max +1
		return result;			
	}
}
