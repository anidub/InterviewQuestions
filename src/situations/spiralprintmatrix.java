package situations;

public class spiralprintmatrix {

	public static void main(String[] args) {
		//int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		//print(matrix);
		System.out.println();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printInsideOut(matrix);

	}
	
	public static void print(int[][] matrix){
		if(matrix.length == 0) return;
		
		int top = 0;
		int left = 0;
		int down = matrix[0].length - 1;
		int right = matrix[0].length - 1;
		
		while(true){
			for(int j = left; j <= right; ++j) System.out.print(matrix[top][j]+" ");
			top++;
			if(top > down || left > right) break;
			
			for(int i = top; i <= down; ++i) System.out.print(matrix[i][right]+" ");
			right--;
			if(top > down || left > right) break;
			
			for(int j = right; j >= left; --j) System.out.print(matrix[down][j]+" ");
			down--;
			if(top > down || left > right) break;
			
			for(int i = down; i >= top; --i)System.out.print(matrix[i][left]+" ");
			left++;
			if(top > down || left > right) break;
			
		}
	}
	
	//inside out
	
	public static void printInsideOut(int[][] matrix) {
		int size = matrix.length;
		int count = 0;
		int row = 0;
		int col = 0;
		int elements = size * size;

		int left = -1, down = 1, right = 2, up = -2;

		if (size % 2 == 0) {
			row = size / 2 - 1;
			col = size / 2;
		} else
			row = col = size / 2;

		System.out.print(matrix[row][col] + " ");

		while (count < elements - 1) {

			for (int i = 0; i > left && count < elements - 1; i--) {
				col = col - 1;
				System.out.print(matrix[row][col] + " ");
				count++;
			}

			for (int i = 0; i < down && count < elements - 1; i++) {
				row = row + 1;
				System.out.print(matrix[row][col] + " ");
				count++;
			}

			for (int i = 0; i < right && count < elements - 1; i++) {
				col = col + 1;
				System.out.print(matrix[row][col] + " ");
				count++;
			}

			for (int i = 0; i > up && count < elements - 1; i--) {
				row = row - 1;
				System.out.print(matrix[row][col] + " ");
				count++;
			}

			left = left - 2;
			down = down + 2;
			right = right + 2;
			up = up - 2;
		}

	}
}
