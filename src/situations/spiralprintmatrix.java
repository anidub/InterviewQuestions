package situations;

public class spiralprintmatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		print(matrix);

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
}
