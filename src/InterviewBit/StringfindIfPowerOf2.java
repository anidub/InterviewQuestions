package InterviewBit;

import java.util.HashSet;
import java.util.Set;

public class StringfindIfPowerOf2 {
//http://javarevisited.blogspot.com/2013/05/how-to-check-if-integer-number-is-power-of-two-example.html
//https://www.interviewbit.com/problems/power-of-2/	
/*	Find if Given number is power of 2 or not. 
	More specifically, find if given number can be expressed as 2^k where k >= 1.*/
	public static void main(String[] args) {
		System.out.println(power("32"));
	}
	
	public static Integer power(String s){//my solution
		Set<Long> hs = new HashSet<Long>();
		hs.add((long) 2);hs.add((long) 4);hs.add((long) 8);hs.add((long) 6);
		Long i = null;
		try {
			i = Long.parseLong(s);
		} catch (NumberFormatException e) {
			return 0;
			//e.printStackTrace();
		}
		if(i == 1) return 1;
		while( i > 1){
			long  k = i % 10;
			if(!hs.contains(k)) return 0;
			else{
				i = i / 2;
			}
		}
		return 1;
	}
}
