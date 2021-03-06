package numbers2;

import java.math.BigDecimal;
//Double  has a certain precision, while BigDecimal is an exact representation of a number. 
//Double in sensible math operations might lead to some loss of data, especially when different orders of magnitude(10k vs 0.00001) are in the same operations.
/*float 4 bytes 7 decimal digits.
double 8 bytes 16 decimal digits.
The disadvantage of BigDecimal is that it's slower, and it's a bit more difficult to program algorithms that way (due to + - * and / not being overloaded).
If you are dealing with money, or precision is a must, use BigDecimal. Otherwise Doubles tend to be good enough.*/

public class roundup {
	public static void main(String[] args) {
		double f = 76.51445;
		double g = 76.2266;
		//roundupnum(f,2);
		System.out.println();
		//roundupnum(g,3);
		
		//round(g,3);// 75.52
		double a = 5.455;
		round(a,2);
	}

	
/*	public static void round(double f, int num){
		System.out.println(f);
		
		int k = 1;int n = num;
		while(num > 0){
			k = k * 10; num--;
		}
		BigDecimal bd = new BigDecimal(f);
		 bd = bd.multiply(new BigDecimal(k));
		 BigDecimal pointfive = new BigDecimal(0.5);
		 bd = bd.add(pointfive);
		 bd = bd.divide(new BigDecimal(k));
		 System.out.println(bd);
		 String t = bd + "";int i = 0;
		 for(i = 0; i < t.length(); i++){
			 if(t.charAt(i) == '.'){
				 System.out.println(i+1+n);
				 System.out.println(t.substring(0,i+1+n));break;
			 }
		 }
		 BigDecimal finalNum = new BigDecimal(t.substring(0,i+1+n));
		 System.out.println(finalNum);
	}*/
	
	//tested//works !!//ask lot of questions on how many digits and input is less than that etc accordingly add
	// null and length conditions
	public static void round(double f, int num){
		System.out.println(f);
		String arr[] = String.valueOf(f).split("\\.");
		String nextHalf = arr[1];
		Float next = Float.parseFloat(nextHalf.substring(0, num+1));
		int nextDigit = nextHalf.charAt(nextHalf.length()-1) - '0';
		Float lastKdigits = Float.parseFloat(nextHalf.substring(0, num)); 
		if(nextDigit > 5)
			lastKdigits++;
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]+".").append(lastKdigits);
		String result = sb.toString();
		System.out.println(result.substring(0, result.length()-2));
	}
}
