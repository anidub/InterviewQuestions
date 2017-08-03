package InterviewBit;

import java.util.Stack;

public class StackandQueuesAbsolutePath {
/*https://www.interviewbit.com/problems/simplify-directory-path/
path = "/a/./b/../../c/", => "/c"
https://unix.stackexchange.com/questions/249039/what-means-the-dots-on-a-path//to understand path
	Given an absolute path for a file (Unix-style), simplify it.
	Examples:
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	Note that absolute path always begin with ‘/’ ( root directory )
	Path will not have whitespace characters.
	http://buttercola.blogspot.com/2014/09/leetcode-simplify-path.html
	Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
Understand the problem:
The problem requires some background of the UNIX command. The string is partitioned by  / .... /. So the basic idea is to check the substring between two / /. 
If the substring equals to '.', simply bypass it because it means the under the current path
If the substring equals to '..', pop the stack
If the substring equals to 'abc', push it into the stack. 
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