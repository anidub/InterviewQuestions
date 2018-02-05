package numbers;

public class NumberOfHops2d {
/*
 * find the number of hops required to reach from source to destination
 * It can only be horizontal or vertical direction
 * Idea : ex(0,0 -> 2,3) = 3-0 + 2-0 = 5
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static int findNumberOfHops(int sourceRow, int sourceCol, int destRow, int destCol){
		if(sourceRow < 0 || sourceCol < 0 || destRow < 0 || destCol < 0)
			return -1;
		int verticalHops = destCol - sourceCol;
		int horizontalHops = destRow - sourceRow;
		
		return verticalHops + horizontalHops;
	}
}

