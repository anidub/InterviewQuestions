package Designs;

public class FindHash {

	private final static long BIG_PRIME = 175365371; 
	private final static int size_of_table = 16;
	public static void main(String[] args) {
		System.out.println(getHash(10));
	}
	
	public static int getHash(int number){
		if(number >= 0){
			return (int)(number * BIG_PRIME) % size_of_table;
		}else{
			return (int)((Integer.MAX_VALUE - number) * BIG_PRIME) % size_of_table;
		}
	}

}
