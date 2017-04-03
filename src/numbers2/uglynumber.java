package numbers2;

public class uglynumber {
//Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
//1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
//	shows the first 11 ugly numbers. By convention, 1 is included.
//	Write a program to find and print the 150’th ugly number.
	//Time Complexity: O(n)
	//Storage Complexity: O(n)
//http://www.geeksforgeeks.org/ugly-numbers/
	
	public static void main(String[] args) {
		int res = getUglyNum(150);

		System.out.println("the answer is " + res);
	}
	private static int min(int a, int b, int c) {

		int temp = Math.min(a, b);
		return Math.min(temp, c);
		}

	
	public static int getUglyNum(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		for(int i = 1; i < n; i++) {
			ugly[i] = min(ugly[i2] * 2, ugly[i3] * 3, ugly[i5] * 5);
			if(ugly[i] == ugly[i2] * 2) {
					i2 += 1;
			}

			if(ugly[i] == ugly[i3] * 3) {
				i3 += 1;
			}

			if(ugly[i] == ugly[i5] * 5) {
				i5 += 1;
			}
		}
			return ugly[n - 1];
		}
}
