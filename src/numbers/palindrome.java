package numbers;

public class palindrome {

	public static void main(String[] args) {
		int num = 12321;
		int k;
		int temp = num;
		int palindrome = 0;
		while(num != 0){
			k = num%10; //1
			num = num/10;
			palindrome = k + (palindrome*10);
		}
		if(temp == palindrome){
			System.out.println("palindrome");
		}
	}

}
