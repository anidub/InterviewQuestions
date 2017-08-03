package numbers;

import java.util.PriorityQueue;
/*// using heap time complexity : nklogk... n is number of arrays, k is size
https://www.interviewbit.com/problems/merge-k-sorted-lists/
	startindex maintains the starting position of evry array in the priority queue*/
public class mergeksortedarrays {

	private static class ArrayContainer implements Comparable<ArrayContainer>{
		private int[] array;
		private int startindex;
		
		public ArrayContainer(int[] array){
			this.array = array;
			startindex = 0;
		}
		
		public boolean isEmpty(){
			return startindex == array.length;
		}
		
		public int peek(){
			return array[startindex];
		}
		
		public int getNextInt(){
			return array[startindex++];
		}
		
		public int compareTo(ArrayContainer o){
			return (new Integer(peek()).compareTo(o.peek()));
					
		}	
	}
	
	public static int[] mergesortedarrays(int[][] sortedarrays){
		int totallength = 0;
		int[] result;
		PriorityQueue<ArrayContainer> heap = new PriorityQueue<ArrayContainer>();
		
		for(int i = 0; i < sortedarrays.length; i++){
			totallength += sortedarrays[i].length;
			heap.add(new ArrayContainer(sortedarrays[i]));
		}
		
		result = new int[totallength];
		int index = 0;
		while(!heap.isEmpty()){
			ArrayContainer arraycontainer = heap.poll();
			result[index++] = arraycontainer.getNextInt();
			if(arraycontainer.isEmpty()) continue;
			heap.add(arraycontainer);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,4,5};
		int[] d = {4,7,8,9};
		int[] c = {11,22};
		int[] b = {33,77,123};
		
		int[] result = mergesortedarrays(new int[][] {a,b,c,d});
 		for(int i : result){
 			System.out.print(i + " ");
 		}
	}
}