package InterviewBit;

import java.util.ArrayList;

public class StringJson {
	/*https://www.interviewbit.com/problems/pretty-json/
	https://discuss.leetcode.com/topic/249/print-json-format-string/25
*/	public static void main(String[] args) {
		String json = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
		String jsona = "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
		System.out.println(pretty(jsona));

	}
//studied// for validation add valid parenthesis program
	public static String pretty(String s) {
		StringBuilder sb = new StringBuilder();
		int indent = 0;
		char pre = 0;
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c))
				continue;
			if (c == ']' || c == '}')
				indent--;
			if (pre == '[' || pre == '{' || pre == ',' || c == ']' || c == '}') {
				sb.append('\n');
				for (int i = 0; i < indent; i++)
					sb.append("  ");
			}
			sb.append(c);
			if (c == '[' || c == '{')
				indent++;
			pre = c;
		}
		return sb.toString();
	}
	
	public ArrayList<String> prettyJSON(String A) {
		ArrayList<String> res = new ArrayList<String>();
		StringBuilder str = new StringBuilder();
		int n = A.length();
		int tabs = 0;
		for (int i = 0; i < n;) {
			i = skipSpace(A, i);
			if (i >= n)	break;

			str = new StringBuilder();
			char c = A.charAt(i);

			if (delimiter(c)) {
				if (isOpenBracket(c)) {
					for (int j = 0; j < tabs; j++)
						str.append("\t");
					tabs++;
				} else if (isClosedBracket(c)) {
					tabs--;
					for (int j = 0; j < tabs; j++)
						str.append("\t");
				}
				str.append(c);
				i++;
				if (i < n && canAdd(A.charAt(i))) {
					str.append(A.charAt(i));
					i++;
				}
				res.add(str.toString());
				continue;
			}

			while (i < n && !delimiter(A.charAt(i))) {
				str.append(A.charAt(i));
				i++;
			}
			if (i < n && canAdd(A.charAt(i))) {
				str.append(A.charAt(i));
				i++;
			}
			StringBuilder strB = new StringBuilder();
			for (int j = 0; j < tabs; j++)
				strB.append("\t");
			strB.append(str);
			res.add(strB.toString());
		}
		return res;
	}
	
	public boolean canAdd(char c) {
		if (c == ',' || c == ':')
			return true;
		return false;
	}

	public boolean delimiter(char c) {
		if (c == ',' || isOpenBracket(c) || isClosedBracket(c))
			return true;
		return false;
	}

	public boolean isOpenBracket(char c) {
		if (c == '[' || c == '{')
			return true;
		return false;
	}

	public boolean isClosedBracket(char c) {
		if (c == ']' || c == '}')
			return true;
		return false;
	}

	public int skipSpace(String A, int i) {
		int n = A.length();
		while (i < n && A.charAt(i) == ' ')
			i++;
		return i;
	}
	
	
	
}
