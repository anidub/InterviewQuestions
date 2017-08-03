package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashingDiff {
/*https://www.interviewbit.com/problems/diffk-ii/
Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
A : [1 5 3] ,k : 2
equations::  i - j = k which is equal to  i = k + j(1) && j = i - k; (2)
*/
	public static void main(String[] args) {//O(n)
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(95);arr.add(3);arr.add(52);arr.add(51);arr.add(63);
		System.out.println(diffPossible(arr, 60));
	}
	public static int diffPossible(final List<Integer> A, int B) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int num : A) {
			if (hashMap.containsKey(num)) {
				hashMap.put(num, hashMap.get(num)+1);
			} else {
				hashMap.put(num, 1);
			}
		}
		for (int num : A) {
			int n = B + num; // (1) check above for derivation
			if (hashMap.containsKey(n)) {
				if (hashMap.get(n) > 1 || num != n)
					return 1;
			}
			n = num - B; // (2) check above for derivation
			if (hashMap.containsKey(n)) {
				if (hashMap.get(n) > 1 || num != n)
					return 1;
			}
		}
		return 0;
	}
}
