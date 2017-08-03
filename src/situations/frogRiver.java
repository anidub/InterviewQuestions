package situations;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
//http://stackoverflow.com/questions/19459197/java-codility-frog-river-one
/*A small frog wants to get to the other side of a river. The frog is currently located at position 0, 
 * and wants to get to position X. Leaves fall from a tree onto the surface of the river.
You are given a non-empty zero-indexed array A consisting of N integers representing the falling leaves. 
A[K] represents the position where one leaf falls at time K, measured in minutes.
The goal is to find the earliest time when the frog can jump to the other side of the river.
 The frog can cross only when leaves appear at every position across the river from 1 to X.
For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In minute 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.*/
public class frogRiver {

	public static void main(String[] args) {
		int x = 5;
		//int [] A = {1,3,1,4,2,3,5,4};
		int[] A = {1,3,-1,-1,-2,1,4,2,3,5,4};
		//int a = frog(x,A);
		int a = solution(x,A);
		System.out.println(a);

	}
	
	 public static int frog(int X, int[] A) {
	        int steps = X;
	        boolean[] bitmap = new boolean[steps+1];
	        for(int i = 0; i < A.length; i++){
	            if(!bitmap[A[i]]){
	                bitmap[A[i]] = true;
	                steps--;
	            }
	            if(steps == 0) return i;
	        }
	        return -1;
	    }
	 
	public static int solution(int X, int[] A) {
		int jumps = -1;
		if(A == null || A.length < X || X == -1) return jumps;
		
		Set<Integer> stones = new TreeSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= X) {
				stones.add(A[i]);
			}
			if (stones.size() == X) {
				jumps = i;
				break;
			}
		}
		return jumps;
	}
}
