package InterviewBit;

public class StringIsNumeric {
//http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
//	https://www.interviewbit.com/problems/valid-number/ 
	public static void main(String[] args) {
		System.out.println(isNumeric("123.2.3"));
	}

	public static boolean isNumeric(String s){ //O(N)
		if(s == null || s.length() < 1) return false;
		int count = 0;
		boolean isNumeric = true;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if( c == '.' || c == 'e' || c == 'E' || c == ' ' ){
				count++;
				if(count < 2) isNumeric = true;
				else {isNumeric = false; break;}
			} else if( c >= '0' || c <=  '9') isNumeric = true;
			else{
				isNumeric = false;
				break;
			}
		}
		return isNumeric;
	}
}
