package numbers2;

import java.util.ArrayList;

public class missingNumber {
/*	Given an array of size N, filled with numbers from 1 to N+1 and no duplicates. Find out the missing number*/

	public static void main(String[] args) {
		int[] a = new int[5];
		a[0] = 1; a[1] = 2; a[2] = 3; a[3] = 5; a[4] = 6;
		System.out.println(find(a));
	}

	public static int find(int[] a){
		int sum = 0;
		int sum1 = 0;
		int number = 1;
		for(int n : a){
			sum += n;
			sum1 += number++;
		}
		sum1 += number;
		return sum1-sum;
		
	}
}
