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
}
