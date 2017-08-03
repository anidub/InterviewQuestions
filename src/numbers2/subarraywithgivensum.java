package numbers2;

public class subarraywithgivensum {
//Find subarray with given sum
//	Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
	//http://www.geeksforgeeks.org/find-subarray-with-given-sum/
	//O(n)
	public static void main(String[] args) {
		int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
		int sum = 14;		
		findsubarraywithgivensum(arr,sum);
	}
	
	public static void findsubarraywithgivensum(int[] arr, int sum){
		if(arr == null) return;
		int curr_sum = arr[0];
		int start = 0;
		int i;
		
		for(i = 1; i < arr.length; i++){
			while(curr_sum > sum && start < i-1){
				curr_sum = curr_sum - arr[start];
				start++;
			}
			
			if(curr_sum == sum){
				System.out.println("The sum is found between index :" + start + " to " + (i-1));
				return;
			}
			
			if(i < arr.length) curr_sum = curr_sum + arr[i];
		}		
		System.out.println("not found");	
	}
}
