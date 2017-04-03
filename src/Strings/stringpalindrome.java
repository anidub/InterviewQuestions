package Strings;

public class stringpalindrome {

	public static void main(String[] args) {
		String s1 = "abwcba";
		String s2 = "";
		for(int i = s1.length()-1; i >= 0; i--){
			s2 = s2 + s1.charAt(i);
		}
		System.out.println("s2 is " + s2);
		if(s1.equals(s2)){
			System.out.println("palindrome");
		}else
			System.out.println("Not palindrome");
	}

}
