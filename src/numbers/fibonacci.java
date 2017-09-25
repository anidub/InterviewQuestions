package numbers;

public class fibonacci {

	public static void main(String[] args) {
		int first = 0;
		int second = 1;
		int fibonacci = 0;
		for(int i = 2; i <= 4; i++){
			if(i <= 1){
				fibonacci = i;
			}else{
			fibonacci = first + second;
			first = second;
			second = fibonacci;
		}
			System.out.println(fibonacci);			
		}	
		System.out.println(tailRecursionFibonacci(4,0));
	}
	//In tail recursion, you perform your calculations first, and then you execute the recursive call, passing the results of your current step to the next recursive step.

/*	def tailrecsum(x, running_total=0):
	  if x == 0:
	    return running_total
	  else:
	    return tailrecsum(x - 1, running_total + x)*/

/*	public int fibonacci(int number, int value = 1, int previous = 0){
	     if(number == 0) return previous;
	     if(number == 1) return value;
	      return fibonacci(number-1, value+previous, value);
	}*/

	public static int tailRecursionFibonacci(int x, int running_total){
		if(x == 0) return running_total;
		else return tailRecursionFibonacci(x-1, running_total+x); 
	}
}
