package numbers;

public class firstlastoccurence {
/*	http://www.geeksforgeeks.org/find-first-last-occurrences-element-sorted-array/
		Find first and last occurrences of an element in a sorted array*/
	public static void main(String[] args) {
		int[] numbers  = {1,2,2,2,3};
		int n = 2;
		System.out.println(firstLast(numbers,n));	
	}
	
	//Time Complexity : O(log n) space = O(1)
	public static int[] firstLast(int[] num, int k){
		int[] result = new int[2];
		result[0] = findFirst(num,0,num.length-1,k);
		result[1] = findLast(num,0,  num.length-1, k);
		return result;
	}
	
	public static int findFirst(int[] arr, int low, int high, int target){
		if(low <= high){
			int mid = low + (high-low)/2;
			if ((mid == 0 || target > arr[mid-1]) && (arr[mid] == target)){
				return mid;
			}
	        else if(target > arr[mid])
	             return findFirst(arr, (mid + 1), high, target);
	        else
	             return findFirst(arr, low, (mid -1), target);			
		}
		return -1;
	}
	
	public static int findLast(int[] arr, int low, int high, int target){
		if(low <= high){
			int mid = low + (high-low)/2;
			if((mid == arr.length-1 || target < arr[mid+1]) && arr[mid] == target){
				return mid;
			}else if(target < arr[mid]){
				return findLast(arr, low, mid-1, target);
			}else {
				return findLast(arr, mid+1, high, target);
			}
		}
		return -1;
	}
}