package numbers;

public class productexceptindex {

	public static void main(String[] args) {
		int[] num = {1,2,3};
		int[] product = new int[num.length];
		product[0] = 1;
		int x = 1;
		
		for(int i = 1; i < num.length; i++){
			product[i] = product[i-1] * num[i-1];
		}
		
		for(int i = num.length - 1; i > 0; i--){
			x = x * num[i];//3
			product[i-1] = x * product[i-1];
		}
		
		for(int i = 0; i < product.length;i++){
			System.out.print(product[i] + " ");
		}
	}
}
