package Strings;

import java.util.HashMap;
import java.util.Map;

public class numberofcharinstring {

	public static void main(String[] args) {
		String s1 = "Hello";
		Map<Character,Integer> charmap = new HashMap<Character,Integer>();
		char[] a1  = s1.toCharArray();
		for(char c : a1){
			if(charmap.containsKey(c)){
				charmap.put(c,charmap.get(c) + 1);
			}else
				charmap.put(c,1);
		}
		
		for(char c : a1){
			charmap.put(c,charmap.getOrDefault(c,0) + 1);
		}
		System.out.println(charmap);
	}
}
