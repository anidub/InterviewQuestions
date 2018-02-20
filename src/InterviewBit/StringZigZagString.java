package InterviewBit;

import java.util.ArrayList;
import java.util.List;

public class StringZigZagString {
//https://www.interviewbit.com/problems/zigzag-string/	
//http://www.programcreek.com/2014/05/leetcode-zigzag-conversion-java//
//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this :PAHNAPLSIIGYIR	
	
	public static void main(String[] args) {
		System.out.println(convert("ABCDEFGH",4));
	}
	//studied
public static String convert(String A, int numRows) {	    
	    if (numRows <= 1)  return A;	    
	    ArrayList<StringBuilder> str = new ArrayList<StringBuilder>();
	    int n = A.length();
	    StringBuilder s;	    
	    for (int i = 0; i < numRows; i++)
	        str.add(new StringBuilder());
        int row = 0;
        int add = 1;        
        for (int i = 0; i < n; i++) {
            s = str.get(row);
            s.append(A.charAt(i));
            row += add;
            if (row == numRows - 1)
                add = -1;
            else if (row == 0)
                add = 1;
        }	    
	    StringBuilder res = new StringBuilder();	    
	    for (StringBuilder ss : str)
	        res.append(ss);	    
	    return res.toString();	    
	}

public static String converta(String s, int numRows) {
	if (numRows == 1)		return s;
 
	StringBuilder sb = new StringBuilder();
	// step
	int step = 2 * numRows - 2;
 
	for (int i = 0; i < numRows; i++) {
		//first & last rows
		if (i == 0 || i == numRows - 1) {
			for (int j = i; j < s.length(); j = j + step) {
				sb.append(s.charAt(j));
			}
		//middle rows	
		} else {
			int j = i;
			boolean flag = true;
			int step1 = 2 * (numRows - 1 - i);
			int step2 = step - step1;
 
			while (j < s.length()) {
				sb.append(s.charAt(j));
				if (flag)
					j = j + step1;
				else
					j = j + step2;
				flag = !flag;
			}
		}
	} 
	return sb.toString();
}
}