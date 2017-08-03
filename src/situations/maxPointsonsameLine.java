package situations;

import java.util.HashMap;
import java.util.Map;

public class maxPointsonsameLine {
	public static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}
		Point(int a, int b) {
			x = a;
			y = b;
		}
		
		 @Override
		    public boolean equals(Object obj) {
		        Point that = (Point)obj;
		        if (that.x == this.x && that.y == this.y)
		            return true;
		        else
		            return false;
		    }

		    @Override
		    public int hashCode() {
		        // TODO Auto-generated method stub
		        return 1;
		    }  
	}
	
	public static void main(String[] args) {
			Point point1 = new Point(0,0); 	
	        Point point2 = new Point(4,5);
	        Point point3 = new Point(2,2);
	        maxPointsonsameLine maxpoint = new maxPointsonsameLine();
	        Point[] points = { point1, point2,point3};
	        System.out.println(maxpoint.maxPoints(points));
	}
	
	public int maxPoints(Point[] points) {
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			Map<Double, Integer> line = new HashMap<Double, Integer>();
			Point a = points[i];
			int localmax = 1;
			int same = 1;
			// System.out.println(a);
			for (int j = i + 1; j < points.length; j++) {
				Point b = points[j];
				// System.out.println(" point " + b.toString());
				if (a.x == b.x && a.y == b.y) {
					same++;
				} else {
					double dy = b.y - a.y;
					double dx = b.x - a.x;
					Double slope;
					if (dy == 0) { // horizontal
						slope = 0.0;
					} else if (dx == 0) {// vertical
						slope = Math.PI / 2;
					} else {
						slope = Math.atan(dy / dx);
					}
					Integer slopeVal = line.get(slope);
					// System.out.println(" slope " + slope + " slope value " + slopeVal);
					if (slopeVal == null) {
						slopeVal = 1;
					} else {
						slopeVal += 1;
					}
					line.put(slope, slopeVal);
				}
			}
			for (Double key : line.keySet()) {
				Integer val = line.get(key);
				result = Math.max(result, val + same);
			}
			// for all points are same
			result = Math.max(result, same);
		}
		return result;
	}
}