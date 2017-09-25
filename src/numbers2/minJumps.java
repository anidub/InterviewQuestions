package numbers2;

public class minJumps {

	//min jumps req to reach end of array
	//https://www.youtube.com/watch?v=vBdo7wtwlXs&list=PLamzFoFxwoNgG0Q5rqfTY6ovWSTAC9mbz&index=2
//http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
	public static void main(String[] args) {
		//int[] arr = {1, 3, 6, 1, 0, 9};
		 int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		 System.out.println("Minimum number of jumps to reach end is : " + minJumps(arr,arr.length));
		 System.out.println(jump(arr));
	}

	public static int jump(int[] A){ //O(n)
		if(A.length  <= 1) return 0;
		int ladder = A[0];
		int stairs = A[0];
		int jump = 1;
		for(int level = 1; level < A.length; level++){
			if(level == A.length -1) return jump;
			int k = A[level];
			if(level + A[level] > ladder) 
				ladder = level + A[level];
			stairs--;
			if(stairs == 0){
				jump++;
				stairs = ladder - level;
			}
		}
		return jump;	
}	
	
	public static  int min(int x, int y) { return (x < y)? x: y; }
	 
	// Returns minimum number of jumps to reach arr[n-1] from arr[0] ...Time Complexity: O(n^2)
	public static int minJumps(int arr[], int n){
	    int[] jumps = new int[n];  // jumps[n-1] will hold the result
	    int i, j;
	 
	    int k = Integer.MAX_VALUE;
	    if (n == 0 || arr[0] == 0)
	        return k;
	 
	    jumps[0] = 0;
	 
	    // Find the minimum number of jumps to reach arr[i]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
	    // from arr[0], and assign this value to jumps[i]
	    for (i = 1; i < n; i++){
	        jumps[i] = k;
	        for (j = 0; j < i; j++){
	        	int aa = j + arr[j]; int bb = jumps[j];
	            if (i <= j + arr[j] && jumps[j] != k) {
	                 jumps[i] = min(jumps[i], jumps[j] + 1);
	                 break;
	            }
	        }
	    }
	    return jumps[n-1];
	}
}
