package InterviewBit;

import java.util.Stack;

public class StringIsPalindrome {
/*http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/
https://www.interviewbit.com/problems/palindrome-string/
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Example:
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.*/			
			
	//using stack
	public static boolean isPalindrome(String s){
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int length = s.length();
		if(length < 2) return true;
		
		Stack<Character> st = new Stack<Character>();
		int index = 0;
		while(index < length/2){
			st.push(s.charAt(index));
			index++;
		}
		if(length % 2 == 1) index++;
		while(index < length){
			if(st.isEmpty()) return false;
			if(st.pop() != s.charAt(index)) return false;
			index++;
		}
		return true;
	}
	
	//using two pointers
	public static boolean isPal(String s){
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int length = s.length();
		for(int i = 0; i < length; i++){
			if(s.charAt(i) != s.charAt(length - 1 - i)) return false;
		}
		return true;	
	}
}
