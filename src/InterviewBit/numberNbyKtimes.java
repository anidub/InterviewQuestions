package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class numberNbyKtimes {
/*	https://www.interviewbit.com/problems/n3-repeat-number/
	You’re given a read only array of n integers. Find out if any integer occurs 
	more than n/3 times in the array in linear time and constant additional space.
	http://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/ O(nlogn)
	
	
	The basic idea is based on Moore’s Voting Algorithm, we need two candidates with top 2 frequency.
	 If meeting different number from the candidate, then decrease 1 from its count, or increase 1 on the opposite condition.
	  Once count equals 0, then switch the candidate to the current number.
	 The trick is that we need to count again for the two candidates after the first loop. Finally, output the numbers appearing more than n/3 times.
*/	
public static void main (String[] args){
		int[] arr = {4, 2, 2, 7};
		System.out.println(getNByK(arr,arr.length));
		//int[] num = new int[2];
		//moreThanNdK(arr,arr.length,3);
}
//USE THIS// TIME COMPLEXITY : o(n) Space complexity : O(1)	
public static List<Integer> getNByK(int[] nums, int k){
	List<Integer> result = new ArrayList<Integer>();
	if(nums == null || nums.length == 0) return result;
	
	int number1 = nums[0]; int number2 = nums[0]; int count1 = 0; int count2 = 0;
	
	for(int i = 0; i < nums.length; i++){
		int n = nums[i];
		if(n == number1){
			count1++;
		}else if(n == number2){
			count2++;
		}else if(count1 == 0){
			number1 = n;
			count1 = 1;
		}else if(count2 == 0){
			number2 = n;
			count2 = 1;
		}else{
			count1--;
			count2--;
		}
	}
	count1 = 0;
	count2 = 0;
	for(int i = 0; i < nums.length; i++){
		int n = nums[i];
		if(n == number1)
			count1++;
		else if(n == number2)
			count2++;
	}
	
	if(count1 > nums.length/k){
		result.add(number1);
	}
	if(count2 > nums.length/k){
		result.add(number2);
	}
	
	return result;			
}
	
	
	
public static class eleCount{
    int element;  // Element
    int count;  // Count
    public eleCount(int e, int c) {
		this.element = e;
		this.count = c;
	}
}

	
	
public static  int find(int[] arr){
	int l = arr.length;
	int res = 0;
	
	Arrays.sort(arr);
	for(int i = 0; i < l;){
		int  num = arr[i];
		int count = 0;
		while(i < l-1 && num == arr[i]){
			i++;
			count++;
		}
		if(count == 3){ res = num;
			break;
		}
	}
	return res;
}


//Prints elements with more than n/k occurrences in arr[] of size n. If there are no such elements, then it prints nothing. //O(NK)
public static void moreThanNdK(int arr[], int n, int k){
 // k must be greater than 1 to get some output
 if (k < 2)
    return;

 /* Step 1: Create a temporary array (contains element and count) of size k-1. Initialize count of all elements as 0 */
  eleCount[] temp = new eleCount[k-1];
 for (int i=0; i<k-1; i++){
    eleCount eC = new eleCount(0, 0);
    temp[i] = eC;
	 //temp[i].c = 0;
 }

 /* Step 2: Process all elements of input array */
 for (int i = 0; i < n; i++){
     int j;
     /* If arr[i] is already present in the element count array, then increment its count */
     for (j=0; j<k-1; j++) {
         if (temp[j].element == arr[i]){
              temp[j].count += 1;
              break;
         }
     }
     /* If arr[i] is not present in temp[] */
     if (j == k-1) {
         int l;    
    /* If there is position available in temp[], then place  arr[i] in the first available position and set count as 1*/
         for (l=0; l<k-1; l++)  {
             if (temp[l].count == 0) {
                 temp[l].element = arr[i];
                 temp[l].count = 1;
                 break;
             }
         }

   /* If all the position in the temp[] are filled, then decrease count of every element by 1 */
         if (l == k-1)
             for (l=0; l<k; l++)
                 temp[l].count -= 1;
     }
 }


 /*Step 3: Check actual counts of potential candidates in temp[]*/
 for (int i=0; i<k-1; i++){
     // Calculate actual count of elements 
     int ac = 0;  // actual count
     for (int j=0; j<n; j++){
         if (arr[j] == temp[i].element)
             ac++;
     }

     // If actual count is more than n/k, then print it
     if (ac > n/k)
    	 System.out.println("Number: " + temp[i].element + " count: " + temp[i].count);
 }
}

}
