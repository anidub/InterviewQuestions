package InterviewBit;

import java.util.HashMap;
import java.util.Map;
/*http://buttercola.blogspot.com/2014/10/leetcode-max-points-on-line.html
	https://www.interviewbit.com/problems/points-on-the-straight-line/
 the time complexity of this approach is O(n^2) and the space complexity is O(n).
 http://stackoverflow.com/questions/23051306/how-to-find-the-maximum-number-of-points-lying-on-the-same-straight-line	*/
public class HashingMaxPointsStraightLine {
	public class Point {
		     int x;
		     int y;
		     Point() { x = 0; y = 0; }
		     Point(int a, int b) { 
		    	 x = a; y = b; 
		     }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int maxPoints(Point[] points) {
	        if (points == null || points.length == 0)  return 0;
	         
	        int max = 1;
	        for (int i = 0; i < points.length - 1; i++) {
	            Map<Double, Integer> map = new HashMap<Double, Integer>();
	            int samePoints = 0;
	            double slope = 0;
	            int localMax = 1;
	            for (int j = i + 1; j < points.length; j++) {
	                // check if point i and j are the same
	                if (points[i].x == points[j].x && points[i].y == points[j].y) {
	                    samePoints++;
	                    continue;
	                } else if (points[i].y == points[j].y) {
	                    slope = 0.0;
	                } else if (points[i].x == points[j].x) {
	                    slope = (double) Integer.MAX_VALUE;
	                } else {
	                    slope = (double) (points[j].y - points[i].y) / (points[j].x - points[i].x);
	                }
	                 
	                 
	                if (map.containsKey(slope)) {
	                    map.put(slope, map.get(slope) + 1);
	                } else {
	                    map.put(slope, 2);
	                }
	            }
	            for (Integer num : map.values()) {
	                localMax = Math.max(localMax, num);
	            }
	            localMax += samePoints;
	            max = Math.max(max, localMax);
	        }
	        return max;
	    }
}