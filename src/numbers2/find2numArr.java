package numbers2;

import java.util.ArrayList;
import java.util.HashSet;

public class find2numArr {
/*
 * find two numbers in an array whose sum is also in the array
 */
	public static void main(String[] args) {
	int[] arr = {0,2,67,5,3};
	ArrayList<Integer> result = twoSum(arr);
	if(!result.isEmpty()){
		int a = result.get(0); int b = result.get(1);
		System.out.println(a + " + " + b + " = " + (a+b));
	}

	}
	
	public static ArrayList<Integer> twoSum(int[] arr){
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i : arr){
			set.add(i);
		}
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				int sum = arr[i] + arr[j];
				if(arr[i] == arr[j]) continue;
				if(set.contains(sum) && sum != arr[i] && sum != arr[j]){
					result.add(arr[i]); result.add(arr[j]);
					return result;
				}
			}
		}
		return result;
	}
}