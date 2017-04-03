package InterviewBit;

import java.util.HashMap;

public class StringRomanToInteger {//MMCLXXIII
	//https://www.interviewbit.com/problems/roman-to-integer/
	public static void main(String[] args) {
		System.out.println(romanToIntA("XIV")); 
	}
	
	//works...but difficult to remember the order of codes[]//solution from interviewbit
	public static int romanToIntA(String A) {
	    int i=0;
        int ret=0;
        String codes[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int val[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        while(A.length()>0)  {	
        	if(i > codes.length) return -1;
            while(i < codes.length && A.startsWith(codes[i]) )
            {
                ret+=val[i];
                A=A.substring(codes[i].length());
            }
            i++;
        }
        return ret;
	}
	
	
	//Works for true cases...fails for other test cases..however if the order of codes is not given then use this
	//https://longwayjade.wordpress.com/2015/05/06/leetcode-java-solution-mathstring-roman-to-integer/
	public int romanToInt(String s) {
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		dict.put('I', 1);dict.put('V', 5);dict.put('X', 10);dict.put('L', 50);
		dict.put('C', 100);dict.put('D', 500);dict.put('M', 1000);
		int res = 0;
		int i = 0;
		for (i = 0; i < s.length() - 1; i++) {
			if (dict.get(s.charAt(i)) >= dict.get(s.charAt(i + 1))) {
				res += dict.get(s.charAt(i));
			} else {
				res -= dict.get(s.charAt(i));
			}
		}
		res += dict.get(s.charAt(i));
		return res;
	}
}
