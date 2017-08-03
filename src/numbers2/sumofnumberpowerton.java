package numbers2;

public class sumofnumberpowerton {

	public static void main(String[] args) {
		int[] num = {1,-2,3,4,5};
		System.out.println(result(num,4));
	}
	
	public static int result(int[] num, int k){
		int result = 0;
		for(int i = 0; i < num.length; i++){
			result += findpower(num[i],k);
		}
		return result;
	}
	
	public static int findpower(int num, int power){
		//if(power == 0) return 1;
		//return num * findpower(num,--power);
		
		int total = 1;
		for(int i = 0; i < power; i++){
			total = total * num;
		}
		System.out.println(total);
		return total;		
	}
}
