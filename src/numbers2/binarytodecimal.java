package numbers2;

import java.util.ArrayList;

public class binarytodecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 0100;
		//binarytodecimalconvert(k);
		ArrayList<Integer> a = new ArrayList<Integer>();
		decimalToBinaryUsingBitManipulation(-10,a);
		for(int i : a){
			System.out.print(i + " ");
		}
	}

	public static void decimalToBinaryUsingBitManipulation(int value, ArrayList<Integer> arr ){
		//ArrayList<Integer> arr = new ArrayList<Integer>();
	    if (value == 0)
	        return ;
	    decimalToBinaryUsingBitManipulation((value >>> 1),arr);
	    arr.add(value & 1);
	    //return arr;
	    // System.out.print(value & 1);	    
	}
	
	public static void decimalToBinaryUsingBitManipulation(int value){
    if (value == 0)
        return;
    int k = value >>> 1;
    decimalToBinaryUsingBitManipulation(value >>> 1);
    System.out.print(value & 1);    
}

	public static void binarytodecimalconvert(int binarynum){
			binarynum = 1010;
			int[] arrar = inttoarray(binarynum);
			if(arrar[0] == 1){
				//return binarytonegativedecimal(arrar);
			}
			int decimal = 0;
			int p = 0;
			int k = 0;
			int[] arr = new int[32];
			System.out.println(binarynum);
			
			while(binarynum > 0){
				if(binarynum == 0) break;
				else{
					int temp = binarynum % 10;
					int c = 1;
					for(int i = 1; i <= p; i++){
						 c = c * 2;
					}
					decimal += temp * c;
					//decimal += temp * Math.pow(2, p);
					binarynum /= 10;
					p++;
				}
			}
			System.out.println(decimal);
	}
	
	public static int[] inttoarray(int num){
		String temp = Integer.toString(num);
		int[] intarr = new int[temp.length()];
		for(int i = 0; i < intarr.length; i++){
			intarr[i] = temp.charAt(i) - '0'; //To get the actual int value of a char, we have to substract the ASCII code value of the char '0' from the ASCII code of the actual char.
		}
		for(int i : intarr){
			System.out.print(i + " ");
		}
		return intarr;
	}
}
