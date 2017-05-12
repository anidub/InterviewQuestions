package InterviewBit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Hashing4Sum {
/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:
(-2, -1, 1, 2)
(-2,  0, 0, 2)
(-1,  0, 0, 1)//O(n2)
https://www.interviewbit.com/problems/4-sum/
*/	public static void main(String[] args) {
		int[] arr = {1, 0, -1, 0, -2, 2};
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(1);num.add(0);num.add(-1);num.add(0);num.add(-2);
		num.add(2);		
		fourSum(num,0);
	}
	
	public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int target) {
		Collections.sort(A);
	    Integer[] num = new Integer[A.size()];
	    num = A.toArray(num);
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = 0; i < num.length-3; i++) {
			for (int j = i + 1; j < num.length-2; j++) {
				int k = j + 1;
				int l = num.length - 1;
	 
				while (k < l) {
					int sum = num[i] + num[j] + num[k] + num[l];
	 
					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						temp.add(num[l]);	 
						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}	 
						k++;
						l--;
					}
				}
			}
		}	 
		return result;
	}
}
