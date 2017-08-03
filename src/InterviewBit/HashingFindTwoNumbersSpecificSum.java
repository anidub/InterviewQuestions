package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/*https://www.interviewbit.com/problems/2-sum/
https://github.com/nagajyothi/InterviewBit/blob/master/Hashing/TwoSum.java
	Given an array of integers, find two numbers such that they add up to a specific target number.
	If multiple solutions exist, output the one where index2 is minimum. 
	If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
	Input: [2, 7, 11, 15], target=9	
	Output: index1 = 1, index2 = //O(n)*/
public class HashingFindTwoNumbersSpecificSum {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(2); arr.add(7); arr.add(11); arr.add(15);
		twoSum(arr,9);
	}
	
	   static class Node implements Comparable<Node> {	        
	        int left;
	        int right;	        
	        public Node(int left, int right) {
	            this.left = left;
	            this.right  = right;
	        }	        
	        public int compareTo(Node o) {
	            if (this.right < o.right)
	                return -1;
	            if (this.right > o.right)
	                return 1;	                
	            return Integer.compare(this.left, o.left);
	        }	        
	    }
	    
	 public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {	     
	     int sum = B;
	     int diff;
	     HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	     int size = A.size();
	     int num;
	     int index;
	     ArrayList<Integer> res = new ArrayList<Integer>();
	     ArrayList<Node> node = new ArrayList<Node>();	     
	     for (int i = size - 1; i >= 0; i--) {
	         num = A.get(i);
	         diff = sum - num;	         
	         if (hashMap.containsKey(diff)) {
	             index = hashMap.get(diff);
	             node.add(new Node(i + 1, index + 1));
	         }	         
	         hashMap.put(num, i);	         
	     }
	     
	     if (node.size() > 0) {
	         Collections.sort(node);
	            res.add(node.get(0).left);
	            res.add(node.get(0).right);
	     }	     
	     return res;	     
	 }
}