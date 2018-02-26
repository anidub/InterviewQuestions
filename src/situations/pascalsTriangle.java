package situations;

import java.util.ArrayList;

public class pascalsTriangle {
//http://www.quickprogrammingtips.com/java/program-to-print-pascal-triangle-in-java.html
//http://www.javamadesoeasy.com/2015/02/pattern-8-pascals-triangle.html
	
	//%4d instructs the formatter to print the number within 4 spaces. 
	//We choose 4 since we know the maximum number of digits in the largest number of a Pascal triangle with 10 rows is 3 digits.

	//http://www.mathsisfun.com/pascals-triangle.html
	public static void main(String[] args) {
		int rows = 5;
		for (int i = 0; i < rows; i++) {
			int number = 1;
			System.out.format("%" + (rows - i) * 2 + "s", "");  //8  //6   //4  //2
			for (int j = 0; j <= i; j++) {
				System.out.format("%4d", number); //1         //1 1    //1 2    // 1 3 3 1   //
				number = number * (i - j) / (j + 1); //0      //1 1    //2 1    // 3 3 1
			}
			System.out.println();
		}
		generate(5);
	}


//to store in arraylist
	//http://www.programcreek.com/2014/03/leetcode-pascals-triangle-java/
public static ArrayList<ArrayList<Integer>> generate(int numRows) {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	if (numRows <= 0)
		return result;
 
	ArrayList<Integer> pre = new ArrayList<Integer>();
	pre.add(1);
	result.add(pre);
 
	for (int i = 2; i <= numRows; i++) {
		ArrayList<Integer> cur = new ArrayList<Integer>();
 
		cur.add(1); //first
		for (int j = 0; j < pre.size() - 1; j++) {
			cur.add(pre.get(j) + pre.get(j + 1)); //middle
		}
		cur.add(1);//last
 
		result.add(cur);
		pre = cur;
	} 
	return result;
}

}