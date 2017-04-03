package numbers;

public class stringprintwithspace {
//print new characters on diff line and same on same line
	public static void main(String[] args) {
		String s1 = "abcc";
		/*for(int i = 0; i <= s1.length(); i++){
			if(s1.charAt(i) == s1.charAt(i+1)){
				System.out.println(s1.charAt(i) + " " + s1.charAt(i+1));
			}else{
				System.out.println(s1.charAt(i));
			}
		}*/

		for(int i = 0; i < s1.length(); i++){
			for(int j = i + 1; j < s1.length(); j++){
			if(s1.charAt(i) == s1.charAt(j)){
				System.out.println(s1.charAt(i) + " " + s1.charAt(j));
			}
			}
			//	System.out.println(s1.charAt(i));
			
		
		
	}

}
}