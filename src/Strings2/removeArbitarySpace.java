package Strings2;

public class removeArbitarySpace {

	//bloomberg interview
	/*
	 * Remove arbitary spaces from a sentence
	 */
	public static void main(String[] args) {
		remove();
	}
	
	public static void remove(){
		String s = "The sky    is   blue";
		StringBuilder sb = new StringBuilder();
		boolean  isSpace = true;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != ' '){
				sb.append(s.charAt(i));
				isSpace = false;
			}else if(!isSpace){
				isSpace = true;
				sb.append(" ");
			}
		}		
		System.out.println(sb.toString());
	}
}
