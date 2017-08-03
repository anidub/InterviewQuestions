package numbers;

import java.util.HashSet;
import java.util.Set;

public class duplicatenumber {

	public static void main(String[] args) {
		int[] num = {1,2,3,2,4,4,5};
		Set<Integer> numset = new HashSet<Integer>();
		for(int i = 0; i < num.length; i++){
			if(numset.contains(num[i])){
				System.out.println(num[i]);
			}else{
				numset.add(num[i]);
			}			
		}
	}
}
