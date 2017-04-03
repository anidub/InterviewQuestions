package Strings;

import java.util.HashSet;
import java.util.Set;

public class firstnonrepeatedchar {

	public static void main(String[] args) {
		String s = "Helo How are you ? ";
		Set<Character> stringmap = new HashSet<Character>();
		for(int i = 0; i < s.length(); i++){
			if(stringmap.contains(s.charAt(i))){
				System.out.println(s.charAt(i));
				break;
			}else
				 stringmap.add(s.charAt(i));
		}
	}

}
