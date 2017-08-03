package InterviewBit;

public class msft {

	public static void main(String[] args) {
		String[] arr = new String[2];
		String s1 = "6175151887";
		String s2 = "617-515-1887";
		arr[0] = s1; arr[1] = s2;
		check(arr);
		
		for(String s : arr){
			System.out.println(s);
		}

	}

	
	public static void check(String[] arr){		
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (Character.isDigit(c) && Character.getNumericValue(c) >= 0 && Character.getNumericValue(c) <= 9) {
					sb.append(c);
				}				
			}			
			sb.insert(3, '-');
			sb.insert(7, '-');
			arr[i] = sb.toString();

		}
		
	}
}
