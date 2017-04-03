package InterviewBit;

public class StringImplementAtoI {
//http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
//https://www.interviewbit.com/problems/atoi/  Implement atoi to convert a string to an integer.
	public static void main(String[] args) {//O(N)
		System.out.println(implementAtoi("123 11"));
	}
	public static int implementAtoi(String a){
		if(a == null || a.length() < 1) return 0;
		a = a.trim();
		
		char flag = '+';
		int i = 0;
		if(a.charAt(i) == '-'){
			flag = '-';
			i++;
		}else if (a.charAt(i) == '+'){
			i++;
		}
		
		double result = 0;
		while(i < a.length() && a.charAt(i) >= '0' && a.charAt(i) <= '9'){
			result = result * 10 + (a.charAt(i) - '0');
			i++;
		}
		if(flag == '-') result = -result;
		if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		else if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		return (int) result;
	}
}
