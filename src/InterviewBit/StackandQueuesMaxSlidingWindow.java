package InterviewBit;

import java.util.LinkedList;
import java.util.Queue;
/*https://www.interviewbit.com/problems/sliding-window-max/
http://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/
https://github.com/ankit249/Algorithms/blob/master/src/com/ds/heap/SlidingWindowMaximum.java	
http://n00tc0d3r.blogspot.com/2013/04/sliding-window-maximum.html?view=sidebar
A long array A[] is given to you. There is a sliding window of size w which is moving from the 
very left of the array to the very right. You can only see the w numbers in the window.
 Each time the sliding window moves rightwards by one position.
Example :
The array is [1 3 -1 -3 5 3 6 7], and w is 3.
Window position	      Max 	 
[1 3 -1] -3 5 3 6 7	   3
1 [3 -1 -3] 5 3 6 7	   3
1 3 [-1 -3 5] 3 6 7	   5
1 3 -1 [-3 5 3] 6 7	   5
1 3 -1 -3 [5 3 6] 7	   6
1 3 -1 -3 5 [3 6 7]	   7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
https://www.youtube.com/watch?v=39grPZtywyQ	
*/public class StackandQueuesMaxSlidingWindow {
	public static void main(String[] args) {
		int[] A =  {1, 3, -1, -3, 5 ,3 ,6, 7};			//{4,2,5,7,9};		
		maxSlidingWindow(A,3);
	}

	public static int[] maxSlidingWindow(int[] arr, int w) {
		int l = arr.length;
		int[] result = new int[l + 1 - w];
		if (l == 1) {
			result[0] = arr[0];
			return result;
		}
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < l; i++) {
		     if(!deque.isEmpty() && deque.peekFirst() == i - w){
		    	 System.out.println(deque.peekFirst());
		    	 deque.poll();
		     }
		 
		        while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]){
		            deque.removeLast();
		        }    
		 
		        deque.offer(i);
		 
		        if(i + 1 >= w)
		            result[i + 1 - w]= arr[deque.peek()];
		}
		return result;
	}
}