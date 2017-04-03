package InterviewBit;

import java.util.ArrayList;

public class BinarySearchinMatrix {
//Given a 2d array in sorted manner where rows and cols are sorted, find a value
//O(LOGN)
//https://www.interviewbit.com/problems/matrix-search/
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,10}};
		System.out.println(search(matrix,9));

	}
	public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
		int row, col;
	    int m, n;
	    if (A == null)  return 0;
	    m = A.size(); if (m == 0) return 0;
	    n = A.get(0).size();	    
	    row = 0;   col = n - 1;
	    while (checkBound(row, col, m, n)) {
	        if (B == A.get(row).get(col)) return 1;
	        int num = A.get(row).get(col);
	        if (B < num)  col--;
	        else if (B > num)  row++;
	    }
	    return 0;
	}
	public boolean checkBound(int row, int col, int m, int n) {
	    return (row >= 0 && row < m && col >= 0 && col < n);
	}
	
	//my solution
	public static int search(int[][] matrix , int target){
		int rowNumber = 0;
		int rowLength = matrix[0].length-1; int colLength = matrix.length-1;
		if(target > matrix[rowLength][colLength] || target < matrix[rowLength][colLength] ) return -1;
		for(int i = matrix[0].length-1; i >= 0; i--){
			if(target <=  matrix[i][rowLength]){
				rowNumber = i;
			}
		}	
		int low = 0;
		int high = matrix[rowNumber].length;
		while(low <= high){
			int mid = (high + low)/2;
			if(matrix[rowNumber][mid] == target) return 1;
			else if(matrix[rowNumber][mid] < target) low = mid+1;
			else
				high = mid-1;
		}
		return -1;	
	}
}
