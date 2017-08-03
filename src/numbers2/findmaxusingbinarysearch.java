package numbers2;

public class findmaxusingbinarysearch {
//http://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
	//time complexity = O(n);
	
	//Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
	//Output: 50
	public static int findmax(int[] arr, int low, int high){
		int l = arr.length;
		if(l == 0) return -1;
		if(l == 1) return arr[low];
		
		if((high == low+1) && arr[low] < arr[high]) return arr[high];
		if((high == low+1) && arr[low] > arr[high]) return arr[low];
		
		
		while(low <= high){
			int mid = (low + high)/2;
			if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return arr[mid];
			else if(arr[mid] < arr[mid-1]  && arr[mid] > arr[mid+1]){
				high = mid-1;
			}else{
				low = mid +1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 50, 10, 9, 7, 6};
		System.out.println(findmax(arr,0,arr.length-1));
	}
}
