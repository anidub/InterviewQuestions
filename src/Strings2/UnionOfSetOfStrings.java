package Strings2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class UnionOfSetOfStrings {
/*
 * https://www.careercup.com/question?id=5698738912755712
 * Given two sets of strings A and B. Find the 
(A-B) U (B-A) ( U = union ). The answer should be in
 lexicographical order and A’s elements should appear before B’s.
 Soln :
  eg : A -> 1,2,3
  b -> 1,2,4,5
  A-B = 3
  B-A= 4,5
  (A-B) U (B-A) = 3,4,5
 */
	public static void main(String[] args) {
		HashSet<String> a = new HashSet<String>();
		HashSet<String> b = new HashSet<String>();
		a.add("Hello");a.add("Anish");a.add("Dubey");
		b.add("Hello");b.add("Manish");b.add("Dubey");
		find(a,b);
	}

	 public static HashSet find(HashSet<String> a, HashSet<String> b){
		 ArrayList<String> arr1 = new ArrayList<String>(a);
		 Collections.sort(arr1);
		 ArrayList<String> arr2 = new ArrayList<String>(b);
		 Collections.sort(arr2);
		 
		 Iterator it = arr1.listIterator();
		 while(it.hasNext()){
			 String p1 = (String) it.next();
			 if(b.contains(p1)){
				 arr2.remove(p1);
				 it.remove();
			 }				 
		 }
		 
		 arr1.addAll(arr2);
		 for(String s : arr1){
			 System.out.println(s);
		 }
		 a = new HashSet<String>(arr1);
		 return a;
	 }
}