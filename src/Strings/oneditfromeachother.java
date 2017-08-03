package Strings;

public class oneditfromeachother {

	
	//Given two strings, return true if they are one edit away from each other, else return false. An edit is insert/replace/delete a character. 
//	Ex. {"abc","ab"}->true, {"abc","adc"}->true, {"abc","cab"}->false
	
	public static void main(String[] args) {
	
		String first = "abc";
		String second = "abd";
		int c = 0;
		boolean flag = true;
		int lengthdiff = first.length() > second.length() ? first.length() - second.length() : second.length() - first.length();
		if(lengthdiff <= 1){
			int length = first.length() > second.length() ? second.length() : first.length();
			 	for(int i = 0; i < length; i++){
			 		if(first.charAt(i) == second.charAt(i));
			 		else{
			 			c++;
			 		}
			 		if( c > 1){
			 			flag = false;
			 			break;
			 		}
			 	}
			 	if(flag){
			 		System.out.println("It is");
			  	}else{
			  		System.out.println("It isn't");
			  	}
		}else{
			System.out.println("It isnt");
		}
}
}
