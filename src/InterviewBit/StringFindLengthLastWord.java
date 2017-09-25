package InterviewBit;

public class StringFindLengthLastWord {
//https://www.interviewbit.com/problems/length-of-last-word/
/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.Given s = "Hello World",return 5 as length("World") = 5.*/
//or can be framed like implement splitter for strings on space	
	public static void main(String[] args) {
		System.out.println(getlast("Hello Wordl  "));
	}	
	public static int getlast(String s){
		if(s == null || s.length() == 0)return 0;
		if(s.length() == 1 && s.charAt(0) == ' ') return 0;
		int i = s.length()-1;
		while(i >= 0 && s.charAt(i) == ' '){
			i--;
		}
		StringBuilder sb = new StringBuilder();
		int space = 1;
		while(i > -1){
			char c = s.charAt(i);
			if(s.charAt(i) == ' '){
				space++;
			}
			if(space > 1) break;
			sb.append(s.charAt(i));
			i--;
		}
		if(sb.length() > 0)		
		return sb.toString().length();		
		return 0;
	}
}
