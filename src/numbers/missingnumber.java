package numbers;

public class missingnumber {

	public static void main(String[] args) {
		int[] numbers = {1,3,6,4,5};
		int sum = 0;
		int total = 0; int n;
		/*for(int i = 0; i < numbers.length; i++){
		sum = sum + numbers[i];	
		}
		
		total = (numbers.length + 1) * (numbers.length + 2)/2;
		n = total - sum;
		System.out.println(n);
		*/
		int temp;
		for(int i = 0; i < numbers.length; i++){
			for(int j = i + 1; j < numbers.length; j++){
				if(numbers[i] > numbers[j]){
					temp = numbers[i];
					numbers[i] =  numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < numbers.length; i++){
			System.out.println(numbers[i]);
		}
		for(int i = 0; i < numbers.length; i++){
			sum = sum + numbers[i];	
			}
			
			total = (numbers.length + 1) * (numbers.length + 2)/2;
			n = total - sum;
			System.out.println("missing number is : " + n);		
	}
}
