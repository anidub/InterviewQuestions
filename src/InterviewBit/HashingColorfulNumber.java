package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class HashingColorfulNumber {
/*	For Given Number N find if its COLORFUL number or not
	A number can be broken into different contiguous sub-subsequence parts. 
	Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
	And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
	https://www.interviewbit.com/problems/colorful-number/ //O(n2)
	https://www.careercup.com/question?id=4863869499473920
	N = 23
	2 3 23
	2 -> 2
	3 -> 3
	23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 
Output : 1	
*/	public static void main(String[] args) {
		System.out.println(checkIfColorful(23));
	}
	
	public static boolean checkIfColorful(int num){
		if(num < 10) return true;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		while(num > 0){
			int temp = num%10;
			numbers.add(temp);
			num = num/10;
		}
		TreeSet<Integer> subSets = new TreeSet<Integer>();
		for(int i = 0; i < numbers.size(); i++){
			for(int j = i; j < numbers.size(); j++){
				int product = 1;
				for(int k = i; k <= j; k++){
					product = product * numbers.get(k);
				}
				boolean add = subSets.add(product);
				if(!add) return false;
			}
		}
			System.out.println(subSets);
			return true;
	}
}