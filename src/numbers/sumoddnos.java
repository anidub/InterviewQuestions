package numbers;

public class sumoddnos {

	public static void main(String[] args) {
		int[] num = {1,2,3,4,5};
		int sum = 0;
		for(int i = 0; i < num.length; i++){
			if(num[i] % 2 == 1){
				sum = sum + num[i];
			}
		}
		System.out.println(sum);
		

	}

}
