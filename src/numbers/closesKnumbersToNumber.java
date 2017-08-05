package numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class closesKnumbersToNumber {
/*
 * http://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 * Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].
 * http://code.geeksforgeeks.org/olSiVL 
Examples:

Input: K = 4, X = 35
       arr[] = {12, 16, 22, 30, 35, 39, 42, 
               45, 48, 50, 53, 55, 56}
Output: 30 39 42 45
O(Logn + k) time
O(K) space
 */
	public static void main(String[] args) {
		  int K = 4;
          int X = 35;
      //   int[]  arr = {12, 16, 22, 30, 35, 39, 42,45, 48, 50, 53, 55, 56};   
         int[]  arr = { 50, 53, 55, 56,12, 16, 22, 30, 35, 39, 42,45, 48};  
         List<Point> points = new ArrayList<Point>();
         Point a = new Point(1,1);Point b = new Point(2,2);Point c = new Point(3,4);Point d = new Point(5,5); 
         points.add(a);points.add(b);points.add(c);points.add(d);
         nearestKPoint(points, new Point(2,2),2);
          ArrayList<Integer> result = getClosestK(arr,K,X);
          for(int i : result){
        	  System.out.print(i + " ");
          }
	}
	
	public static ArrayList<Integer> getClosestK(int[] num, int k, int x){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(num.length < k) return result;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		ArrayList<Integer> diffHolder = new ArrayList<Integer>();		
		for(int i = 0; i < num.length; i++){
			if(num[i] != x){
				diffHolder.add(x - num[i]);
			}
		}
		
		int added = 0;
		for(int i = 0; i < diffHolder.size(); i++){
			int current = Math.abs(diffHolder.get(i));
			if(added < k){
				pq.offer(current);
				added++;
			}else{
				if(current < Math.abs(pq.peek())){
					pq.poll();
					pq.offer(diffHolder.get(i));
				}
			}
		}
		
		while(!pq.isEmpty()){
			result.add(x - pq.poll());
		}
		return result;		
	}
	
	/*
	 * https://stackoverflow.com/questions/20398799/find-k-nearest-points-to-point-p-in-2-dimensional-plane
	 * Given a point P and other N points in two dimensional space, find K points out of the N points which are nearest to P.
	 * make heap of size K and collect points by minimal distance O(NLogK) complexity.
	 * O(NLogK) : TIME 
	 */
	private static List<Point> nearestKPoint(List<Point> list, final Point center, int k) {
	    List<Point> ans = new ArrayList<Point>();
	    PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k + 1, new Comparator<Point>() {
	        public int compare(Point o1, Point o2) {
	            return distance(center, o2) - distance(center, o1);
	        }
	    });
	    for (Point p : list) {
	        maxHeap.offer(p);
	        if (maxHeap.size() > k) {
	            maxHeap.poll();
	        }
	    }
	    Iterator<Point> i = maxHeap.iterator();
	    while (i.hasNext()) {
	        ans.add(i.next());
	    }
	    return ans;
	}
	
	public static int distance(Point p1, Point p2) {
	    return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}
	
	protected static class Point {
	    int x;
	    int y;

	    public Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Point point = (Point) o;

	        if (x != point.x) return false;
	        return y == point.y;
	    }
	}
}
