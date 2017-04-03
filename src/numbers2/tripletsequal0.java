package numbers2;

import java.util.Arrays;
import java.util.HashMap;

public class tripletsequal0 {
//Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. 
	//If there is such a triplet present in array, then print the triplet and return true. Else return false. 
	//		For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, 
	//then there is a triplet (12, 3 and 9) present in array whose sum is 24.
	
	///http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
	//Time Complexity: O(n^2)
	public static void main(String[] args) {
		int[] array = {1, 4, 45, 6, 10, 8};
		int sum = 22;
		find3numbers(array, sum);
		
		//findhashmap(array,sum);

	}
	
	public static void find3numbers(int[] array, int sum){
		if(array.length == 0) return;
		Arrays.sort(array);
		for(int i = 0; i < array.length - 2; i++){
			int l = i + 1;
			int r = array.length - 1;
			while(l < r){
				if(array[i] + array[l] + array[r] == sum){
					System.out.println(array[i] + " " + array[l] + " " +  array[r]);
					break;
				}else if (array[i] + array[l] + array[r] < sum){
					l++;
				}else //array[i] + array[l] + array[r] > sum
					r--;
			}
		}
		//System.out.println("cannot found");
		
	}
	
	public static void findhashmap(int[] array, int sum){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i = 0; i < array.length - 1; i++){
			hm.put(array[i], 1);
		}
		int count = 3;
		for(int i = 0; i < array.length - 1; i++){
			for(int j = i + 1; j < array.length - 1; j++){
				int n = sum - array[i] + array[j];
				if(hm.containsKey(n)){
					if(n == array[i] || n == array[j]){
						continue;
					}
					if(count%3 == 0){
						System.out.println(array[i] + " " + array[j] + " " + n);
						count++;
					}
					
				}
			}
		}
	}
}
