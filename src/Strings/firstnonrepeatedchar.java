package Strings;

import java.util.LinkedHashMap;

public class firstnonrepeatedchar {

	public static void main(String[] args) {
		String s = "Helo How are you ? ";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		for(char c : map.keySet()){
			if(map.get(c) == 1){
				System.out.println(c);
				return;
			}
		}
	}
}