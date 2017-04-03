package numbers2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class targetequaltooneelementfromeacharray {
	
	public static List<List<Integer>> threeSum(int[] a, int[] b, int[] c, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
			for(int i = 0 ; i < a.length; i++) {
				for(int j = 0; j < b.length; j++) {
					int subSum = a[i] + b[j];
						if(subSum < target) {
							if(search(c, target - subSum)) {
									res.add(Arrays.asList(a[i], b[j], target-subSum));
							}
					}
				}
			}
				return res;
		} 
	
	public static boolean search(int[] c, int target) {
			int left = 0, right = c.length - 1;
				while(left <= right) {
					int mid = left + (right -left)/2;
					if(c[mid] == target)
						return true;
					else if(c[mid] < target)
						left = mid +1;
					else
						right = mid -1;
				}
				return false;
		}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		int[] b = { 2, 3, 4 };
		int[] c = { 1, 2, 4 };
		targetequaltooneelementfromeacharray test = new targetequaltooneelementfromeacharray();
		System.out.println(test.threeSum(a, b, c, 7));
	}
}
