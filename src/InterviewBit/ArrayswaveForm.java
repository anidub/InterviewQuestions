package InterviewBit;

import java.util.Arrays;

public class ArrayswaveForm {
/*	https://www.interviewbit.com/problems/wave-array/
Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
Given [1, 2, 3, 4]
One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]*/
	public static void main(String[] args) {
		int[] arr = {2,4,5,6};
		wave(arr);
	}
	
	public static void wave(int[] arr){
		if(arr.length < 2) return;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length - 1; i += 2){
			swap(arr,i,i+1);
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
