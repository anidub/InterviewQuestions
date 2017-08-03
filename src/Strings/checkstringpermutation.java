package Strings;

public class checkstringpermutation {

	public static void main(String[] args) {
		//String s1 = "Hello";
		//String s2 = "lloeH";
		String s1 = "aaaaaaaaaaabb";
		String s2 = "aaabbbbbbbbbb";
		if(s1.length() != s2.length()){
			System.out.println("Not permutations");
		}
		System.out.println(ispermutation(s1,s2));
	}
		public static boolean ispermutation(String s1,String s2){
			int[] count = new int[256];
			for(int i = 0; i < s1.length(); ++i){
				++count[s1.charAt(i)];
			}
			for(int i = 0; i < s1.length(); ++i){
				if(--count[s2.charAt(i)] < 0){
					return false;
				}
			}
			return true;
		}
}