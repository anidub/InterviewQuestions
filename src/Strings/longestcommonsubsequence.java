package Strings;

public class longestcommonsubsequence {
//LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
	//A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous
	//LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
	//LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
	//http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
	//Time Complexity of the above implementation is O(mn)
	public static void main(String[] args) {
		//char[] c1 = {'A', 'G', 'G', 'T', 'A', 'B'};
		//char[] c2 = {'G','X' ,'T', 'X', 'A', 'Y', 'B','C'};
		char[] c1 = {'G', 'G', 'T', 'A'};
		char[] c2 = {'G','T', 'B','A'};
		int m = c1.length;
		int n = c2.length;
		int[][] table = new int[m+1][n+1];
		findLCS(c1,c2,m,n,table);
	//	findLC(c1.toString(),c2.toString(),m,n,table);

	}
	public static void findLCS(char[] a, char[] b, int m, int n, int[][] table){
		
		if(m == 0 || n == 0) return;
		for(int i = m-1; i >= 0; i--){
			for(int j = n-1; j >= 0; j--){
				if(a[i] == b[j]){
					table[i][j] = 1 + table[i+1][j+1];
				}else{
					table[i][j] = Math.max(table[i][j+1], table[i+1][j]);
				}
			}
		}
		int result = table[0][0];
		System.out.println(result);
		
		char[] lcs = new char[result+1];
		int i = m, j = n;
		while(i > 0 && j > 0){
			char a1 = a[i-1];
			char b1 = b[j-1];
			if(a[i-1] == b[j-1]){
				lcs[result-1] = a[i-1];
				i--;j--;result--;
			}else if(table[i-1][j] > table[i][j-1]){
				i--;
			}else
				j--;
		}
		System.out.println(lcs);
}
	
	public static void findLC(String s1, String s2, int m, int n, int[][] table){
		if(m == 0 || n == 0) return ;
		for(int i = m-1; i >= 0; i--){
			for(int j = n-1; j >= 0; j--){
				if(s1.charAt(i) == s2.charAt(j)){
					table[i][j] = 1 + table[i+1][j+1];
				}else{
					table[i][j] = Math.max(table[i+1][j], table[i][j+1]);
				}
			}
		}
		
		int result = table[0][0];
		int i = m; int j = n;
		char[] lc = new char[result+1];
		while(i > 0 && j > 0){

			if(s1.charAt(i-1) == s2.charAt(j-1)){
				lc[result-1] = s1.charAt(i-1);
				result--;
				i--;
				j--;
			}else if(table[i-1][j] > table[i][j-1]) 
				i--;
			else
				j--;
		}
		System.out.println(lc);
	}
}
