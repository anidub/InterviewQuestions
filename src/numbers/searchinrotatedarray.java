package numbers;

public class searchinrotatedarray {
//Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). 
	//How do you find an element in the rotated array efficiently? You may assume no duplicate exists in the array
	public static void main(String[] args) {
		int[] numbers = {3,4,5,0,1,2};
		int key = 2;
		int index = search(numbers,0,numbers.length -1 ,key);
		if(index != -1)
		System.out.println(index);
		else
			System.out.println("not found ");
	}
	public static int search(int[] numbers, int low, int high, int key){
		if(low > high)
			return -1;
		int mid = (low + high)/2;		
		if(numbers[mid] == key)
			return mid;
		
		/* If arr[l...mid] is sorted */
		if(numbers[low] <= numbers[mid]){
			 /* As this subarray is sorted, we can quickly
	           check if key lies in half or other half */
			if(key >= numbers[low] && key <= numbers[mid])
				return search(numbers, low, mid - 1, key);
				
				return search(numbers,mid+1,high,key); 				
		}
		 /* If arr[l..mid] is not sorted, then arr[mid... r]
	       must be sorted*/
		if(key >= numbers[mid] && key <= numbers[high])
			return search(numbers,mid+1, high,key);
			
			return search(numbers,low,mid-1,key);		
	}
}
