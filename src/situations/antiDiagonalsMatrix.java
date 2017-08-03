package situations;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/anti-diagonals/
/*Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.		
Input: 	
1 2 3
4 5 6
7 8 9
Return the following :
[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]*/	//https://angshukutu.wordpress.com/2016/02/08/interviewbit-arrays/
//O(n2)//remember the reverse L Shape for the answer
public class antiDiagonalsMatrix {
	public static ArrayList<ArrayList<Integer>> antiDiagonal(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (a == null || a.size() == 0)
			return result;

		int[][] b = new int[a.size()][a.get(0).size()];
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(i).size(); j++) {
				b[i][j] = a.get(i).get(j);
			}
		}

		int nLists = a.size() * 2 - 1;
		for (int i = 0; i < nLists; i++) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			result.add(l);
		}

		int layers = a.size();
		for (int i = 0; i < layers; i++) {
			int k = i;
			for (int j = 0; j < layers - 1 - i; j++) {
				int t2 = b[i][j];
				result.get(k++).add(b[i][j]);
			}
			for (int j = i; j < layers; j++) {
				int t1 = layers - i - 1;
				int t2 = b[j][layers - i - 1];
				result.get(k++).add(b[j][layers - i - 1]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> one = new ArrayList<Integer>();
		one.add(1);	one.add(2);	one.add(3);
		ArrayList<Integer> two = new ArrayList<Integer>();
		two.add(4);	two.add(5);	two.add(6);
		ArrayList<Integer> three = new ArrayList<Integer>();
		three.add(7);three.add(8);three.add(9);
		t.add(one);	t.add(two);	t.add(three);
		antiDiagonal(t);
	}	
}