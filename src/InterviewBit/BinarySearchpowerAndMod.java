package InterviewBit;

public class BinarySearchpowerAndMod {
//https://www.interviewbit.com/problems/implement-power-function/ O(logn)//Binary search
	//https://www.careercup.com/question?id=22767685
	//calculate (x^y)%z without pow()
	public static void main(String[] args) {
		System.out.println(mod(2,3,3));
	}
	public static int mod(int x, int y, int z){
		int result=1;
		int square=x;
		if(y==0)  return 1;
		while(y!=0){
		    if(y % 2 != 0)   result=result*square;
		    
		    square=(square*square)%z;
		    y=y/2;
		    if(result>z)  result=result%z;
		}
		return result;
	}
		
	public static int calPower(int x, int y){
		if(y == 0) return 1;
		int temp;
		temp = calPower(x, y/2);
		if(y % 2 == 0)
			return temp * temp;
		else{
			if( y > 0) return  x * temp * temp;
			else
				return temp * temp/x;
		}
	}
}
