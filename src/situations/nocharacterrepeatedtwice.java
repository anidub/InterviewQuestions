package situations;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class nocharacterrepeatedtwice {
	//no same letters same op : adba
	private static String rearrangeLetters(String s) {
		final class CharFreq implements Comparable<CharFreq> {
			char c;
			int freq;
			public CharFreq(char ch, int count) {
				c = ch;
				freq = count;
			}
			public int compareTo(CharFreq o) {
				return 0;
			}
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c))
				map.put(c, 0);
			map.put(c, map.get(c) + 1);
		}

		PriorityQueue<CharFreq> PQ = new PriorityQueue<CharFreq>(new Comparator<CharFreq>()	{
			public int compare(CharFreq arg0, CharFreq arg1) {//high freq chars above others
				if (arg0.freq > arg1.freq)
					return -1;
				else if (arg0.freq < arg1.freq)
					return 1;
				else
					return 0;
			}
		});
		for (Character key : map.keySet()) {
			if (map.get(key) > (s.length() + 1) / 2)
				return "INVALID OUTPUT";
			PQ.add(new CharFreq(key, map.get(key)));
		}
		while (!PQ.isEmpty()) {
			CharFreq front = PQ.poll(), secondFromFront = null;
			res.append(front.c);
			front.freq--;
			if (!PQ.isEmpty())
				secondFromFront = PQ.poll();
			if (secondFromFront != null) {
				res.append(secondFromFront.c);
				secondFromFront.freq--;
				if (secondFromFront.freq > 0)
					PQ.add(secondFromFront);
			}
			if (front.freq > 0)
				PQ.add(front);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String str = "baad"; // no same letters together
		System.out.println(rearrangeLetters(str));
		System.out.println(reLetters("ababa"));
		System.out.println(reaLetters("aababa"));
	}
//same letter together : aaabb
	public static String reLetters(String a) {
		StringBuilder res = new StringBuilder();
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (hmap.containsKey(c)) {
				hmap.put(c, hmap.get(c) + 1);
			} else {
				hmap.put(c, 1);
			}
		}

		for (Entry<Character, Integer> entry : hmap.entrySet()) {
			if (res.toString().length() == a.length())
				break;
			char c = entry.getKey();
			int num = entry.getValue();
			while (num > 0) {
				res.append(c);
				num--;
			}
		}
		return res.toString();
	}
	
	
	//same letter together : aaabb
		public static String reaLetters(String a) {
			StringBuilder res = new StringBuilder();
			int[] chars = new int[26];
			for(int i = 0; i < a.length(); i++){
				chars[a.charAt(i) - 97]++;
			}
			
			for(int i = 0; i < chars.length; i++){
				int index = chars[i];
				while(index != 0){
					char c = (char)(i+97);
					res.append(c);
					index--;
				}
			}			
			return res.toString();
		}
}