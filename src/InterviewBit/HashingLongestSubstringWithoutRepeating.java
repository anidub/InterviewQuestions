package InterviewBit;

import java.util.HashSet;

public class HashingLongestSubstringWithoutRepeating {
/*https://www.interviewbit.com/problems/longest-substring-without-repeat/
	Given a string, find the length of the longest substring without repeating characters.	
	The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
	For "bbbbb" the longest substring is "b", with the length of 1.*/
	public static void main(String[] args) {//O(n)
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
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
	    HashMap<character, integer=""> map = new HashMap<character, integer="">();
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
}