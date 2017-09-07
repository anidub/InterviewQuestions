package numbers;

public class fibonacci {

	public static void main(String[] args) {
		System.out.print(0 + " " + 1 + " " );
		int first = 0;
		int second = 1;
		int fib = 0;
		int num = 6;
		for(int i = 2; i < num; i++){
			fib = first + second;
			first = second;
			second = fib;
			System.out.print(fib + " ");
		}	
	}
}
