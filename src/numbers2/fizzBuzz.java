package numbers2;

import java.util.Scanner;

public class fizzBuzz {
//	if(i%5==0) means if a number is multiple of 5 then print Buzz.
	//if(i%3==0) means if a number is multiple of 3 then print Fizz.
	//if((i%3==0)&&(i%5==0)) means if a number is multiple of 3 as well as 5, then print FizzBuzz.
	public static void main(String[] args) {
		int number;
		System.out.println("Enter a number");
		Scanner sc = new Scanner(System.in);
		number = sc.nextInt();
		
		
		for(int i = 1; i <= number; i++){
			if(i % 3 == 0 && i % 5 == 0){
				System.out.println("FizzBuzz");
			}else if(i % 3 == 0){
				System.out.println("Fizz");
			}else if(i % 5 == 0){
				System.out.println("Buzz");
			}else{
				System.out.println(i);
			}
		}

	}

}
