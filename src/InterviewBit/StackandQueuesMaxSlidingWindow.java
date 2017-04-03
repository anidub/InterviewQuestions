package InterviewBit;

import java.util.LinkedList;
/*https://www.interviewbit.com/problems/sliding-window-max/
http://www.shuati123.com/blog/2014/07/27/Sliding-Window-Maximum/
http://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/
https://github.com/ankit249/Algorithms/blob/master/src/com/ds/heap/SlidingWindowMaximum.java	
http://n00tc0d3r.blogspot.com/2013/04/sliding-window-maximum.html?view=sidebar
https://www.youtube.com/watch?v=39grPZtywyQ	
*/public class StackandQueuesMaxSlidingWindow {
	public static void main(String[] args) {
		int[] A =  {1, 3, -1, -3, 5 ,3 ,6, 7};			//{4,2,5,7,9};		
		maxSlidingWindow(A,3);
	}
public static int[] maxSlidingWindow(int[] arr,int w){
		int l = arr.length;
		int[] result = new int[l-w+1];
		
		LinkedList<Integer> deQueue = new LinkedList<Integer>();
		for(int i = 0; i < l; i++){
			if(!deQueue.isEmpty() && deQueue.get(0) + w <= i)
				deQueue.remove(0);
			
			if(!deQueue.isEmpty() && arr[deQueue.size() - 1] <= arr[i])
				deQueue.remove(deQueue.size()-1);
			
			deQueue.add(arr[i]);
			
			if(i + 1 >= w )
				result[i+1-w] = arr[deQueue.get(0)];
		}
		return result;
	}
}
