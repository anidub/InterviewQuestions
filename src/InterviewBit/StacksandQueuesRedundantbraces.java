package InterviewBit;

import java.util.Stack;
//https://www.interviewbit.com/problems/redundant-braces/
//https://github.com/nagajyothi/InterviewBit/blob/master/StacksAndQueues/Braces.java
/*((a + b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0
*/public class StacksandQueuesRedundantbraces {
	public static void main(String[] args) {   
	String a = "(a + (a + b)) ";
    System.out.println(hasRedundantBraces(a));
}
	
	public static boolean hasRedundantBraces(String str) {
		Stack<Character> stack = new Stack<Character>();
		int index = 0;
		while (index < str.length()) {
			char c = str.charAt(index);
			if (c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.peek() == '(') {
					return true;
				} else {
					while (!stack.isEmpty() && stack.peek() != '(') {
						stack.pop();
					}
					stack.pop();
				}
			}
			index++;
		}
		return false;
	}
}