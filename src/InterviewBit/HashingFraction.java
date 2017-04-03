package InterviewBit;

import java.util.HashMap;
import java.util.Map;
/*https://www.interviewbit.com/problems/fraction/
http://www.programcreek.com/2014/03/leetcode-fraction-to-recurring-decimal-java/
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"*/
public class HashingFraction {
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1,3));

	}
	 public static String fractionToDecimal(int numerator, int denominator) {
	        long a=numerator,b=denominator;
	        if(a%b==0) return String.valueOf(a/b);//if no decimal, return
	        Map<Long,Integer> map=new HashMap<Long,Integer>();
	        StringBuilder res=new StringBuilder();
	        if((a>0&&b<0)||(a<0&&b>0)) res.append("-");//if negative
	        a=Math.abs(a);
	        b=Math.abs(b);
	        res.append(a/b+".");//add decimal
	        a=(a%b)*10;
	        while(!map.containsKey(a)){
	            map.put(a,res.length());//putting length coz to track where recurring starts
	            res.append(String.valueOf(a/b));
	            a=(a%b)*10;
	            if(a==0) return res.toString();//if no recurring
	        }
	        return res.insert(map.get(a),"(").append(")").toString();//if recurring
		}
}
