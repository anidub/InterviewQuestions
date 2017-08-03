package numbers;

public class maxsumofarray {
	//program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
//	/http://www.ardendertat.com/2011/09/24/programming-interview-questions-3-largest-continuous-sum/
	//http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

	public static void main(String[] args) {
	int[] numbers = {-10, 2, 3, -2, 0, 5, -15};
		System.out.println(maxsumincontiguous(numbers));
	}

	public static int maxsumincontiguous(int[] numbers){
		int current_max = numbers[0];
		int final_max = numbers[0];
		
		for(int i = 0; i < numbers.length; i++){
			current_max = Math.max(numbers[i], current_max+numbers[i]);
			final_max = Math.max(final_max,current_max);
		}
		return final_max;
	}
	
	 public static int maxSubArraySum(int a[]){
	        int size = a.length;
	        int max_so_far = Integer.MIN_VALUE, cur_max = 0;
	 
	        for (int i = 0; i < size; i++) {
	        	cur_max = cur_max + a[i];
	            if (max_so_far < cur_max)
	                max_so_far = cur_max;
	            if (cur_max < 0)
	            	cur_max = 0;
	        }
	        return max_so_far;
	    }
}
