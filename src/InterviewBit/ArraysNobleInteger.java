package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

public class ArraysNobleInteger {
	/*https://www.interviewbit.com/problems/noble-integer/
	Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
	If such an integer is found return 1 else return -1.O(nlogn)*/
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(5);array.add(6);array.add(2);
		System.out.println(findNobleInt(array));
	}

	public static int findNobleInt(ArrayList<Integer> array) {
		Collections.sort(array);
		int size = array.size();
		for (int i = 0; i < size; i++) {
			int c = array.get(i);
			while (i + 1 < size && array.get(i) <= array.get(i + 1)) {
				i++;
			}
			if (c == i)
				return 1;
		}
		return -1;
	}
}
