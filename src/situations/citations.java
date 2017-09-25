package situations;

import java.util.Arrays;

public class citations {
//Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
	//O(n)
//For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. 
	//Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
	public static void main(String[] args) {
		int[] citations = {3,1,6,0,5};
		System.out.println(hIndex(citations));
	}

	public static int hIndex(int[] citations) {  
        int n = citations.length;  //5
        int [] equal_h = new int[n+1];  
        for (int h = 0; h<n; h++){  
            if(citations[h] >= n) equal_h[n] += 1;  // 
            else equal_h[citations[h]] += 1;  //                [1  1  0  1  0  2 ] 
        }  
        int s = 0; //we don't need check overflow here coz sum always <= n  
        for (int h = n; h>0; h--){  
            s += equal_h[h];  
            if (s >= h) return h;  
              
        }  
        return 0;  
    }	
	
	//greater than O(n)	
	public int hhIndex(int[] citations) {
	    Arrays.sort(citations);
	 
	    int result = 0;    
	    for(int i=0; i<citations.length; i++){
	        int smaller = Math.min(citations[i], citations.length-i);
	        result = Math.max(result, smaller);
	    }	 
	    return result;
	}
}

