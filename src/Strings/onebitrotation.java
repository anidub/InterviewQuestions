package Strings;

public class onebitrotation {

	public static void main(String[] args) {
		String s1 = "Hello";
		
		char[] a1 = s1.toCharArray();
		char temp = a1[a1.length - 1]; //o
		char[] a2 =  new char[a1.length];
		a2[0] = temp;
		for(int i = 0; i < a1.length - 1; i++){
			a2[i + 1] = a1[i];  
		}
			System.out.println(a2);
	}
}
