package InterviewBit;

public class BinarySearchfindIndex {
//Binary Search	
//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//[1,3,5,6], 2 -> 1; [1,3,5,6], 5 -> 2	//O(logn)
public static void main(String[] args) {
		int[] arr = {1,3,5,6}; 
		int t = 4;
		System.out.println(search(arr, t));
	}
	
	public static int search(int[] num, int target) {
		if (num.length == 0)
			return -1;
		int low = 0;
		int result = -1;
		int high = num.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == num[mid]) {
				result = mid;
				break;
			}
			if (target > num[mid])
				low = mid + 1;
			else if (target < num[mid])
				high = mid - 1;
		}
		if (result == -1)
			result = low;
		return result;
	}
}
