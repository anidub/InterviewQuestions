package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class sourcepattern {
	//also known as implementation of indexOf and Contains

	public static void main(String[] args) {
		String source = "I like to go to school";
		String pattern = "t o";
		System.out.println(find(source,pattern));
		allmatches();
	}
	
	public static boolean find(String source, String pattern){
		for(int i = 0; i < source.length() - pattern.length(); i++){
			boolean found = true;
			for(int f = 0; f < pattern.length(); f++){
				char s = source.charAt(i+f);
	        	char p = pattern.charAt(f);
				if(pattern.charAt(f) != source.charAt(i+f)){
					found = false;
					break;
				}
			}
			if(found){
				System.out.println("Start index = " + (i-1));
				System.out.println("End index = " + (i + pattern.length()-1));
				return true;
			}
		}
		return false;
	}
	
	// if you want all matches
	public static void allmatches(){
	  String pattern = "abc";
	    String letters = "defabcdefabc";
	    int i = 0;
	    List<Integer> matches = new ArrayList();
	    while (i <= letters.length() - pattern.length()) {
	        if (letters.substring(i, i + pattern.length()).equals(pattern))
	            matches.add(i);
	        i += 1;
	    }
	    System.out.println(matches.size());
	}
}
