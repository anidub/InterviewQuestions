package numbers2;

public class longestincreasingsubsequence {
//The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence 
	//of a given sequence such that all elements of the subsequence are sorted in increasing order.
	//For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
	//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
	public static void main(String[] args) {
		int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		LIS(array);
	}

	public static void LIS(int[] arr) {
		int max = 1;
		int n = arr.length;
		int[] LS = new int[n];
		String[] path = new String[n];
		for (int k = 0; k < n; k++) {
			LS[k] = 1;
			path[k] = arr[k] + " ";
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && LS[i] < 1 + LS[j]) {
					LS[i] = LS[j] + 1;
					path[i] = path[j] + arr[i] + " ";
				}
				if (max < LS[i]) {
					max = LS[i];
				}
			}
		}

		for (int a = 0; a < n; a++) {
			if (LS[a] == max) {
				System.out.println(path[a]);
			}
		}
		System.out.println("max is " + max);

	}	
}
