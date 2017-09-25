package Strings2;

public class preserveSpaces {
///preserve spaces where they are and reverse words
	public static void main(String[] args) {
		String orig = "    Hello   World  I  a";
		System.out.println(preserveSpaces(orig));
	}
	
	public static String preserveSpaces(String input){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			if(input.charAt(i) == ' '){
				sb.append(" ");
			}else{
				int endIndex = i;
				while(endIndex < input.length() && input.charAt(endIndex) != ' '){
					endIndex++;
				}
				String reverse = reverse(input.substring(i,endIndex));
				i = endIndex-1;		
				sb.append(reverse);
			}
		}
		return sb.toString();		
	}
	
	public static String reverse(String input){
		StringBuilder sb = new StringBuilder();
		for(int i = input.length()-1; i >= 0; i--){
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}
}
