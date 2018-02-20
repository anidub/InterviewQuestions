package InterviewBit;

public class StackandQueuesTrappingWater {
//https://www.interviewbit.com/problems/rain-water-trapped/	
//http://www.geeksforgeeks.org/trapping-rain-water/ TIME:O(N) space : O(N)	
/*Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
For example, given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.	*/
	public static void main(String[] args) {
		int[] arr = {3,0,0,2,0,4};
		System.out.println(trap(arr,arr.length));
	}
	public static int findWater(int arr[], int n){
// left[i] contains height of tallest bar to the left of i'th bar including itself
	    int[] left = new int[n];
	 
// Right [i] contains height of tallest bar to the right of ith bar including itself
	    int[] right = new int[n];
	 
	// Initialize result
	    int water = 0;
	 
	// Fill left array
	    left[0] = arr[0];
	    for (int i = 1; i < n; i++)
	       left[i] = Math.max(left[i-1], arr[i]);
	 
	    // Fill right array
	    right[n-1] = arr[n-1];
	    for (int i = n-2; i >= 0; i--)
	       right[i] = Math.max(right[i+1], arr[i]);
	 
// Calculate the accumulated water element by element consider the amount of water on i'th bar, the
//amount of water accumulated on this particular bar will be equal to min(left[i], right[i]) - arr[i] .
	    for (int i = 0; i < n; i++)
	       water += Math.min(left[i],right[i]) - arr[i];
	 
	    return water;
	}
	
	
	//studied
	public static int trap(int A[], int n) {
        int left = 0; int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;
        while(left <= right){
            if(A[left] <= A[right]){
                if(A[left] >= maxleft) maxleft = A[left];
                else res += maxleft-A[left];
                left++;
            }
            else{
                if(A[right] >= maxright) maxright = A[right];
                else res += maxright - A[right];
                right--;
            }
        }
        return res;
    }
	
}