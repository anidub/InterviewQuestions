package Strings2;

public class BackspaceStringCompare {
	/*
	 * Given two strings S and T, return if they are equal when both are typed
	 * into empty text editors. # means a backspace character.
	 * 
	 * Example 1:
	 * 
	 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T
	 * become "ac". Example 2:
	 * 
	 * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T
	 * become "". Example 3:
	 * 
	 * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T
	 * become "c". Example 4:
	 * 
	 * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while
	 * T becomes "b".
	 * https://leetcode.com/problems/backspace-string-compare/description/ O(N) time and O(1) space
	 */
	public static void main(String[] args) {
		System.out.println(backSpaceCompare("a##c", "#a#c"));

	}

	public static boolean backSpaceCompare(String s1, String s2) {
		return processString(s1).equals(processString(s2));
	}

	public static String processString(String s) {// "a##c", T = "#a#c"
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == '#') {
				count++;
			} else {
				if (count > 0) {
					count--;
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

}
