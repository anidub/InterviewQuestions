package numbers2;

public class allPossibleSumsConsecutiveNumbersSumN {
/*
 * http://www.geeksforgeeks.org/print-possible-sums-consecutive-numbers-sum-n/
 * Print all possible sums of consecutive numbers with sum N
Given a number N. The task is to print all possible sums of consecutive numbers that add up to N.
Examples:
Input : 100
Output :
9 10 11 12 13 14 15 16 
18 19 20 21 22 

Input :125
Output :
8 9 10 11 12 13 14 15 16 17 
23 24 25 26 27 
62 63 
 */
	public static void main(String[] args) {
		addforN(15);
	}
	public static void addforN(int N){
		int start = 1; int end = 1;
		int sum = 1;
		while(start <= N/2){
			if(sum < N){
				end++;
				sum += end;				
			}else if(sum > N){
				sum = sum - start;
				start++;
			}else{
				for(int i = start; i <= end; i++){
					System.out.print(i+" ");					
				}
				System.out.println();
				sum = sum - start;
				start++;
			}
		}
	}
}
