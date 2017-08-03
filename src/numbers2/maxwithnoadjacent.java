package numbers2;

public class maxwithnoadjacent {

	 /*Function to return max sum such that no two elements
    are adjacent */
//only for positive
	public	int FindMaxSum(int arr[], int n)  {
      int incl = arr[0];
      int excl = 0;
      int temp;
      for (int i = 1; i < n; i++) {
          /* current max excluding i */
          temp  = Math.max(incl, excl);

          /* current max including i */
          incl = excl + arr[i];
          excl = temp;
      }

      /* return max of incl and excl */
      return Math.max(incl, excl);
  }

  // Driver program to test above functions
  public static void main(String[] args){
	  maxwithnoadjacent sum = new maxwithnoadjacent();
      int arr1[] = new int[]{5, 5, 10, 100, 10, 5};
	  int arr2[] = new int[]{3,-6,1,-10};
     System.out.println(sum.FindMaxSum(arr1, arr1.length));
	  System.out.println(MaxSumNonContiguousWithNegative(arr2));
  }
  
  
  //for all positive and negative
	static int MaxSumNonContiguousWithNegative(int[] arr){
	    int incl = 0;
	    int excl =0;
	    boolean isAllNegative = true;
	    int allNegativeMax = Integer.MIN_VALUE;
	    for(int i=0;i< arr.length;i++) {
	       if(arr[i] >=0)   {
	           isAllNegative = false;
	           int temp = incl;
	           incl = Math.max(incl, arr[i] + excl);
	           excl = temp;
	       }
	       else {
	           excl = incl;
	           if(isAllNegative && arr[i] > allNegativeMax){
	               allNegativeMax = arr[i];
	           }
	       }
	    }	    
	    return isAllNegative ? allNegativeMax : Math.max(incl, excl);
	}
}