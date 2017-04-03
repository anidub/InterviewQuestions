package numbers;

import java.util.HashSet;
import java.util.Set;

public class commonnosinarray {

	public static void main(String[] args) {
		int[] num1 = {1,2,3,4};
		int[] num2 = {2,3};
		Set<Integer> numset = new HashSet<Integer>();
		for(int i : num1){
			numset.add(i);
		}
		
		for(int i : num2){
			if(numset.contains(i)){
				System.out.println("Common element is " + i);
			}
		}

	}

}
