package Strings2;

import java.util.HashMap;

import org.xml.sax.HandlerBase;

public class sumofallnumberspresentinstring {
/*//http://www.geeksforgeeks.org/calculate-sum-of-all-numbers-present-in-a-string/
//O(n)
 * https://www.careercup.com/question?id=5766700180963328
	Input:  1abc23
	Output: 24*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int calsum(String s){
		s = "1abc23";
		s = s.replaceAll("\\D", "");
		int result = 0;
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			Character c = s.charAt(i);
			if(Character.isDigit(c)){
				temp.append(c);
			}else{
				if(temp.length() != 0) result += Integer.parseInt(temp.toString());
				temp.setLength(0);
			}			
		}
		if(temp.length() != 0)
		result += Integer.parseInt(temp.toString());;
		return result;		
	}
	
	public static int cal(String s){
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("zero", "0");
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		
		StringBuilder sb = new StringBuilder();
		int temp;
		
		for(int i = 0; i < s.length(); i++){
			
			
		}
		return 0;
		
	}
}
