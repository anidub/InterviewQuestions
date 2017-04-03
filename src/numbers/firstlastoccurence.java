package numbers;

public class firstlastoccurence {

	public static void main(String[] args) {
		int[] numbers  = {1,2,2,2,3};
		int n = 2;
		System.out.println(findfirstlast(numbers,n));
	}
	
	public static int[] findfirstlast(int[] input, int number){
		if(input == null || input.length == 0){
			return new int[]{-1,-1};
		}
		int start = 0;
		int end = input.length - 1;		
		while(start <= end){
			int middle = (start + (end - start))/2;
			if(number > input[middle]){
				start = middle + 1;
			}else if(number < input[middle]){
				end = middle - 1;
			}else{
				int first = findfirstindex(input, middle,number);
				int last = findlastindex(input,middle,number);
				return new int[] {first,last};
			}
		}
			return new int[] {-1,-1};
}
	
	
	public static int findfirstindex(int[] input, int index, int number){
		int i = index - 1 ;
		for(; i >= 0; i--){
			if(input[i] != number){
				break;
			}
		}
		return i + 1;	
	}
	
	public static int findlastindex(int[] input, int index, int number){
		int i = index + 1;
		for(; i <= input.length;i++){
			if(input[i] != number){
				break;
			}
		}
		return i - 1;
	}
}