package InterviewBit;

public class BinarySearchMedianSortedArrays {
/*http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
https://github.com/nagajyothi/InterviewBit/blob/master/BinarySearch/MedianOfTwoSortedArrays.java
https://www.interviewbit.com/problems/median-of-array/
There are two sorted arrays A and B of size m and n respectively.
Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
The overall run time complexity should be O(log (m+n)).
A : [1 4 5] B : [2 3] o/p:3*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findMedian(int[] num1, int[] num2){
		int totalLength = num1.length + num2.length;
		if(totalLength % 2 == 0){
			return (findKth(totalLength/2+1,num1,num2,0,0) + findKth(totalLength/2, num1, num2,0,0)/2);
		}else
			return findKth(totalLength/2,num1, num2, 0, 0);
	}
	
	public static int findKth(int k, int[] num1, int[] num2, int start1, int start2){
		if(start1 >= num1.length)
			return num2[start2 + k-1];
		if(start2 >= num2.length)
			return num1[start1 + k-1];
		
		if(k == 1) return Math.min(num1[start1], num2[start2]);
		
		int m1 = start1 + k/2 - 1;
		int m2 = start2 + k/2 - 1;
		
		int mid1 = m1 < num1.length ? num1[m1] : Integer.MAX_VALUE;
		int mid2 = m2 < num2.length ? num2[m2] : Integer.MAX_VALUE;
		
		if(mid1 < mid2){
			return findKth(k-k/2, num1, num2, m1+1, start2);
		}else
			return findKth(k-k/2, num1, num2, start1, m2+1);
	}

}
