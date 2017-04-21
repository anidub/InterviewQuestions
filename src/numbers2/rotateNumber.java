package numbers2;

public class rotateNumber {

	public static void main(String[] args) {
		int[] num = {1,2,3,4,5};
		int rotate = 66;
		int[] res = rotate(num, rotate); // 3 4 5 1 2
		for(int k : res){
			System.out.print(k + " ");
		}
	}
	
	public static int[] rot(int[] num, int rotate){ //1 2 3 4 5 1 2 3 4 5
		int[] temp = new int[num.length * 2];
		rotate = rotate%num.length;
		if(rotate == 0) return num;
		int k = 0;
		for(int i = 0; i < num.length; i++){
			temp[k++] = num[i];
		}
		for(int i = 0; i < num.length; i++){
			temp[k++] = num[i];
		}
		k = 0;
		int[] result = new int[num.length];
		for(int i = rotate; i < temp.length; i++){
			if(k  > num.length-1) break;
			result[k++] = temp[i];
			
		}
		return result;		
	}
/*	http://www.programcreek.com/2015/03/rotate-array-in-java/
		 O(1) space and in O(n) time*/
	public static int[] rotate(int[] arr, int k){
		int[] result = new int[arr.length];
		if(k > arr.length)
			k = k % arr.length;
		int arrayBreak = arr.length-k;
		reverse(arr,result, 0, arrayBreak-1);
		reverse(arr,result, arrayBreak,arr.length-1);
		reverse(arr,result, 0,arr.length-1);
		return result;
	}
	
	public static void reverse(int[] arr,int[] result, int left, int right){
		if(arr == null || arr.length == 1)
			return;
		while(left <= right){
			int temp = arr[left];
			result[left] = arr[right];
			result[right] = temp;
			left++; right--;			
		}
	}
}
