
package InterviewBit;

public class ArraysfindMaxDiff {
/*http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
https://www.interviewbit.com/problems/maximum-consecutive-gap/
http://stackoverflow.com/questions/18281625/find-the-max-difference-between-j-and-i-indices-such-that-j-i-and-aj-ai
https://www.youtube.com/watch?v=_3sCTc9BzoY
Given an array arr[], find the maximum j – i such that arr[j] > arr[i].Time Complexity: O(n)*/
	public static int maxGap(int[] arr){ //O(N2)
		if(arr.length < 2) return -1;
		int maxDiff = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = arr.length - 1; j > i; j--){
				if(arr[i] < arr[j] && maxDiff < j-i)
					maxDiff = j-i;
			}
		}
		return maxDiff;
	}
	
	public static int findMaxGap(int[] arr){ //O(N) //can ask nilesh
		int maxDiff,i,j;
		int l = arr.length;
		int[] lMin = new int[l];
		int[] rMax = new int[l];
		
		
		lMin[0] = arr[0];
		rMax[l-1] = arr[l-1];
 /* Construct LMin[] such that LMin[i] stores the minimum value from (arr[0], arr[1], ... arr[i]) */		
		for(i = 1; i < l; i++){
			lMin[i] = Math.min(arr[i],lMin[i-1]);
		}
/* Construct RMax[] such that RMax[j] stores the maximum value from (arr[j], arr[j+1], ..arr[n-1]) */	
		for(j = l-2; j >= 0; j--){
			rMax[j] = Math.max(arr[j],rMax[j+1]);
		}
		  /* Traverse both arrays from left to right to find optimum j - i*/
		i = 0; j = 0;maxDiff=0;
		while(i < l && j < l){
			if(lMin[i] < rMax[j]){
				maxDiff = Math.max(maxDiff,j-i);
				j = j+1;
			}else
				i = i+1;
		}
		return maxDiff;			
	}
	
	public static void main(String[] args) {
		int[] arr= {34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println(findMaxGap(arr));
	}
}
