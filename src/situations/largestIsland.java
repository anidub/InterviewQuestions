package situations;

public class largestIsland {
	//http://www.nataraz.in/find-out-heaviest-island/#
	 //Everything is declared static to avoid object creation
    static int island[][] = {{1,0,0,0},{1,0,1,1},{1,1,0,1},{0,0,0,1}} ;
    static int large=0,sum=0;
    static String path="",tempPath="";
    static int rows=4, cols=4;    
    static String allPath="";
 
    public static void main(String[] args) {
        //prints matrix 
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(island[i][j]+"  ");
            }
            System.out.println();//empty line
        }
        //Process the matrix,to calculate matrix,See the power of recursion 
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){  
                if(island[i][j]>0 ){ //we got an island
                    sum=0;
                    tempPath="["+i+"]["+j+"]";
                    if(allPath.indexOf(tempPath)==-1){
                    	tempPath="";
                    	find(i,j);
                    	System.out.println("Weight="+sum+":: Path="+tempPath);//Display the weight of each Island
                    }
                }
 
                if(large<sum){
                   large=sum;path=tempPath;
                }
            }//inner for
        }//outer for
        System.out.println(large+"::"+path);

}//main

    public static void find(int i,int j){
        String currPath="["+i+"]["+j+"]";
		if (allPath.indexOf(currPath) == -1) {
			sum = sum + island[i][j];
			tempPath += "[" + i + "][" + j + "]";
			allPath += "[" + i + "][" + j + "],";

			if ((j < (cols - 1) && island[i][j + 1] > 0) && (i < (rows - 1) && island[i + 1][j] > 0)) {
				find(i + 1, j);
				find(i, j + 1);
			}

			else if (j < (cols - 1) && island[i][j + 1] > 0)
				find(i, j + 1);
			else if (i < (rows - 1) && island[i + 1][j] > 0)
				find(i + 1, j);
			if ((j > 0 && island[i][j - 1] > 0) && (i > 0 && island[i - 1][j] > 0)) {
				find(i, j - 1);
				find(i - 1, j);
			}

			else if (i > 0 && island[i - 1][j] > 0)
				find(i - 1, j);
			else if (j > 0 && island[i][j - 1] > 0)
				find(i, j - 1);

		}//outer if
    }//find()
    
    
    //simpler method : working //http://stackoverflow.com/questions/15705490/find-largest-area-in-2d-array-in-c
    
   /* static int M = 2;
	static int N = 2;
	static int[][] arr = {{1,0},
						  {1,0}};
		{
		{ 0, 0, 0, 0, 1, 1, 0, 0, },
		{ 1, 0, 0, 1, 1, 1, 0, 0, },
		{ 1, 1, 0, 1, 0, 1, 1, 0, },
		{ 0, 0, 0, 1, 1, 1, 1, 0, },
		{ 0, 1, 1, 0, 0, 0, 0, 0, },
		}; 


	static int fill(int arr[][], int r, int c) {
		  int count = 0;
		  if (r < N && arr[r][c] != 0) {
		    for (int i = c; i >= 0 && arr[r][i] != 0; --i) {
		      arr[r][i] = 0;
		      count += fill(arr, r + 1, i) + 1;
		    }
		    for (int i = c + 1; i < M && arr[r][i] != 0; ++i) {
		      arr[r][i] = 0;
		      count += fill(arr, r + 1, i) + 1;
		    }
		  }
		  return count;
		}
	
	static void print_components(int arr[][]) {
		int maxarea = -1;
		int area = -1;
		  for (int r = 0; r < N; ++r) {
		    for (int c = 0; c < M; ++c) {
		      if (arr[r][c] != 0) {
		    	  area = fill(arr,r,c);
		    	  if(area > maxarea) maxarea = area;
		    	  System.out.println(area);
		        //std::cout << fill(arr, r, c) << std::endl;
		      }
		    }
		  }
		  System.out.println("maxarea : " + maxarea);
		}
	
	public static void main(String args[]) {
		print_components(arr);
	}*/
    
} //class


/*  working USE THIS !!! STUDIED !!
public class findLargetsIsland {
	static boolean[][] visited = new boolean[4][4];
	int i,j;
	// variables for the area:
	static int current_area = 0;
	static int row = 4; static int col = 4;
	static int max_area = 0;
	static int arr[][]={    {1,0,0,0},
							{1,0,1,1},
							{1,1,0,1},
							{0,0,0,1} 
	};
	 // functions
	public static void prepare_visited_map() {
	    for(int i=0;i<row;i++) {
	        for(int j=0;j<col;j++) visited[i][j] = false;
	    }
	}

	// recursive function to calculate the area around (x,y)
	public static void calculate_largest_area(int x, int y) {
		 if(x<0 || y<0 || x>=row || y>=col) return;
	    if(visited[x][y] == true) return;
	    // check if out of boundaries
	   
	    // check if the cell is 0
	    if(arr[x][y] == 0) {
	        visited[x][y] = true;
	        return;
	    }

	    // found a proper cell, proceed
	    current_area++;
	    visited[x][y] = true;
	    // call recursive function for the adjacent cells (north, east, south, west)
	    calculate_largest_area(x,y-1);
	    calculate_largest_area(x+1,y);
	    calculate_largest_area(x,y+1);
	    calculate_largest_area(x-1,y);
	    // by the end of the recursion current_area will hold the area around the initial    cell
	}

	public static void main(String[] args) {
	    // calculate the sorrounding area of each cell, and pick up the largest of all results
		  prepare_visited_map();
		for(int i=0;i<row;i++) {
	        for(int j=0;j<col;j++) {	          
	            current_area = 0;
	            calculate_largest_area(i,j);
	            if(current_area > max_area)   
	            	max_area = current_area;
	        }
	    }
	    System.out.println("Max area is :" + max_area);
	}	
}*/

//works
static int m = 3;
static int n  = 3;
static boolean[][] visited = new boolean[3][3];
static int currentArea = 0;
static int maxarea = 0;

public static int calMax(int[][] matrix){
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			currentArea = 0;
			cal(matrix,i,j);
			if(currentArea > maxarea) maxarea = currentArea;
		}
	}
	return maxarea;
}

public static void cal(int[][] mat, int i, int j){
	if(i<0 || j<0 || i>=m || j>=n) return;
	if(visited[i][j] == true) return;
	if(mat[i][j] == 0){
		visited[i][j] = true;
		return;
	}
	currentArea++;
	visited[i][j] = true;
	mat[i][j] = 0;
	cal(mat, i+1, j);
	cal(mat, i, j+1);
	cal(mat, i-1, j);
	cal(mat, i, j-1);
}
	
}