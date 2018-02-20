package InterviewBit;

import java.util.HashMap;
import java.util.Map.Entry;

public class StringsPalindrome {
/*Minimum Characters required to make a String Palindromic
http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
https://www.youtube.com/watch?v=DOnK40BvazI&feature=youtu.be
Given a string, find the minimum number of characters to be inserted to convert it to palindrome.*/
	public static void main(String[] args) {
		String s = "abc";
		System.out.println(insertPalindrome(s));
	} 
	
public static String makePalindrome(String s){
	if(s == null || s.length() == 0) return "";
	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
	StringBuilder sb = new StringBuilder();
	for(Character c : s.toCharArray()){
		int totalChar = hm.get(c) != null ? hm.get(c) : 0;
		if(totalChar + 1 % 2 == 0){
			sb.append(c);
			sb.insert(0, c);
			hm.remove(c);
			continue;
		}
		hm.put(c, ++totalChar);
	}
	if(hm.size() > 0){
		Entry<Character,Integer> pair = (Entry<Character, Integer>) hm.entrySet();
		sb.append(pair.getKey());
	}
	return sb.toString();	
}

public static int solve(String a) {
    int n = a.length();
    char c[]=a.toCharArray();
    int ans= bs(c,n);
    return ans;
    
}

	public static int bs(char c[], int n) {
		int first = 0, last = n;
		int ans = 0;
		while (first <= last) {
			int middle = (first + last)/2;
			if (valid(c, n, middle)) {
				ans = middle;
				last = middle - 1;
			} else {
				if (middle - 1 >= 0 && valid(c, n, middle - 1)) {
					ans = middle - 1;
					last = middle - 2;
				} else
					first = middle + 1;
			}
		}
		return ans;
	}
public static boolean valid(char c[],int n,int middle){
    int start=0;
    int end=n-middle-1;
    while(start<=end){
        if(c[start]!=c[end])
            return false;
        start++;
        end--;
    }
    return true;
}



/*
 * minimum number of insertions required
 * in front to have palindrome O(n^2) and this method also requires O(n^2) extra space
 */
public static int insertPalindrome(String s){
	String s2 = new StringBuffer(s).reverse().toString();
	int length = s.length();
	return length - longestCommonSubstring(s,s2,length,length);
}
static int longestCommonSubstring( String X, String Y, int m, int n ){
    int lcs[][] = new int[n+1][n+1];
    int i, j;
    /* Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (i=0; i<=m; i++){
        for (j=0; j<=n; j++){
            if (i == 0 || j == 0)
                lcs[i][j] = 0;

            else if (X.charAt(i-1) == Y.charAt(j-1))
                lcs[i][j] = lcs[i-1][j-1] + 1;

            else
                lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
        }
    }
    /* L[m][n] contains length of LCS for  X[0..n-1] and Y[0..m-1] */
    return lcs[m][n];
}

}