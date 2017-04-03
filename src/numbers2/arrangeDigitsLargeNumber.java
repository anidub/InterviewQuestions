package numbers2;

import java.util.Arrays;
import java.util.Comparator;

public class arrangeDigitsLargeNumber {
//http://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
//http://www.programcreek.com/2014/02/leetcode-largest-number-java/
/*	we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y). If XY is larger, then X should come before Y in output, 
	else Y should come before. For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542. Since 60542 is greater than 54260, we put Y first.	*/
	// O(nlogn)
public static void main(String[] args) {
		int[] arr = { 3, 30, 34, 5, 9 };
		System.out.println(largestNumber(arr));
		System.out.println();
		String[] num = {"1","0","23","2"};
		Arrays.sort(num);
		for(String aa : num)
		System.out.print(aa + " ");
}

	public static String largestNumber(int[] nums) {
		String[] arr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = String.valueOf(nums[i]);
		}
 
		Arrays.sort(arr, new Comparator<String>() {   // 3  30
			public int compare(String a, String b) { // 3   34  30
				return (b + a).compareTo(a + b);    //34   3   30
			}										//5   34   3   30
		});											//9  5  34  3  30

		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1)
			sb.deleteCharAt(0);

		return sb.toString();
	}
}
