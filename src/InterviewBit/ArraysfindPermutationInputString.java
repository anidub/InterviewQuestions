package InterviewBit;

public class ArraysfindPermutationInputString {
/*//https://www.interviewbit.com/problems/find-permutation/
	Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.
	D means the next number is smaller, while I means the next number is greater.
	Input 1:
		n = 3
		s = ID
		Return: [2, 3, 1]
	//O(N)*/
	public static void main(String[] args){
		findPerm("DD",3);
	} 
	public static int[] findPerm(String A, int B) {
		  if(A.length() != (B - 1)) return null;
		  for(int i = 0; i < B - 1; i++)
			  if((A.charAt(i) != 'I') && (A.charAt(i) != 'D')) return null;

		  int[] ans = new int[B];
		  int start = 1, upto = B;
		  for(int i = 0; i < B && (start < upto); i++) {
		      if(A.charAt(i) == 'D') ans[i] = upto--;
		      else ans[i] = start++;
		  }
		  if(start == upto){
		  ans[B - 1] = start;
		}
		  return ans;
	}
}
