package situations;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
//http://stackoverflow.com/questions/19459197/java-codility-frog-river-one
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
