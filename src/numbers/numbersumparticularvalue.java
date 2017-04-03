package numbers;

import java.util.HashSet;
import java.util.Set;

public class numbersumparticularvalue {

	public static void main(String[] args) {
		int[] a = {1,2,5,7,2,5};
		int sum = 7;
	
		Set<Integer> nm = new HashSet<Integer>();
		 nm.add(a[0]);
		 for(int i = 1; i < a.length; i++){
			 if(nm.contains(sum - a[i])){
				 System.out.println(a[i]+", "+(sum  - a[i]));
				 break;
			 }else
				 nm.add(a[i]);
		 }
		
		
		}
}


