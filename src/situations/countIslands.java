package situations;

import java.util.LinkedList;
import java.util.Queue;

public class countIslands {
		static int count=0;
		//http://www.geeksforgeeks.org/find-number-of-islands/
		//Time complexity: O(ROW x COL)

		public static void main(String[] args) {
			countIslands obj = new countIslands();
			int[][] matrix = {  { 1, 1, 0, 0, 0 },
								{ 0, 1, 0, 0, 1 },
								{ 1, 0, 0, 1, 1 },
								{ 0, 0, 0, 0, 0 },
								{ 1, 0, 1, 0, 1 } };
			System.out.println("Islands: " + obj.findIslands(matrix));
			System.out.println("Islands: " + obj.countIslands(matrix));
			
		}

		int countIslands(int[][] matrix) {
			int n=matrix.length;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(true==isConnected(i,j,n,matrix))
						count++;
				}
			}
			return count;
		}
		boolean isConnected(int i,int j,int n,int[][]matrix){
			if(!isValidIndex(i, j, n)){
				return false;
			}
			if(matrix[i][j]==1){
				matrix[i][j]=0;
				
				
				isConnected(i, j+1, n,matrix);
				isConnected(i-1, j+1, n,matrix);
				isConnected(i+1, j+1, n,matrix);
				
				isConnected(i, j-1, n,matrix);
				isConnected(i-1, j-1, n,matrix);
				isConnected(i+1, j-1, n,matrix);
				
				isConnected(i+1, j, n,matrix);
				isConnected(i-1, j, n,matrix);

				return true;
			}
			
			return false;
		}

		boolean isValidIndex(int i, int j, int n) {
			if (i >= n || i < 0 || j >= n || j < 0)
				return false;
			return true;
		}
		
		
		//method 2 Time complexity : M * N
		//https://www.pramp.com/question/yZm60L6d5juM7K38KYZ6
		public int findIslands(int[][] matrix){
			int m = matrix.length;
			int n = matrix[0].length;
			int count = 0;
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					if(matrix[i][j] == 1){
						getIslands(matrix, i, j, m, n);
						count++;
					}
				}
			}
			return count;
		}
		
		static class point{
			int x;
			int y;
			public point(int x, int y){
				this.x = x;
				this.y = y;
			}
		}
		public static void getIslands(int[][] matrix, int i, int j, int m, int n){
			Queue<point> queue = new LinkedList<point>();
			point point = new point(i,j);
			queue.add(point);
			while(!queue.isEmpty()){
				point item = queue.poll();
				int x = item.x;
				int y = item.y;
				if(matrix[x][y] == 1){
					matrix[x][y] = -1;
					pushIfValid(queue, x, y+1, m, n);
					pushIfValid(queue, x, y-1, m, n);
					pushIfValid(queue, x+1, y, m, n);
					pushIfValid(queue, x-1, y, m, n);
				}
			}
		}
		
		public static void pushIfValid(Queue<point> queue, int i, int j, int m, int n){
			if(i >= 0 && i < m && j >= 0 && j < n){
				queue.add(new point(i,j));
			}
		}
	}