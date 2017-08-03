package Strings2;

import java.util.HashSet;
import java.util.Set;

public class allDistictPalindromeSubStrings {
/*
 * given a string of lowercase ASCII characters, find all distinct continuous palindromic sub-strings of it.
Examples:
Input: str = "abaaa"
Output:  Below are 5 palindrome sub-strings
a
aa
aaa
aba
b
 * http://code.geeksforgeeks.org/QFeKaU
 * http://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-given-string/
 * https://stackoverflow.com/questions/19801081/find-all-substrings-that-are-palindromes
 */	
	
	public static void main(String[] args) {		
		final String s = "aabaa";		
		HashSet<String> distinct_palin = getPal(s);		
		for(String string : distinct_palin){
			System.out.println(string);
		}
	}
	//studied
	public static HashSet<String> getPal(String s) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j) && isPalindrome(s, i, j)) {
					set.add(s.substring(i, j + 1));
				}
			}
		}
		return set;
	}
	
	static boolean isPalindrome(String s, int start, int end){
		    boolean result = true;
		    for(int i=start ; i<=end;++i){
		        if(s.charAt(i) == s.charAt(end)){
		            end--;
		        }
		        else{
		            result = false;
		            break;
		        }
		    }
		    return result;
	}
	
	//another method
	 public static HashSet<String> palindromes(final String input) {
	     final HashSet<String> result = new HashSet<String>();
	     for (int i = 0; i < input.length(); i++) {
	         // expanding even length palindromes:
	         expandPalindromes(result,input,i,i+1);
	         // expanding odd length palindromes:
	         expandPalindromes(result,input,i,i);
	     } 
	     return result;
	  }

	  public static void expandPalindromes(final Set<String> result, final String s, int i, int j) {
	      while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
	            result.add(s.substring(i,j+1));
	            i--; j++;
	      }
	  }

}
