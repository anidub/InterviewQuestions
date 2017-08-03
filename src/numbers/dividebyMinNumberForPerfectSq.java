package numbers;

public class dividebyMinNumberForPerfectSq {
/**
 * http://www.geeksforgeeks.org/find-minimum-number-divided-make-number-perfect-square/
 * https://www.careercup.com/question?id=5647590528909312
 * How :  z/x = root of y : z = given num, x = number to be found, y = perfect square
 * example : z = 50
 * 50/y^(1/2) = x
 * LHS should be perfectly divisible
 * so start from 50 and find squares of it till it is perfectly divisible and that will be answer
 * use pen paper 
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public static int divideByMinNumber(int x){		
		for(int i = x; i > 0; i--){
			int newSquare = (int) Math.pow(i, 2);
			if(newSquare < x){
				if(x % newSquare == 0){
					return x/newSquare;
				}
			}else if(newSquare == x){
				return 1;
			}
		}
		return -1;
	}
}