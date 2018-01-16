package numbers2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class listofallpairaddtosum {

	public static void main(String args[]) {
		
		listofallpairaddtosum solution = new listofallpairaddtosum();
		int[] arr = { 1, 2, 3, 5, 5, -6, 7, 11,16 };
		List<Pair> pairs = solution.findPairsOfIntegers(arr, 10);
		for (Pair pair : pairs) {
			System.out.println("Pair:" + pair.getNum1() + ":" + pair.getNum2());
		}
	}

	public List<Pair> findPairsOfIntegers(int[] arr, int sum) throws IllegalArgumentException {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array has to have elements");
		}
		final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		final Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		final Set<Integer> numbersAlreadyTracked = new HashSet<Integer>();
		final List<Pair> pairs = new ArrayList<Pair>();
		for (int num : arr) {
			map.put(num, sum - num);
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}
		for (int num : arr) {
			if (map.containsKey(sum - num) && !numbersAlreadyTracked.contains(num)
					&& (countMap.get(num) > 1 || ((sum - num) != num))) {
				boolean y = countMap.get(num) > 1;
				Pair pair = new Pair(num, sum - num);
				pairs.add(pair);
				numbersAlreadyTracked.add(sum - num);numbersAlreadyTracked.add(num);
			}
		}
		return pairs;
	}

	class Pair {
		private int num1;
		private int num2;

		public Pair(int num1, int num2) {
			this.num1 = num1;
			this.num2 = num2;
		}

		public int getNum1() {
			return num1;
		}

		public int getNum2() {
			return num2;
		}
	}
}
