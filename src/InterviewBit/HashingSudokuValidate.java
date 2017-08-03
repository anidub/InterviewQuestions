package InterviewBit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/*https://www.interviewbit.com/problems/valid-sudoku/
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx	
*/public class HashingSudokuValidate {

	public static void main(String[] args) {
		ArrayList<String> sudoku = new ArrayList<String>();
		//["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
		sudoku.add("53..7....");sudoku.add("6..195...");sudoku.add(".98....6.");
		sudoku.add("8...6...3");sudoku.add("4..8.3..1");sudoku.add("7...2...6");
		sudoku.add(".6....28.");sudoku.add("...419..5");sudoku.add("....8..79");
		System.out.println(isValidSudoku(sudoku));
	}
	
	public static int isValidSudoku(final List<String> A) {
		if (A == null)	return 0;
		int n = A.size();
		if (n != 9 || A.get(0).length() != 9) return 0;

		HashSet<Character> hashSet = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {
			hashSet.clear();
			for (int j = 0; j < 9; j++) {//all columns
				char c = A.get(i).charAt(j);
				if (c == '.')
					continue;
				if (hashSet.contains(c) || (c -'0') > 9)
					return 0;
				hashSet.add(c);
			}
		}

		for (int i = 0; i < 9; i++) {
			hashSet.clear();
			for (int j = 0; j < 9; j++) {//all rows
				char c = A.get(j).charAt(i);
				if (c == '.')
					continue;
				if (hashSet.contains(c) || (c -'0') > 9) 
					return 0;
				hashSet.add(c);
			}
		}
//total 9 subgrids
		for (int k = 0; k < 9; k++) {//all sub grids
			int x = k / 3;
			int y = k % 3;
			hashSet.clear();
			for (int i = 3 * x; i < 3 * x + 3; i++) {
				for (int j = y * 3; j < y * 3 + 3; j++) {
					char c = A.get(j).charAt(i);//goes in stading direction for every sub grid
					if (c == '.')
						continue;
					if (hashSet.contains(c) || (c -'0') > 9) // >9 because digit cant be greater than 9.Invalid case if given is string
						return 0;
					hashSet.add(c);
				}
			}
		}
		return 1;
	}
}

