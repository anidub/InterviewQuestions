package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashingSubStringConcatenation {
/*The idea is first store all words in a hashmap.Then iterate along string.Copy original hashmap to a new one hm.
The check for every word in the words and see if it is there in hashmap. If not break,if yes then reduce its value by
1, so that we clear duplicates.if empty mean that all words are covered in substring and add the index to result
https://www.interviewbit.com/problems/substring-concatenation/
What is the complexity of this algorithm?
The time of checking a concatenation is O(k*m) = O(m) and we check it (n - k*m) times, 
so the total running time is O((n - k*m)*m). The space complexity is the size of list L,
 which is O(k*m) = O(m),  since we create a hash table of list L.
	http://n00tc0d3r.blogspot.com/2013/06/substring-with-concatenation-of-all.html
S: "barfoothefoobarman"
L: ["foo", "bar"]	*/
	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		ArrayList<String> words = new ArrayList<String>();
		words.add("foo");
		words.add("bar");
		System.out.println(findSubstring(S, words));
	}
	
	public static ArrayList<Integer> findSubstring(String S, final List<String> words) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (S == null || words == null || words.size() == 0 || S.length() == 0)
			return res;
		HashMap<String, Integer> wordsmap = new HashMap<String, Integer>();
		int len = 0;

		for (String str : words) {
			len = str.length();
			wordsmap.put(str, wordsmap.getOrDefault(str, 0) + 1);
		}

		int size = words.size();
		int index;

		for (int i = 0; i <= S.length() - len * size; i++) {
			index = i;
			HashMap<String, Integer> hashMap = new HashMap<String, Integer>(wordsmap);

			for (int j = 0; j < size; j++) {
				int startPoint = index + j * len;
				String str = S.substring(startPoint, startPoint + len);
				if (hashMap.containsKey(str)) {
					int val = hashMap.get(str);
					if (val == 1) {
						hashMap.remove(str);
					} else {
						hashMap.put(str, val - 1);
					}
				} else
					break;
			}

			if (hashMap.isEmpty()) {
				res.add(i);
			}
		}
		return res;
	}
}