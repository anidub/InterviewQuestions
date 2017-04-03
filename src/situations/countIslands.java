package situations;

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

	}

