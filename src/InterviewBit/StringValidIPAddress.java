package InterviewBit;

import java.util.ArrayList;
import java.util.List;

public class StringValidIPAddress {
/*	https://www.interviewbit.com/problems/valid-ip-addresses/
		Given a string containing only digits, 
		restore it by returning all possible valid IP address combinations.
		A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. 
		The numbers cannot be 0 prefixed unless they are 0.
		Example:
		Given “25525511135”,
		return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)*/
	public static void main(String[] args) {
		String s = "25525511135";
		//String s = "2552500";
		ArrayList<String> IpAddresses = (ArrayList<String>) restoreIpAddressesIterative(s);
		for(String t : IpAddresses){
			System.out.println(t);
		}

	}
	/*public ArrayList<String> restoreIpAddresses(String A) {
	    int ip;
	    ArrayList<String> res = new ArrayList<String>();
	    dfs(res, 0, A, 3, "");	    
	    Collections.sort(res);	    
	    return res;
	}
	
	public void dfs(ArrayList<String> res, int startIndex, String A, int num, String ip) {    
	    if (num == 0) {
	        int len = A.length();	        
	        if (len - startIndex > 3 || len - startIndex < 1) return;
	        String str = A.substring(startIndex, len);
	        int val = Integer.parseInt(str);	        
	        if (val < 0 || val > 255)     return;
	        if (str.charAt(0) == '0' && str.length() > 1)  return;
	        res.add(ip + str);  return; 
	    }
	    
	    for (int i = startIndex + 1; i <= Math.min(A.length(), startIndex + 3); i++) {
	        String str = A.substring(startIndex, i);
	        int val = Integer.parseInt(str);
	        if (val > 255)  continue;
            if (str.charAt(0) == '0' && str.length() > 1) return;
	        dfs(res, i, A, num - 1, ip + str + "."); 
	    }

	}*/
	
	//works
	public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        
        if(s.length() <4 || s.length() > 12)
            return result;
        
        helper(result, list, s , 0);
        return result;
    }
    
    public static void helper(ArrayList<String> result, ArrayList<String> list, String s, int start){
        if(list.size() == 4){
            if(start != s.length())
                return;
            
            StringBuffer sb = new StringBuffer();
            for(String tmp: list){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        
        for(int i=start; i<s.length() && i < start+3; i++){
            String tmp = s.substring(start, i+1);
            if(isvalid(tmp)){
                list.add(tmp);
                helper(result, list, s, i+1);
                list.remove(list.size()-1);
            }
        }
    }
    
    private static boolean isvalid(String s){
        if(s.charAt(0) == '0')
            return s.equals("0"); // to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
    
    //studied
  public static List<String> restoreIpAddressesIterative(String s) {
    	List<String> ans = new ArrayList<String>();
    	int len = s.length();
    	int count = 0;
    	for (int i = 1; i <=3; ++i){  // first cut
    		count++;
    		if (len-i > 9) continue;    		
    		for (int j = i+1; j<=i+3; ++j){  //second cut
    			count++;
    			if (len-j > 6) continue;    			
    			for (int k = j+1; k<=j+3 && k<len; ++k){  // third cut
    				count++;
    				int a,b,c,d;                // the four int's seperated by "."
    				a = Integer.parseInt(s.substring(0,i));  
    				b = Integer.parseInt(s.substring(i,j)); // notice that "01" can be parsed into 1. Need to deal with that later.
    				c = Integer.parseInt(s.substring(j,k));
    				d = Integer.parseInt(s.substring(k));
    				if (a>255 || b>255 || c>255 || d>255) continue; 
    				String ip = a+"."+b+"."+c+"."+d;
    				if (ip.length()<len+3) continue;  // this is to reject those int's parsed from "01" or "00"-like substrings
    				ans.add(ip);
    			}
    		}
    	}
    	System.out.println("count " + count);
    	return ans;
    }
}
