package Strings;

public class stringissubstring {

	public static void main(String[] args) {
		String s1 = "Hello World";
		String s2 = "Woorld";
		String temp = s1 + s1;
		/*if(temp.contains(s2)){
			System.out.println("S2 is a substring of s1 ");
		}else{
			System.out.println("S2 is not a substring of s1 ");
		}*/
		
		int n = temp.indexOf(s2);
		if(n != -1){
			System.out.println("s2 is a substring of s1");
		}else{
			System.out.println("s2 is not a substring of s1");
		}
	}	
}