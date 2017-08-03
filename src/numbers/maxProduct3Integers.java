package numbers;

public class maxProduct3Integers {

	/*
	 * find the maximum product that can be obtained from any 3 integers in an integer array.
	 *  The optimal solution has time complexity of O(n) and space complexity of O(1)
	 *  https://codereview.stackexchange.com/questions/109214/maximum-product-of-3-integers-in-an-int-array
	 *  http://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/
	 */
		public static void main(String[] args) {
			int arr[] = { 1, -4, 3, -6, 7, 0 };
			 int max = findMaxProduct(arr);
			 System.out.println(max);

		}
		/*
		 * The idea is if all the terms are positive integers then maximum product value can be 
		 * achieved by multiplying largest three values.
	If there are negative numbers, as product of two -ve numbers gives positive number,
	we need exactly two -ve numbers and one +ve number. When the smallest two -ve numbers are multiplied,
	 they gives the largest +ve number.
	Now you may argue that, there is only one -ve number or there is zero in first two location. 
	This issue will be taken care of by the Max function. 
		 */
		//time complexity of O(n) and space complexity of O(1)
		public static int findMaxProduct(int[] arr){
				int maxOne = Integer.MIN_VALUE;
				int maxTwo = Integer.MIN_VALUE;
				int maxThree = Integer.MIN_VALUE;
				
				int minOne = Integer.MAX_VALUE;
				int minTwo = Integer.MAX_VALUE;
				
				for(int i = 0; i < arr.length; i++){
					if(arr[i] >= maxOne){
						maxThree = maxTwo;
						maxTwo = maxOne;
						maxOne = arr[i];
					}else if(arr[i] >= maxTwo){
						maxThree = maxTwo;
						maxTwo = arr[i];
					}else if(arr[i] >= maxThree){
						maxThree = arr[i];
					}
					
					if(arr[i] <= minOne){
						minTwo = minOne;
						minOne = arr[i];
					}else if(arr[i] <= minTwo){
						minTwo = arr[i];
					}
				}
				return Math.max(maxOne * maxThree * maxTwo, maxOne * minOne  * minTwo);
		}
}