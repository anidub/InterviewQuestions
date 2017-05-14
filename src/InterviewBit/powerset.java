package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class powerset {
/*Given a number print all of its sub sets
for Example:  1234 -> 1,2,3,4,12,23,34,234,1234*/ 
	public static void main(String[] args) {
		allSubsets(1234);
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);intList.add(2);intList.add(3);intList.add(4);
		//powerSet(intList);
		//allSubsets(3);
		
	}
	
	public static TreeSet<Integer> allSubsets(int a) {
		TreeSet<Integer> hs = new TreeSet<Integer>();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		while (a > 0) {
			int k = a % 10;
			numbers.add(k);
			a = a / 10;
		}

		Collections.reverse(numbers);
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = i; j < numbers.size(); j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = i; k <= j; k++) {
					sb.append(numbers.get(k) + "");
				}
				hs.add(Integer.parseInt(sb.toString()));
			}
		}
		System.out.println(hs);
		return hs;
	}
	
	
//print all subsets in any order
//http://stackoverflow.com/questions/4640034/calculating-all-of-the-subsets-of-a-set-of-numbers O(2 ^ n)//worst	
public static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> intList) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    result.add(new ArrayList<Integer>());

    for (int i : intList) {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

        for (ArrayList<Integer> innerList : result) {
            innerList = new ArrayList<Integer>(innerList);
            innerList.add(i);
            temp.add(innerList);
        }
        result.addAll(temp);
    }
    return result;
}

	public static Set<Set<Integer>> pow(Set<Integer> set) {
		Set<Set<Integer>> result = new HashSet<Set<Integer>>();
		pow(set, result, set.iterator());
		return result;
	}

	public static Set<Set<Integer>> pow(Set<Integer> set, Set<Set<Integer>> result, Iterator<Integer> iterator) {
		if (iterator.hasNext()) {
			Integer head = iterator.next();
			Set<Integer> current = new HashSet<Integer>();
			current.addAll(set);
			current.remove(head);
			result.add(current);
			pow(current, result, current.iterator());
			pow(set, result, iterator);
		}
		return result;
	}
}
