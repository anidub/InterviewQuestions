package InterviewBit;

import java.util.ArrayList;
import java.util.PriorityQueue;
/*https://www.interviewbit.com/problems/magician-and-chocolates/
Given N bags, each bag contains Ai chocolates. There is a kid and a magician.
In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.
K = 3
N = 2
A = 6 5
	Return: 14
	At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
	At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
	At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
	so, total number of chocolates eaten: 6 + 5 + 3 = 14*/
	public class HeapsAndMapsMagicianChoclate {
	
	public static void main(String[] args) {
		int time = 3;
		ArrayList<Integer> choclates = new ArrayList<Integer>();
		choclates.add(6);choclates.add(5);
		System.out.println(maxChoclates(time, choclates));
	}
	/*
	 * we use priority queue to maintain the list in the reverse sorted fashion.
	 * The max num will always be on top.
	 */
	private static class ArrayContainer implements Comparable<ArrayContainer>{
		int num; 
		public ArrayContainer(int left){
			this.num = num;
		}
		
		public int compareTo(ArrayContainer o){
			return (new Integer(o.num).compareTo(this.num));
		}
	}	
	
	public static int maxChoclates(int time, ArrayList<Integer> bags) {
		if (bags.isEmpty())
			return 0;
		int result = 0;

		PriorityQueue<ArrayContainer> pq = new PriorityQueue<ArrayContainer>();
		for (Integer i : bags) {
			pq.add(new ArrayContainer(i));
		}
		while (time > 0) {
			ArrayContainer e = pq.poll();
			int eat = e.num;
			result += eat;
			pq.add(new ArrayContainer(eat / 2));
			time--;
		}
		return result;
	}
	
	private static class ArrCont implements Comparable<ArrCont>{
		int i;
		public ArrCont(int i){
			this.i = i;
		}
		public int compareTo(ArrCont o){
			if(i < o.i) return -1;
			else return 1;
		}
	}
}