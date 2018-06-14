	package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Hashing4Sum {
/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:
(-2, -1, 1, 2)
(-2,  0, 0, 2)
(-1,  0, 0, 1)//O(n3)
https://www.interviewbit.com/problems/4-sum/
*/	public static void main(String[] args) {
		int[] arr = {1, 0, -1, 0, -2, 2};
		ArrayList<Integer> num = new ArrayList<Integer>();
		//num.add(1);num.add(0);num.add(-1);num.add(0);num.add(-2);num.add(2);
		num.add(10);num.add(20);num.add(30);num.add(40);num.add(1);num.add(2);//10, 20, 30, 40, 1, 2
		fourSumBetter(num,91);
	}

//O(N2)//use this!!!
	public static ArrayList<Integer> fourSumBetter(ArrayList<Integer> arr, int target) {
		//Collections.sort(A);
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    HashMap<Integer, pair> map = new HashMap<Integer, pair>();
	    for(int i = 0; i < arr.size(); i++){
	    	for(int j = i + 1; j < arr.size(); j++){
	    		int sum = arr.get(i) + arr.get(j);
	    		map.put(sum, new pair(arr.get(i), arr.get(j)));
	    	}
	    }
	    
	    for(int i = 0; i < arr.size(); i++){
	    	for(int j = i+1; j < arr.size(); j++){
	    		int currentsum = arr.get(i) + arr.get(j);
	    		if(map.containsKey(target - currentsum)){
	    			pair pair = map.get(target- currentsum);
	    			if(pair.x != arr.get(i) && pair.y != arr.get(j)
	    					&& pair.x != arr.get(j) && pair.y != arr.get(i)){
	    				result.add(pair.x);
	    				result.add(pair.y);
	    				result.add(arr.get(i));
	    				result.add(arr.get(j));
	    				System.out.println(result);
	    				return result;
	    			}
	    		}
	    	}
	    }
		return result;
	}
	
	static class pair{
		int x;
		int y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;
		}
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
