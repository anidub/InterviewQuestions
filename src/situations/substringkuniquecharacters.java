package situations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//Find the longest substring with k unique characters in a given string
//O(N)
public class substringkuniquecharacters {

	/*public static void main(String[] args) {
		//String s = "aabacbebebe";
		String s = "aabac";
	//	String t = unique2CharSubstring(s,2);
		String t = unique22CharSubstring(s,2);
		System.out.println(t);

	}
	
	public static String unique2CharSubstring(String str, int k) {
		if(k == 0) return "invalid input";
        String result = "";
        int len = str.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] c = str.toCharArray();
        int right = 0, max = 0;
       LinkedList<Character> queue = new LinkedList<Character>();
        for (int left = 0; left < len; left++) {
            while (right < len) {
                if (!map.containsKey(c[right])) {
                    queue.add(c[right]);
                }
                map.put(c[right], right);
                if (map.size() > k) {
                    left = Math.max(left, map.get(queue.peek()) + 1);
                    map.remove(queue.pop());
                }
                if (right - left > max) { 
                    max = right - left;
                    result = str.substring(left, right + 1);
                }
                right++;
            }
        }
        if(queue.size() < k) return "invalid input";
        return result;
    }
	

	public static String unique22CharSubstring(String str, int k) {
		if(k == 0) return "invalid input";
        String result = "";
        int len = str.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] c = str.toCharArray();
        int right = 0, max = 0;
       LinkedList<Character> queue = new LinkedList<Character>();
        for (int left = 0; left < len; left++) {
            while (right < len) {
                if (!map.containsKey(c[right])) {
                    queue.add(c[right]);
                }
                map.put(c[right], right);
                if (map.size() > k) {
                    left = Math.max(left, map.get(queue.peek()) + 1);
                    map.remove(queue.pop());
                }
                if (right - left > max) { 
                    max = right - left;
                    result = str.substring(left, right + 1);
                }
                right++;
            }
        }
        if(queue.size() < k) return "invalid input";
        return result;
    }*/

	
	//works
	//http://ideone.com/MJV0Ig
public static boolean isValid(int count[],int k){
		int val = 0;
	    for (int i=0; i<256; i++)
	        if (count[i] > 0)
	            val++; 
	    return (k >= val);
}
public  static final int MAX_CHARS = 256;
//Finds the maximum substring with exactly k unique chars
	public static void kUniques(String s, int k) {
		int u = 0; // number of unique characters
		int n = s.length();
		// Associative array to store the count of characters
		int[] count = new int[MAX_CHARS];
		// Traverse the string, Fills the associative array
		// count[] and count number of unique characters
		for (int i = 0; i < n; i++) {
			if (count[s.charAt(i) - 'a'] == 0) //s.charAt(i) - 'a' will give zero initially for every character
				u++;
			count[s.charAt(i) - 'a']++;
		}
		// If there are not enough unique characters, show an error message.
		if (u < k) {
			System.out.println("Not enough unique characters");
			return;
		}
		// Otherwise take a window with first element in it.
		// start and end variables.
		int curr_start = 0, curr_end = 0;
		// Also initialize values for result longest window
		int max_window_size = 1, max_window_start = 0;
		// Initialize associative array count[] with zero
		Arrays.fill(count, 0);
		count[s.charAt(0) - 'a']++; // put the first character
		// Start from the second character and add characters in window according to above explanation
		for (int i = 1; i < n; i++) {
			// Add the character 's[i]' to current window
			count[s.charAt(i) - 'a']++;
			curr_end++;
			// If there are more than k unique characters in
			// current window, remove from left side
			while (!isValid(count, k)) {
				count[s.charAt(curr_start) - 'a']--;
				curr_start++;
			}
			// Update the max window size if required
			if (curr_end - curr_start + 1 > max_window_size) {
				max_window_size = curr_end - curr_start + 1;
				max_window_start = curr_start;
			}
		}
		System.out.println("Max sustring is : " + s.substring(max_window_start, max_window_start + max_window_size)	+ " with length " + max_window_size);
	}
public static void main (String[] args) throws java.lang.Exception{
			//String s="aabacbebebe";
			String s = "abcaadeaaa";
			int k=3;
			kUniques(s,k);
			getSubString(s,k);
			getSubStringSet(s,k);
}


//studied//http://code.geeksforgeeks.org/sceIv7
//http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
//can refer to this also for hashset solution:
//http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
public static void getSubString(String s,int k){
    int length=s.length();
    int hasFound[]=new int[26];
    int maxWindowSize = Integer.MIN_VALUE, unique=0;
    String str=null;
    for (int currStart=0,currEnd=0; currEnd < length; currEnd++) {
        char c = s.charAt(currEnd);
        if(hasFound[c-'a']==0) unique++;
        hasFound[c-'a']++;
        if(unique>k) {
            int prevCurrStart = currStart;
            while (unique > k) {
                while (hasFound[s.charAt(prevCurrStart) - 'a'] != 0) {
                    hasFound[s.charAt(currStart) - 'a']--;
                    prevCurrStart = currStart;
                    currStart++;
                }
                unique--;
            }
        }
        else if (unique==k){
            int len=currEnd-currStart+1;
            if(len>maxWindowSize)  {
                maxWindowSize=len;
                str=s.substring(currStart,currEnd+1);
            }
        }
    }

    if(unique<k)
        System.out.println("Not enough chars");
    else System.out.println(str);
}

	//uses set
	public static void getSubStringSet(String s, int k) {
		int length = s.length();
		HashSet<Character> set = new HashSet<Character>();
		int maxWindowSize = Integer.MIN_VALUE;
		String str = null;
		int start = 0;
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (!set.contains(c)) {
				set.add(c);
			}
			if (set.size() > k) {
				while (set.size() > k && set.contains(s.charAt(start))) {
					set.remove(s.charAt(start));
					start++;
				}
			} else if (set.size() == k) {
				if (maxWindowSize < i - start + 1) {
					maxWindowSize = i - start + 1;
					str = s.substring(start, i + 1);
				}
			}
		}
		if (set.size() < k)
			System.out.println("Not enough chars");
		else
			System.out.println(str);
	}

}