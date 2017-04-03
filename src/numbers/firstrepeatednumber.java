package numbers;

import java.util.HashSet;
import java.util.Set;

public class firstrepeatednumber {
	//first repeated of integer in array
	
	public static void main(String[] args) {
		int[] numbers = {1,2,4,5,6,7,6};
		Set<Integer> numset = new HashSet<Integer>();
		for(int i = 0; i < numbers.length; i++){
			if(numset.contains(numbers[i])){
				System.out.println("The repeated number is : " + numbers[i]);
			}else{
				numset.add(numbers[i]);
			}
		}

	}

}
