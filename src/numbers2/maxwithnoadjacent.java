package numbers2;

public class maxwithnoadjacent {

	 /*Function to return max sum such that no two elements
    are adjacent */

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
  public static void main(String[] args) 
  {
	  maxwithnoadjacent sum = new maxwithnoadjacent();
     // int arr[] = new int[]{5, 5, 10, 100, 10, 5};
	  int arr[] = new int[]{-3,-6,-1,-10};
      System.out.println(sum.FindMaxSum(arr, arr.length));
  }
}

