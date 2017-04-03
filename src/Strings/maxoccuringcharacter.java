package Strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class maxoccuringcharacter {

	public static void main(String[] args) {
		String s = "Sample String";
		int[] count = new int[256];//Since a char value can hold one of only 256 different values,
		//any string that's longer than 256 characters must contain at least one duplicate.
		
		for(int i = 0; i < s.length(); i++){
			count[s.charAt(i)]++;
		}
		int max = 1;
		char result = ' ';
		for(int i = 0; i < s.length(); i++){
			if(count[s.charAt(i)] > max){
				max = count[s.charAt(i)];
				result = s.charAt(i);
			}
		}
		
		System.out.println(result);
		getmax(s);

	}
	
	public static void getmax(String s){
		int[] count = new int[256];
		for(int i = 0; i < s.length(); i++){
			count[s.charAt(i)]++;
		}
		
		int max = 1;
		char result = ' ';
		for(int i = 0; i < s.length(); i++){
			if(count[s.charAt(i)] > max){
				max = count[s.charAt(i)];
				result = s.charAt(i);
			}
		}
		
		
		//same thing but using hashmap
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0)+1);
		}
		int maxa = (Collections.max(hm.values()));
		
		for(Entry<Character, Integer> entry : hm.entrySet()){
			if(entry.getValue() == maxa){
				System.out.println(entry.getKey());
			}
		}
		System.out.println(result);
		
	}

}
