package InterviewBit;

public class StringValidNumber {

	public static void main(String[] args) {
		System.out.println(isValid("0.1"));
	}

	public static int isValid(String s) {
		if (s == null) return 0;
		boolean isNumeric = true;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'e' || c == 'E' || c == '.' || c == ' ') {
				count++;
				if (count < 2)
					isNumeric = true;
				else {
					isNumeric = false;
					break;
				}
			} else if (c >= '0' && c <= '9')
				isNumeric = true;
			else {
				isNumeric = false;
				break;
			}
		}
		if (isNumeric)
			return 1;
		else
			return 0;
	}
}
