package InterviewBit;

public class ArraysFlip {
/*http://massivealgorithms.blogspot.com/2016/06/flip-leetcode-discuss.html
https://www.interviewbit.com/problems/flip/
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. 
In a single operation, you can choose two indices L and R such that 1 <= L <= R <= N and flip the characters SL, SL+1, …, SR. 
By flipping, we mean change character 0 to 1 and vice-versa.
Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. 
If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. 
		If there are multiple solutions, return the lexicographically smallest pair of L and R.
Ex:S = 010
Pair of [L, R] | Final string
_______________|_____________
	[1 1]          | 110
	[1 2]          | 100
	[1 3]          | 101
	[2 2]          | 000
	[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
If S = 111
No operation can give us more than three 1s in final string. So, we return empty array [].*/
	public static void main(String[] args) {
		String arr = "11110000";
		getFlipRange(arr);

	}
/*
Here is dp solution.It used Kadane algolithm for maximum sum subarray. The idea is related 
to fact that when 0 is flipped, +1 is added to the number of 1's,
when 1 is flipped -1 is substracted from the number of 1's.
We try to maximize total gain from flip of some range [i,j].
The algorithm search the max sum subarray of array which contains what is the gain when give index is flipped.	*/
	public static int[] getFlipRange(String str) {
	    if (str.length() == 0)
	        return new int[]{};		 
	    boolean zero = false;
	    int gain[] = new int[str.length()];
	    for (int i = 0; i< str.length(); i++) {		        
	           gain[i] = (str.charAt(i) == '1') ? -1 : 1;
	       if (str.charAt(i) == '0') {
	               zero = true; 
	           }
	    }
	    if(!zero)
	        return new int[]{};   
	    int l = 0;
	    int r = str.length() - 1;
	    int maxSum = 0;
	    int curSum = 0;
	    int currL = 0;
	    int currR = 0;
	    for (int i =  0; i < gain.length; i++) {
	        if (curSum + gain[i] >= 0) {
	            curSum += gain[i];
	            currR = i;
	        }
	        else {
	            curSum = 0;	
	            currL = i + 1;
	        }
	        if (maxSum<curSum) {
	            maxSum = curSum;	
	            l = currL;
	            r = currR;
	        }		       
	    }
	    return new int[]{l + 1, r + 1};
	}
}