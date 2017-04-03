	package Strings;

import java.util.HashSet;
import java.util.Set;

public class removeduplchars {

	
	//remove duplicate characters
	public static void main(String[] args) {
			
		String original = "AABBC";
		System.out.println(original);
		
		Set<Character> charset = new HashSet<Character>();
		for(char c : original.toCharArray()){
			charset.add(c);
		}
		StringBuilder sb = new StringBuilder();
		for(char c : charset){
			sb.append(c);	
			
		}
		System.out.println(sb.toString());
		//System.out.print(c);
	}

}
