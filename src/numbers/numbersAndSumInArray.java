package numbers;

import java.util.HashMap;

public class numbersAndSumInArray {
/*
 * program to find two elements which sum to a particular number
 * which is also in the same array
 * Eg: [1,2,3,4,5] -> 1+2 = 3
 * 2+3 -> 5
 * ordering does not matter in permutation
 * ordering does not matter mean : 1,2 -> 3 and 2,1 -> 3 anyone will come of these two
 * http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 */

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,1,2};
		findElements(array);
		System.out.println(count);

	}
	static int count = 0;
	public static void findElements(int[] array){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < array.length; i++){
			map.put(array[i], map.getOrDefault(array[i], 0) + 1);
		}
		int pair = 2;
		int[] data = new int[pair];
		getElements(array, map, 0, array.length-1, 0,pair, data);
	}
	
	public static void getElements(int[] array, HashMap<Integer, Integer> map, int index, int length, int i, int pair, int[] data){		if(i >= length) return;
		count++;
		if(index == pair){
			int sum = 0;
			for(int k : data){
				sum += k;
			}
			
			if(map.containsKey(sum)){
				System.out.println("elements : " + data[0] + " + " + data[1] + " = " + sum);
			}
			return;
		}
		
		data[index] = array[i];
		getElements(array, map, index+1, length, i+1, pair, data); // the one which is goona be array mein ghumne wala like j loop in iterative sense
	/*	while (array[i] == array[i+1]) for no duplicates
            i++;*/ 
		getElements(array, map, index, length, i+1, pair, data);//like i loop in iterative sense
}
}