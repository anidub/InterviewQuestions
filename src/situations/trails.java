package situations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class trails {

	
	public static void main(String[] args){
		int[] A =  {1,2,3};			//{4,2,5,7,9};	
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);intList.add(2);intList.add(3);intList.add(4);
		powerSet(intList);
		colorful(123);
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
	
	public static int colorful(int A) {
	    HashSet<Integer> hashSet = new HashSet<Integer>();
	    ArrayList<Integer> numbers = new ArrayList<Integer>();
	    
	    while (A != 0) {
	        int num = A % 10;
	        numbers.add(num);
	        A /= 10;
	    }
	    
	    Collections.reverse(numbers);
	    int n = numbers.size();
	    
	    for (int i = 0; i < n; i++) {
	        for (int j = i; j < n; j++) {
	            int prod = 1;
	            StringBuilder ss = new StringBuilder();
	            for (int k = i; k <= j; k++) {
	            	
	            	 ss.append(numbers.get(k)+"");
	                prod *= numbers.get(k);
	            }            
	            hashSet.add(Integer.parseInt(ss.toString()));
	        }
	    }
	    
	    return 1;
	    
	}
}