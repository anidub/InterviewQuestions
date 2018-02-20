package InterviewBit;

public class findSqRoot {
//binary search
	//Compute and return the square root of x.
	//https://www.interviewbit.com/problems/square-root-of-integer/
//If x is not a perfect square, return floor(sqrt(x))//O(logn)

	public static void main(String[] args) {
		System.out.println(findRoot(72));
		}
	public static int findRoot(int num){
		if(num == 1) return num;
		int low = 1; int high = num;
		int root = -1; int mid;
		while(low <= high){
			mid = (high+low)/2;
			if(mid * mid == num && num % mid == 0){
				return mid;
			}
			if(mid * mid <= num){
				low = mid+1;
				root = mid;
			}
			if(mid * mid >= num) high = mid-1;
		}
		return root;
	}
}
