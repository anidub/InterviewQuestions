package numbers2;

import java.util.HashSet;

public class happyNumber {
//https://www.rosettacode.org/wiki/Happy_numbers#Java		
	public static void main(String[] args) {
			
		//System.out.println(isHappy(19));
		
		String a = "19";
		//int b = convertstringtoint(a);
		//System.out.println(b);
		//System.out.println(power(10,2));
		System.out.println(calculatePower(10,-1));

	}
	
	public static int convertstringtoint(String a){
		if(a.length() == 0) return -1;
		int[] numarray = new int[a.length()];
		
		for(int i = 0; i < numarray.length; i++){
			numarray[i] = a.charAt(i) - '0';
		}
		
		int num = 0;
		int factor = 1;
		for(int i = numarray.length-1; i >= 0; i--){
			int d = numarray[i]; //9
			num += d * factor;
			factor = factor*10;
		}
		return num;		
	}
	
	
	public static void inttoarray(int num){
		String temp = Integer.toString(num);
		int[] intarr = new int[temp.length()];
		for(int i = 0; i < intarr.length; i++){
			intarr[i] = temp.charAt(i) - '0'; //To get the actual int value of a char, we have to substract the ASCII code value of the char '0' from the ASCII code of the actual char.
		}
		for(int i : intarr){
			System.out.print(i + " ");
		}
	}

	private static float calculatePower(float x, int y){ 
        float temporary;
        /* Termination condition for recursion */    
        if(y==0)
                return 1;
        temporary=calculatePower(x,y/2);
        /* Check if the power is even */
        if(y%2==0)
                return (temporary * temporary);
        else{
                if(y>0)
                        return (x * temporary * temporary);
                else
                        return (temporary*temporary)/x;
        }    
}
	
	
	public static int power(int num, int pow){
		if(pow == 0) return 1;
		return num * power(num,--pow);
	}
	
	public static boolean isHappy(int num){
		int digit = 0;
		HashSet<Integer> store = new HashSet<Integer>();
		int m = 0;
		while(num != 1 && store.add(num)){
			m = 0;
			while(num > 0){
				digit = num%10;
				m += digit*digit;
				num = num/10;
			}
			num = m;
		}	
		return num == 1;
	}
}
