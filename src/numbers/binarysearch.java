package numbers;

public class binarysearch {

	public static void main(String[] args) {
		int[] num = {1,2,3,4,2};
		/*int low = 0;
		int high = num.length - 1;
		int mid = (low + high)/2;
		int key = 3;
		while(low <= high){
			if(num[mid] < key){
				low = mid + 1;
			}else if(num[mid] > key){
				high = mid - 1;
			}else{
				System.out.println("Key found index : " + mid );
				break;
			}
		}*/
		
		int high = num.length - 1;
		int low = 0;
		int mid = (high + low)/2;
		int key = 2;
		while(low <= high){
			if(key < array[mid]){
				high = mid + 1;
			}else if(key > array[mid]){
				low = mid + 1;
			}else if(array[mid] == key){
				System.out.println("key found at index : " + mid+1);
				return true;
			}
		}
			if(low > high){
				System.out.println("not found");
			}
			return false;
	}

}
