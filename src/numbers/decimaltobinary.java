package numbers;

public class decimaltobinary {

	public static void main(String[] args) {
		int num = 10;
		int[] binary = new int[32];
		int index = 0;
		while(num > 0){
			binary[index++] = num%2;
			num = num/2;
		}
		for(int i = index - 1; i >= 0; i--){
		System.out.print(binary[i] + " ");
	
		}
		System.out.println();
		inttoarray(422);
		
		//binary to dec
		int binarynum = 1010;
		int decimal = 0;
		int p = 0;
		while(true){
			if(binarynum == 0)
				break;
		else{
			int temp = binarynum % 10;
			int c = 1;
			for(int i = 1; i <= p; i++){
				 c = c * 2;
			}
			decimal += temp * c; // or decimal += temp * Math.pow(2,p);
			
			binarynum /= 10;
			p++;
		}
	}
		System.out.println();
		System.out.println("decimal : " +   decimal);
}

	
	public int[] convertBinary(int no) {
	    int i = 0, temp[] = new int[7];
	    int binary[];
	    while (no > 0) {
	        temp[i++] = no % 2;
	        no /= 2;
	    }
	    binary = new int[i];
	    int k = 0;
	    for (int j = i - 1; j >= 0; j--) {
	        binary[k++] = temp[j];
	    }

	    return binary;
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

}
