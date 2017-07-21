package Strings2;

public class excelRows {
/*
 * How would you convert a row number on Excel to a label? 
 * Rows are labeled alphabetically with letters added on once the alphabet has been fully used. 
 * (Ex. row # 5 is labeled E, row # 27 is labeled AA, row # 28 is AB, 
 * row # 53 is BA and so forth) What would the row label be for a large number, such as 1500?
 */
	public static void main(String[] args) {	
		getRowLabel(52);
	}
static int ASCII_CONST = 64;
static StringBuilder sb = new StringBuilder();

public static int getRowLabel(int number){
	if(number == 0){
		sb = sb.reverse();
		System.out.println(sb);
	}
	
	int remainder = number % 26;
	if(remainder == 0){
		remainder = 26;
		number = number-1;
	}
	
	int lastchar = ASCII_CONST  + remainder;
	String s = new Character((char) lastchar).toString();
	sb.append(s);
	return getRowLabel(number/26);
}
}
