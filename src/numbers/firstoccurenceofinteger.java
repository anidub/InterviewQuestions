package numbers;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//program to find first occurence of a digit in a string
public class firstoccurenceofinteger {

	public static void main(String[] args) {
		String input = "abc321ccs56sd";
			
		Matcher m = Pattern.compile("[^0-9]*([0-9]+).*").matcher(input);
		if (m.matches()) {
		    System.out.println(m.group(1));
		}
	
		
		
		int res = new Scanner("Str87uyuy232").useDelimiter("\\D+").nextInt();
		System.out.println(res);

	}

}
