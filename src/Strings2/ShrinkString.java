package Strings2;

import java.util.HashSet;

public class ShrinkString {
//Apple
/*
 * Tells the string with the substring of size x contains unique characters after removing the character at given index 	
 */
	public static void main(String[] args) {
		System.out.println(canRemove("abcabcabc", 3, 2));
	}

	public static boolean canRemove(String string, int x, int index) {
		if (string == null || string.length() == 0 || x <= 0)
			return false;
		if (index >= string.length())
			return false;
		string = string.substring(0, index) + string.substring(index + 1);
		String newString = string + string.substring(0, x);
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < newString.length(); i++) {
			char c = newString.charAt(i);
			if (!set.isEmpty() && set.size() >= x) {
				char d = newString.charAt(i - x);
				set.remove(newString.charAt(i - x));
			}
			if (set.contains(newString.charAt(i))) {
				return false;
			} else {
				set.add(newString.charAt(i));
			}
		}
		return true;
	}

}
