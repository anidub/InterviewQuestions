package InterviewBit;

public class StringIntegerToRoman {
//https://www.interviewbit.com/problems/integer-to-roman/
	public static void main(String[] args) {
		System.out.println(intToRoman(999));

	}
	public static String intToRoman(int n) {
		if(n <= 1)return "Only positive allowed";
	    int[] A = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] B = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<A.length; i++) {
	        while(n >= A[i]) {
	            sb.append(B[i]);
	            n -= A[i];
	        }
	    }
	    return sb.toString();
	}
}
//this works too // easy to understand but stackoverflow//http://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
/*private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
static {
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");
}
public final static String toRoman(int number) {
    int l =  map.floorKey(number);//floorkey return next key less than or equal to specified value
    if ( number == l ) {
        return map.get(number);
    }
    return map.get(l) + toRoman(number-l);
}*/