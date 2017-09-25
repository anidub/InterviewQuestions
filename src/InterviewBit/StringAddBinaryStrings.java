package InterviewBit;

public class StringAddBinaryStrings {
//http://www.programcreek.com/2014/05/leetcode-add-binary-java/
//https://www.interviewbit.com/problems/add-binary-strings/	
/*	Given two binary strings, return their sum (also a binary string)
			a = "100"
			b = "11"
			Return a + b = “111”.*/		
	public static void main(String[] args) {
		System.out.println(addBinary("1001","11"));
	}
	
	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();	 
	    int i=a.length()-1; int j=b.length()-1;	 
	    int carry = 0;	 
	    while(i>=0 || j>=0){
	        int sum=0;	 
	        if(i>=0 && a.charAt(i)=='1'){
	            sum++;    
	        }	 
	        if(j>=0 && b.charAt(j)=='1'){
	            sum++;
	        }	 
	        sum += carry;	 
	        if(sum>=2){
	            carry=1;
	        }else{
	            carry=0;
	        }	 
	        sb.insert(0,  (char) ((sum%2) + '0'));	//to covert to character 
	        i--; j--;
	    }	 
	    if(carry==1)sb.insert(0, '1');
	    return sb.toString();
	}
}
