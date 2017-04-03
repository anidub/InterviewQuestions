package situations;

import java.util.Arrays;

public class minplatformneeded {
//Given arrival and departure times of all trains that reach a railway station, 
	//find the minimum number of platforms required for the railway station so that no train waits.
	
	public static void main(String[] args) {
		int[] arr = {900, 940, 950, 1100, 1500, 1800};
	    int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
	    
	    int n = arr.length;
	    Arrays.sort(arr);// Sort arrival and departure arrays
	    Arrays.sort(dep);
	    findminplatform(arr,dep,n);
	    System.out.println("The minimum number of platforms needed are : " + findminplatform(arr,dep,n) );
	}

	
	public static int findminplatform(int[] arr, int[] dep, int n){
		int platform_needed = 1;
		int result = 1;
		int i = 1;
		int j = 0;
		while( i < n && j < n){
			// If next event in sorted order is arrival, increment count of
		      // platforms needed
			if(arr[i] < dep[j]){
				platform_needed++;
				i++;
					if(platform_needed >= result)
						result = platform_needed;
			}else{// Else decrement count of platforms needed
						platform_needed--;
						j++;
						
					}
			}	
		return result;
	}
}
