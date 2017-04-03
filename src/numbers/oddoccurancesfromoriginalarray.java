package numbers;

import java.util.HashMap;
import java.util.Map.Entry;

public class oddoccurancesfromoriginalarray {

	//Given an unsorted array of integers, 
	//output an array containing the numbers in the original array that appear an odd number of times.
	//What is the runtime of your process?
		
	public static void main(String[] args) {
		int[] original = { 1,3,5,4,6,2,10,3,6,2,3 };
		int[] output = {};
		HashMap<Integer,Integer> nummap = new HashMap<Integer,Integer>();
		/*
		for(int i = 0; i < original.length; i++){
			if(nummap.containsKey(original[i])){
				nummap.put(original[i], nummap.get(original[i]) + 1);
			}else{
				nummap.put(original[i], 1);
			}
		}
		System.out.println(nummap);
		
		for (Entry<Integer, Integer> entry : nummap.entrySet()) {
		    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			if(entry.getValue() % 2 == 1){
				//System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
				System.out.println("The numbers are  = " + entry.getKey() );
			}
		}*/
		
		for(int i = 0; i < original.length; i++){
			if(nummap.containsKey(original[i])){
				nummap.put(original[i], nummap.get(original[i]) + 1);
			}else{
				nummap.put(original[i],1);
			}
		}
		System.out.println(nummap);
		for(Entry<Integer, Integer> entry : nummap.entrySet()){
			if(entry.getValue() % 2 == 1){
				System.out.println("The numbers are : " + entry.getKey());
			}
		}
		

	}

}
