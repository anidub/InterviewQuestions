package numbers2;

public class sortZeroOnes {
	//Given integer array { 1, 0 ,1 0} you want all 1s and 0s on one side {1,1, 0, 0 } or {0, 0, 1, 1} where 1 represents red color and 0 is blue color.
	//https://techinterviewsolutions.net/2015/03/18/given-an-array-containing-just-0s-and-1s-sort-it-in-place-in-one-pass/
	
	public static void main(String args[]) {
		int[] arr = {1,0,1,0,1};
		sortArray(arr);
	}
	
	//for even off use  same logic
	public static void sortArray(int[]arr){
		int n = arr.length;
		int temp, left=0, right=n-1;
		
		while(left<right){
			if(arr[left] == 1){
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				right--;
			}else
				left++;			
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
	}
}