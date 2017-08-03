package numbers2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
//Given an array and a number x, find if there is a pair with product equal to x.//
//Examples :
//Input : arr[] = {10, 20, 9, 40};
//        int x = 400;
//Output : Yes

public class findpairforproduct {

	public static void main(String[] args) {
		int[] num = {10,9,20,40};
		int x = 800;
		System.out.println(find(num,x));
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(9);
		numbers.add(20);
		numbers.add(11);
		ArrayList<Integer> result = oddeven(numbers);
		for(int i = 0; i<result.size(); i++){
			System.out.print
			(result.get(i) + " ");
		}
	}
	
	public static boolean find(int[] num, int x){
		if(num.length == 0) return false;
		int l = num.length;
		if(l < 2 && num[0] == x) return true;
		Set<Integer> numset = new HashSet<Integer>();
		for(int i = 0; i < l; i++){
			if(x % num[i] == 0){
				if(numset.contains(x/num[i])) return true;
				else numset.add(num[i]);
			}
		}
		return false;
	}
	
	// given a list of integers print odd first then even
	public static ArrayList<Integer> oddeven(ArrayList<Integer> num){
		if(num == null || num.size() == 0 || num.size() == 1) return num;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < num.size(); i++){
			if(num.get(i) % 2 != 0)
				result.add(num.get(i));
		}
		for(int i = 0; i < num.size(); i++){
			if(num.get(i) % 2 == 0)
				result.add(num.get(i));
		}
		
		return result;
		//works --single iteraion
	/*	int[] array = new int[arr.size()];
		int low = 0;
		int high = arr.size()-1; int k = 0;
		while(low <= high){
			int i = arr.get(k);k++;
			if(i % 2 != 0){ 
				array[low] = i;low++;
			}else{
				array[high] = i; high--;
			}
		}
		for(int i : array){
			System.out.println(" " + i);
		}*/
	}
}
