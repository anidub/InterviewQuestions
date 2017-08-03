package situations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class trails {	
	public static void main(String[] args){
		int[] A =  {1,2,3};			//{4,2,5,7,9};	
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);intList.add(2);intList.add(3);intList.add(4);
		buildDictionary();
		//powerSet(intList);
	}
	
	public static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> intList) {

	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    result.add(new ArrayList<Integer>());

	    for (int i : intList) {
	        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

	        for (ArrayList<Integer> innerList : result) {
	            innerList = new ArrayList<Integer>(innerList);
	            innerList.add(i);
	            temp.add(innerList);
	        }
	        result.addAll(temp);
	    }
	    return result;
	}	 
	
	public static void buildDictionary(){
		HashMap<Character, ArrayList<String>> map = new HashMap<Character, ArrayList<String>>();
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("hello");arr.add("dello");arr.add("yello");arr.add("ye");
		
		for(String s : arr){
			for(Character c : s.toCharArray()){
				ArrayList<String> temp;
				if(map.containsKey(c)){
					temp = map.get(c);
				}else{
					 temp = new ArrayList<String>();
				}
				temp.add(s);
				map.put(c, temp);
			}
		}
		
		String chars = "del";
		ArrayList<String> result = new ArrayList<String>();
		HashSet<String> res1 = new HashSet<String>();
		for(Character c : chars.toCharArray()){
			if(map.containsKey(c)){
				ArrayList<String> arr1 = map.get(c);
				for(String s1 : arr1){
					if(s1.indexOf(chars) != -1){
						result.add(s1);
						res1.add(s1);
					}
				}
			}
		}
		
		for(String s : res1){
			System.out.println(s);
		}
		
	}
	
	
}