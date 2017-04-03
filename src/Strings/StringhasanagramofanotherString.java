package Strings;

import java.util.HashMap;

public class StringhasanagramofanotherString {

	public static void main(String[] args) {
		String s1 = "Hello"; //parent
		String s2 = "oleHwfl"; //child
		
		System.out.println(checkifstringcontainsanagram(s1,s2));
		
	}
	
	public static boolean checkifstringcontainsanagram(String s1, String s2){
		HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
		for(int i = 0; i < s1.length(); i++){
			char c = s1.charAt(i);
			if(hm1.containsKey(c)){
				hm1.put(c, hm1.get(c) + 1);
			}else{
				hm1.put(c,1);
			}
			
		}
		
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
		for(int i = 0; i < s2.length(); i++){
			char c = s2.charAt(i);
			if(hm2.containsKey(c)){
				hm2.put(c, hm2.get(c) + 1);
			}else{
				hm2.put(c,1);
			}
		}
		
		
		boolean found = true;		
		for(Character k : hm2.keySet()){
			if(!(hm1.containsKey(k))) {found = false; return found;}
		}
		
		if(hm2.size() > hm1.size()) {found = false;return found;}
		
		for(Character k : hm2.keySet()){
			 if (hm2.get(k) > hm1.get(k)) {
	                found = false; return found;
	            }
		}
		return found;
	}
}
