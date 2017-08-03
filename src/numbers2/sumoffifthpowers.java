package numbers2;

public class sumoffifthpowers {
// Find the sum of all the numbers that can be written as the sum of fifth powers of their digits
	//http://www.mathblog.dk/project-euler-30-sum-numbers-that-can-be-written-as-the-sum-fifth-powers-digits/
	public static void main(String[] args) {
	 //lets say our range is 355000
		int range = 355000;
		int result = 0;
		for(int i = 2; i <= range; i++){
			int sumofPowers = 0;
			int number = i;
			while(number > 0){
				int d = number %10;
				number = number/10;
				int temp = d;
				for(int j = 1; j < 5;j++){ //starting from 1 because temp == d in first case 
					temp *= d;
				}
				sumofPowers += temp;
			}
			if(sumofPowers == i){
				result += i;
			}
		}
		System.out.println(result);
	}
}