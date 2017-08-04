package numbers;

public class QuickSort {

	public static void main(String[] args) {
		int[] num = {3,2,1,4,5,6};
		quickSort(num);
		for(int i : num) System.out.print(i+" ");

	}
	
	public static void quickSort(int[] arr){
		if(arr.length == 0) return;
		int low = 0; int high = arr.length;
		quickSort(arr, low, high-1);
	}
	
	public static void quickSort(int[] arr, int low, int high){
		if(arr.length == 0 || low >= high) return;
		
		int middle = low + (high-low)/2;
		int pivot = arr[middle];
		
		int i = low; int j = high;
		while(i <= j){
			while(arr[i] < pivot){
				i++;
			}
			while(arr[j] > pivot){
				j--;
			}
			
			if(i <= j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		
		if(low < j){
			quickSort(arr,low,j);
		}
		if(high > i){
			quickSort(arr, i, high);
		}
	}

}
