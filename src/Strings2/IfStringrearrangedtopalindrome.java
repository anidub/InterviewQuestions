    package Strings2;

import java.util.HashMap;
import java.util.Map.Entry;

public class IfStringrearrangedtopalindrome {
//http://quiz.geeksforgeeks.org/check-characters-given-string-can-rearranged-form-palindrome/
	//check if the string can be re arranged to form a palindrome
	//O(n)
	public static void main(String[] args) {
		String s = "abbcac";
		System.out.println(canBeRearrangedtoPalindrome(s));
		System.out.println(rearrangetoPalindrome(s));

	}
	
	public static boolean canBeRearrangedtoPalindrome(String s){
		if(s.length() == 0) return false;
		if(s.length() == 1) return true;
		
		// For each character in input strings, increment count in the corresponding count array
		int[] count = new int[256];
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			count[c]++;
		}
		// Count odd occurring characters
		int odd = 0;
		for(int i = 0; i < 256; i++){
				if(count[i] % 2 == 1)
					odd++;  
		}
		 // Return true if odd count is 0 or 1, otherwise false
		return odd <= 1;	
	}
	
	
	public static String rearrangetoPalindrome(String s){
		if(s.length() == 0 || s == null || s == "") return null;
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(hm.containsKey(c)){
				hm.put(c,hm.get(c)+1);
			}else
				hm.put(c,1);
		}
		
		int oddcount = 0;
		for(Entry<Character, Integer> entry : hm.entrySet()){
			if(entry.getValue() % 2  != 0) oddcount++;
			if(oddcount > 1) return "Invalid Input";
		}
		
		int middle = s.length()/2;
		StringBuilder result = new StringBuilder();
		Character middlechar = null;
		for(Entry<Character, Integer> entry : hm.entrySet()){
				int charCount = entry.getValue();
				char c = entry.getKey();
				if(charCount % 2  != 0){
					middlechar = c;
				}
				int i = charCount/2;
				while(i > 0){
					result.append(c);
					result.insert(0,c);
					i--;
				}
		}	
		if(middlechar != null) result.insert(middle,middlechar);
		return result.toString();	
	}
}