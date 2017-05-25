package InterviewBit;

public class ArraysspiralMatrix {
//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	//https://www.interviewbit.com/problems/spiral-order-matrix-ii/
	//http://www.programcreek.com/2014/05/leetcode-spiral-matrix-ii-java/
	public static void main(String[] args) {
		getSpiral(4);
	}

	public static int[][] getSpiral(int n){
		int[][] matrix = new int[n][n];
		int top = 0;
		int left = 0;
		int right = n-1;
		int down = n-1;
		
		int k = 1;
		
		while(k <= n * n){
			for(int i = left; i <= right; i++){
				matrix[top][i] = k;
				k++;
			}
			top++;
			
			for(int j = top; j <= down; j++){
				matrix[j][right] = k;
				k++;
			}
			right--;
			
			for(int i = right; i >= left; i--){
				matrix[down][i] = k;
				k++;
			}
			down--;
			
			for(int i = down; i >= top; i--){
				matrix[i][left] = k;
				k++;
			}
			left++;
		}
		return matrix;
	}
}
