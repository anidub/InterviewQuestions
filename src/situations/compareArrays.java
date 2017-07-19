package situations;

public class compareArrays {
/*	There are two integer array arrayA and arrayB in the same size and two integer
 *  countA and countB. If arrayA[i] > arrayB[i], then we increase countA by 1,
 *   if arrayB[i]>arrayA[i], then we increase countB by 1. We will do nothing otherwise.
 *    Now you are given arrayA and arrayB, write a function to shuffle arrayA and so you can get countA > countB.
 *     Assume the input array are always valid, not empty and the input is guaranteed to have answer. 

	For example: 

	arrayA = [12, 24, 8, 32] 
	arrayB = [13, 25, 32, 11] 

	After shuffle: 

	arrayA = [24, 32, 8, 12] 
	arrayB = [13, 25, 32, 11]*/
	public static void main(String[] args) {
		int[] arr1 = {12,24,8,32};
		int[] arr2 = {13,25,32,11};
		
		shuffle(arr1, arr2);
		for(int i : arr1) System.out.print(i + " ");

	}
	
	public static void shuffle(int[] arr1, int[] arr2){
		int count1= 0;
		int count2 = 0;
		for(int i = 0; i < arr1.length; i++){
			if(arr1[i] > arr2[i]) count1++;
			else if(arr1[i] < arr2[i]) count2++;
		}
		if(count1 > count2) return;
		int count = 0;
		for(int i = 0; i < arr1.length; i++){
			if(arr1[i] > arr2[i]) count++;
			else{
				int temp = searchNextBig(arr1, i, arr2[i]);
				if(temp != i && temp != -1){
					swap(arr1,i, temp);
					count++;
				}else{
					System.out.println("cannot process");
				}				
			}
		}
	}
	
	public static int searchNextBig(int[] arr, int location, int k){
		int i;
		for(i= location; i < arr.length; i++){
			if(arr[i] > k) return i;
		}
		return -1;
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
