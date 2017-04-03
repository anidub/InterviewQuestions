package numbers;

public class Dutchflagproblem {
//arrange the array of 0s , 1s, 2s without calculating the length
	public static void main(String[] args) {
		int[] array = {0,1,1,0,2,2,1,0};
		int size = array.length;
		sort012(array, size);
		for(int i = 0; i < size; i++){
			System.out.print(array[i]);
		}
		System.out.println();
		int[] num = {1,2,3,4,2};
		System.out.println(binarysearch(num,2));
	}
	
	public static void sort012(int[] array, int l){
		int low = 0;
		int mid = 0;
		int high = l - 1;
		int temp = 0;
		
		while(mid <= high){//{0,1,1,0,2,2,1,0};
			{
				switch(array[mid]){
				case 0:{ 
					temp = array[low];
					array[low] = array[mid];
					array[mid] = temp;
					low++;
					mid++;
					break;
				}case 1:{
					mid++;
					break;
				}case 2:{
					temp = array[high];
					array[high] = array[mid];
					array[mid] = temp;
					high--;
					break;
				}
				
				}
			}
		}
	} 
	
	public static boolean binarysearch(int[] arr, int k){
		int low = 0;
		int high = arr.length - 1;
		int mid;
		
		while(low <= high){
			mid = low + (high-low)/2;
			if(arr[mid] == k) return true;
			else if(arr[mid] > k) high = mid - 1;
			else low = mid + 1;
		}
		if(low > high) return false;
		return false;
	}
}
