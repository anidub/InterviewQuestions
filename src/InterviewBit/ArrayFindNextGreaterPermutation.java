package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayFindNextGreaterPermutation {
/*//https://www.interviewbit.com/problems/next-permutation/
	Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.
	If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.
	The replacement must be in-place, do not allocate extra memory.
	This question can also be asked as find next greater number with same digits
	1,2,3 -> 1,3,2
	3,2,1 -> 1,2,3
	1,1,5 -> 1,5,1
	20, 50, 113 -> 20, 113, 50*/
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
	//	array.add(769);array.add(533);
		array.add(3);array.add(2);array.add(1);
		nextPermutation(array);
	}

	public static void nextPermutation(ArrayList<Integer> array) {
		if (array == null || array.size() == 1)
			return;
		int i = 0;
		int j = 0;
		int lastDigit = array.get(array.size() - 1);
		for (i = array.size() - 2; i >= 0; i--) {
			if (lastDigit > array.get(i)) {
				break;
			}
			lastDigit = array.get(i);
		}
		if (i >= 0) {
			for (j = array.size() - 1; j > i; j--) {
				if (array.get(j) > array.get(i))
					break;
			}
			swap(array, i, j);
			sort(array, i + 1, array.size()-1);
		} else {
			 Collections.sort(array);
		}
	}
	public static void sort(ArrayList<Integer> array, int i, int j){
		if(i > j) return;
		swap(array,i,j);
		i++;
		j--;
	}	
	
	public static void swap(ArrayList<Integer> array, int i, int j){
		int temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}
}
