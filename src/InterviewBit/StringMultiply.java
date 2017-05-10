package InterviewBit;

public class StringMultiply {
//https://www.interviewbit.com/problems/multiply-strings/
/*	
	Given two numbers represented as strings, return multiplication of the numbers as a string.
			 Note: The numbers can be arbitrarily large and are non-negative.
			Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer. 
			For example, 
			given strings "12", "10", your answer should be “120”.*/
	public static void main(String[] args) {
		System.out.println(multiplya("12","13"));
	}
	//studied/http://www.jiuzhang.com/solutions/multiply-strings/
		public static String multiplya(String num1, String num2) {
	        if (num1 == null || num2 == null) return null;        
	        int len1 = num1.length(), len2 = num2.length();
	        int len3 = len1 + len2;
	        int i, j, product, carry;

	        int[] num3 = new int[len3];
	        for (i = len1 - 1; i >= 0; i--) {
	            carry = 0;
	            for (j = len2 - 1; j >= 0; j--) {
	                product = carry + num3[i + j + 1] +
	                    Character.getNumericValue(num1.charAt(i)) *
	                    Character.getNumericValue(num2.charAt(j));
	                num3[i + j + 1] = product % 10;
	                carry = product / 10;
	            }
	            num3[i + j + 1] = carry;
	        }
	        StringBuilder sb = new StringBuilder();
	        i = 0;
	        while (i < len3 - 1 && num3[i] == 0)   i++;
	         while (i < len3)
	            sb.append(num3[i++]);
	        return sb.toString();
	    }
		
	//http://www.programcreek.com/2014/05/leetcode-multiply-strings-java/	
	public static String multiply(String num1, String num2) {
	    String n1 = new StringBuilder(num1).reverse().toString();
	    String n2 = new StringBuilder(num2).reverse().toString();
	 
	    int[] d = new int[num1.length()+num2.length()];
	 
	    //multiply each digit and sum at the corresponding positions
	    for(int i=0; i<n1.length(); i++){
	        for(int j=0; j<n2.length(); j++){
	            d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
	        }
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    //calculate each digit
	    for(int i=0; i<d.length; i++){
	        int mod = d[i]%10;
	        int carry = d[i]/10;
	        if(i+1<d.length){
	            d[i+1] += carry;
	        }
	        sb.insert(0, mod);
	    }
	 
	    //remove front 0's
	    while(sb.charAt(0) == '0' && sb.length()> 1){
	        sb.deleteCharAt(0);
	    }
	 
	    return sb.toString();
	}
}
