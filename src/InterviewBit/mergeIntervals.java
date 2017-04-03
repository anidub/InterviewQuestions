package InterviewBit;

import java.util.ArrayList;

public class mergeIntervals {
	//https://www.interviewbit.com/problems/merge-intervals/
	//O(N)
//	/http://www.programcreek.com/2012/12/leetcode-insert-interval/
	public static class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
}
public static void main (String[] args){
	ArrayList<Interval> interval = new ArrayList<Interval>();
	Interval i = new Interval();Interval j = new Interval();Interval k = new Interval();Interval l = new Interval();
	i.start =  1;i.end = 3;
	j.start = 6; j.end = 9; 
	
	Interval newInterval = new Interval();
	newInterval.start = 2; newInterval.end = 5;
	interval.add(newInterval);interval.add(j);
	ArrayList<Interval> result = insertInterval(interval,i);
}

public static ArrayList<Interval> insertInterval(ArrayList<Interval> intervals, Interval newInterval) {
	ArrayList<Interval> result = new ArrayList<Interval>();
	int newStart = newInterval.start; int newEnd = newInterval.end;
	for (Interval interval : intervals) {
		if (newStart > interval.end) {
			result.add(interval);
		} else if (newEnd < interval.start) {
			result.add(newInterval);
			newInterval = interval;
		} else if (newEnd >= interval.start || newStart <=  interval.end) {
			newInterval = new Interval(Math.min(interval.start, newStart),	Math.max(newEnd, interval.end));
		}
	}
	result.add(newInterval);
	return result;
}
}
