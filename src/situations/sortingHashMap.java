package situations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;

public class sortingHashMap {
	// sort a hashmap
	// take out the keys / values , put them in a tree set , sort them and put back in linkedhashmap
	//https://stackoverflow.com/questions/780541/how-to-sort-a-hashmap-in-java

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("hello", "H");
		hm.put("abc", "J");
		hm.put("www", "x");
		hm.put("aaa", "s");
		for(String s : hm.keySet()){
			System.out.println(s);
		}
		sortHM(hm);
	}
	
	public static void sortHM(HashMap<String, String> hm){
		Set<String> sortedKeys = new TreeSet<String>(hm.keySet());
		System.out.println();
		
		LinkedHashMap<String, String> lm= new LinkedHashMap<String,String>();
		
		for(String s : sortedKeys){
			lm.put(s, hm.get(s));
		}
		
		for(String s : lm.keySet()){
			System.out.println(s);
		}
		
	}

}
