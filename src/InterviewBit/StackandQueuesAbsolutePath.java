package InterviewBit;

import java.util.Stack;

public class StackandQueuesAbsolutePath {
///https://www.interviewbit.com/problems/simplify-directory-path/
/*	path = "/a/./b/../../c/", => "/c"*/	
/*	http://buttercola.blogspot.com/2014/09/leetcode-simplify-path.html
*/	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		System.out.println(simplifyPath(path));
	}
	
	public static String simplifyPath(String path) {
		if (path == null || path.length() == 0)
			return "";
		Stack<String> stack = new Stack<String>();
		int i = 0;
		while (i < path.length()) {
			// bypass the first /
			while (i < path.length() && path.charAt(i) == '/') {
				i++;
			}
			int start = i;
			if (i == path.length())
				break;
			// reach the end /
			while (i < path.length() && path.charAt(i) != '/') {
				i++;
			}
			int end = i;
			String curr = path.substring(start, end);
			if (curr.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!curr.equals(".")) {
				stack.push(curr);
			}
		}
		if (stack.isEmpty())
			return "/";
		StringBuilder sb = new StringBuilder();
		String[] arr = stack.toArray(new String[stack.size()]);
		for (int j = 0; j < arr.length; j++) {
			sb.append('/');
			sb.append(arr[j]);
		}
		return sb.toString();
	}
}
