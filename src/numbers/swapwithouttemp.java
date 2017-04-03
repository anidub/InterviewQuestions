package numbers;

public class swapwithouttemp {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		a = a + b;//3
		b = a - b;//1
		a = a - b;
		System.out.println("a :" + a);
		System.out.println("b :"  + b);

	}

}
