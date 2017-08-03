package InterviewBit;

public class StringCountAndSay {
/*	http://www.programcreek.com/2014/03/leetcode-count-and-say-java/
	http://www.geeksforgeeks.org/look-and-say-sequence/
	https://www.interviewbit.com/problems/count-and-say/
	The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.
21 is read off as one 2, then one 1 or 1211.*/
	public static void main(String[] args) {
		System.out.println(countandSay(4));
	}
	
	public static String countandSay(int n){
	    // Base cases
	    if (n == 1)      return "1";
	    if (n == 2)      return "11";
		String result = "1";
		int i = 1;
		while(i < n){
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for(int j = 1; j < result.length(); j++){
				if(result.charAt(j) == result.charAt(j-1))
					count++;
				else{			
					sb.append(count).append(result.charAt(j-1));
					count = 1;
				}
			}
			sb.append(count).append(result.charAt(result.length()-1));
			result = sb.toString();
			i++;
		}
		return result;
	}	
}