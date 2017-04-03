package numbers;

public class leastconsecutinvenumbersum {

	//Given an integer N, express it as the sum of at least two consecutive positive integers. For example: 

//10 = 1 + 2 + 3 + 4 
//24 = 7 + 8 + 9 
//If there are multiple solutions, output the one with the smallest possible number of summands. 

	
	public static void main(String[] args) {
		int num = 105;
		int start = num/2;
		int sum = 0;
		
		while(start > 0){
			StringBuilder result = new StringBuilder();
			int counter = start;
			while(sum < num && counter > 0){
				sum = sum + counter;
				result.append(counter + "+");
				counter--;
			}
			if(sum == num){
				String str = result.toString();
				//System.out.println(str);
				System.out.println(str.substring(0,str.length() - 1));
				return;
			}else {
				start--;
				sum = 0;
			}
		}
		System.out.println("Impossible");	
	}
}
