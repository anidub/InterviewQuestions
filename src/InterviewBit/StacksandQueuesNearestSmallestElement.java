package InterviewBit;

import java.util.ArrayList;
import java.util.Stack;
/*http://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
https://www.interviewbit.com/problems/nearest-smaller-element/
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
Input : A : [4, 5, 2, 10]
Return : [-1, 4, -1, 2]
O(n) */
public class StacksandQueuesNearestSmallestElement {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(4);arr.add(5);arr.add(2);arr.add(10);arr.add(7);
		ArrayList<Integer> result = findNearestSmallestElement(arr);
	}
	
	public static ArrayList<Integer> findNearestSmallestElement(ArrayList<Integer> arr){
		if(arr == null || arr.isEmpty()) return arr;
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < arr.size(); i++){
//Keep removing top element from S while the top element is greater than or equal to arr[i]			
			while(!st.isEmpty() && st.peek() >= arr.get(i))
				st.pop();
// If all elements in S were greater than arr[i]			
			if(st.isEmpty()){
				result.add(-1);
//Else print the nearest smaller element				
			}else if(st.peek() < arr.get(i))
				result.add(st.peek());
// Push this element			
			st.push(arr.get(i));
		}
		return result;
	}
}
