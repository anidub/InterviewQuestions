package HashGeeks;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
/*
 * https://www.geeksforgeeks.org/find-smallest-range-containing-elements-from-k-lists/
 * Find smallest range containing elements from k lists
Given k sorted lists of integers of size n each, find the smallest range that includes at least element from each of the k lists. If more than one smallest ranges are found, print any one of them.

Example :

Input:
K = 3
arr1[] : [4, 7, 9, 12, 15]
arr2[] : [0, 8, 10, 14, 20]
arr3[] : [6, 12, 16, 30, 50]
Output:
The smallest range is [6 8] 
Explanation: Smallest range is formed by 
number 7 from first list, 8 from second
list and 6 from third list.


Input: 
k = 3
arr1[] : [4, 7]
arr2[] : [1, 2]
arr3[] : [20, 40]
The smallest range is [2 20]  

 Time Complexity : O(nk Logk).
 */
public class SmallestRangeElementKLists {
	 public static class heapNode{
		int data;
		int row;
		int col;
		public heapNode(int data, int r, int c) {
			this.data = data;
			row = r;
			col = c;
		}
	}
	public static void main(String[] args) {
		int arr[][] = { { 4, 7 }, 
						{ 1, 2 },
						{ 20, 40 } };
		minRange(arr);
	}	
	
	public static class mycomp implements Comparator<heapNode>{
	    public int compare(heapNode h1,heapNode h2){
	        if(h1.data > h2.data) return 1;
	        else return -1;
	    }
	}
	static int max=1000, min=0;
	public static void minRange(int arr[][]) {
		int row = arr.length;
		int totalColumns = arr[0].length;
		int tmax, tmin, currentRow, currentColumn;
		heapNode temp, temp1;
		PriorityQueue<heapNode> queue = new PriorityQueue<heapNode>(new mycomp());
		for (int i = 0; i < row; i++){
			temp = new heapNode(arr[i][0], i, 0);
			queue.offer(temp);
		}

		while (queue.size() >= row) {
			temp = queue.poll();
			tmin = temp.data;
			Iterator<heapNode> it = queue.iterator();
			tmax = Integer.MIN_VALUE;
			while (it.hasNext()) {
				temp1 = it.next();
				if (temp1.data > tmax) {
					tmax = temp1.data;
				}
			}
			if (max - min > tmax - tmin) {
				max = tmax;
				min = tmin;
			}
			currentRow = temp.row;
			currentColumn = temp.col;
			if (currentColumn < totalColumns - 1) {
				temp = new heapNode(arr[currentRow][currentColumn + 1], currentRow, currentColumn + 1);
				queue.offer(temp);
			} else {
				break;
			}
		}
		System.out.println(min + " " + max);
	}
}