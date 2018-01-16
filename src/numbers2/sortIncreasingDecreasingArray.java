package numbers2;

import java.util.ArrayList;

/*
 * Given an array of integers that consists of two parts, one part descending and one part ascending, sort the array from least to greatest.
 * IDEA: Use binary search to find the increasing point in the array and then just rotate them from that point.
 * TC: O(n)
 * https://www.glassdoor.com/Interview/engineer-bloomberg-lp-interview-questions-SRCH_KO0,8_KE9,21_SDRD.htm
 */
public class sortIncreasingDecreasingArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,9,8,7,6};
		sort(arr);
	}

	public static ArrayList<Integer> sort(int[] arr){
		ArrayList<Integer> result = new ArrayList<Integer>();
		int pivot = 0;
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			int mid = low + (high - low)/2;
			if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
				pivot = mid;
				break;
			}else if(arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1]){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		int i = 0;
		while(i < pivot){
			result.add(arr[i]);
			i++;
		}
		i = arr.length-1;
		while(i >= pivot){
			result.add(arr[i]);
			i--;
		}
		for(int j : result){
			System.out.print(j + " ");
		}
		return result;
	}
}
