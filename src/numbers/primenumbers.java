package numbers;

public class primenumbers {

	public static void main(String[] args) {
		// Set<Integer> numset= new HashSet<Integer>();

		for (int i = 2; i < 100; i++) {
			int count = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					count++;
				// break;

			}
			if (count == 0) {
				System.out.print(i + " ");
			}
		}

		int n = 33;
		int countfactor = 0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0)
				countfactor++;
		}
		if (countfactor == 1)
			System.out.println("prime");
		else
			System.out.println("not prime");
	}
}