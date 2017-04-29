package numbers2;

import java.util.ArrayList;
import java.util.HashSet;
/*//http://www.geeksforgeeks.org/check-exist-two-elements-array-whose-sum-equal-sum-rest-array/
Check if there exist two elements in an array whose sum is equal to the sum of rest of the array
//O(n).
*/public class findTwoNumberInArraySumRest {

	public static void main(String[] args) {
		int[] arr = {2, 11, 5, 1, 4, 7};
		ArrayList<Integer> result = sum(arr);
		if(!result.isEmpty())
		System.out.println("Numbers : " + result.get(0) + " + " + result.get(1));

	}

	public static ArrayList<Integer> sum(int[] arr){
		int sum = 0;
		int sum1 = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i : arr){
			sum += i;
		}
		if (sum%2 != 0)
	        return result;
		sum1 = sum/2;
		return result = findTwoNum(arr, sum1);
	}
	
	public static ArrayList<Integer> findTwoNum(int[] arr, int sum){
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++){
			int k = sum - arr[i];
			if(set.contains(k)){
				result.add(arr[i]);
				result.add(k);
			}				
			set.add(arr[i]);
		}
		return result;
	}	
}
