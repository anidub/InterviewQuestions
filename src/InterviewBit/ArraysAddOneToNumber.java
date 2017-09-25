package InterviewBit;

import java.util.ArrayList;

public class ArraysAddOneToNumber {
/*https://www.interviewbit.com/problems/add-one-to-number/
 * If the vector has [1, 2, 3] the returned vector should be [1, 2, 4]
as 123 + 1 = 124.*/
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(2);array.add(5);array.add(6);array.add(8);array.add(6);array.add(1);
		array.add(2);array.add(4);array.add(5);
		plusOne(array);addone(array);
	}
	public static ArrayList<Integer> plusOne(ArrayList<Integer> array) {
		if(array.isEmpty()) return array;
		ArrayList<Integer> result = new ArrayList<Integer>();
		long k = 1;
		long number = 0;
		for(int i = array.size()-1; i >= 0; i--){
			long n = array.get(i);
			n = k * n;
			number += n ;
			k = k * 10;
		}
		System.out.println(number);
		number =  number+1;
		String num = String.valueOf(number);
		for(int i = num.length()-1; i >= 0; i--){
			result.add(0,Integer.parseInt(num.charAt(i)+""));
		}
		return result;
	}
	
	public static ArrayList<Integer> addone(ArrayList<Integer> arr){
		int num = 0;
		int factor = 1;
		for(int k = arr.size() - 1; k >=0; k--){
			int i = arr.get(k);
			i = i * factor;
			num += i;
			factor = factor * 10;
		}
		System.out.println(num);
		num++;
		String n = String.valueOf(num);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < n.length(); i++){
			res.add(0,n.charAt(i)-'0');
		}
		return res;
	}
}