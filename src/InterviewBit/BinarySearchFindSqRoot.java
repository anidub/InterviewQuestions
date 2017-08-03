package InterviewBit;

public class BinarySearchFindSqRoot {
/*	https://www.interviewbit.com/problems/square-root-of-integer/
		Compute and return the square root of x.
		If x is not a perfect square, return floor(sqrt(x))
			Input : 11	Output : 3*/
	public static void main(String[] args) {
		System.out.println(sqrt(11));
	}
	
	public static int sqrt(int num) {
		int low = 1, high = num;
		int mid; int root = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			if (mid * mid == num && (num % mid == 0))
				return mid;

			if (mid * mid <= num) {
				root = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return root;
	}
}
