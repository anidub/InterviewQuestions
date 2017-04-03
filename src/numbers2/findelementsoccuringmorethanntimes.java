package numbers2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class findelementsoccuringmorethanntimes {
//Given an array of of size n and a number k, find all elements that appear more than n/k times
	//Given an array of size n, find all elements in array that appear more than n/k times. 
	//For example, if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3].
	//time : o(n) space higher than o(k)
	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
		int k = 4;
			ArrayList<Integer> output = find(arr,k);
		for(int i : output){
			System.out.println(i);
		}
	}	
		public static ArrayList<Integer> find(int[] arr, int k){
			if(arr.length == 0) return null;
			ArrayList<Integer> output = new ArrayList<Integer>();
			
			HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
			for(int i = 0; i < arr.length; i++){
				if(hmap.containsKey(arr[i])){
					hmap.put(arr[i], hmap.get(arr[i])+1);
				}
				else
					hmap.put(arr[i],1);
			}
			int t = arr.length/k;
			int c = 0;
			for(Entry<Integer, Integer> entry : hmap.entrySet()){
				if(entry.getValue() > t){
					output.add(entry.getKey());
				}
			}
			return output;	
		}		
	}


