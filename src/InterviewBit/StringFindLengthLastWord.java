package InterviewBit;

public class StringFindLengthLastWord {
//https://www.interviewbit.com/problems/length-of-last-word/
/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.Given s = "Hello World",return 5 as length("World") = 5.*/
//or can be framed like implement splitter for strings on space	
	public static void main(String[] args) {
		System.out.println(getLastLength("Wordl  "));
	}
	
	public static int getLastLength(String a){ //O(N)
		if(a.length() == 0) return 0; 
		if(a.length() == 1) return 1;
		StringBuilder sb = new StringBuilder();
		int i = a.length()-1;
		while(a.charAt(i) != ' ' || i > -1){
				if(a.charAt(i) != ' '){
					sb.append(a.charAt(i));
					}
				i--;
				if(i < 0)break;
		}
		if(sb.length() > 0) return sb.length();
		else return 0;
		
	}
}
