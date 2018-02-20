package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;
/*https://www.interviewbit.com/problems/equal/
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, 
 * where A,B,C & D are integers values in the array
 * Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
A + B = C + D, where A,B,C & D
	http://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/	
*/public class HashingFindFourNumbers {//O(n2)
	public static void main(String[] args) {
		int arr[] = {3, 4, 7, 1, 2, 9, 8};
		HashingFindFourNumbers a = new HashingFindFourNumbers();
        equal(arr);
	}
	
	 // Class to represent a pair
public class pair{
	        int first, second;
	   public pair(int f,int s){
	            first = f; second = s;
	        }
	    };
	 
/*	public boolean findPairs(int arr[]) {
		// Create an empty Hash to store mapping from sum to pair indexes
		HashMap<Integer, pair> map = new HashMap<Integer, pair>();
		int n = arr.length;

		// Traverse through all possible pairs of arr[]
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
	// If sum of current pair is not in hash, then store it and continue to next pair
				int sum = arr[i] + arr[j];
				if (!map.containsKey(sum))
					map.put(sum, new pair(i, j));
				else {// Else (Sum already present in hash) Find previous pair
					pair p = map.get(sum);
	// Since array elements are distinct, we don't need to check if any element is common among pairs
		System.out.println(	"(" + arr[p.first] + ", " + arr[p.second] + ") and (" + arr[i] + ", " + arr[j] + ")");
					return true;
				}
			}
		}
		return false;
	}*/
//works//extension of same problem for no duplicates in given array//studied
public static  ArrayList<Integer> equal(ArrayList<Integer> A) {    
 //https://www.interviewbit.com/problems/equal/
    ArrayList<Integer> res = new ArrayList<Integer>();
    HashMap<Integer, ArrayList<Node>> hashMap = new HashMap<Integer, ArrayList<Node>>();
    int n;
    int sum;
    ArrayList<Node> nodes;
    Node curNode;
    n = A.size();    
    if (A == null || A.size() < 4)   return res;
    
    for (int i = 0; i < n; i++) {        
        for (int j = i + 1; j < n; j++) {            
            sum = A.get(i) + A.get(j);
            curNode = new Node(i, j);
            
            if (hashMap.containsKey(sum)) {
                nodes = hashMap.get(sum);
            } else {
                nodes = new ArrayList<Node>();
            }
            
            nodes.add(curNode);
            hashMap.put(sum, nodes);            
        }        
    }    
    
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            
            sum = A.get(i) + A.get(j);
            curNode = new Node(i, j);
            
            if (hashMap.containsKey(sum)) {
                nodes = hashMap.get(sum);
                
                for (Node node : nodes) {
                    if (overlaps(curNode, node))
                        continue;
                    res.add(curNode.i);
                    res.add(curNode.j);
                    res.add(node.i);
                    res.add(node.j);
                    return res;
                }
            }
        }
    }    
    return res;    
}

public static boolean overlaps(Node n1, Node n2) {    
    if (n1.i == n2.i || n1.i == n2.j || n1.j == n2.i || n1.j == n2.j)
        return true;    
    return false;
}

class Node {
    int i, j;    
    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
}