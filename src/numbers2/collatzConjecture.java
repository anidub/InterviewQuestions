package numbers2;

public class collatzConjecture {
//find longest callatz conjecture
	//http://www.mathblog.dk/project-euler-14/
	
	static int number = 1000000;
	
	public static void main(String[] args) {
		int sequenceLength = 0;
		int startingNumber = 0;
		long sequence;
		int[] cache = new int[number + 1];
		
		for(int i = 0; i < cache.length; i++){
			cache[i] = -1;
		}
		//we know length of 1 is 1;
		cache[1] = 1;		
		for(int i = 2; i <= number; i++){
			int k = 0;
			sequence = i;
			while(sequence != 1 && sequence >= i){
				k++;
				if(sequence % 2 == 0)
					sequence = sequence/2;
				else
					sequence = 3 * sequence + 1;
			}
			 //Store result in cache
			cache[i] = k + cache[(int) sequence];
		
			  //Check if sequence is the best solution  
			if(cache[i] > sequenceLength){
				sequenceLength = cache[i];
				startingNumber = i;
			}
		}		
		System.out.println(sequenceLength);
		System.out.println(startingNumber);
	}
}