package InterviewBit;

import java.util.HashMap;
import java.util.Map.Entry;

public class StringsPalindrome {
/*Minimum Characters required to make a String Palindromic
thttp://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
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




public static int insertPalindrome(String s){
	char[] c1 = s.toCharArray();
	String s2 = new StringBuffer(s).reverse().toString();
	char[] c2 = s2.toCharArray();
	int length = s.length();
	return length - longestCommonSubstring(c1,c2);
}

public static int longestCommonSubstring(char[] c1, char[] c2){
	int m =  c1.length; int n = c2.length;
	int[][] lcs = new int[c1.length+1][c2.length+1];
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(i == 0 || j == 0)
				lcs[i][j] = 0;
			else if(c1[i-1] == c2[j-1])
				lcs[i][j] = lcs[i-1][j-1]+1;
			else
				lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
		}
	}
	return lcs[m][n];
	
}
}
