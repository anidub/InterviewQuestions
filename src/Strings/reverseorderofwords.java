package Strings;

public class reverseorderofwords {

	public static void main(String[] args) {
		/*
		String s1 = "Cats like Dogs";
		String s2 = "";
		String[] str = s1.split(" ");
		for(int i = str.length - 1; i >= 0; i--){
			s2 = s2 + str[i] + " ";
		}
		System.out.println(s2);
	*/
		String s = "Hi there.";
		String[] str = s.split("");
		System.out.println(ReverseTheWords(s));
		
	}
	
	public static String ReverseTheWords(String str){
		if(str == null || str == " ")
			return str;
		boolean hasperiod = str.endsWith(".");
		if(hasperiod)
			str = str.substring(0, str.length() - 1);
		String[] array = str.split(" ");
		
		StringBuilder sb = new StringBuilder();
		for(int i = array.length - 1; i > 0; i--){
			sb.append(array[i] + " ");
		}
		sb.append(array[0]);
		if(hasperiod)
			sb.append(".");
			return sb.toString();							
	}	
}