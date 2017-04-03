package numbers;

public class swapminmaxarray {

	public static void main(String[] args) {
		int[] num = {1,2,3,4,2};
		int minindex = 0;
		int maxindex = 0;
		int current = 0;
		for(int i = 0; i < num.length; i++){
			current = num[i];
			if(current < num[minindex])
				minindex = i;
			if(current > num[maxindex])
				maxindex = i;
		}
		int temp = num[minindex];
		num[minindex] = num[maxindex];
		num[maxindex] = temp;
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + " ");
		}
	}
}
