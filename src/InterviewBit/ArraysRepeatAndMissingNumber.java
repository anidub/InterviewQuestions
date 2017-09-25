package InterviewBit;

import java.util.ArrayList;
import java.util.HashSet;

public class ArraysRepeatAndMissingNumber {
/*https://www.interviewbit.com/problems/repeat-and-missing-number-array/
You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
http://stackoverflow.com/questions/5766936/find-the-missing-and-duplicate-elements-in-an-array-in-linear-time-and-constant

Input:[3 1 2 5 3] 
Output:[3, 4] 
A = 3, B = 4*/
	public static void main(String[] args) {

	}
	
	public static ArrayList<Integer> getRepeatedAndMissing(ArrayList<Integer> numbers){
		HashSet<Integer> numSet = new HashSet<Integer>();
		int repeated = -1;
		int missing = -1;
		int sum = 0; int largestNum = -1;
		for(int i = 0; i < numbers.size(); i++){
			int temp = numbers.get(i);
			if(!numSet.contains(temp)){
				numSet.add(temp);
				sum += temp;
			}else{
				repeated = temp;
			}
			if(temp > largestNum){
				largestNum = temp;
		    }
		}
		
		int total = largestNum * (largestNum+1)/2;
		missing = total - sum;
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(repeated,missing);
		return result;
	}	
}