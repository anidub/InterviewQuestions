package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashingAnagrams {
/*Given an array of strings, return all groups of strings that are anagrams. 
Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.
Input : cat dog god tca
Output : [[1, 4], [2, 3]]*/

	public static void main(String[] args) {//cat dog god tca
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("cat");temp.add("dog");temp.add("god");temp.add("tca");
		String[] words = {"cat","dog","god","tca","anish"};
		anagrams((words));

	}
	//if you want words// works
	  public static List<String> anagrams(String[] strs) {
	        List<String> result = new ArrayList<String>();
	        if (strs == null || strs.length == 0) {
	            return result;
	        }	         
	        Map<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();	         
	        for (int i = 0; i < strs.length; i++) {
	            char[] word = strs[i].toCharArray();
	             
	            Arrays.sort(word);
	            String key = new String(word);
	             
	            if (hashMap.containsKey(key)) {
	                hashMap.get(key).add(strs[i]);
	            } else {
	                ArrayList<String> value = new ArrayList<String>();
	                value.add(strs[i]);
	                hashMap.put(key, value);
	            }
	        }
	         
	        // dump the anagrams to the result list
	        Set<String> keySet = hashMap.keySet();
	         
	        for (String key : keySet) {
	            List<String> temp = hashMap.get(key);
	            if (temp.size() > 1) {
	                result.addAll(temp);
	            }
	        }	         
	        return result;
	    }
  //if you want indices//works
/*	  public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {		    
		    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		    HashMap<String, ArrayList<Integer>> hashMap = new HashMap<String, ArrayList<Integer>>();
		    int i = 1;		    
		    for (String str : A) {		        
		        char [] array = str.toCharArray();
		        Arrays.sort(array);
		        String sorted = new String(array);
		        
		        if (hashMap.containsKey(sorted)) {
		            ArrayList<Integer> list = hashMap.get(sorted);
		            list.add(i);
		        } else {
		            ArrayList<Integer> list = new ArrayList<Integer>();
		            list.add(i);
		            hashMap.put(sorted, list);
		        }		        
		        i++;		        
		    }		    
		    for (Map.Entry<String, ArrayList<Integer>> entrySet : hashMap.entrySet()) {
		        res.add(entrySet.getValue());
		    }		    
		    return res;		    
		}*/
}
