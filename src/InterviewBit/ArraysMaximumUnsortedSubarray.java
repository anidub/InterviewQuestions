package InterviewBit;

import java.util.ArrayList;

public class ArraysMaximumUnsortedSubarray {
/*https://www.interviewbit.com/problems/maximum-unsorted-subarray/
http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.
Input 1:A = [1, 3, 2, 4, 5]	Return: [1, 2]
Input 2:A = [1, 2, 3, 4, 5]	Return: [-1] 
O(n)*/
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);array.add(3);array.add(2);array.add(5);array.add(4);
		array.add(6);
		
		subUnsort(array);
	}
	//very easy
	public static ArrayList<Integer> subUnsort(ArrayList<Integer> array) {
		int s = 0;int e = array.size()-1;
		int size = array.size();
		//find 1st element which breaks sorting order from front
		for(s = 0; s < size-1; s++){
			if(array.get(s) > array.get(s+1))
				break;
		}
		//if all elements sorted
		if(s == size-1){
			return new ArrayList<Integer>();
		}
		//find 1st element which breaks reverse sorting order from behind
		for(e = size-1; e > 0; e--){
			if(array.get(e) < array.get(e-1) )
				break;
		}
		int max = array.get(s);int min = array.get(s);
		//find max and min in between s and e
		for(int i = s+1; i <= e; i++){
			if(array.get(i) < min)
				min = array.get(i);
			
			if(array.get(i) > max)
				max = array.get(i);
		}
		//find 1st element which is greater than min
		for(int i = 0; i < s; i++){
			if(array.get(i) > min){
				s = i;
				break;
			}
		}
		//find 1st element which is less than max
		for(int i = size-1; i >= e+1; i--){
			if(array.get(i) < max){
				e = i;
				break;
			}
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(s);result.add(e);
		return result;		
    }	
	
}
