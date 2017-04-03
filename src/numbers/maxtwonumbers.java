package numbers;

public class maxtwonumbers {

	public static void main(String[] args) {
		/*
		int[] numbers = {1,2,3,6,2};
		int maxone = 0;
		int maxtwo = 0;
		for(int i : numbers){
			if(maxone < i){
				maxtwo = maxone;
				maxone = i;
			}else if(maxtwo < i)
				maxtwo = i;
		}
		System.out.println(maxone);
		System.out.println(maxtwo);*/
		
		
		int[] num = {1,2,3,4,6,5};
		int maxone = 0;
		int maxtwo = 0;
		for(int i = 0; i < num.length; i++){
			if(maxone < num[i]){
				maxtwo = maxone;
				maxone = num[i];
			}else if(maxtwo < num[i]){
				maxtwo = num[i];
			}
		}
		System.out.println(maxone);
		System.out.println(maxtwo);
	}
}
