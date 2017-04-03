package numbers;

class Numbertowords {

	public static final String[] units = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	public static final String[] tens = { "", // 0
			"", // 1
			"twenty", // 2
			"thirty", // 3
			"forty", // 4
			"fifty", // 5
			"sixty", // 6
			"seventy", // 7
			"eighty", // 8
			"ninety" // 9
	};

	public static String convert(final int n) {
		if (n < 0) {
			return "minus " + convert(-n);
		}

		if (n < 20) {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 1000000) {
			return convert(n / 1000) + " thousand" + ((n % 1000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 1000000000) {
			return convert(n / 1000000) + " million" + ((n % 1000000 != 0) ? " " : "") + convert(n % 1000000);
		}

		return convert(n / 1000000000) + " billion" + ((n % 1000000000 != 0) ? " " : "") + convert(n % 1000000000);
	}

	public static void main(String[] args) {
		int n;
		//n = -10100;
		n = 1999;
		if (n == 0) {
			System.out.println("zero");
		} else
			System.out.printf("%10d = '%s'%n", n, converta(n));
	}
	
	
	public static final String[] unitsa= {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen","eighteen", "nineteen"};

	public static final String[] tenas = {"","twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public static String converta(int n){
		if(n < 0){
			return "minus" + converta(-n);
		}
		
		if(n < 20){
			return unitsa[n];
		}
		
		if(n < 100){
			return tenas[n/10] + ((n % 10 != 0) ? " ":"") + unitsa[n%10];
			
		}
		
		if(n < 1000){
			return unitsa[n/100] + " hundred " + ((n % 100 != 0) ? " ":"") + convert(n%100);
		}
		
		if(n < 1000){
			return unitsa[n/100] + " thousand " + ((n % 1000 != 0) ? " ":"") + convert(n%1000);
		}
		
		if(n < 1000000){
			return unitsa[n/1000] + " million" + ((n % 10000 != 0) ? " ":"") + convert(n % 1000);
		}
		return "";
	}
}

