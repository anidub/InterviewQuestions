package numbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class rotation180 {

	public static void main(String[] args) {
		try{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Character> m = new HashMap<Character, Character>();
		m.put('0','0');
		m.put('1','1');
		m.put('6','9');
		m.put('8','8');
		m.put('9','6');
		
		System.out.println("Enter number : ");
		String num = br.readLine();
		boolean fancynumber = true;
		
		for(int i = 0; i < ((num.length()/2) + 1); i++){
			if(m.containsKey(num.charAt(i))){
				char ch = m.get(num.charAt(i));
				if(num.charAt(num.length() - (i + 1)) != ch){
					//if(num.charAt(num.length()-(i+1)) != ch){
					fancynumber = false;
				}
			}else{
				fancynumber = false;
			}
		}
		
		if(fancynumber)
			System.out.println("Given number is fancy number");
		else
			System.out.println("given number is not fancy number ");
		
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}		
		}
	}