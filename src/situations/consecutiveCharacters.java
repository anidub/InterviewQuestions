package situations;

import java.util.ArrayList;

public class consecutiveCharacters {
/**
 * https://www.careercup.com/question?id=5766711472029696
 * Write a function that receives a string an returns a list of all the substrings (of length >= 2) 
 * composed by consecutive characters. E.g input : "BCCDE" , output: ["BC","CD","CDE","DE"]
 * @param args
 */
	public static void main(String[] args) {
		ArrayList<String> intList = getConsecutiveLettersinString("BCCDE");

	}
	public static ArrayList<String> getConsecutiveLettersinString(String str) {
        ArrayList<String> lst = new ArrayList<String>();

        outer : for(int outer_index = 0; outer_index < str.length(); outer_index++){
			int start_index = str.charAt(outer_index);
			for(int inner_index = outer_index+1; inner_index < str.length(); inner_index++){
				if(start_index < str.charAt(inner_index)){
					lst.add(str.substring(outer_index, inner_index + 1));
					start_index = str.charAt(inner_index);
				}else{
					continue outer;
				}
			}
		}
		//return lst;
        for(String k : lst) System.out.println(k);
        return lst;
    }
}
