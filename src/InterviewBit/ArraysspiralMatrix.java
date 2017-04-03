package InterviewBit;

public class ArraysspiralMatrix {
//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	//https://www.interviewbit.com/problems/spiral-order-matrix-ii/
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
		
		while(k <= n*n){
			for(int i = top; i <= right; i++){
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
			
			for(int j = down; j >= top; j--){
				matrix[j][left] = k;
				k++;
			}
			left++;
		}
		return matrix;
	}
}
