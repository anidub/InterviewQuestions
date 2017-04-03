package InterviewBit;

import java.util.Arrays;

public class numberNbyKtimes {
//	/https://www.interviewbit.com/problems/n3-repeat-number/
	//You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
	//http://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/ O(nlogn)
	

public static class eleCount{
    int e;  // Element
    int c;  // Count
    public eleCount(int e, int c) {
		this.e = e;
		this.c = c;
	}
}

	public static void main (String[] args){
		int[] arr = {0,1,4,1,4,1,4,2,5,8,9};
		//System.out.println(find(arr));
		int[] num = new int[2];
		moreThanNdK(arr,arr.length,3);
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
         if (temp[j].e == arr[i]){
              temp[j].c += 1;
              break;
         }
     }
     /* If arr[i] is not present in temp[] */
     if (j == k-1) {
         int l;    
    /* If there is position available in temp[], then place  arr[i] in the first available position and set count as 1*/
         for (l=0; l<k-1; l++)  {
             if (temp[l].c == 0) {
                 temp[l].e = arr[i];
                 temp[l].c = 1;
                 break;
             }
         }

   /* If all the position in the temp[] are filled, then decrease count of every element by 1 */
         if (l == k-1)
             for (l=0; l<k; l++)
                 temp[l].c -= 1;
     }
 }


 /*Step 3: Check actual counts of potential candidates in temp[]*/
 for (int i=0; i<k-1; i++){
     // Calculate actual count of elements 
     int ac = 0;  // actual count
     for (int j=0; j<n; j++){
         if (arr[j] == temp[i].e)
             ac++;
     }

     // If actual count is more than n/k, then print it
     if (ac > n/k)
    	 System.out.println("Number: " + temp[i].e + " count: " + temp[i].c);
 }
}

}
