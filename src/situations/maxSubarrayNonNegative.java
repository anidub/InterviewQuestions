package situations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class maxSubarrayNonNegative {
	//https://www.hackerrank.com/challenges/maxsubarray
//	/https://www.quora.com/How-can-I-get-the-maximum-sum-subarray-for-only-non-negative-subarrays
	//https://www.interviewbit.com/problems/max-non-negative-subarray/
	//O(n)

	public static void main(String[] args) {
		int[] arr = {-1, -2, 5, 7, -2, -3};
		int[] result = maxContiguous(arr);
	}
	
	public static int[] maxContiguous(int[] source){
		int curStart = 0,maxStart = 0,maxSum = 0,curSum = 0,curLength = 0,maxLength = 0;
		
		for(int index = 0;  index < source.length; index++){
			if(source[index] < 0){
				if(curSum >= maxSum && curLength > maxLength){
					maxSum = curSum;
					maxStart = curStart;
					maxLength = curLength;
				}	
					curLength = 0;
					curSum = 0;
					curStart = index+1;
			}else{
				curSum += source[index];
				curLength++;
			}
		}
		
		if(curSum >= maxSum && curLength > maxLength){
			maxSum = curSum;
			maxStart = curStart;
			maxLength = curLength;
		}
		int[] result = new int[maxLength];
		int k = 0;
		for(int i = maxStart; i < (maxStart+maxLength); i++){
			result[k++] = source[i];
		}
		return result;
	}
	
	/**
	 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
	 * You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
	 */
	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    Set<Integer> numset = new HashSet<Integer>();
	    int sum = 0;
	    int largestnumber = 0;
	    int aa = -1;
	    int b = -1;
	    for(int i = 0; i < a.size(); i++){
            int temp = a.get(i);
	        if(!numset.contains(temp)){
	            numset.add(temp);
	            sum += temp;
	        }else{
	            aa = temp;
	        }
	        if(temp > largestnumber){
	            largestnumber = temp;
	        }
	    }	    
	    int givenSum =  largestnumber * (largestnumber + 1)/2;
	    b =  givenSum - sum;
	    result.add(aa);result.add(b);
	    return result;
	}
	
	//https://www.interviewbit.com/problems/add-one-to-number/
	public static void getNext(ArrayList<Integer> arr){
		int number = 0;
		int k = 1;
		for(int i = arr.size()-1; i >= 0; i--){
			int j = arr.get(i);
			number += k * j;
			k = k * 10;
		}
		number = number + 1;
		System.out.println(number);		
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(number > 0){
			int a = number % 10;
			result.add(a);
			number = number/10;
		}
		
		for (int i = 0; i < result.size() / 2; i++) {
	        int temp = result.get(i);
	        result.set(i, result.get(result.size() - i - 1));
	        result.set(result.size() - i - 1, temp);
		}
		for(int i : result){
			System.out.print(i + " ");
		}
	}
}
