package numbers2;

public class quickSortArray {
//http://www.geeksforgeeks.org/quick-sort/
	/*
	 * Time
	 * Avg case : nlogn
	 * worst case : n2
	 * 
	 * Space 
	 * avg case : nlogn
	 * worst case : n
	 */
	public static void main(String[] args) {
		 int arr[] = {10, 7, 8, 9, 1, 5};
		 sort(arr,0,arr.length-1);
		 for(int i : arr) System.out.print(i + " ");
	}
	
	public  static void sort(int[] arr, int low, int high){
		if(low < high){
			int partitionIndex = partition(arr,low,high);
			
			sort(arr, low, partitionIndex-1);
			sort(arr, partitionIndex+1,high);
		}
	}
	
	public  static int partition(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low-1;
		
		for(int j = low; j < high; j++){
			if(arr[j] <= pivot){
				i++;
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;		
		return i+1;
	}

	
	public void sortIterative(int[] arr, int low, int high){
		int[] stack = new int[high - low + 1];
		int top = -1;
		stack[++top] = low;
		stack[++top] = high;
		
		while(top >= 0){
			high = stack[top--];
			low = stack[top--];
			if(low < high){
				int pivot = partitionIterative(arr, low, high);
				if(pivot - 1 > low){
					stack[++top] = low;
					stack[++top] = pivot - 1;
				}
				
				if(pivot + 1 < high){
					stack[++top] = pivot + 1;
					stack[++top] = high;
				}
			}
		}
	}
	
	public int partitionIterative(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low-1;
		for(int j = low; j < high; j++){
			if(arr[j] <= pivot){
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, high);
		return i+1;
	}
	
	public void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}