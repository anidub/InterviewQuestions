package numbers;

public class searchinrotatedarray {
//Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). 
	//How do you find an element in the rotated array efficiently? You may assume no duplicate exists in the array
	public static void main(String[] args) {
		int[] numbers = {3,4,5,0,1,2};
		int[] n1 = {3,4,1,2};
		System.out.println(findMin(n1));
		
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
		int mid = (low + (high-low)/2);		
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
/*	http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/
*/	public static int getIndexIterative(int[] num, int key){
		int low = 0; int high = num.length-1;
		
		while(low <= high){
			int mid = low + (high-low)/2;
			if(num[mid] == key)
				return mid;
			if(num[low] <= num[mid]){
				if(key > num[low] && key <= num[mid]){
					high = mid-1;
				}else
					low = mid+1;				
			} else {
				if (key > num[mid] && key <= num[high])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		return -1;
	}

/*//find minimum in sorted array
http://www.programcreek.com/2014/02/leetcode-find-minimum-in-rotated-sorted-array/
*/public static int findMin(int[] arr){
	if(arr.length == 1)
		return arr[0];
	
	int low = 0; int high = arr.length-1;
	if(arr[low] <= arr[high])
		return arr[low];

	while(low <= high){
		if(high - low == 1)
			return arr[high];
		int mid = low + (high-low)/2;
		
		if(arr[mid] > arr[high])
			low = mid;
		else
			high = mid;
	}
	return arr[low];
}
}