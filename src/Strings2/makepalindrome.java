package Strings2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*"aabcbcbdcc" you can remove and shuffle characters, find the maximum length of string which forms palindrome. like "ccabdbacc" */
//https://www.careercup.com/question?id=5636223029739520
/*"aabcbcbdcc" you can remove and shuffle characters, find the maximum length of string which forms palindrome. 
like "ccabdbacc"*/

/*continue will skip processing the code below it and until the end of the loop. 
Then, you are moved to the loop's condition and run the next iteration if this condition still holds (or if there is a flag, to the denoted loop's condition).*/

public class makepalindrome {
	public static void main(String[] args) {
		//LongestPalindrom longest = new LongestPalindrom();
		System.out.println("aabcbcbdcc");
		//System.out.println(longest("aabcbcbdcc"));
		System.out.println(longest("aabcba"));
	}
	
	public static String longest(String string) {
		if (string.length() == 0 || string == null) {
			return "";
		}
		
		StringBuffer palindrom = new StringBuffer();
		Map<Character, Integer> charBag = new HashMap<Character, Integer>();
		for (Character c : string.toCharArray()) {
			int totalChar = charBag.get(c) != null ? charBag.get(c) : 0;
			if ((totalChar + 1) % 2 == 0) {         //totalchar + 1 !! is because you want to start only you encounter 2nd occurence of that character
				palindrom.append(c);
				palindrom = palindrom.insert(0, c);
				charBag.remove(c);
				continue;
			}
			charBag.put(c, ++totalChar);
		}
		
		if (charBag.size() > 0) {
		Iterator<Entry<Character, Integer>> it = charBag.entrySet().iterator();
			Map.Entry pair = (Map.Entry<Character, Integer>)it.next();
			String c = pair.getKey().toString();	
			palindrom.insert(palindrom.length()/2, c);
		}
		return palindrom.toString();
	}
}
