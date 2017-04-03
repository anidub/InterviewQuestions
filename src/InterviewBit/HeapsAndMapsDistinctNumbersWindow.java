package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HeapsAndMapsDistinctNumbersWindow {
/*https://www.interviewbit.com/problems/distinct-numbers-in-window/
 * http://qa.geeksforgeeks.org/3934/find-the-count-distinct-numbers-windows-size-amazon-latest
 * http://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.
A=[1, 2, 1, 3, 4, 3] and K = 3
All windows of size K are
[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]
So, we return an array [2, 3, 3, 2].*/		
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);numbers.add(2);numbers.add(1);numbers.add(3);
		numbers.add(4);numbers.add(3);
		ArrayList<Integer> result = findKDistinct(numbers, 3);
	}
	
	
	//my solutions// works//complexity not so good
	public static ArrayList<Integer> distinct(ArrayList<Integer> numbers, int windowSize){
		if(numbers == null) return numbers;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < numbers.size()- windowSize+1; i++){
			int index = i;
			HashSet<Integer> hs = new HashSet<Integer>();
			while(index - i < windowSize ){	
				hs.add(numbers.get(index));
				index++;
			}
			result.add(hs.size());			
		}
		return result;
	}
	
	//use this // complexity good//o(n)
	private static ArrayList<Integer> findKDistinct(ArrayList<Integer> arr, int k) {		 
        ArrayList<Integer> result= new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 
        if(k>arr.size())  return result;
 
        int index=0;
        for (Integer integer : arr) {
            if(map.containsKey(integer)){
                map.put(integer,map.get(integer)+1);
            }else {
                map.put(integer,1);
            }
 
            if(index>=k-1){
                result.add(map.size());
                int s = arr.get(index-(k-1));
                if(map.get(s)>1){
                    map.put(s,map.get(s)-1);
                }else {
                    map.remove(s);
                }
            }
            index++;
        } 
        return result;
    }
}
