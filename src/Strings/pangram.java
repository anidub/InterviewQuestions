package Strings;

public class pangram {
//program to check pangram...each letter once
	public static void main(String[] args) {
			String s = "the quick brown fOx jumps over the lazy dog";
			System.out.println(isPangram(s));
		
	}

	 public static boolean isPangram(String test){
	        for (char a = 'A'; a <= 'Z'; a++)
	            if ((test.indexOf(a) < 0) && (test.indexOf((char)(a + 32)) < 0))
	                return false;
	        return true;
	    }

}
