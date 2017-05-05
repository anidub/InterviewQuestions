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
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(0);array.add(0);array.add(-1);array.add(0);
		getmax(array);
	}	
	public static ArrayList<Integer> getmax(ArrayList<Integer> array){
		ArrayList<Integer> news = new ArrayList<Integer>();
		ArrayList<Integer> maxs = new ArrayList<Integer>();
		long maxsum = Long.MIN_VALUE;
		long newsum = 0;
		for(int i: array){
			if(i >= 0){
				newsum += i;
				news.add(i);
			}else{
				if(maxsum < newsum || (maxsum == newsum && maxs.size() <= news.size())) {
					maxsum = newsum;
					maxs = news;
				}
				newsum = 0;
				news = new ArrayList<Integer>();
			}
		}
		if(maxsum < newsum || (maxsum == newsum && maxs.size() <= news.size())) {
			maxsum = newsum;
			maxs = news;
		}		
		return maxs;
	}
}