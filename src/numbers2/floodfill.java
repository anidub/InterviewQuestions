package numbers2;

public class floodfill {
	//http://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
	//Given a 2D screen, location of a pixel in the screen and a color, replace color of the given pixel and all adjacent same colored pixels with the given color.
	
	static int M = 8;
	static int N = 8;
	
	public static void main(String[] args) {
	
		int[][] matrix = {{1, 1, 1, 1, 1, 1, 1, 1},
						{1, 1, 1, 1, 1, 1, 0, 0},
						{1, 0, 0, 1, 1, 0, 1, 1},
						{1, 2, 2, 2, 2, 0, 1, 0},
						{1, 1, 1, 2, 2, 0, 1, 0},
						{1, 1, 1, 2, 2, 2, 2, 0},
						{1, 1, 1, 1, 1, 2, 1, 1},
						{1, 1, 1, 1, 1, 2, 2, 1}};
		int x = 3; int y = 3; int newC = 3;
		display(matrix);
		System.out.println();
		floodfillmatrix(matrix,x,y, newC);
		display(matrix);
		
	}
	
	public static void display(int[][] matrix){
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void floodfillmatrix(int[][] matrix, int x, int y, int newC){
		int prevC = matrix[x][y];
		floodfillutil(matrix, x, y, newC, prevC);
		//display(matrix);
	}
	
	public static void floodfillutil(int[][] matrix, int x, int y, int newC, int prevC){
		if(x < 0 || x > M || y < 0 || y > N) return;
		
		int a = matrix[x][y]; //2, 
		if(matrix[x][y] != prevC) return;
		if(a == prevC){
		matrix[x][y] = newC;
		
		floodfillutil(matrix, x+1, y, newC, prevC);
		floodfillutil(matrix, x-1, y, newC, prevC);
		floodfillutil(matrix, x, y+1, newC, prevC);
		floodfillutil(matrix, x, y-1, newC, prevC);
		}
	}
}
