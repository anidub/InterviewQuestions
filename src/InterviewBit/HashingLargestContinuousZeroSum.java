package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;

public class HashingLargestContinuousZeroSum {
/*Find the largest continuous sequence in a array which sums to zero.
Example:
Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}
https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
 * Returns length of the maximum length subarray with 0 sum
The idea is if you wont come across same sum in the next iteration unless
there is a value which brings it this sum.Those values which bring it to this sum
are essentially zero forming vales*///O(n)
   public static int maxLen(int arr[])  {
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 
        int sum = 0;      // Initialize sum of elements
        int max_len = 0;  // Initialize result 
        // Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			int k = arr[i];
			// Add current element to sum
			sum += arr[i];
			if (arr[i] == 0 && max_len == 0)
				max_len = 1;

			if (sum == 0)
				max_len = i + 1;

			// Look this sum in hash table
			Integer prev_i = hM.get(sum);

			// If this sum is seen before, then update max_len if required
			if (prev_i != null) {
				max_len = Math.max(max_len, i - prev_i);
			} else // Else put this sum in hash table
				hM.put(sum, i);
		} 
        	return max_len;
    }
        
 
    // Drive method
    public static void main(String arg[]) {
        int arr[] = {1 ,1 ,1 ,4 ,-4};
        ArrayList<Integer> in = new ArrayList<Integer>();
        in.add(1);in.add(2);in.add(3);in.add(-3);in.add(4);
        
        System.out.println(maxLen(arr,arr.length));
        System.out.println("Length of the longest 0 sum subarray is " + lszero(in));
    }
   
    
 // Returns length of the largest subarray with 0 sum//O(n2)
   static int maxLen(int arr[], int n) {
        int max_len = 0; // Initialize result

        // Pick a starting point
        for (int i = 0; i < n; i++) {
            // Initialize currr_sum for every starting point
            int curr_sum = 0;

            // try all subarrays starting with 'i'
            for (int j = i; j < n; j++) {
                curr_sum += arr[j];

                // If curr_sum becomes 0, then update max_len if required
                if (curr_sum == 0)
                   max_len = Math.max(max_len, j-i+1);
            }
        }
        return max_len;
    }

    //this is used to print the elements//O(N)
   //This can be used for any sum not just 0 by changing line 82 to given sum
    //https://github.com/nagajyothi/InterviewBit/blob/master/Hashing/LSZero.java  
    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A == null) return result;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);//change this for other than zero sum
        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLength  = Integer.MIN_VALUE;
        for(int i = 0; i < A.size(); i++){
            sum += A.get(i);

            if(map.containsKey(sum)){
                if(maxLength < (i - map.get(sum))){
                    start = map.get(sum) + 1;
                    end = i;
                    maxLength = i - map.get(sum); 
                    System.out.printf("start = %d, end = %d, maxLength = %d \n", start, end, maxLength);                    
                }               
            }else
                map.put(sum, i);
        }

        if(start >= 0 && end >= 0){
            for(int i = start; i <= end; i++){
                result.add(A.get(i));
            }
        }
        return result;
    } 
  }