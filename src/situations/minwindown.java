package situations;

import java.util.HashMap;

public class minwindown {
//Find the smallest window in a string containing all characters of another string	
	//Both the begin and end pointers can advance at most N steps (where N is S‘s size) in the worst case, adding to a total of 2N times. 
	//Therefore, the run time complexity must be in O(N).
	
	//http://stackoverflow.com/questions/2459653/how-to-find-smallest-substring-which-contains-all-characters-from-a-given-string
	//o(n+m)1
	


/*	public static boolean find(String s, String t){
		int slen = s.length();
		int tlen = t.length();
		int[] needtofind = new int[256];
		
		for(int i = 0; i < tlen; i++){
			needtofind[t.charAt(i)]++;
		}
		
		int[] hasfound = new int[256];
		int minWindownlen = 1000000;
		int count = 0;
		
		for(int begin = 0, end = 0; end < slen; end++){
			if(needtofind[s.charAt(end)] == 0) continue;
			hasfound[s.charAt(end)]++;
			if(hasfound[s.charAt(end)] <= needtofind[s.charAt(end)]) count++;
			
			if(count == tlen){
				while(needtofind[s.charAt(begin)] == 0 || 
					hasfound[s.charAt(begin)] > needtofind[s.charAt(begin)]){
						if(hasfound[s.charAt(begin)] > needtofind[s.charAt(begin)])
							hasfound[s.charAt(begin)]--;
							
							begin++;
					}
					
					//int windowlen = end - begin +1;
					//if(windowlen < minWindownlen){
					//		minWindownBegin = begin; //0//0
					//		minWindownend = end;//5//6
					//		minWindownlen = windowlen; //4//5
				}
			}
		//}
		
		return count == tlen ? true : false;
	}
	
	*/

	public static void main(String[] args) {
		String s = "ZAQCBBACA";
		String t = "BAC";
		//String s = "ACB";
		//String t = "AC";
		//System.out.println(finds(s,t));
		check();
	}
	  private static boolean containsPatternChar(int[] sCount, int[] pCount) {
	        for(int i=0;i<256;i++) {
	            if(pCount[i]>sCount[i])
	                return false;
	        }
	        return true;
	    }
	  public static String finds(String s, String p) {
	        if (p.length() > s.length())
	            return null;
	        int[] pCount = new int[256];
	        int[] sCount = new int[256];
	        // Time: O(p.lenght)
	        for(int i=0;i<p.length();i++) {
	            pCount[(int)(p.charAt(i))]++;
	            sCount[(int)(s.charAt(i))]++;
	        }
	        int i = 0, j = p.length(), min = Integer.MAX_VALUE;
	        String res = null;
	        // Time: O(s.lenght)
	        while (j < s.length()) {
	            if (containsPatternChar(sCount, pCount)) {
	                if ((j - i) < min) {
	                    min = j - i;
	                    res = s.substring(i, j);
	                    // This is the smallest possible substring.
	                    if(min==p.length())
	                        break;
	                    // Reduce the window size.
	                    sCount[(int)(s.charAt(i))]--;
	                    i++;
	                }
	            } else {
	                sCount[(int)(s.charAt(j))]++;
	                // Increase the window size.
	                j++;
	            }
	        }
	        System.out.println(res);
	        return res;
	    }
	  
	  
	  //proper working solution !!!!!! use this
	public static void check() {
		//String s = "AKCBBACA";
		String s = "ASCBCBCAS";
		String f = "BAC";
		int[] count = new int[256];
		int[] actual = new int[256];

		int i;
		int cnt = 0;
		int start = -1;
		int min = Integer.MAX_VALUE;
		int min_start = -1;
		for (i = 0; i < f.length(); i++) {
			if (count[f.charAt(i)] == 0)cnt++;
			count[f.charAt(i)]++;
		}

		for (i = 0; i < s.length(); i++) {
			if (count[s.charAt(i)] != 0) {
				if (start == -1)
					start = i;
				actual[s.charAt(i)]++;
				if ((actual[s.charAt(i)] == count[s.charAt(i)])) cnt--;
			}
			if (cnt == 0 && min == Integer.MAX_VALUE) {
				min = i - start + 1;
				min_start = start;
			}
			if (cnt == 0 && (actual[s.charAt(start)] > count[s.charAt(start)])) {
				while ((count[s.charAt(start)] == 0) || (actual[s.charAt(start)] > count[s.charAt(start)])) {
					if (count[s.charAt(start)] != 0) actual[s.charAt(start)]--;
					start++;
				}
				if (min > (i - start + 1)) {
					min = i - start + 1;
					min_start = start;
				}
			}
		}
		System.out.println("min:" + min);
		if (min == -1)
			System.out.println("Not possible");
		else
			for (i = min_start; i < min + min_start; i++)
				System.out.print(" " + s.charAt(i));

	}	  	
}

