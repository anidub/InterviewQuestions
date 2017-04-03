package Strings;

public class longestpalindromeinsubstring {
//Time O(n^2), Space O(1)
	//http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/
	//http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
	//http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
	public static void main(String[] args) {
		String s = "ABCCBP";
		System.out.println(LPS("banana"));

	}
	//expandAroundCenter
	public static String longestpalindrome(String s){
		if(s.length() == 0)
			return null;
		if(s.length() == 1)
			return s;
		
		String longest = s.substring(0,1);
		for(int i = 0; i < s.length() ; i++){
			String temp = palindrome(s,i,i);
			if(temp.length() > longest.length())
				longest = temp;
			
			temp = palindrome(s,i,i+1);
			if(temp.length() > longest.length())
				longest = temp;
			
		}
		return longest;
	}
	
	public static String palindrome(String s, int begin, int end){
		
		while(begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)){
			char b = s.charAt(begin);char e = s.charAt(end);
			begin--;
			end++;
		}
		String t = s.substring(begin+1,end);
		return s.substring(begin+1,end);
	}
	
	
	
/*//	/https://www.youtube.com/watch?v=obBdxeCx_Qs
	https://github.com/IDeserve/learn/blob/master/LongestPalindromicSubstring.java
	studied..Time complexity: O ( n^2 )
Auxiliary Space: O ( n^2 )
http://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/*/
	public static String LPS(String s) {
		int n = s.length();
		int palindromeBeginsAt = 0; // index where the longest palindrome begins
		int max_len = 1;// length of the longest palindrome
		boolean palindrome[][] = new boolean[n][n]; // boolean table to store
													// palindrome truth

		// Trivial case: single letter palindromes
		for (int i = 0; i < n; i++) {
			palindrome[i][i] = true;
		}

		// Finding palindromes of two characters.
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				palindrome[i][i + 1] = true;
				palindromeBeginsAt = i;
				max_len = 2;
			}
		}

		// Finding palindromes of length 3 to n and saving the longest
		for (int curr_len = 3; curr_len <= n; curr_len++) {
			for (int i = 0; i < n - curr_len + 1; i++) {
				int j = i + curr_len - 1;
				if (s.charAt(i) == s.charAt(j) // 1. The first and last characters should match
						&& palindrome[i + 1][j - 1]) // 2. Rest of the substring should be a palindrome
				{
					palindrome[i][j] = true;
					palindromeBeginsAt = i;
					max_len = curr_len;
				}
			}
		}
		return s.substring(palindromeBeginsAt, max_len + palindromeBeginsAt);
	}
	
	//very simple //O(N2)
	//http://stackoverflow.com/questions/1115001/write-a-function-that-returns-the-longest-palindrome-in-a-given-string
	 public static String getLongestPalindrome(final String input) {
	        int rightIndex = 0, leftIndex = 0;
	        String currentPalindrome = "", longestPalindrome = "";
	        for (int centerIndex = 1; centerIndex < input.length() - 1; centerIndex++) {
	            leftIndex = centerIndex - 1;  rightIndex = centerIndex + 1;
	            while (leftIndex >= 0 && rightIndex < input.length()) {
	                if (input.charAt(leftIndex) != input.charAt(rightIndex)) {
	                    break;
	                }
	                currentPalindrome = input.substring(leftIndex, rightIndex + 1);
	                longestPalindrome = currentPalindrome.length() > longestPalindrome.length() ? currentPalindrome : longestPalindrome;
	                leftIndex--;  rightIndex++;
	            }
	        }
	        return longestPalindrome;
	    }
}
