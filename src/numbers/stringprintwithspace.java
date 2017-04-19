package numbers;
import java.util.TreeMap;
public class stringprintwithspace {
//print new characters on diff line and same on same line
	public static void main(String[] args) {
		String s1 = "abccdefffg";
		print(s1);
	}		
	public static void print(String s){
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
		System.out.print(s.charAt(0));
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) != s.charAt(i-1)){
				System.out.println();
			}
			System.out.print(s.charAt(i));
		}
	}
}