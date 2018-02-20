package InterviewBit;

import java.util.ArrayList;
import java.util.Stack;

//https://www.interviewbit.com/problems/evaluate-expression/
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//my code !
public class StackandQueuesArithmaticExpresion {

	private static int mutiply;

	public static void main(String[] args) {
		// 2", "1", "+", "3", "*"
		ArrayList<String> exp = new ArrayList<String>();
		exp.add("2");exp.add("1");exp.add("+");exp.add("3");exp.add("*");
		//System.out.println(evaluateRPN(exp));
		// System.out.println(exp("1*2+3*4"));
		//System.out.println(exp("3*5+5*9+2*0"));
		getexp("");

	}

	public static int evaluateRPN(ArrayList<String> exp) {
		if (exp == null || exp.size() == 0)
			return -1;
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < exp.size(); i++) {
			String s = exp.get(i);
			if (!isOperator(s))
				st.push(s);
			else {
				int n1 = 0;
				int n2 = 0;
				if (!st.isEmpty())
					n2 = Integer.parseInt(st.pop());
				if (!st.isEmpty())
					n1 = Integer.parseInt(st.pop());
				int result = 0;
				if (s.equals("*"))
					result = n1 * n2;
				else if (s.equals("+"))
					result = n1 + n2;
				else if (s.equals("-"))
					result = n1 - n2;
				else if (s.equals("/"))
					result = n1 / n2;
				st.push(result + "");
			}
		}
		return Integer.parseInt(st.pop());
	}
	

	public static boolean isOperator(String op) {
		if (op.equals("+") || op.equals("*") || op.equals("-") || op.equals("/"))
			return true;
		return false;
	}
	//https://www.careercup.com/question?id=4911380140392448
	//method 1
	public static int exp(String s) {
		final Stack<Integer> stack = new Stack<Integer>();
        final String str = "3*5+5*9+2*0";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                stack.push(stack.pop() * Character.digit(str.charAt(++i), 10));
            } else if (str.charAt(i) == '+') {
                continue;
            } else {
                stack.push(Character.digit(str.charAt(i), 10));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
        return sum;
	}
	
	////https://www.careercup.com/question?id=4911380140392448
	//method 2 //Input: 3*5+8 (as String) 
	//Output: 23 (as int)
	public static int expression(String s) {
		String[] adds = s.split("\\+");
		int sum = 0;
		for (String mul : adds) {
			String[] mults = mul.split("\\*");
			int multiply = 1;
			if (mults.length != 1) {
				for (String d : mults) {
					multiply = multiply * Integer.parseInt(d);
				}
				sum += multiply;
			}else{
				sum += Integer.parseInt(mul);
			}
		}
		return sum;
	}
	
	public static boolean isoper(Character c){
		if(c == '+' || c == '-' || c == '/' || c == '*'){
			return true;
		}
		return false;
	}
	
	public static void getexp(String exp){
		int result = 0;
		exp = "1+2+3-4-5-6+6";
		StringBuilder sb;
		for(int i = 0; i < exp.length(); i++){
			char c = exp.charAt(i);
			if(c == '+'){
				i++;
				int endIndex = getNum(exp,i);
				String s = exp.substring(i, endIndex);
				result = result + Integer.parseInt(s);
				i = endIndex-1;
			}else if(c == '-'){
				i++;
				int endIndex = getNum(exp,i);
				String s = exp.substring(i, endIndex);
				result = result - Integer.parseInt(s);
				i = endIndex-1;
			}else{				
				int endIndex = getNum(exp,i);
				String s = exp.substring(i, endIndex);
				result = Integer.parseInt(s);
				i = endIndex-1;
			}
		}
		System.out.println(result);
	}
	
	public static int getNum(String exp, int i){
		while(i < exp.length() && (exp.charAt(i) != '+' && exp.charAt(i) != '-')){
			i++;
		}
		return i;
	}
}