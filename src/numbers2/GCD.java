package numbers2;
/*
 * https://www.geeksforgeeks.org/c-program-find-gcd-hcf-two-numbers/
 * GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides both of them.
 * GCD of two numbers doesn’t change if smaller number is subtracted from a bigger number.
 */
public class GCD {

	public static void main(String[] args) {
		 int a = 98, b = 56;
	     System.out.println("GCD of " + a +" and " + b + " is " + findGCD(a, b));
	     System.out.println(findGCDNnumbers(new int[] {2,4,10,6,8}));
	}

	public static int findGCD(int a, int b){
		if(a == 0 || b == 0)
			return 0;
		if(a == b)
			return a;
		
		if(a > b)
			return findGCD(a-b, b);
		else
			return findGCD(a, b-a);
	}
	
	/*
	 * https://www.geeksforgeeks.org/gcd-two-array-numbers/
	 */
	public static int findGCDNnumbers(int[] arr){
		int result = arr[0];
		for(int i = 1; i < arr.length; i++){
			result = gcd(arr[i], result);
		}
		return result;
	}
	
	public static int gcd(int a, int b){
		if(a == 0) return b;
		return gcd(b%a, a);
	}
	
	//ITERATIVE
static int gcd(int a, int b){
  if(a == 0 || b == 0) return a+b; // base case
  return gcd(b,a%b);
}

//Using a while loop:
static int gcd(int a, int b){
  while(a!=0 && b!=0){// until either one of them is 0
     int c = b;
     b = a%b;
     a = c;
  }
  return a+b; // either one is 0, so return the non-zero value
}
}
