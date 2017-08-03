package numbers2;

public class jumbledNumber {
//https://www.careercup.com/question?id=5729332770111488
	/*Write all jumbled number which is >0 && <N, where N is provided by the user. 
	A jumbled number is a number whose neighbor digit (either left or right) max differ by 1 value. 

	e.g.: 
	8987 is a jumbled number. 
	13 is not a jumbled number. 
	123456 is a jumbled number. 
	287 is not jumbled number.*/
	public static void main(String args[]) {
		int n = 100;
		for (int i = 1; i < n; i++) {
			boolean chk = false;
			String x = String.valueOf(i);
			int[] m = new int[x.length()];
			for (int j = 0; j < x.length(); j++) {
				String h = String.valueOf(x.charAt(j));
				m[j] = Integer.parseInt(h);
			}
			for (int j = 0; j < x.length() - 1; j++) {
				if ((m[j] - m[j + 1] == 1) || (m[j + 1] - m[j] == 1)) {
					chk = true;
				}
			}
			if (chk == true) {
				System.out.print((i) + " ");
			}
		}
		System.out.println(" hello ");
		jumbled(n);
	}
	
	//same thing except for line 43
	public static void jumbled(int n){
		for(int i = 1; i < n; i++){
			boolean chk = false;
			String x = String.valueOf(i);
			int[] m = new int[x.length()];
			for(int j = 0; j < x.length(); j++){
				int k = x.charAt(j) - '0';
				m[j] = k;
			}
			for(int j = 0; j < x.length() - 1; j++){
				if(m[j] - m[j+1] == 1 || m[j+1] - m[j] == 1) chk = true;
			}
			if(chk == true) 
				System.out.print(i+ " ");
		}
	}
}