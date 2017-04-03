package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArraysmergeOverlappingIntervals {
/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
Make sure the returned intervals are also sorted.*/
///https://www.interviewbit.com/problems/merge-overlapping-intervals/
//http://stackoverflow.com/questions/31670849/merge-overlapping-intervals
//O(N)//http://www.geeksforgeeks.org/merging-intervals/	
	private static class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
}

public static void main (String[] args){
	ArrayList<Interval> x = new ArrayList<Interval>();
   x.add(new Interval(1, 3));
   x.add(new Interval(2, 6));
   x.add(new Interval(8, 10));
   x.add(new Interval(15, 18));
   x.add(new Interval(17, 20));
   x = merge(x);
   for(Interval i : x)  {
       System.out.println(i.start + " " + i.end);
   }
}

public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	if(intervals.size() == 0 || intervals.size() == 1)    return intervals;
  Collections.sort(intervals, new IntervalComparator()); // sorts in ascending order..: lowest first
   Interval first = intervals.get(0);
   int start = first.start;
   int end = first.end;

   ArrayList<Interval> result = new ArrayList<Interval>();

   for (int i = 1; i < intervals.size(); i++) {
       Interval current = intervals.get(i);
       if (current.start <= end) {
           end = Math.max(current.end, end);
       } else {
           result.add(new Interval(start, end));
           start = current.start;
           end = current.end;
       }
   }
   result.add(new Interval(start, end));
   return result;
}
private static class  IntervalComparator implements Comparator<Interval>{
	   public int compare(Interval i1, Interval i2)  {
	       return i1.start - i2.start;
	   }
	}
}
