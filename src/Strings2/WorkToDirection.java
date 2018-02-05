package Strings2;
//https://www.careercup.com/question?id=5127611667709952
/*Given a set top box: 
a, b, c, d, e, 
f, g, h, i, j, 
k, l, m, n, o 
p, q, r, s, t 
u, v, w, x, y 
z 

Write code to give the character sequence given a word, For example, if the word is "CON", the function will print this: 
Right//now we're at B 
Right//now we're at C 
OK//to select C 
Down 
DOwn 
Right 
Right 
OK//to select O 
Left//now at N 
OK//to select N 

note: Be careful when you're at Z. if you go to the right, you will get stuck. 
Afterwards, the interviewer adds a space to the right of 'Z' to test the code.*/
public class WorkToDirection {

	public static void main(String[] args) {
		char[] str = {'c','o','n'};
		System.out.println(getPath(5,str));
		printMoves("CON",5); //5 -> width
	}

	public static String getPath(int w, char[] str) {
		int i = 0;
		StringBuilder sb = new StringBuilder();
		int curR = 0;
		int curC = 0;
		while (i < str.length) {
			int destR = (str[i] - 'a') / w;//up or down like y cordinate
			int destC = (str[i] - 'a') % w;//right or left like x coordinate. to understand why '/' and '%'
			//take an example of char f for above grid. / and % are a technique to get x and y coordinate

			while (curC > destC) {
				sb.append('l');
				curC--;
			}

			while (curR > destR) {
				sb.append('u');
				curR--;
			}

			while (curC < destC) {
				sb.append('r');
				curC++;
			}

			while (curR < destR) {
				sb.append('d');
				curR++;
			}

			sb.append('!');
			i++;
		}
		return sb.toString();
	}
	
	
	static void printSteps(int a, int b, char key){
		while(a < b) {
			System.out.print(key); 
			a++;
		}
	}

	static void printMoves(String movie, int w){
		movie = movie.toLowerCase();
		int x = 0, y = 0;
		int i = 0;
		while(i < movie.length()) {
			char c = movie.charAt(i);
			int tx = ((c) - 'a') % w;
			int ty = ((c) - 'a') / w;

			printSteps(tx, x, 'l');
			printSteps(ty, y, 'u');
			printSteps(x, tx, 'r');
			printSteps(y, ty, 'd');
			System.out.println('!'); // select
			x = tx; y = ty;
			i++;
		}
		System.out.println(); 
	}
}
