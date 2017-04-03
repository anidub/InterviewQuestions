package numbers;

public class sortnumbers {

	public static void main(String[] args) {
		int[] numbers = {1,3,2,4};
		int temp = 0;
		for(int i = 0; i < numbers.length; i++){
			for(int j = i + 1; j < numbers.length; j++){
				if(numbers[i] > numbers[j]){
					temp = numbers[i];
					numbers[i] =  numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
		for(int i = 0; i <numbers.length; i++){
			System.out.println(numbers[i]);
		}

	}
}
