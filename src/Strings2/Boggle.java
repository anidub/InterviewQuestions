package Strings2;

import java.util.HashSet;
import java.util.Set;
//http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
//Find out how many words from a dictionary can be obtained from a given matrix
///complexity pow(8,m*n)
//Note that the above solution may print same word multiple times. 
//For example, if we add “SEEK” to dictionary, it is printed multiple times. To avoid this, we can use hashing to keep track of all printed words.
public class Boggle {	
	static Set<String> set = new HashSet<String>();
	 
	//dictionary
	static void makeSet() {
		set.add("GEEKS");set.add("FOR");set.add("QUIZ"); set.add("GO");set.add("SEEK");
	}
 
	static boolean isValidWord(String str) {
		return set.contains(str);
	}
 
	static void DFSUtil(char[][] boggle, boolean[][] visited, int i, int j, String str) {
		// Mark current cell as visited and append current character to str
		visited[i][j] = true;
		str += boggle[i][j];
 
		// If str is present in dictionary, then print it
		if(isValidWord(str))
			System.out.println(str);
		
 //// Traverse 8 adjacent cells of boggle[i][j]
		for(int row=i-1;row<=i+1 && row<boggle.length;row++) {
			for(int col=j-1;col<=j+1 && col<boggle[0].length;col++) {
				if(row>=0 && col >= 0 && !visited[row][col])
					DFSUtil(boggle,visited,row,col,str);
			}
		}
 //// Erase current character from string and mark visited of current cell as false
		String temp = str.substring(0,str.length()-1);
		str = temp;
		visited[i][j] = false;
	}
 
	static void printWords(char[][] boggle) {
		int M = boggle.length;
		int N = boggle[0].length;
 
		  // Mark all characters as not visited
		boolean[][] visited = new boolean[M][N];
		String str = "";
 
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++)
				DFSUtil(boggle,visited,i,j,str);
		}
	}
 
	static void printMatrix(char[][] boggle) {
		for(int i=0;i<boggle.length;i++) {
			for(int j=0;j<boggle[0].length;j++)
				System.out.print(boggle[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		makeSet();
		char[][] boggle = {{'G','I','Z'},
		                 {'U','E','K'},
		                 {'Q','S','E'}};
 
		System.out.println("Boggle:");
		printMatrix(boggle);
 
		System.out.println("\nWords:");
		printWords(boggle);
	}
}
