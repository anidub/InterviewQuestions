package InterviewBit;

import java.util.Stack;
//https://www.interviewbit.com/problems/redundant-braces/
//https://github.com/nagajyothi/InterviewBit/blob/master/StacksAndQueues/Braces.java
/*path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"*/
public class StacksandQueuesRedundantbraces {

	public static void main(String[] args) {   
	String a = "((a + b)) ";
    System.out.println(braces(a));
}
	
	public static int braces(String str) {
		Stack<Character> stack = new Stack<Character>();
		int index = 0;
		while (index < str.length()) {
			char c = str.charAt(index);
			if (c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.peek() == '(') {
					return 1;
				} else {
					while (!stack.isEmpty() && stack.peek() != '(') {
						stack.pop();
					}
					stack.pop();
				}
			}
			index++;
		}
		return 0;
	}
}
