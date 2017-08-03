package numbers;

public class binarysearch {
	public static void main(String[] args) {
		int[] num = {1,2,3,4};
		System.out.println(binaryS(num, 3));
	}	
	public static boolean binaryS(int[] arr, int target){
		int low = 0;
		int high = arr.length-1;
		
		while(low <= high){
			int mid = low + ((high - low) / 2);
			if(target < arr[mid])
				high = mid-1;
			else if(target > arr[mid])
				low = mid+1;
			else if(target == arr[mid]){
				return true;
			}				
		}
			return false;
	}
	/*//if recursively then int mid = low + (high-low)/2; //to prevent overflows
	"You may also wonder as to why mid is calculated using mid = lo + (hi-lo)/2 instead of the usual mid = (lo+hi)/2. "
	+ "This is to avoid another potential rounding bug: in the first case, we want the division to always round down, "
	+ "towards the lower bound. But division truncates, so when lo+hi would be negative, it would start rounding towards the higher bound."
	+ " Coding the calculation this way ensures that the number divided is always positive and hence always rounds as we want it to."
	+ " Although the bug doesn't surface when the search space consists only of positive integers or real numbers, "
	for (low+high)/2 ->
	* It fails for large values of l and r. Specifically, it fails if the sum of low and high is greater than the maximum positive int value (231 – 1). 
	* The sum overflows to a negative value, and the value stays negative when divided by two. */
}
