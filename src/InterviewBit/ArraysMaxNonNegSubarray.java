package InterviewBit;

import java.util.ArrayList;
/*https://www.interviewbit.com/problems/max-non-negative-subarray/
Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. 
A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index*/
public class ArraysMaxNonNegSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> maxset(ArrayList<Integer> array) {
		ArrayList<Integer> maxArray = new ArrayList<Integer>();
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		long maxSum = 0; long newSum = 0;
		for(Integer i:array){
			if(i >= 0){
				newSum += i;
				newArray.add(i);
			}else{
				newSum = 0;
				newArray = new ArrayList<Integer>();
			}
			if(maxSum < newSum || maxSum == newSum || maxArray.size() < newArray.size()){
				maxSum = newSum;
				maxArray = newArray;
			}
		}
		return maxArray;		
	}
}
