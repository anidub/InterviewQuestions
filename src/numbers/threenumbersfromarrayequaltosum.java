package numbers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class threenumbersfromarrayequaltosum {

	//Assume we have three arrays of length N which contain arbitrary numbers of type long. 
	//Then we are given a number M (of the same type) and our mission is to pick three numbers A, B and C 
	//one from each array (in other words A should be picked from first array, B from second one and C from third)
	//so the sum A + B + C = M.
	
	public static void main(String[] args) {
		int[] array1 = {1,2,3,4};
		int[] array2 = {2,3,4,5};
		int[] array3 = {3,4,5,6};
		int k = 8;
		HashMap<Integer, Integer> nummap = new HashMap<Integer,Integer>();
		
		for(int i  = 0; i < array3.length; i++){
			nummap.put(array3[i], 1);
		}
		
		
		
		for(int i = 0; i < array1.length; i++){
			for(int j = 0; j < array2.length; j++){
				int sum = array1[i] + array2[j];
				if(nummap.containsKey(k -  sum)){
					int m = k - sum;
					System.out.println("The values are : " + array1[i] + " + " + array2[j] + " + " + m );
					break;
					
				}
			}
		}
		
		
	}

}
