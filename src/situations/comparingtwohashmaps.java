package situations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class comparingtwohashmaps {

	public static void main(String[] args) {
		HashMap<String, Integer> hm1 = new HashMap<String,Integer>();
		hm1.put("A", 2);
		hm1.put("B", 3);
		hm1.put("C", 4);
		
		HashMap<String, Integer> hm2 = new HashMap<String,Integer>();
		hm2.put("A", 2);
		hm2.put("B", 3);
		hm2.put("C", 4);
		hm2.put("D", 4);
		
		System.out.println(areMapsEqual(hm1, hm2));
		iterateoverHashmap(hm1);
		arraylistofarrays();
		}
	
	public static boolean areMapsEqual(HashMap hm1, HashMap hm2){
		if(hm1.size() != hm2.size()) return false;
		  for (Object k : hm2.keySet()) {
			  if (hm1.get(k) != hm2.get(k)) {
	                return false;
	            }

		    }
		    for (Object y : hm1.keySet()) {
		    	 if (!hm2.containsKey(y)) {
		                return false;
		            }

		    }
		return true;	
	}

	public static void iterateoverHashmap(HashMap hm1){
		Iterator it = hm1.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " " + pair.getValue());
			it.remove();
		}
	}
	
	//ArrayList of Arrays
	
	public static void arraylistofarrays(){
		ArrayList<int[]> listofarrays = new ArrayList<int[]>();
		int[] a = {1,2,3};
		int[] b = {3,4,5,6};
		int[] c = {5,6,7,9};
		listofarrays.add(a);listofarrays.add(b);listofarrays.add(c);
		
		for(int i = 0; i < listofarrays.size(); i++){
			for(int j = 0; j < listofarrays.get(i).length; j++){
				System.out.print(" " + listofarrays.get(i)[j]);

			}
		}
	}
}
