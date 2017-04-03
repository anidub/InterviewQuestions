package numbers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class displayintegeroddtimes {
//) Write a function which accepts an integer and returns the one integer that occurs an odd number of times.  
	public static void main(String[] args) {
		//int[] array = {1,2,3,2,1};
		int[] array = {1,2,1};
		
		int num = 0;
		for(int i = 0; i < array.length; i++){
			num = num ^ array[i];
	}
		
		
		
		//find interger even number of times
		HashMap<Integer, Integer> nummap = new HashMap<Integer,Integer>();
		for(int i = 0; i < array.length; i++){
			if(nummap.containsKey(array[i]))
				nummap.put(array[i], nummap.get(array[i]) + 1);
		else
			nummap.put(array[i], 1);
	}
	
		
		Iterator<Entry<Integer,Integer>> it = nummap.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>)it.next();
			if(pair.getValue() % 2 == 0){
				System.out.println(pair.getKey());
			}
		}
		
		//System.out.println(num);
	}

}
