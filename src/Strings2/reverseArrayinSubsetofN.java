package Strings2;

public class reverseArrayinSubsetofN {
//https://careercup.com/question?id=5181130190880768
/*	Reverse an array in subset of N. Example: 
		input: Array = [1,2,3,4,5,6,7,8,9], N = 3 
		output: [3,2,1,6,5,4,9,8,7]*/
	//Java solution, complexity O(n * k):
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		int k = 4;
		int[] b = reverseArray(a,k);
		for(int i : b){
			System.out.print(i + " ");
		}

	}
	
	private static int[] reverseArray(int[] A, int k) {
		if(A == null) return A;
		if(A.length < k) return A;
        for (int i = 0; i < A.length; i += k) {
            int left = i;
            // in case right larger than A.length
            int right = Math.min(i + k - 1, A.length - 1);
            // reverse sub array
            while (left < right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                left++;
                right--;
            }
        }
        return A;
    }
}