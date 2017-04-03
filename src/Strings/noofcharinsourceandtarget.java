package Strings;

import java.util.HashSet;
import java.util.Set;

public class noofcharinsourceandtarget {

	public static void main(String[] args) {
		String source = "Hello";
		String target = "el";
		char[] a1 = source.toCharArray();
		char[] a2 = target.toCharArray();
		Set<Character> charset = new HashSet<Character>();
		int count = 0;
		
		for(char a : a1){
			charset.add(a);
		}
		for(char a : a2){
			if(charset.contains(a)){
				count++;
			}
		}
		System.out.println(count);
	}

}
