package InterviewBit;

import java.util.ArrayList;

public class BinarySearchLookRange {
/*http://www.programcreek.com/2014/04/leetcode-search-for-a-range-java/
https://www.interviewbit.com/problems/search-for-a-range/
Given a sorted array of integers, find the starting and ending position of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4]	*/
	public static ArrayList<Integer> findRange(ArrayList<Integer> numbers, int target){
		ArrayList<Integer> result = new ArrayList<Integer>(2);
		if(numbers.size() == 0) return null;
		result.add(-1);result.add(-1);
		find(numbers, 0, numbers.size(), target, result);
		//findrange(numbers,target);
		return result;
	}
	
	public static void find(ArrayList<Integer> numbers, int start, int end, int target, ArrayList<Integer> result){
		if(start > end) return;
		if(numbers.get(start) == numbers.get(end) && numbers.get(start) == target){
			result.set(0,start); result.set(1,end);
			return;
		}
		
		int mid = start + (end-start)/2;
		if(target < numbers.get(mid)) 
			find(numbers,start,mid-1,target,result);
		else if(target > numbers.get(mid))
			find(numbers,mid+1,end,target,result);
		else{
			result.add(mid);result.add(mid);
			int t1 = mid+1;
			while(t1 > start && numbers.get(t1 - 1) == numbers.get(mid)){
				t1--;
				result.set(0, t1);
			}
			int t2 = mid-1;
			while(t2 < end && numbers.get(t2 - 1) == numbers.get(mid)){
				t2++;
				result.set(1, t2);
			}
		}
	}
	
	public static ArrayList<Integer> findrange(int[] numbers, int k){
	//Integer[] numbers = (Integer[]) num.toArray();
		int low = 0;
		int high = numbers.length-1;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(-1);result.add(-1);
		while(low <= high){
			int mid = low + (high-low)/2;
			if(numbers[mid] == k){
				int t1 = mid;
				int t2 = mid;
				while(numbers[t1-1] == numbers[mid] && t1 >= low){
					t1--;
				}
				result.set(0,t1);
				while(numbers[t2+1] == numbers[mid] && t2 <= high){
					t2++;
				}
				result.set(1,t2);
				break;
			}else if(k < numbers[mid]){
				high = mid-1;
			}else
				low = mid+1;
		}
		
		return result;
	}
	
	public static void main(String[] args){

		int[] arr = {5, 7, 7, 8, 8, 10};
		int target = 8;
		findrange(arr, target);
		
	}
}
