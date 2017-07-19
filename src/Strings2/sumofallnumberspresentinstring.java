package Strings2;

import java.util.ArrayList;
import java.util.HashMap;

public class sumofallnumberspresentinstring {
/*//http://www.geeksforgeeks.org/calculate-sum-of-all-numbers-present-in-a-string/
//O(n)
 * https://www.careercup.com/question?id=5766700180963328
	Input:  1abc23
	Output: 24*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calsum("");
		cal("");
	}
	
	public static int calsum(String s){
		s = "1abc23";
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
		System.out.println(result);
		return result;		
	}
	
	public static int cal(String s){
		//correct answer
		String inputStr = "xyzonexyztwothreeeabrminussevenskdjjtwozerodone";
        int i=0, sum=0;
        String currString = "";
        
        inputStr =inputStr.replace("one", "1");
        inputStr =inputStr.replace("two", "2");
        inputStr =inputStr.replace("three", "3");
        inputStr =inputStr.replace("four", "4");
        inputStr =inputStr.replace("five", "5");
        inputStr =inputStr.replace("six", "6");
        inputStr =inputStr.replace("seven", "7");
        inputStr =inputStr.replace("eight", "8");
        inputStr =inputStr.replace("nine", "9");
        inputStr =inputStr.replace("zero", "0");
        inputStr =inputStr.replace("minus", "-");
        
        while(i<inputStr.length()) {
			if (inputStr.charAt(i) >= '0' && inputStr.charAt(i) <= '9' || inputStr.charAt(i) == '-') {
				currString = currString + inputStr.charAt(i);
				i++;
			} else {
				if (currString != "") {
					sum = sum + Integer.parseInt(currString);
					currString = "";
				}
				i++;
			}
		}
        
        if(currString != "")
            sum = sum + Integer.parseInt(currString);
        
         System.out.println(sum);
         return -1;
		/*
		 * half answer
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("zero", "0");
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		map.put("four", "4");
		s = "xyzoneyctwothreefourvone";
		int temp;
		StringBuilder strB = new StringBuilder();
		ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
		StringBuilder strB1 = new StringBuilder();
		boolean isNum = false;

		for (int i = 0; i <= s.length() - 1; i++) {
			strB.append(s.charAt(i));
			if (strB.length() >= 3 && map.containsKey(strB.toString())) {
					isNum = true;
					strB1.append(map.get(strB.toString().toLowerCase()));
					strB = new StringBuilder();
				} else if (strB.length() > 5) {
					isNum = false;
					strB1.append("+");
					strB = new StringBuilder();
					i = i - 5;
				}
			}
		
		
		System.out.println(strB1.toString());
		System.out.println("------");		
	*/}
}
