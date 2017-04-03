package situations;

import java.util.HashSet;
import java.util.Set;

public class aeroplane {

	public static void main(String[] args) {
		String s = "41D2R";
		System.out.println(tocommand(s));
	}

	public static String tocommand(String s) {
		if (s == null || s.length() == 0 || s == " ")
			return null;
		String result = "";
		Set<Character> st = new HashSet<Character>();
		st.add('U');st.add('D');st.add('L');st.add('R');st.add('X');
		st.add('0');st.add('1');st.add('2');st.add('3');st.add('4');
		st.add('5');st.add('6');st.add('7');st.add('8');st.add('9');st.add('0');

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!st.contains(c))
			return null;
		}
		String tod = null;
		StringBuilder sb = new StringBuilder();
		int numdigit = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < s.length(); i++) {
			sb = new StringBuilder();
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				sb.append(c);
				int k = i +1;
				for(k = i + 1; k < s.length(); k++){
					if (Character.isDigit(s.charAt(k))) {
						sb.append(s.charAt(k));
					}else break;
				}
				i = k-1;
				/*while (s.charAt(k) != 'U' || s.charAt(k) != 'D' || s.charAt(k) != 'L' || s.charAt(k) != 'R'	|| s.charAt(k) != 'X') {
					 tod = s.substring(i,k); k++;
					//int numdigit = Character.getNumericValue('c');
				}*/
				numdigit = Integer.parseInt(sb.toString());
				
			}else{
				if(c == 'D'){
					x += -numdigit;
				}else if(c == 'U'){
					x += numdigit;
				}else if(c == 'L'){
					y += -numdigit;
				}else if(c == 'R'){
					y += numdigit;
				}else if(c == 'X'){
					if(s.charAt(i-1) == 'D'){
						x -= numdigit;
					}else if(c =='U'){
						x -= numdigit; 
					}else if(c == 'L'){
						y -= numdigit;
					}else if(c == 'R'){
						y -= numdigit;
					}
				}
				
			}
		}
		
		System.out.println("x"); System.out.println(x);
		System.out.println("y" ); System.out.println(y);
		return null;

	}
	
	
/*	public static String tocommand(String command){
		Set<Character> s = new HashSet<Character>();
		s.add('L');s.add('R');s.add('U');s.add('D');s.add('X');
		s.add('0');s.add('1');s.add('2');s.add('3'); s.add('4');
		s.add('5');s.add('6');s.add('7');s.add('8');s.add('9');

		int l = command.length();
		int x = 0;
		int y = 0;
		int numdigit = 0;
		
		int xnumdigit = 0;
		int ynumdigit = 0;
		
		for(int i = 0 ; i < l; i++){
			StringBuilder sb = new StringBuilder();
			char c = command.charAt(i);
			if(Character.isDigit(c)){
				sb.append(c);
				int k = i+1;
				for(k = i + 1; k < command.length(); k++ ){
					char cc = command.charAt(k);
					if(!Character.isDigit(cc)) break;
					else{
						sb.append(cc);
					}
				}
				i = k - 1;
				if(c == 'R' || c == 'L'){
					xnumdigit = Integer.parseInt(sb.toString());
				}else{
					ynumdigit = Integer.parseInt(sb.toString());
				}
				numdigit = Integer.parseInt(sb.toString());
			}else{
				if(c == 'R'){
					x += xnumdigit;
				}else if(c == 'L'){
					x -= xnumdigit;
				}else if(c == 'U'){
					y += ynumdigit;
				}else if(c == 'D'){
					y -= ynumdigit;
				}else if(c == 'X'){
						if(command.charAt(i-1) == 'D'){
							x += ynumdigit;
						}else if(command.charAt(i-1) =='U'){
							x -= ynumdigit; 
						}else if(command.charAt(i-1) == 'L'){
							y += xnumdigit;
						}else if(command.charAt(i-1) == 'R'){
							y -= xnumdigit;
						}
				}
			}
		}
		
		System.out.println("x : " + x);
		System.out.println("y : " + y );
		return null;
	}*/

}
