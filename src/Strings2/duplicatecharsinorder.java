package Strings2;

import java.util.LinkedHashMap;
import java.util.Map.Entry;import numbers2.getMedianofTwosortedarrays;

public class duplicatecharsinorder {
	// Print the count of duplicate char in a given string in same order.
	// O(n) //LinkedHashMap: The order of the iteration is determined by the insertion order, so you will get the key/values back in the order that they were added to this Map.
	public static void main(String[] args) {
		String a = "abllahabadl";
		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			hm.put(c, hm.getOrDefault(c, 0) + 1);
		}

		for (Entry<Character, Integer> entry : hm.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}

}
