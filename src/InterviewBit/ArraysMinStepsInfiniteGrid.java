package InterviewBit;

import java.util.ArrayList;
/*You are given a sequence of points and the order in which you need to cover the points.
 *  Give the minimum number of steps in which you can achieve it. You start from the first point.
Input : [(0, 0), (1, 1), (1, 2)]
Output : 2
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
https://www.interviewbit.com/problems/min-steps-in-infinite-grid/*/
public class ArraysMinStepsInfiniteGrid {

	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		x.add(0);x.add(1);x.add(1);
		y.add(0);y.add(1);y.add(2);
		System.out.println(minSteps(x, y));

	}

	public static int minSteps(ArrayList<Integer> x, ArrayList<Integer> y) {
		if (x == null || y == null || x.size() != y.size())
			return -1;
		int numOfSteps = 0;
		for (int i = 1; i < x.size(); i++) {
			numOfSteps += Math.max(x.get(i) - x.get(i - 1), y.get(i) - y.get(i - 1));
		}
		return numOfSteps;
	}
}