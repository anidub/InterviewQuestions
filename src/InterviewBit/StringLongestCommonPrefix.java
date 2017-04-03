package InterviewBit;

public class StringLongestCommonPrefix {
/*https://www.interviewbit.com/problems/longest-common-prefix/
Write a function to find the longest common prefix string amongst an array of strings.
Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
[ "abcdefgh", "aefghijk","abcefgh"]The answer would be “a”.
http://www.programcreek.com/2014/02/leetcode-longest-common-prefix-java/*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String longestCommonPref(String[] words) {
		if (words == null)
			return "";
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words.length < minLength)
				minLength = words.length;
		}

		String result = "";
		for (int i = 0; i < minLength; i++) {
			char c = words[0].charAt(i);
			for (int j = 1; j < words.length; j++) {
				if (words[j].charAt(i) != c)
					return result;
			}
			result += c;
		}
		return result;
	}
}
