package numbers;

public class fibonacci {

	public static void main(String[] args) {
		int first = 0;
		int second = 1;
		int fibonacci = 0;
		for(int i = 2; i <= 10; i++){
			if(i <= 1){
				fibonacci = i;
			}else{
			fibonacci = first + second;
			first = second;
			second = fibonacci;
		}
			System.out.println(fibonacci);
		}	
	}
}
