package numbers2;

import java.util.ArrayList;
import java.util.Arrays;

public class allpossiblecombinationstoagivensun {
/*http://www.programcreek.com/2014/02/leetcode-combination-sum-java/
http://stackoverflow.com/questions/4632322/finding-all-possible-combinations-of-numbers-to-reach-a-given-sum		
*///As others mention this is an NP problem. It can be solved in exponential time O(2^n), for instance for n=10 there will be 1024 possible solution
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
    	// Sum up partial
    	int s = 0;
        for (int x: partial) s += x;
      //Check sum matched
        if (s == target)
             System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
        if (s >= target)
             return;
      //Iterate each input character
        for(int i=0;i<numbers.size();i++) {
        	//Build list of remaining items to iterate
              ArrayList<Integer> remaining = new ArrayList<Integer>();
              int n = numbers.get(i);
              for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
              //Update partial list
              ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
              partial_rec.add(n);
              sum_up_recursive(remaining,target,partial_rec);
        }
     }    
     static void sum_up(ArrayList<Integer> numbers, int target) {
         sum_up_recursive(numbers,target,new ArrayList<Integer>());
     }
     
	public static void main(String[] args) {
			Integer[] numbers = {3,9,8,4,5,7,10};
	        int target = 15;
	        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);
	}
	
	// Dynamic Programmining. Algo complexity is O(Sum * N) and use O(Sum) memory.
	private static int GetmNumberOfSubsets(int[] numbers, int sum){
	    int[] dp = new int[sum + 1];
	    dp[0] = 1;
	    int currentSum =0;
	    for (int i = 0; i < numbers.length; i++)  {
	        currentSum += numbers[i];
	        for (int j = Math.min(sum, currentSum); j >= numbers[i]; j--)
	            dp[j] += dp[j - numbers[i]];
	    }
	    return dp[sum];
	}
}