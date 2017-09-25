package InterviewBit;

import java.util.HashSet;
import java.util.TreeSet;

public class HashingLongestSubstringWithoutRepeating {
/*https://www.interviewbit.com/problems/longest-substring-without-repeat/
	Given a string, find the length of the longest substring without repeating characters.	
	The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
	For "bbbbb" the longest substring is "b", with the length of 1.
	http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
	https://leetcode.com/articles/longest-substring-without-repeating-characters/*/
	public static void main(String[] args) {//O(n)
		String s = "abcabcdb";
		System.out.println(longestSub(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)	return 0;
		HashSet<Character> set = new HashSet<Character>();
		int max = 0;
		int i = 0;
		int start = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (!set.contains(c)) {
				set.add(c);
			} else {
				max = Math.max(max, set.size());
				while (start < i && s.charAt(start) != c) {
					set.remove(s.charAt(start));
					start++;
				}
				start++;
			}
			i++;
		}
		max = Math.max(max, set.size());
		return max;
	}
/*	public int lengthOfLongestSubstring(String s) {//works
	    HashMap<character, integer> map = new HashMap<character, integer>();
	    if (s == null || s.length() == 0) return 0;
	    if (s.length() == 1) return 1;
	    int rightPointer = 0, leftPointer = rightPointer - 1, answer = 0;
	    while (rightPointer != s.length()) {
	         Integer previousOccurrence = map.put(s.charAt(rightPointer), rightPointer);
	         if (previousOccurrence != null) {
	             leftPointer = Math.max(leftPointer, previousOccurrence);
	         }
	         answer = Math.max(answer, rightPointer - leftPointer);
	         rightPointer++;
	    }
	    return answer;
	}*/
	//length with string // studied
	public static int longestSub(String s){
		if(s == null) return 0;
		TreeSet<Character> set = new TreeSet<Character>();
		int start = 0;
		String sub = "";
		int maxLen = 0;
		for(int i = 0; i < s.length(); i++){
			Character c = s.charAt(i);
			if(!set.contains(c)){
				set.add(c);
			}else{
				/*maxLen = Math.max(maxLen, set.size());*/
				if(maxLen < set.size()){
					maxLen = set.size();
					sub = set.toString();//use string builder instead of tostring
					//System.out.println(sub);
				}
					
				while(start < i && s.charAt(start) != c){
					set.remove(s.charAt(start));
					start++;
				}
				start++;
			}
		}
		if(maxLen < set.size()){
			maxLen = set.size();
			sub = set.toString();//use string builder instead of tostring
			if(set.toString().length() > sub.length()){
				sub = set.toString();
			}
		}
		System.out.println(sub);
		return Math.max(maxLen, set.size());
	}
	
}