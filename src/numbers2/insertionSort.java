package numbers2;

public class insertionSort {//http://quiz.geeksforgeeks.org/insertion-sort/
/*Time Complexity: O(n*n)Auxiliary Space: O(1) 
Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.
Algorithmic Paradigm: Incremental Approach
Sorting In Place: Yes	Stable: Yes
Online: Yes	Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.*/
	public static void main(String[] args){
		int[] A = {2,4,5,1,0,8,-8,4};
		inserstionSort(A);
	}
	public static int[] inserstionSort(int[] arr){
		for(int i = 1; i < arr.length; i++){
			int key = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > key){
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
		return arr;
	}
}
